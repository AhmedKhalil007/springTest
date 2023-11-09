<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
    * {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  background: #27272c;
}

button {
  position: relative;
  background: #444;
  color: #fff;
  text-decoration: none;
  text-transform: uppercase;
  border: none;
  letter-spacing: 0.1rem;
  font-size: 1rem;
  padding: 1rem 3rem;
  transition: 0.2s;
}

button:hover {
  letter-spacing: 0.2rem;
  padding: 1.1rem 3.1rem;
  background: var(--clr);
  color: var(--clr);
  /* box-shadow: 0 0 35px var(--clr); */
  animation: box 3s infinite;
}

button::before {
  content: "";
  position: absolute;
  inset: 2px;
  background: #272822;
}

button span {
  position: relative;
  z-index: 1;
}
button i {
  position: absolute;
  inset: 0;
  display: block;
}

button i::before {
  content: "";
  position: absolute;
  width: 10px;
  height: 2px;
  left: 80%;
  top: -2px;
  border: 2px solid var(--clr);
  background: #272822;
  transition: 0.2s;
}

button:hover i::before {
  width: 15px;
  left: 20%;
  animation: move 3s infinite;
}

button i::after {
  content: "";
  position: absolute;
  width: 10px;
  height: 2px;
  left: 20%;
  bottom: -2px;
  border: 2px solid var(--clr);
  background: #272822;
  transition: 0.2s;
}

button:hover i::after {
  width: 15px;
  left: 80%;
  animation: move 3s infinite;
}

@keyframes move {
  0% {
    transform: translateX(0);
  }
  50% {
    transform: translateX(5px);
  }
  100% {
    transform: translateX(0);
  }
}

@keyframes box {
  0% {
    box-shadow: #27272c;
  }
  50% {
    box-shadow: 0 0 25px var(--clr);
  }
  100% {
    box-shadow: #27272c;
  }
}

</style>
<body>
    <body>
        <!--   <button style="--clr:#EA00FF"><span>Button</span><i></i></button> -->
        <!-- <button style="--clr:#FFF01F"><span>Button</span><i></i></button> -->
        <!-- <button style="--clr:#7FFF00"><span>Button</span><i></i></button> -->
        <!-- <button style="--clr:#FF5E00"><span>Button</span><i></i></button> -->
        <a href="ajouterPersonnes"> <button style="--clr:#0FF0FC"><span>Ajouter Personne</span><i></i></button> </a>
        <!-- <button style="--clr:#FF3131"><span>Button</span><i></i></button> -->
        <!-- <button style="--clr:#1F51FF"><span>Button</span><i></i></button> -->
        <a href="updatePersonnes"> <button style="--clr:#0FF0FC"><span>Update Personne</span><i></i></button> </a>
        <!-- <button style="--clr:#BC13FE"><span>Button</span><i></i></button> -->
        <a href="deletePersonnes"> <button style="--clr:#0FF0FC"><span>Supprimer Personne</span><i></i></button> </a>
        <!-- <button style="--clr:#E7EE4F"><span>Button</span><i></i></button> -->
        <a href="listePersonne"> <button style="--clr:#0FF0FC"><span>Liste Personnes</span><i></i></button> </a>
        <!-- <button style="--clr:#FF1493"><span>Button</span><i></i></button> -->
        <!-- <button style="--clr:#CCFF00"><span>Button</span><i></i></button> -->
        <a href="graph"> <button style="--clr:#0FF0FC"><span>Répartition par age</span><i></i></button> </a>
        <!-- <button style="--clr:#FF1493"><span>Button</span><i></i></button> -->
        <!-- <button style="--clr:#CCFF00"><span>Button</span><i></i></button> -->
        <a href="graphmois"> <button style="--clr:#0FF0FC"><span>Répartition par Mois</span><i></i></button> </a>
        <!-- <button style="--clr:#FF1493"><span>Button</span><i></i></button> -->
        <!-- <button style="--clr:#CCFF00"><span>Button</span><i></i></button> -->
      </body>
</body>
</html>