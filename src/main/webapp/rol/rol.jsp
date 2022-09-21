<%-- 
    Document   : rol
    Created on : 3 sept. 2022, 14:01:30
    Author     : Alberto Moisés Gerardo Lemus Alvarado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_GT" />


<!DOCTYPE html>
<html lang="es">
<head>
    <title>Hospital Forest | Roles</title>
    <meta charset="utf-8" />
    <link rel="icon" href="../assets/images/hospital.jpg">    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../assets/css/hoja-estilo-hospital.css" />
    <link rel="stylesheet" type="text/css" href="../assets/css/hoja-estilo-hospital-entidades.css"/>
    <script src="../assets/js/099af0269d.js"></script>
    <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css" />   
</head>
<body style="background-image: linear-gradient(175deg, #ffffa6 0, #efffa2 25%, #d5f29d 50%, #bde298 75%, #a8d394 100%);">
        <header>  
            <div id="main-header" class="text-dark">
                <div class="container text-white">
                    <div class="row">
                        <div class="col-12 text-center"> 
                            <p class="fs-1">ROLES</p>
                               <br/>
                               <p class="fs-1"><i class="fa-sharp fa-solid fa-address-book"></i> Control Roles</p>
                        </div>
                    </div>
                </div>
            </div>       
        </header>       
        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp" />    
        <main>
            <section id="accions" class="py-4 mb-2 ">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <a href="#" class="btn btn-primary btn-block" 
                               id="btn-agregar">Agregar Rol</a>
                        </div>
                    </div>
                </div>
                
            </section>
                        
            <section>
                <div class="container mt-3 mb-5 pb-5">
                    <div class="row">
                        <div class="col-10">
                            <div class="card">
                                <div id="cabecera-tabla" class="card-header text-center">
                                    <h4>Listado de Roles</h4>
                                </div>
                            </div>
                            <table class="table table-striped">
                                <thead class="head-atributos" id="elementos-tabla">
                                    <tr>
                                        <th>#</th>
                                        <th>Tipo del rol</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody class="contenido-tabla">
                                    <c:forEach items="${data}" var="rol">
                                        <tr id = "atributos">
                                            <td>
                                                ${rol.idRol}
                                            </td>
                                            <td>
                                                ${rol.tipoRol}
                                            </td>
                                            <td>
                                                <i class="fa fa-edit"></i> Editar
                                            </td>
                                            <td>
                                                <a class="btn btn-success text-black bg-opacity-50" href="${pageContext.request.contextPath}/ServletRol?accion=eliminar&id=${rol.idRol}">
                                                   <i class="fa fa-trash-alt"></i> Eliminar</a> 
                                            </td>
                                        </tr>
                                    </c:forEach>    
                                </tbody>
                            </table>
                        </div>
                        <div class="col-2">
                            <div class="card text-center bg-success text-white mb-3">
                                <div class="card-body">
                                        <h4>Total de Registros: </h3>
                                        <h4>${totalRoles}</h4>     
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <footer>
        </footer>
        <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
        <script type="text/javascript" src="../assets/js/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="../assets/js/script.js"></script>
        <script type="text/javascript" src="../assets/js/bootstrap.bundle.js" ></script>
    </body>
</html>
