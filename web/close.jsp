<%@page import="clases.Client"%>
<% 
    Client cliente;
    cliente = new Client();
    int id = Integer.parseInt(session.getAttribute( "idUsuario" ).toString());
    cliente.setID(id);
    cliente.removeUser();
    session.setAttribute( "idUsuario", null); 
%>
<h3>Haz cerrado sesión</h3>