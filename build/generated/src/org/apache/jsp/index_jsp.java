package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>WawChat</title>\n");
      out.write("\t<meta charset=\"utf-8\" />\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("\t<script type=\"text/javascript\" src=\"jquery.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div id=\"black\" class=\"degradadoGris\"></div>\n");
      out.write("\t<div id=\"login\">\n");
      out.write("\t\t<h1>WawChat</h1>\n");
      out.write("\t\t<label>Ingrese su nombre en el chat:</label>\n");
      out.write("\t\t<input type=\"text\" id=\"nombre\" autocomplete=\"off\" />\n");
      out.write("\t\t<input type=\"button\" id=\"snombre\" value=\"Ingresar\" />\n");
      out.write("\t</div>\n");
      out.write("\t<div id=\"todo\">\n");
      out.write("\t\t<div id=\"contm\">\n");
      out.write("\t\t\t<nav class=\"usuarios\">\n");
      out.write("\t\t\t\t<h2>Usuarios</h2>\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</nav>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"cont\">\n");
      out.write("\t\t\t<section id=\"finfo\"></section>\n");
      out.write("\t\t\t<section id=\"info\">\n");
      out.write("\n");
      out.write("\t\t\t\t<nav id=\"pestana\">\n");
      out.write("\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t<li id=\"ch-1\" class=\"s\">Chat general</li>\n");
      out.write("\t\t\t\t\t\t<li id=\"mas\">+</li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</nav>\n");
      out.write("\t\t\t\t<div id=\"con-1\" class=\"activo chat\">\n");
      out.write("\t\t\t\t\t<div id=\"mss\"></div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div id=\"write\">\n");
      out.write("\t\t\t\t\t<input type=\"button\" id=\"enviar\" value=\"Enviar\" />\n");
      out.write("\t\t\t\t\t<textarea id=\"texto\"></textarea>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<section id=\"textoabajo\">\n");
      out.write("\t\t\t\t\t<span id=\"txteliminar\">Eliminar chat</span>\n");
      out.write("\t\t\t\t\t<span><a href=\"close.jsp\">Cerrar sesión</a></span>\n");
      out.write("\t\t\t\t</section>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</section>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\t$().ready(function() {\n");
      out.write("\t\t\tvar mensaje = \"undefined\";\n");
      out.write("\t\t\tvar usuariosigual = \"\";\n");
      out.write("\t\t\tvar chats = 0+\"\";\n");
      out.write("\t\t\tfunction iniciarAjax(nombre) {\n");
      out.write("\t\t\t\tconsole.log(\"Nombre iniciarAjax: \"+nombre);\n");
      out.write("\t\t\t\t(function poll(){\n");
      out.write("\t\t\t\t    $.ajax({ \n");
      out.write("\t\t\t\t    \turl: \"client.jsp\", \t\n");
      out.write("\t\t\t\t    \ttype: \"GET\",\n");
      out.write("\t\t\t\t    \tdata: { texto: mensaje, nombre: nombre, chats: chats },\n");
      out.write("\t\t\t\t    \tsuccess: function(data){\n");
      out.write("\t\t\t\t    \t\tvar res = data.split(\"|:|\");\n");
      out.write("\t\t\t\t\t        var data2 = $.trim(res[0]); \n");
      out.write("\t\t\t\t\t        //console.log(\"Exito data: \"+data2+\" data.value: \"+data.value+\" Mensaje:\"+mensaje);\n");
      out.write("\t\t\t\t\t        if(data2.length>1) {\n");
      out.write("\t\t\t\t\t        \t//console.log(\"Exito data: \"+data2+\" data.value: \"+data.value+\" Mensaje:\"+mensaje);\n");
      out.write("\t\t\t\t\t        \tmensaje = \"undefined\";\n");
      out.write("\t\t\t\t\t\t        var id = $(\"#pestana ul .s\").attr('id');\n");
      out.write("\t\t\t                    id = id.replace(\"ch\",\"\");\n");
      out.write("\t\t\t                    $(\"#con\"+id+\" #mss\").append(\"<div class='mensaje'>\"+data2+\"</div>\");\n");
      out.write("\t\t\t                    $('#con'+id).animate({scrollTop: $(\"#con\"+id+\" #mss\").height()}, 800);\n");
      out.write("\t\t\t                }\n");
      out.write("\t\t\t                var usuarios = res[1];\n");
      out.write("\t\t\t                if (usuarios!=usuariosigual) {\n");
      out.write("\t\t\t                \t$(\"#contm .usuarios ul\").html(usuarios);\n");
      out.write("\t\t\t                \tusuariosigual = usuarios;\n");
      out.write("\t\t\t                \tactivarClickUsuarios();\n");
      out.write("\t\t\t                }\n");
      out.write("\t\t\t                var idNuevoChat = res[2];\n");
      out.write("\t\t\t                if (idNuevoChat.length>=1) {\n");
      out.write("\t\t\t                \talert(\"Chat agregado: \"+idNuevoChat);\n");
      out.write("\t\t\t                \tnuevoChat(idNuevoChat);\n");
      out.write("\t\t\t                }\n");
      out.write("\t\t\t                var idChatEliminar = res[3];\n");
      out.write("\t\t\t                if (idChatEliminar.length>=1) {\n");
      out.write("\t\t\t                \talert(\"Chat eliminado: \"+idChatEliminar);\n");
      out.write("\t\t\t                \teliminarChat(idChatEliminar);\n");
      out.write("\t\t\t                }\n");
      out.write("\t\t\t                \n");
      out.write("\t\t\t\t    \t}, \n");
      out.write("\t\t\t\t    \terror: function(data){\n");
      out.write("\t\t\t\t\t        //console.log(\"Error\");\n");
      out.write("\t\t\t\t    \t}, \n");
      out.write("\t\t\t\t    \tcomplete: poll, \n");
      out.write("\t\t\t\t    \ttimeout: 1000 \n");
      out.write("\t\t\t\t    });\n");
      out.write("\t\t\t\t})();\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tvar act = false;\n");
      out.write("\t\t\tvar chat =1;\n");
      out.write("\t\t\t$(\"#mas\").click(function(){\n");
      out.write("\t\t\t\tconsole.log(\"Click en mas\");\n");
      out.write("\t\t\t\tif ($(this).hasClass(\"select\")) {\n");
      out.write("\t\t\t\t\t// Crear chat\n");
      out.write("\t\t\t\t\tvar rec = [];\n");
      out.write("\t\t\t\t\tvar cont = 0;\n");
      out.write("\t\t\t\t\t// Sacar ID's\n");
      out.write("\t\t\t\t\t$( \".usuarios ul .sel\" ).each(function() {\n");
      out.write("\t\t\t\t\t  \tvar recs = $( this ).attr('id');\n");
      out.write("\t\t\t\t\t  \tvar id = recs.replace(\"u\",\"\");\n");
      out.write("\t\t\t\t\t  \tconsole.log(\"ID \"+id+\" cont:\"+cont);\n");
      out.write("\t\t\t\t\t  \trec[cont] = id;\n");
      out.write("\t\t\t\t\t  \tcont++;\n");
      out.write("\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t$(\".usuarios ul .sel\").removeClass(\"sel\");\n");
      out.write("\t\t\t\t\tvar IDSUsuarios = rec[0];\n");
      out.write("\t\t\t\t\tfor (var i = 1; i<cont; i++) {\n");
      out.write("\t\t\t\t\t\tconsole.log(\"REC \"+rec[i]);\n");
      out.write("\t\t\t\t\t\tIDSUsuarios = IDSUsuarios+\",\"+rec[i];\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t\tif (cont>=1) {\n");
      out.write("\t\t\t\t\t\t// Enviar a server\n");
      out.write("\t\t\t\t\t\t$.ajax({ \n");
      out.write("\t\t\t\t\t    \turl: \"newChat.jsp\", \t\n");
      out.write("\t\t\t\t\t    \ttype: \"GET\",\n");
      out.write("\t\t\t\t\t    \tdata: { usuarios: IDSUsuarios },\n");
      out.write("\t\t\t\t\t    \tsuccess: function(data){\n");
      out.write("\t\t\t\t\t    \t\talert(\"IDChat: \"+data);\n");
      out.write("\t\t\t\t\t\t        var data2 = $.trim(data); \n");
      out.write("\t\t\t\t\t\t       \t// Crear pestaña y conversación\n");
      out.write("\t\t\t\t\t\t\t\tnuevoChat(data2);\n");
      out.write("\t\t\t\t\t    \t}, \n");
      out.write("\t\t\t\t\t    \terror: function(data){\n");
      out.write("\t\t\t\t\t\t        //console.log(\"Error\");\n");
      out.write("\t\t\t\t\t    \t}\n");
      out.write("\t\t\t\t\t    });\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t\tact = false;\n");
      out.write("\t\t\t\t\t$(\"#mas\").removeClass(\"select\");\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t} else {\n");
      out.write("\t\t\t\t\t$(\"#mas\").addClass(\"select\");\n");
      out.write("\t\t\t\t\tact = true;\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\tfunction nuevoChat(id) {\n");
      out.write("\t\t\t\t$(\".s\").removeClass(\"s\");\n");
      out.write("\t\t\t\t$( \"<li id='ch\"+id+\"' class='s'>Chat \"+id+\"</li>\" ).insertBefore( \"#pestana ul #mas\" );\n");
      out.write("\t\t\t\t//$(\"#pestana ul\").append(\"<li id='ch\"+chat+\"' class='s'>Chat \"+chat+\"</li>\")\n");
      out.write("\t\t\t\t$(\".activo\").removeClass(\"activo\");\n");
      out.write("\t\t\t\t$(\"<div id='con\"+id+\"' class='activo chat'><div id='mss'></div></div>\").insertBefore(\"#write\");\t\n");
      out.write("\t\t\t\tactivar();\n");
      out.write("                chats = chats+\",\"+id;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tfunction activarClickUsuarios() {\n");
      out.write("\t\t\t\t$(\".usuarios ul li\").click(function(){\n");
      out.write("\t\t\t\t\tconsole.log(\"Click en usuarios\");\n");
      out.write("\t\t\t\t\tif (act && $(this).hasClass(\"sel\")) {\n");
      out.write("\t\t\t\t\t\t$(this).removeClass(\"sel\");\n");
      out.write("\t\t\t\t\t} else if (act) {\n");
      out.write("\t\t\t\t\t\t$(this).addClass(\"sel\");\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t};\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t$(\"#enviar\").click(function(){\n");
      out.write("\t\t\t\tenviar();\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\tfunction enviar() {\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tvar texto = $(\"#texto\").val();\n");
      out.write("\t\t\t\ttexto = texto.replace(\"\\n\",\"\");\n");
      out.write("\t\t\t\ttexto = texto.replace(\"<\",\"\");\n");
      out.write("\t\t\t\ttexto = texto.replace(\">\",\"\");\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tconsole.log(\"El texto dice: \"+texto);\n");
      out.write("\t\t\t\tif (texto.length>=1) {\n");
      out.write("\t\t\t\t\tmensaje = texto;\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t$(\"#texto\").val(\"\");\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tvar entrar = true;\n");
      out.write("\t\t\tvar activocd = false;\n");
      out.write("\t\t\tfunction cambiarPestana(thing) {\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tvar ids = $(thing).attr('id');\n");
      out.write("\t\t\t\tvar id = ids.replace(\"ch\",\"\");\n");
      out.write("\t\t\t\tconsole.log($.isNumeric(id)+\" ID: \"+id);\n");
      out.write("\t\t\t\tif($.isNumeric(id)) {\n");
      out.write("\t\t\t\t\t$(\"#pestana ul .s\").removeClass(\"s\");\n");
      out.write("\t\t\t\t\t$(thing).addClass(\"s\");\n");
      out.write("\t\t\t\t\tid = \"con\"+id;\n");
      out.write("\t\t\t\t\t$(\".activo\").removeClass(\"activo\");\n");
      out.write("\t\t\t\t\t$(\"#\"+id).addClass(\"activo\");\n");
      out.write("\t\t\t\t\tvar time = setInterval(function() {\n");
      out.write("\t\t\t      \t\tentrar= true;\n");
      out.write("\t\t\t      \t}, 1000);\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t};\n");
      out.write("\n");
      out.write("\t\t\tfunction activar() {\n");
      out.write("\t\t\t\t$(\"#pestana ul li\").click(function(){\n");
      out.write("\t\t\t\t\tconsole.log(\"Entra #pestaña ul li\");\n");
      out.write("\t\t\t\t\tif (!$(this).hasClass(\"s\") && entrar) {\n");
      out.write("\t\t\t\t\t\tentrar = false;\n");
      out.write("\t\t\t\t\t\tcambiarPestana(this);\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t$(\"#snombre\").click(function(){\n");
      out.write("\t\t\t\tingresar();\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\tfunction eliminarChat(id) {\n");
      out.write("\t\t\t\t$(\"#ch\"+id).remove();\n");
      out.write("\t\t\t\t$(\"#con\"+id).remove();\n");
      out.write("\t\t\t\tcambiarPestana(\"#pestana ul #ch-1\");\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t$(\"#txteliminar\").click(function(){\n");
      out.write("\t\t\t\tentrar = false;\n");
      out.write("\t\t    \tif (activocd==false) {\n");
      out.write("\t\t    \t\tactivocd = true;\n");
      out.write("\t\t    \t\tconsole.log(\"False\");\n");
      out.write("\t\t\t\t\tconsole.log(\"Entra Eliminar\");\n");
      out.write("\t\t\t\t\tvar id = $(\".s\").attr('id');\n");
      out.write("\t\t\t\t\tid = id.replace(\"ch\",\"\");\n");
      out.write("\t\t\t\t\tif(id!=-1) {\n");
      out.write("\t\t\t\t\t\t$.ajax({ \n");
      out.write("\t\t\t\t\t    \turl: \"removeChat.jsp\", \t\n");
      out.write("\t\t\t\t\t    \ttype: \"GET\",\n");
      out.write("\t\t\t\t\t    \tdata: { id: id },\n");
      out.write("\t\t\t\t\t    \tsuccess: function(data){\n");
      out.write("\t\t\t\t\t    \t\teliminarChat(id);\n");
      out.write("\t\t\t\t\t    \t\talert(\"Eliminado chat \"+id);\n");
      out.write("\t\t\t\t\t    \t}, \n");
      out.write("\t\t\t\t\t    \terror: function(data){\n");
      out.write("\t\t\t\t\t\t        //console.log(\"Error\");\n");
      out.write("\t\t\t\t\t    \t}\n");
      out.write("\t\t\t\t\t    });\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t    \t}else {\n");
      out.write("\t\t    \t\tactivocd = false;\n");
      out.write("\t\t    \t\tconsole.log(\"True\");\n");
      out.write("\t\t    \t\t$(\"#pestana ul li #menu\").remove();\n");
      out.write("\t\t    \t}\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t      \tvar time = setInterval(function() {\n");
      out.write("\t\t      \t\tentrar= true;\n");
      out.write("\t\t      \t}, 1000);\n");
      out.write("\t\t\t});\n");
      out.write("\n");
      out.write("\t\t\tfunction ingresar() {\n");
      out.write("\t\t\t\tvar nombre = $(\"#nombre\").val();\n");
      out.write("\t\t\t\tconsole.log(\"Nombre ingresar: \"+nombre);\n");
      out.write("\t\t\t\t$(\"#black\").css(\"display\",\"none\");\n");
      out.write("\t\t\t\t$(\"#login\").css(\"display\",\"none\");\n");
      out.write("\t\t\t\tiniciarAjax(nombre);\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t$(document).keypress(function(e) {\n");
      out.write("\t\t\t    if(e.which == 13) {\n");
      out.write("\t\t\t    \tconsole.log(\"Entra\");\n");
      out.write("\t\t\t        if($('#black').css('display') == 'block') {\n");
      out.write("\t\t\t        \t// Ingresando el usuario\n");
      out.write("\t\t\t        \tingresar();\n");
      out.write("\t\t\t\t\t} else {\n");
      out.write("\t\t\t\t\t\t// Comentando\n");
      out.write("\t\t\t\t\t\tenviar();\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t    }\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\t\n");
      out.write("\t\t});\n");
      out.write("\t</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
