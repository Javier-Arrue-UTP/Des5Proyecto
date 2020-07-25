package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Controlador.Consultas;
import java.util.List;
import java.util.List;
import java.util.ArrayList;
import Entidades.Curiosidades;

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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>4V PLay&Learn</title>\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/curiosidades.css\">\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("            \n");
      out.write("        ");
 
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
        
      out.write("\n");
      out.write("        \n");
      out.write("    <body style=\"\n");
      out.write("          overflow:hidden;\n");
      out.write("          background-image: url(");
      out.print(imagenes.get(imagenIndice));
      out.write(");\n");
      out.write("           background-position: center;\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-size: cover;\n");
      out.write("            height: 100vh;\n");
      out.write("            color:white;\n");
      out.write("          \"> \n");
      out.write("        <div class=\"contenedor\">\n");
      out.write("            \n");
      out.write("            <div class=\"nav\">NAV</div>\n");
      out.write("            \n");
      out.write("            <div class=\"contenido\">\n");
      out.write("               \n");
      out.write("                ");

                    for(Curiosidades curiosidad : curiosidades){
                        if((id+1)==curiosidad.getId()){
                        idActual = curiosidad.getId();
                
      out.write("\n");
      out.write("                <h1>");
      out.print(curiosidad.getTitulo());
      out.write("</h1>\n");
      out.write("                <hr>\n");
      out.write("                <p>");
      out.print(curiosidad.getDescripcion());
      out.write("</p>\n");
      out.write("                    \n");
      out.write("                    ");
      }
                        }
                    
      out.write("\n");
      out.write("                    \n");
      out.write("                    ");
if(curiosidades.size() < (id+1)){
                
      out.write("      \n");
      out.write("                <h1>¡ Terminaste ! </h1> \n");
      out.write("                <h3>Puedes visitar los otros valores en el menu \n");
      out.write("                    o volver a revisar este :)</h3>\n");
      out.write("                ");

                }
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("                    <div class=\"boton1\">\n");
      out.write("                        <form action=\"javascript:history.back()\">\n");
      out.write("                            <button class=\"anteriorBTN\">Anterior</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                        \n");
      out.write("                    <div class=\"boton2\">\n");
      out.write("                         <form action=\"menuCuriosidades.html\">\n");
      out.write("                             <button class=\"menuBTN\">Volver al Menu</button>\n");
      out.write("                         </form>\n");
      out.write("                    </div>\n");
      out.write("                        \n");
      out.write("                    <div class=\"boton3\">\n");
      out.write("                        <form action=\"index.jsp\" method=\"post\">\n");
      out.write("                            <button value=\"");
      out.print(idActual);
      out.write("\" name=\"id\" class=\"siguienteBTN\">Siguiente</button>\n");
      out.write("                            <input type=\"hidden\" value=\"");
      out.print(valor);
      out.write("\" name=\"valor\">\n");
      out.write("                            <input type=\"hidden\" value=\"");
      out.print(valorIMG);
      out.write("\" name=\"valorIMG\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                    \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("       \n");
      out.write("            \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
