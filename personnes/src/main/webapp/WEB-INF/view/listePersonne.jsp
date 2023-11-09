<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste Personnes</title>
</head> <body> <h1> Liste des Personnes</h1>
<table>
<tr><th>ID</th><th>Nom personne</th><th>Prix</th><th>Date Création</th></tr> 
<c:forEach items="${personne}" var="p">
<tr>
<td>${p.idPersonne} </td>
<td>${p.nomPersonne}</td>
<td>${p.prenomPersonne }</td>
<td>${p.agePersonne }</td>
<td><fmt:formatDate pattern="dd/MM/yyyy" value="${p.datePersonne}" /></td>
</tr>
</c:forEach>

</table></body></html>