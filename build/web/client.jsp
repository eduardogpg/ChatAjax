<%@page import="clases.Client"%>
<% if( request.getParameter("texto") != null) {
        String nombre = request.getParameter("nombre");
        String chats = request.getParameter("chats");
        Client cliente;
        cliente = new Client();
        if ( session.getAttribute( "idUsuario" ) ==null) {
            session.setAttribute( "idUsuario", cliente.getNewID(nombre));
        }
        int id = Integer.parseInt(session.getAttribute( "idUsuario" ).toString());
        cliente.setID(id);

        String Message = request.getParameter("texto");
        
        // Mandar mensaje
        if (!Message.equals("undefined")) {
            cliente.Enviar(Message);
        }
        out.print(cliente.Recibir()+"|:|"+cliente.usuariosConectados()+cliente.usuariosConectados(chats)+"|:|"+cliente.revNuevoChat()+"|:|"+cliente.revEliminadoChat(chats));
    }
    %>