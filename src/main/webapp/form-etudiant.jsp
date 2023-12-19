<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%
String login = "";
      if(session.getAttribute("username")!=null){
    	   login = session.getAttribute("username").toString();
      }else{
			response.sendRedirect("Login.jsp");

      }

%>



<html>

<head>
    <title></title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- <link rel="preconnect" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"> -->
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous"> -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous"> -->



</head>
<style>

</style>

<body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a class="navbar-brand" href="#" data-abc="true">BBBOOTSTRAP</a> <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
        <div class="collapse navbar-collapse" id="navbarColor02">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/showdepartement" data-abc="true">Departements <span class="sr-only">(current)</span></a> </li>
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/showfilier" data-abc="true">Filieres </a> </li>
                <li class="nav-item active"> <a class="nav-link" href="<%=request.getContextPath()%>/showetudiant" data-abc="true">Etudiants </a> </li>
            </ul>
            <form  action="chercheretudiant" method="post" class="form-inline my-2 my-lg-0"> <input class="form-control mr-sm-2" type="text" placeholder="Search" name="nameUser3"> <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button> </form> 
          <ul class="navbar-nav mr-auto" style="margin-left: 51%;">
            <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/logout" data-abc="true">Deconnecter</a> </li>
        </ul>

        </div>
    </nav>
    <a href="<%=request.getContextPath()%>/newetudiant" > <i class='bx bx-plus' style='color:rgb(66, 64, 64);font-size:40px;' title="Ajouter un departement" ></i></a>

<div   style="margin-top:5%;">

    <center><c:if test="${user != null}">
        <form action="updateetudiant" method="post" class="start">
    </c:if>
    <c:if test="${user == null}">
        <form action="insertetudiant" method="post" class="start">
    </c:if>
    
    <caption>
        <h2>
            <c:if test="${user != null}">
    Modifier l'etudiant <c:out value="${user.nom}" /> :	
    <br>
     </c:if>
            <c:if test="${user == null}">
           Ajouter un etudiant :
           
           <br>
        </c:if>
        </h2>
    </caption>
    
    <c:if test="${user != null}">
        <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
    </c:if>
    
    
    <div class="form-floating mb-3">
            <label for="floatingInput">CNE </label>
    
        <input type="text" style=" width:70% " class="form-control" name="cne"  value="<c:out value='${user.cne}' />" id="floatingInput" placeholder="Nom de filiere">
      </div>
    <div class="form-floating mb-3">
            <label for="floatingInput">Nom</label>
    
        <input type="text" style=" width:70% " class="form-control" name="name"  value="<c:out value='${user.nom}' />" id="floatingInput" placeholder="Nom de filiere">
      </div>
      <div class="form-floating mb-3">
              <label for="floatingInput">Prenom</label>
      
        <input type="text"  style=" width:70% " class="form-control" name="prenom"  value="<c:out value='${user.prenom}' />" id="floatingInput" placeholder="Nom de filiere">
      </div>
      <div class="form-floating mb-3">
              <label for="floatingInput">Telephone</label>
      
        <input type="text" style=" width:70% " class="form-control" name="telephone"  value="<c:out value='${user.telephone}' />" id="floatingInput" placeholder="Nom de professeur">
      </div>
        <c:if test="${user != null}">
        <div class="form-floating mb-3">
                <label for="floatingInput">Id de filiere</label>
        
        <input type="number" style=" width:70% " readonly class="form-control" name="idfilier"  value="<c:out value='${user.idfilier}' />" id="floatingInput" placeholder="Nom de professeur">
      </div>
      <div class="form-floating mb-3">
              <label for="floatingInput">Id de Departement</label>
      
        <input type="number" style=" width:70% " readonly class="form-control" name="iddepar"  value="<c:out value='${user.iddepar}' />" id="floatingInput" placeholder="Id de Departement">
      </div>
    </c:if>
    
    <c:if test="${user == null}">
    <div class="form-floating mb-3">
            <label for="floatingInput">Id de filiere</label>
    
        <input type="number" style=" width:70% " class="form-control" name="idfilier"  value="<c:out value='${user.idfilier}' />" id="floatingInput" placeholder="Nom de professeur">
      </div>
     <div class="form-floating mb-3">
             <label for="floatingInput">Id de Departement</label>
     
        <input type="number" style=" width:70% " class="form-control" name="iddepar"  id="floatingInput" placeholder="Id de Departement">
      </div>
    </c:if>
    
    <div class="col-12">
    <c:if test="${user != null}">
    <button class="btn btn-primary" type="submit">Modifier</button>
    </c:if>
    
    <c:if test="${user == null}">
    <button class="btn btn-primary" type="submit">Ajouter</button>
    </c:if>
    
    </div>
    </form>
    </center>
    </div>
        <!--Container Main end-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous">
        </script>
       
    </body>

</html>