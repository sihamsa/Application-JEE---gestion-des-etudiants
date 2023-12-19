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
                <li class="nav-item "> <a class="nav-link" href="<%=request.getContextPath()%>/showdepartement" data-abc="true">Departements <span class="sr-only">(current)</span></a> </li>
                <li class="nav-item active"> <a class="nav-link" href="<%=request.getContextPath()%>/showfilier" data-abc="true">Filieres </a> </li>
                <li class="nav-item "> <a class="nav-link" href="<%=request.getContextPath()%>/showetudiant" data-abc="true">Etudiants </a> </li>
            </ul>
            <form  action="chercherfilier" method="post" class="form-inline my-2 my-lg-0"> <input class="form-control mr-sm-2" type="text" placeholder="Search" name="nameUser2" > <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button> </form> 
          <ul class="navbar-nav mr-auto" style="margin-left: 51%;">
            <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/logout" data-abc="true">Deconnecter</a> </li>
        </ul>

        </div>
    </nav>


    <a href="<%=request.getContextPath()%>/newfilier" > <i class='bx bx-plus' style='color:rgb(66, 64, 64);font-size:40px;' title="Ajouter un departement" ></i></a>
        
       
        <div class="" style="position:relative; top: 10%;">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Filier</th>
                        <th scope="col">Nom professeur</th>
                        <th scope="col">Numbre d'etudiant</th>

                        <th scope="col">Action</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${Filiere}">

                        <tr>
                            <td>
                                <c:out value="${user.id}" />
                            </td>
                            <td>
                                <c:out value="${user.nom}" />
                            </td>
                            <td>
                                <c:out value="${user.nomprof}" />
                            </td>
                            <td>
                                <c:out value="${user.netudiant}" />
                            </td>
                            <td><a href="editfilier?id=<c:out value='${user.id}' />"><i class='bx bxs-edit'
                                        style='color:#39d119;font-size:20px;' title="Modifier le filiere"></i></a>
                                &nbsp;&nbsp;&nbsp;&nbsp; <a href="deletefilier?id=<c:out value='${user.id}' />"><i
                                        class='bx bx-trash' style='color:#ea1818; font-size:20px;'
                                        title="Supprimer le filiere"></i></a></td>


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