<%@page import="creche.Parent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@ page import="creche.ConnexionJDBC" %>
<%@ page import="creche.Enfant" %>
<%  
    Parent ef = new Parent();
    Enfant[] e = ef.getAllEnfant(Integer.parseInt(request.getParameter("id")));
    Parent p = ef.getParent(Integer.parseInt(request.getParameter("id")));
    String s = "supprimer";
    if(request.getParameter("supprimer")!=null && request.getParameter("supprimer")!=""){ 
        if(s.compareTo(request.getParameter("supprimer"))==0){             
               ef.supprimerTout(Integer.parseInt(request.getParameter("id")));
               response.sendRedirect("listeParent.jsp");
        }
    }
%>
<!DOCTYPE html>
<html>
	<head>
		<title>Crèche</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="../bootstrap/js/bootstrap.js"></script>
		<script src="../bootstrap/js/bootstrap.min.js"></script>
		<script src="../bootstrap/js/npm.js"></script>
		<link href="../bootstrap/css/bootstrap.css" rel="stylesheet" />
		<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		<link href="../bootstrap/css/bootstrap-theme.css" rel="stylesheet" type="text/css" />
		<link href="../bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
		<link href="../css/style1.css" rel="stylesheet" type="text/css" />
		<script src="../javascript.js"></script>
	</head>
	<body>	
		<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
					  <nav class="navbar navbar-inverse">
						  <div class="container-fluid">
							<ul class="nav navbar-nav">
							  <li><a href="index.html">Creche</a></li>
							  <li class="dropdown">
								<a class="dropdown-toggle" class="active" data-toggle="dropdown" href="#">Insertion
								<span class="caret"></span></a>
								<ul class="dropdown-menu">
								  <!--<li><a href="insertP.jsp">Inserer parent</a></li>-->
								  <li><a href="insertion.jsp">Inserer etudiant</a></li>
								</ul>
							  </li>
							  <li class="dropdown">
                                                                <a class="dropdown-toggle" class="active" data-toggle="dropdown" href="#">Liste
                                                                <span class="caret"></span></a>
                                                                <ul class="dropdown-menu">
                                                                    <li><a href="liste.jsp">Liste enfant</a></li>
                                                                    <li><a href="listeParent.jsp">Liste parent</a></li>
                                                                </ul>
                                                          </li>
							  <li><a href="ecolage.jsp">Facture</a></li>
							</ul>
						</div>
					</nav>
				<hr>
				</div>
				<div class="col-md-2">
				</div>
		</div>
                 <div class="row">
                 <div class="col-md-2">
                 </div>
                 <div class="col-md-8"><hr>
                         <div class="panel-group">	
                            <div class="panel panel-default">
                                <div class="panel-body">	       
                                 <form>    
                                    <div class="form-group">
                                        <label>Nom :</label>
                                        <% out.println(p.nomParent);%>
                                    </div>
                                    <div class="form-group">
                                        <label>Prenom :</label>
                                        <% out.println(p.prenomParent);%>
                                    </div>                                     
                                 </form>
                                </div>
                            </div>
                         </div>
                 </div>
                 <div class="col-md-2">
                 </div>
            </div>
           <div class="row">
                 <div class="col-md-2">
                 </div>
                <div class="col-md-8">                  
                         <div class="panel-group">	
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h3>Suppression</h3>
                                    <table border="2" width="100%" class="table table-bordered table-hover table-striped">
                                        <tr>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>Sexe</th>
                                        </tr>
                                    <%
                                      for(int i=0;i<e.length;i++){
                                          out.println("<tr><td>"+e[i].nomEnfant+"</td><td>"+e[i].prenomEnfant+"</td><td>"+e[i].sexeEnfant+"</td></tr>");
                                      }
                                    %>
                                    </table>
                                </div>
                                    <form method="POST">
                                    <div class="form-group" style="display:none">
                                           <input name="supprimer" value="supprimer">
                                           <input name="id" value=<%out.println(p.idParent);%>>
                                    </div>
                                    <button type="submit" id="submit" class="btn btn-default" value="supprimer">Confirmer la suppression</button><br><br>
                                 </form> 
                            </div>
                         </div>
                 </div>
                 <div class="col-md-2">
                 </div>
            </div>
         </body>
</html>
