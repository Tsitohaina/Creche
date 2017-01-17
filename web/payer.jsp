<%@page import="creche.Facture"%>
<%@page import="creche.Niveau"%>
<%@page import="creche.Consommation"%>
<%@page import="creche.Produit"%>
<%@page import="creche.Enfant"%>
<%
    Enfant e1 = new Enfant();
    Enfant e = new Enfant();
    Niveau n = new Niveau();
    Facture f = new Facture();
    String s = "nouveau";
    Consommation c = new Consommation();
    int idE = f.getIdEnfant(Integer.parseInt(request.getParameter("id")));
    String numero = f.getNumero(Integer.parseInt(request.getParameter("id")));
    e = e1.getEnfant(idE);
    String niveau = n.getNiveau(idE);
    Consommation[] ct = c.getConsommation(idE);
    
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
                    <h2>Crèche</h2>
                    <h3>Facture numero : <%out.println(numero); %></h3>
                      <form>    
                           <div class="form-group">
                                 <label>Nom :</label>
                                 <% out.println(e.nomEnfant);%>
                           </div>
                           <div class="form-group">
                                  <label>Prenom :</label>
                                  <% out.println(e.prenomEnfant);%>
                           </div>
                            <div class="form-group">
                                  <label>Sexe :</label>
                                  <% out.println(e.sexeEnfant);%>
                             </div>
                             <div class="form-group">
                                  <label>Niveau:</label>
                                  <% out.println(niveau);%>
                             </div>
                             <div class="form-group" style="display:none">
                                   <input name="id" value="<% out.println(idE);%>">
                             </div>
                     </form>
                </div>
                <div class="col-md-2">
		</div>
            </div>
            <div class="row">
                 <div class="col-md-2">
                 </div>
                <div class="col-md-8">
                     <h2>Consommation</h2> 
                         <div class="panel-group">	
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    
                                    <table border="2" width="100%" class="table table-bordered table-hover table-striped">
                                        <tr>
                                            <th>Date</th>
                                            <th>Designation</th>
                                            <th>Prix(Ariary)</th>
                                        </tr>
                                    <%
                                      double somme = 0;
                                      for(int i=0;i<ct.length;i++){
                                          out.println("<tr><td>"+ct[i].dateConsommation+"</td><td>"+ct[i].nomProduit+"</td><td>"+ct[i].prixProduit+"</td></tr>");
                                          somme = somme + ct[i].prixProduit;
                                      }
                                    %>
                                    </table>
                                    <br>
                                    <h4>Somme à payer :  <%out.println(somme);%>Ariary</h4>
                                    <form method="POST" action="listefacture.jsp">
                                        <div class="form-group" style="display:none">
                                               <input name="payer" value="payer">
                                        </div>
                                        <div class="form-group" style="display:none">
                                                <input name="numero" value="<% out.println(numero);%>">
                                        </div>
                                        <div class="form-group" style="display:none">
                                                <input name="id" value="<% out.println(idE);%>">
                                        </div>
                                         <button type="submit" id="submit" class="btn btn-default" value="payer">Payer</button>
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
