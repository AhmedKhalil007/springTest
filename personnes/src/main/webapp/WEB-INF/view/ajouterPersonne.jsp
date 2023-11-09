<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Créer une Personne</title>
</head>
<body>
<form action="savePersonne" method="post">
<pre>
nom : <input type="text" name="nomPersonne">
prenomnom : <input type="text" name="prenomPersonne">
age : <input type="text" name="agePersonne">
date création : <input type="date" name="date" >
<input type="submit" value="ajouter"></pre>
</form>
${msg}
<br/>
<br/>
<form action="deletePersonne" >
    <pre>
    id Personne <input type="text" name="idPersonne">
    <input type="submit" value="deletePersonne">
    </pre>
</form>
${msg2}
<br>
<br>
<br>
<br>
<br>
<br>
<form action="updatePersonne" method="post">
    <pre>
     idPersonne : <input type="text" name="idPersonne">
    nom : <input type="text" name="nomPersonne">
    prenomnom : <input type="text" name="prenomPersonne">
    age : <input type="text" name="agePersonne">
    date création : <input type="date" name="date" >
    <input type="submit" value="updatePersonne"></pre>
    </form>
<br>
<br>
<br>
<br>
<br>
<br>

<a href="ListePersonne">Liste Personnes</a>
</body>
</html>