<%-- 
    Document   : insertionEtudiant.jsp
    Created on : 16 nov. 2016, 14:39:04
    Author     : ITU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="creche.ConnexionJDBC" %>
<%@ page import="creche.Enfant" %>
<%@ page import="creche.Parent" %>
<%@ page import="creche.ContactParent" %>
<%@ page import="creche.AdressParent" %>
<%@ page import="creche.Niveau" %>
<%   
    if(Integer.parseInt(request.getParameter("id"))==0 &&
       request.getParameter("nomEtudiant")!=null && request.getParameter("nomEtudiant")!="" &&
       request.getParameter("prenomEtudiant")!=null && request.getParameter("prenomEtudiant")!="" &&
       request.getParameter("sexe")!=null && request.getParameter("sexet")!="" &&
       request.getParameter("date")!=null && request.getParameter("date")!="" &&
       request.getParameter("niveau")!=null && request.getParameter("niveau")!=""){
                Niveau n = new Niveau();
                int idNiveau = n.getIdNiveau(request.getParameter("niveau"));
                Enfant e = new Enfant(request.getParameter("nomEtudiant"),request.getParameter("prenomEtudiant"),request.getParameter("date"),request.getParameter("sexe"));
                Parent p = new Parent();
                int idParent = p.getIdParent();
                e.addEnfant(idParent,idNiveau,e);
                response.sendRedirect("liste.jsp");
                
    }
    if(Integer.parseInt(request.getParameter("id"))!=0 &&
       request.getParameter("nomEtudiant")!=null && request.getParameter("nomEtudiant")!="" &&
       request.getParameter("prenomEtudiant")!=null && request.getParameter("prenomEtudiant")!="" &&
       request.getParameter("sexe")!=null && request.getParameter("sexet")!="" &&
       request.getParameter("date")!=null && request.getParameter("date")!="" &&
       request.getParameter("niveau")!=null && request.getParameter("niveau")!=""){
                Niveau n = new Niveau();
                int idNiveau = n.getIdNiveau(request.getParameter("niveau"));
                Enfant e = new Enfant(request.getParameter("nomEtudiant"),request.getParameter("prenomEtudiant"),request.getParameter("date"),request.getParameter("sexe"));
                Parent p = new Parent();
                int idParent = Integer.parseInt(request.getParameter("id"));
                e.addEnfant(idParent,idNiveau,e);
                response.sendRedirect("liste.jsp");
    }
%>