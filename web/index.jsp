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
        <title>4V PLay&Learn</title>
        
        <link rel="stylesheet" href="CSS/curiosidades.css">
    </head>
    
            
        <% 
             int id = Integer.parseInt(request.getParameter("id"));
             String valor = request.getParameter("valor");
             String valorIMG = request.getParameter("valorIMG");
             
            int idActual = 0;
            
            List<Curiosidades> curiosidades = new ArrayList<Curiosidades>();
            ArrayList<String> imagenes = new ArrayList<String>();
            
            Consultas consulta = new Consultas();
            Consultas obj = new Consultas();
           
            imagenes = obj.consultarIMG(valorIMG);
            curiosidades = consulta.consultar(valor);
            
            int max = imagenes.size() - 1;
           //Generando indice aleatorio para mostrar imagen de fondo
            int imagenIndice = (int)(Math.random() * (max - 0 + 1) + 0);
        %>
        
    <body style="
          overflow:hidden;
          background-image: url(<%=imagenes.get(imagenIndice)%>);
           background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            height: 100vh;
            color:white;
          "> 
        <div class="contenedor">
            
            <div class="nav">NAV</div>
            
            <div class="contenido">
               
                <%
                    for(Curiosidades curiosidad : curiosidades){
                        if((id+1)==curiosidad.getId()){
                        idActual = curiosidad.getId();
                %>
                <h1><%=curiosidad.getTitulo()%></h1>
                <hr>
                <p><%=curiosidad.getDescripcion()%></p>
                    
                    <%      }
                        }
                    %>
                    
                    <%if(curiosidades.size() < (id+1)){
                %>      
                <h1>¡ Terminaste ! </h1> 
                <h3>Puedes visitar los otros valores en el menu 
                    o volver a revisar este :)</h3>
                <%
                }%>

            </div>
            
                    <div class="boton1">
                        <form action="javascript:history.back()">
                            <button class="anteriorBTN">Anterior</button>
                        </form>
                    </div>
                        
                    <div class="boton2">
                         <form action="menuCuriosidades.html">
                             <button class="menuBTN">Volver al Menu</button>
                         </form>
                    </div>
                        
                    <div class="boton3">
                        <form action="index.jsp" method="post">
                            <button value="<%=idActual%>" name="id" class="siguienteBTN">Siguiente</button>
                            <input type="hidden" value="<%=valor%>" name="valor">
                            <input type="hidden" value="<%=valorIMG%>" name="valorIMG">
                        </form>
                    </div>
                        
                        
                        
                    
            
            
        </div>
       
            
        
        
        
        
    </body>
</html>
