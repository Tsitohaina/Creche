<%@page import="creche.Personnel"%>
<%@page import="java.util.Date"%>
<%@ page import="creche.ConnexionJDBC" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<%
        if(request.getParameter("nom")!=null && request.getParameter("nom")!="" &&
                request.getParameter("prenom")!=null && request.getParameter("prenom")!="" &&
                request.getParameter("date")!=null && request.getParameter("date")!="" &&
                request.getParameter("sexe")!=null && request.getParameter("sexe")!="" &&
                request.getParameter("email")!=null && request.getParameter("email")!="" &&
                request.getParameter("pass")!=null && request.getParameter("pass")!=""){
                try{    
                    Personnel p = new Personnel(request.getParameter("nom"),
                    request.getParameter("prenom"),
                    request.getParameter("date"),
                    request.getParameter("sexe"),
                    request.getParameter("email"),
                    request.getParameter("pass"));
                    p.inscription(p);
                }
                catch(Exception e){
                    out.println("<script type='text/javascript'>alert("+e.getMessage()+")</script>");
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
							  <li><a href="index.html" class="active">Creche</a></li>
							  <li class="dropdown">
								<a class="dropdown-toggle" data-toggle="dropdown" href="#">Insertion
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
				<div class="panel-group">	
					<div class="panel panel-default">
						<div class="panel-body">
                                                    <form method="POST">
								<h2>Inscription utilisateur</h2>
									<div class="form-group">
										<label>Nom</label>
                                                                                <input type="text" name="nom" class="form-control" required>
									</div>
									<div class="form-group">
										<label>Prenom</label>
                                                                                <input type="text" name="prenom" class="form-control" required>
									</div>
                                                                        <div class="form-group">
										<label>Date de naissance</label>
                                                                                <input type="date" name="date" class="form-control" required>
									</div>
                                                                        <div class="form-group">
										<label>Sexe</label>
                                                                                <input type="text" name="sexe" class="form-control" required>
									</div>
                                                                        <div class="form-group">
										<label>E-mail</label>
                                                                                <input type="email" name="email" class="form-control" required>
									</div>
                                                                        <div class="form-group">
										<label>Mot de passe</label>
                                                                                <input type="password" name="pass" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Le mot de passe doit contenir 1 majucul,1 chiffre,1 caractere special et au moins 8 cararcteres" class="form-control" required>
									</div>
                                                                        <div class="form-group">
                                                                            <%				          
                                                                                ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI", "6LeIxAcTAAAAAGG-vFI1TnRWxMZNFuojJ4WifJWe", false);
                                                                                out.print(c.createRecaptchaHtml(null, null));
                                                                             %>    
                                                                        </div>
									<button type="submit" id="submit" class="btn btn-default" value="Ok">Ok</button>
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
