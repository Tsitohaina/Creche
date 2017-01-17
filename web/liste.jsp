<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@ page import="creche.ConnexionJDBC" %>
<%@ page import="creche.Enfant" %>
<%
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
                out.println("<script type='text/javascript'>alert('Enfant supprimer')</script>");
                response.sendRedirect("liste.jsp");
    }
    if(request.getParameter("nouveau")!=null && request.getParameter("nouveau")!=""){ 
        if(s.compareTo(request.getParameter("nouveau"))==0){
               response.sendRedirect("insertion.jsp");
               
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
							  <li><a href="listefacture.jsp">Facture</a></li>
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
                 <div class="col-md-8">
                    <h1>Listes des enfants</h1>
                    <form>
                        <div class="form-group">
                            <label>Champ 1</label>
				<select id="sexe" name="champ">
                                    <option value="nomenfant">nom</option>	
                                    <option value="prenomenfant">prénom</option>
                                    <option value="sexeenfant">sexe</option>
                                </select>
			</div>
                        <div class="form-group">
                            <label>Mot clé</label>
				<input type="text" name="mot" class="form-control"> 
			</div>
                        <div class="form-group">
                            <label>Champ 2</label>
				<select id="sexe" name="champ1">	
                                    <option value="prenomenfant">prénom</option>
                                    <option value="sexeenfant">sexe</option>
                                </select>
			</div>
                        <div class="form-group">
                            <label>Mot clé</label>
				<input type="text" name="mot1" class="form-control"> 
			</div>
                        <button type="submit" id="submit" class="btn btn-default" value="Ok">Ok</button>
                    </form><hr>
            </div>
            <div class="col-md-2">
            </div>
        </div>
            <div class="row">
                 <div class="col-md-2">
                 </div>
                <div class="col-md-7">
                 </div>
                <div class="col-md-1">
                    <form method="POST">
                        <div class="form-group" style="display:none">
                               <input name="nouveau" value="nouveau">
                        </div>
                         <button type="submit" id="submit" class="btn btn-default" value="nouveau">Nouveau</button><br><br>
                    </form>                   
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
                                    <table border="2" width="100%" class="table table-bordered table-hover table-striped">
                                        <tr>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>Sexe</th>
                                            <th>Action</th>
                                        </tr>
                                    <%
                                      for(int i=0;i<nb;i++){
                                          out.println("<tr><td><a href='consommation.jsp?id="+e1[i].idEnfant+"'>"+e1[i].nomEnfant+"</td><td>"+e1[i].prenomEnfant+"</td><td>"+e1[i].sexeEnfant+"</td><td><a href='fiche.jsp?id="+e1[i].idEnfant+"'>Modifier  </a>/<a href='liste.jsp?id="+e1[i].idEnfant+"'> Supprimer</a></td></tr>");
                                      }
                                    %>
                                    </table>
                                </div>
                            </div>
                         </div>
                 </div>
                 <div class="col-md-2">
                 </div>
            </div>
    </body>
</html>
