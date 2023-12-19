<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




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
                <li class="nav-item active"> <a class="nav-link" href="<%=request.getContextPath()%>/" data-abc="true">Departements <span class="sr-only">(current)</span></a> </li>
                <li class="nav-item "> <a class="nav-link" href="<%=request.getContextPath()%>/Filier" data-abc="true">Filieres </a> </li>
                <li class="nav-item "> <a class="nav-link" href="<%=request.getContextPath()%>/Etudiant" data-abc="true">Etudiants </a> </li>
            </ul>
            <form  action="chercherindexdepartement" method="post" class="form-inline my-2 my-lg-0"> <input class="form-control mr-sm-2" type="text" placeholder="Search"  name="nameUser" value="${model.nameUser}"> <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button> </form> 
          <ul class="navbar-nav mr-auto" style="margin-left: 51%;">
            <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/login" data-abc="true">Connecter</a> </li>
        </ul>

        </div>
    </nav>


    <div class="" style="position:relative; top: 10%;">
        <table class="table">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Departement</th>
                <th scope="col">Numbre Filiere</th>
                <th scope="col">Numbre d'etudiant</th>
              </tr>
            </thead>
            <tbody>
                <c:forEach items="${model.departement}" var="p">
                 <tr>
                   <th scope="row">${p.id }</th>
                   <td>${p.nom }</td>
                   <td>${p.nfilier }</td>
                   <td>${p.netudiant }</td>
                 </tr>
                </c:forEach>
                 
               </tbody>
          </table>         
        
</div>
    
    
        <!--Container Main end-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous">
        </script>
       
    </body>

</html>