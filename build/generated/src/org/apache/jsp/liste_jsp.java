package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import creche.ConnexionJDBC;
import creche.Enfant;

public final class liste_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    Enfant[] e1;
    Enfant e = new Enfant();
    int nb = e.getNbEnfant();
    e1 = e.findEnfant();
    String s = "nouveau";
    if(request.getParameter("champ")!=null && request.getParameter("champ")!="" &&
       request.getParameter("mot")!=null && request.getParameter("mot")!=""){
   		e1 = e.findEnfantSearch(
                request.getParameter("champ"),
                request.getParameter("mot"));
                nb = e1.length;
    }
    if(request.getParameter("champ")!=null && request.getParameter("champ")!="" &&
       request.getParameter("champ1")!=null && request.getParameter("champ1")!="" &&
       request.getParameter("champ1")!=null && request.getParameter("champ1")!="" &&
       request.getParameter("mot1")!=null && request.getParameter("mot1")!=""){
   		e1 = e.findEnfantSearch1(
                request.getParameter("champ"),
                request.getParameter("mot"),
                request.getParameter("champ1"),
                request.getParameter("mot1"));
                nb = e1.length;
    }
    if(request.getParameter("id")!=null && request.getParameter("id")!="" ){
                int suppr = e.supprimerEnfant(Integer.parseInt(request.getParameter("id")));
                response.sendRedirect("liste.jsp");
    }
    if(request.getParameter("nouveau")!=null && request.getParameter("nouveau")!=""){ 
        if(s.compareTo(request.getParameter("nouveau"))==0){
               response.sendRedirect("insertion.jsp");
        }
    }
    

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<title>Crèche</title>\n");
      out.write("\t\t<meta charset=\"utf-8\">\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("\t\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("\t\t<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\t\t<script src=\"../bootstrap/js/bootstrap.js\"></script>\n");
      out.write("\t\t<script src=\"../bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("\t\t<script src=\"../bootstrap/js/npm.js\"></script>\n");
      out.write("\t\t<link href=\"../bootstrap/css/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("\t\t<link href=\"../bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("\t\t<link href=\"../bootstrap/css/bootstrap-theme.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\t\t<link href=\"../bootstrap/css/bootstrap-theme.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\t\t<link href=\"../css/style1.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\t\t<script src=\"../javascript.js\"></script>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\t\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col-md-2\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t <div class=\"col-md-8\">\n");
      out.write("\t\t\t\t\t  <nav class=\"navbar navbar-inverse\">\n");
      out.write("\t\t\t\t\t\t  <div class=\"container-fluid\">\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"nav navbar-nav\">\n");
      out.write("\t\t\t\t\t\t\t  <li><a href=\"index.html\">Creche</a></li>\n");
      out.write("\t\t\t\t\t\t\t  <li class=\"dropdown\">\n");
      out.write("\t\t\t\t\t\t\t\t<a class=\"dropdown-toggle\" class=\"active\" data-toggle=\"dropdown\" href=\"#\">Insertion\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"caret\"></span></a>\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">\n");
      out.write("\t\t\t\t\t\t\t\t  <!--<li><a href=\"insertP.jsp\">Inserer parent</a></li>-->\n");
      out.write("\t\t\t\t\t\t\t\t  <li><a href=\"insertion.jsp\">Inserer etudiant</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t  </li>\n");
      out.write("\t\t\t\t\t\t\t  <li class=\"dropdown\">\n");
      out.write("                                                                <a class=\"dropdown-toggle\" class=\"active\" data-toggle=\"dropdown\" href=\"#\">Liste\n");
      out.write("                                                                <span class=\"caret\"></span></a>\n");
      out.write("                                                                <ul class=\"dropdown-menu\">\n");
      out.write("                                                                    <li><a href=\"liste.jsp\">Liste enfant</a></li>\n");
      out.write("                                                                    <li><a href=\"listeParent.jsp\">Liste parent</a></li>\n");
      out.write("                                                                </ul>\n");
      out.write("                                                          </li>\n");
      out.write("\t\t\t\t\t\t\t  <li><a href=\"#\">Ecolage</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</nav>\n");
      out.write("\t\t\t\t<hr>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col-md-2\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("            \n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-2\">\n");
      out.write("                </div>\n");
      out.write("                 <div class=\"col-md-8\">\n");
      out.write("                    <h1>Listes des enfants</h1>\n");
      out.write("                    <form>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Champ 1</label>\n");
      out.write("\t\t\t\t<select id=\"sexe\" name=\"champ\">\n");
      out.write("                                    <option value=\"nomenfant\">nom</option>\t\n");
      out.write("                                    <option value=\"prenomenfant\">prénom</option>\n");
      out.write("                                    <option value=\"sexeenfant\">sexe</option>\n");
      out.write("                                </select>\n");
      out.write("\t\t\t</div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Mot clé</label>\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"mot\" class=\"form-control\"> \n");
      out.write("\t\t\t</div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Champ 2</label>\n");
      out.write("\t\t\t\t<select id=\"sexe\" name=\"champ1\">\t\n");
      out.write("                                    <option value=\"prenomenfant\">prénom</option>\n");
      out.write("                                    <option value=\"sexeenfant\">sexe</option>\n");
      out.write("                                </select>\n");
      out.write("\t\t\t</div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Mot clé</label>\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"mot1\" class=\"form-control\"> \n");
      out.write("\t\t\t</div>\n");
      out.write("                        <button type=\"submit\" id=\"submit\" class=\"btn btn-default\" value=\"Ok\">Ok</button>\n");
      out.write("                    </form><hr>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-2\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                 <div class=\"col-md-2\">\n");
      out.write("                 </div>\n");
      out.write("                <div class=\"col-md-7\">\n");
      out.write("                 </div>\n");
      out.write("                <div class=\"col-md-1\">\n");
      out.write("                    <form>\n");
      out.write("                        <div class=\"form-group\" style=\"display:none\">\n");
      out.write("                               <input name=\"nouveau\" value=\"nouveau\">\n");
      out.write("                        </div>\n");
      out.write("                         <button type=\"submit\" id=\"submit\" class=\"btn btn-default\" value=\"nouveau\">Nouveau</button><br><br>\n");
      out.write("                    </form>                   \n");
      out.write("                 </div>\n");
      out.write("                <div class=\"col-md-2\">\n");
      out.write("                 </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                 <div class=\"col-md-2\">\n");
      out.write("                 </div>\n");
      out.write("                <div class=\"col-md-8\">\n");
      out.write("                   \n");
      out.write("                         <div class=\"panel-group\">\t\n");
      out.write("                            <div class=\"panel panel-default\">\n");
      out.write("                                <div class=\"panel-body\">\t       \n");
      out.write("                                    <table border=\"2\" width=\"100%\" class=\"table table-bordered table-hover table-striped\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>Nom</th>\n");
      out.write("                                            <th>Prenom</th>\n");
      out.write("                                            <th>Sexe</th>\n");
      out.write("                                            <th>Action</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    ");

                                      for(int i=0;i<nb;i++){
                                          out.println("<tr><td><a href='ecolage.jsp?id="+e1[i].idEnfant+"'>"+e1[i].nomEnfant+"</a></td><td>"+e1[i].prenomEnfant+"</td><td>"+e1[i].sexeEnfant+"</td><td><a href='fiche.jsp?id="+e1[i].idEnfant+"'>Modifier  </a>/<a href='liste.jsp?id="+e1[i].idEnfant+"'> Supprimer</a></td></tr>");
                                      }
                                    
      out.write("\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                         </div>\n");
      out.write("                 </div>\n");
      out.write("                 <div class=\"col-md-2\">\n");
      out.write("                 </div>\n");
      out.write("            </div>\n");
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
