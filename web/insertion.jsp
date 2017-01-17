<%-- 
    Document   : insertion
    Created on : 27 oct. 2016, 13:19:36
    Author     : ITU
--%>
<%@page import="java.util.Date"%>
<%@ page import="creche.ConnexionJDBC" %>
<%@ page import="creche.Enfant" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
							  <li class="dropdown">
                                                                <a class="dropdown-toggle" class="active" data-toggle="dropdown" href="#">Liste
                                                                <span class="caret"></span></a>
                                                                <ul class="dropdown-menu">
                                                                    <li><a href="liste.jsp">Liste enfant</a></li>
                                                                 
                                                                </ul>
                                                          </li>
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
							<form action="insertionParent.jsp"  method="POST">
								<h1>Insertion etudiant</h1>
                                                                <h4>Information parent</h4>
									<div class="form-group">
										<label>Nom parent</label>
										<input type="text" name="nom" class="form-control" required>
									</div>
									<div class="form-group">
										<label>Prenom parent</label>
										<input type="text" name="prenom" class="form-control" required>
									</div>
									<div class="form-group">
										<label>Contact parent</label>
                                                                                <input type="text" name="contact" class="form-control" required>
									</div>
                                                                        <div class="form-group">
										<label>Adresse parent</label>
                                                                                <input type="text" name="adresse" class="form-control" required>
									</div>
									<button type="submit" id="submit" class="btn btn-default" value="Ok">suivant</button>
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
