<%@page import="clases.Client"%>
<%      int idi = Integer.parseInt(request.getParameter("id"));
        Client cliente;
        cliente = new Client();
        int id = Integer.parseInt(session.getAttribute( "idUsuario" ).toString());
        cliente.setID(id);
        cliente.eliminarChat(idi);
    %>