<html>
<head>
	<title>WawChat</title>
	<meta charset="utf-8" />
	<link rel="stylesheet" type="text/css" href="style.css">
	<script type="text/javascript" src="jquery.js"></script>
</head>
<body>
	<div id="black" class="degradadoGris"></div>
	<div id="login">
		<h1>WawChat</h1>
		<label>Ingrese su nombre en el chat:</label>
		<input type="text" id="nombre" autocomplete="off" />
		<input type="button" id="snombre" value="Ingresar" />
	</div>
	<div id="todo">
		<div id="contm">
			<nav class="usuarios">
				<h2>Usuarios</h2>
				<ul>
				</ul>
			</nav>
		</div>
		<div id="cont">
			<section id="finfo"></section>
			<section id="info">

				<nav id="pestana">
					<ul>
						<li id="ch-1" class="s">Chat general</li>
						<li id="mas">+</li>
					</ul>
				</nav>
				<div id="con-1" class="activo chat">
					<div id="mss"></div>
				</div>
				<div id="write">
					<input type="button" id="enviar" value="Enviar" />
					<textarea id="texto"></textarea>
					
				</div>
				<section id="textoabajo">
					<span id="txteliminar">Eliminar chat</span>
					<span><a href="close.jsp">Cerrar sesión</a></span>
				</section>
				
			</section>

		</div>
	</div>
	<script type="text/javascript">
		$().ready(function() {
			var mensaje = "undefined";
			var usuariosigual = "";
			var chats = 0+"";
			function iniciarAjax(nombre) {
				console.log("Nombre iniciarAjax: "+nombre);
				(function poll(){
				    $.ajax({ 
				    	url: "client.jsp", 	
				    	type: "GET",
				    	data: { texto: mensaje, nombre: nombre, chats: chats },
				    	success: function(data){
				    		var res = data.split("|:|");
					        var data2 = $.trim(res[0]); 
					        //console.log("Exito data: "+data2+" data.value: "+data.value+" Mensaje:"+mensaje);
					        if(data2.length>1) {
					        	//console.log("Exito data: "+data2+" data.value: "+data.value+" Mensaje:"+mensaje);
					        	mensaje = "undefined";
						        var id = $("#pestana ul .s").attr('id');
			                    id = id.replace("ch","");
			                    $("#con"+id+" #mss").append("<div class='mensaje'>"+data2+"</div>");
			                    $('#con'+id).animate({scrollTop: $("#con"+id+" #mss").height()}, 800);
			                }
			                var usuarios = res[1];
			                if (usuarios!=usuariosigual) {
			                	$("#contm .usuarios ul").html(usuarios);
			                	usuariosigual = usuarios;
			                	activarClickUsuarios();
			                }
			                var idNuevoChat = res[2];
			                if (idNuevoChat.length>=1) {
			                	alert("Chat agregado: "+idNuevoChat);
			                	nuevoChat(idNuevoChat);
			                }
			                var idChatEliminar = res[3];
			                if (idChatEliminar.length>=1) {
			                	alert("Chat eliminado: "+idChatEliminar);
			                	eliminarChat(idChatEliminar);
			                }
			                
				    	}, 
				    	error: function(data){
					        //console.log("Error");
				    	}, 
				    	complete: poll, 
				    	timeout: 1000 
				    });
				})();
			}
			
			var act = false;
			var chat =1;
			$("#mas").click(function(){
				console.log("Click en mas");
				if ($(this).hasClass("select")) {
					// Crear chat
					var rec = [];
					var cont = 0;
					// Sacar ID's
					$( ".usuarios ul .sel" ).each(function() {
					  	var recs = $( this ).attr('id');
					  	var id = recs.replace("u","");
					  	console.log("ID "+id+" cont:"+cont);
					  	rec[cont] = id;
					  	cont++;
					});
					$(".usuarios ul .sel").removeClass("sel");
					var IDSUsuarios = rec[0];
					for (var i = 1; i<cont; i++) {
						console.log("REC "+rec[i]);
						IDSUsuarios = IDSUsuarios+","+rec[i];
					}
					if (cont>=1) {
						// Enviar a server
						$.ajax({ 
					    	url: "newChat.jsp", 	
					    	type: "GET",
					    	data: { usuarios: IDSUsuarios },
					    	success: function(data){
					    		alert("IDChat: "+data);
						        var data2 = $.trim(data); 
						       	// Crear pestaña y conversación
								nuevoChat(data2);
					    	}, 
					    	error: function(data){
						        //console.log("Error");
					    	}
					    });
						
					}
					act = false;
					$("#mas").removeClass("select");
					
				} else {
					$("#mas").addClass("select");
					act = true;
				}
				
			});
			function nuevoChat(id) {
				$(".s").removeClass("s");
				$( "<li id='ch"+id+"' class='s'>Chat "+id+"</li>" ).insertBefore( "#pestana ul #mas" );
				//$("#pestana ul").append("<li id='ch"+chat+"' class='s'>Chat "+chat+"</li>")
				$(".activo").removeClass("activo");
				$("<div id='con"+id+"' class='activo chat'><div id='mss'></div></div>").insertBefore("#write");	
				activar();
                chats = chats+","+id;
			}
			function activarClickUsuarios() {
				$(".usuarios ul li").click(function(){
					console.log("Click en usuarios");
					if (act && $(this).hasClass("sel")) {
						$(this).removeClass("sel");
					} else if (act) {
						$(this).addClass("sel");
					}
				});
			};
				
			$("#enviar").click(function(){
				enviar();
			});
			function enviar() {
				
				var texto = $("#texto").val();
				texto = texto.replace("\n","");
				texto = texto.replace("<","");
				texto = texto.replace(">","");
				
				console.log("El texto dice: "+texto);
				if (texto.length>=1) {
					mensaje = texto;
				}
				$("#texto").val("");
				
			}
			var entrar = true;
			var activocd = false;
			function cambiarPestana(thing) {
				
				var ids = $(thing).attr('id');
				var id = ids.replace("ch","");
				console.log($.isNumeric(id)+" ID: "+id);
				if($.isNumeric(id)) {
					$("#pestana ul .s").removeClass("s");
					$(thing).addClass("s");
					id = "con"+id;
					$(".activo").removeClass("activo");
					$("#"+id).addClass("activo");
					var time = setInterval(function() {
			      		entrar= true;
			      	}, 1000);
				}
				
			};

			function activar() {
				$("#pestana ul li").click(function(){
					console.log("Entra #pestaña ul li");
					if (!$(this).hasClass("s") && entrar) {
						entrar = false;
						cambiarPestana(this);
					}
				});
			}
			$("#snombre").click(function(){
				ingresar();
			});
			function eliminarChat(id) {
				$("#ch"+id).remove();
				$("#con"+id).remove();
				cambiarPestana("#pestana ul #ch-1");
			}
			$("#txteliminar").click(function(){
				entrar = false;
		    	if (activocd==false) {
		    		activocd = true;
		    		console.log("False");
					console.log("Entra Eliminar");
					var id = $(".s").attr('id');
					id = id.replace("ch","");
					if(id!=-1) {
						$.ajax({ 
					    	url: "removeChat.jsp", 	
					    	type: "GET",
					    	data: { id: id },
					    	success: function(data){
					    		eliminarChat(id);
					    		alert("Eliminado chat "+id);
					    	}, 
					    	error: function(data){
						        //console.log("Error");
					    	}
					    });
						
					}
		    	}else {
		    		activocd = false;
		    		console.log("True");
		    		$("#pestana ul li #menu").remove();
		    	}	
				
		      	var time = setInterval(function() {
		      		entrar= true;
		      	}, 1000);
			});

			function ingresar() {
				var nombre = $("#nombre").val();
				console.log("Nombre ingresar: "+nombre);
				$("#black").css("display","none");
				$("#login").css("display","none");
				iniciarAjax(nombre);
			}
			$(document).keypress(function(e) {
			    if(e.which == 13) {
			    	console.log("Entra");
			        if($('#black').css('display') == 'block') {
			        	// Ingresando el usuario
			        	ingresar();
					} else {
						// Comentando
						enviar();
					}
			    }
			});
			
		});
	</script>
</body>
</html>