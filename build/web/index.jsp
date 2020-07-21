<%-- 
    Document   : index
    Created on : 07/04/2020, 03:42:23 PM
    Author     : javi0
--%>

<%@page import="Controlador.Consultas"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Curiosidades"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prueba de Guardado</title>
    </head>
    <body>
        <h1>Prueba de mostrado de datos</h1>
        
        <% 
            List<Curiosidades> curiosidades = new ArrayList<Curiosidades>();
            Consultas consulta = new Consultas();
            
            curiosidades = consulta.consultar();
        %>
                <table>
            <thead>
                <th>Curiosidad</th>
            </thead>
            <tbody>
                <%
                    for(Curiosidades curiosidad : curiosidades){
                %>
                <tr>
                    <td><%=curiosidad.getDescripcion()%></td>
                </tr>
                <%}
                %>
            </tbody>

        </table>

        
        
        
    </body>
</html>
