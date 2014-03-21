<%@page import="clases.Client"%>
<%      String usuarios = request.getParameter("usuarios");
        
       
            Client cliente;
            cliente = new Client();
            int id = Integer.parseInt(session.getAttribute( "idUsuario" ).toString());
            cliente.setID(id);
            int IDChat = cliente.crearChat(usuarios);
            out.print(IDChat);
        
  %>