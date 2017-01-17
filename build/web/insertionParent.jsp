<%-- 
    Document   : insertionParent.jsp
    Created on : 16 nov. 2016, 10:30:00
    Author     : ITU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="creche.ConnexionJDBC" %>
<%@ page import="creche.Parent" %>
<%@ page import="creche.ContactParent" %>
<%@ page import="creche.AdressParent" %>
<%@ page import="creche.Niveau" %>
<%
    int id = 0;
    if(request.getParameter("nom")!=null && request.getParameter("nom")!="" &&
       request.getParameter("prenom")!=null && request.getParameter("prenom")!="" &&
       request.getParameter("contact")!=null && request.getParameter("contact")!="" &&
       request.getParameter("adresse")!=null && request.getParameter("adresse")!=""){
   		Parent p = new Parent();
                p.addParent(request.getParameter("nom"),request.getParameter("prenom"));
                ContactParent c = new ContactParent(request.getParameter("contact"));
                c.addContact(c);
                AdressParent a = new AdressParent(request.getParameter("adresse"));
                a.addAdress(a);
                
    }
    if(request.getParameter("id")!=null && request.getParameter("id")!=""){
                id = Integer.parseInt(request.getParameter("id"));
    }
    Niveau n = new Niveau();
    int t =n.getNbNiveau(); 
    String[] niveau =  n.getNomNiveau();
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
								  <li><a href="#">Inserer etudiant</a></li>
								</ul>
							  </li>
							  <li><a href="liste.jsp">Liste</a></li>
							  <li><a href="#">Page 3</a></li>
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
				<div class="panel-group">	
					<div class="panel panel-default">
						<div class="panel-body">
                                                    <form action="insertionEtudiant.jsp">
								<h1>Insertion etudiant</h1>
                                                                <h4>Information etudiant</h4>
									<div class="form-group">
										<label>Nom</label>
										<input type="text" name="nomEtudiant" class="form-control"> 
									</div>
									<div class="form-group">
										<label>Prenom</label>
										<input type="text" name="prenomEtudiant" class="form-control">
									</div>
									<div class="form-group">
										<label>Sexe</label>
										<select name="sexe">
                                                                                    <option value="Masculin">Masculin</option>
                                                                                    <option value="Feminin">Féminin</option>
                                                                                </select>
									</div>
                                                                        <div class="form-group">
										<label>Date de naissance</label>
										<input type="date" name="date" class="form-control">
									</div>
                                                                        <div class="form-group">
										<label>Niveau</label>
										<select name="niveau">
                                                                                    <%
                                                                                        for(int i=0;i<t;i++){
                                                                                           out.println("<option value='"+niveau[i]+"'>"+niveau[i]+"</option>");
                                                                                        }
                                                                                    %> 
                                                                                </select>
									</div>
                                                                        <div class="form-group" style="display:none">
                                                                            <input name="id" value="<% out.println(id);%>">
                                                                        </div>
									<button type="submit" id="submit" class="btn btn-default" value="Ok">Ajouter</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-2">
			</div>
		</div>
	</body>
</html>
