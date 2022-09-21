<%-- 
    Document   : horario
    Created on : 2 sept. 2022, 17:53:07
    Author     : Alberto Moisés Gerardo Lemus Alvarado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_GT" />


<!DOCTYPE html>
<html lang="es">
<head>
    <title>Hospital Forest | Horario</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../assets/css/hoja-estilo-hospital.css" />
    <link rel="stylesheet" type="text/css" href="../assets/css/hoja-estilo-hospital-entidades.css"/>
    <link rel="icon" href="../assets/images/hospital.jpg">    
    <script src="../assets/js/099af0269d.js"></script>
    <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css" />   
</head>
    <body style="background-color: #e3f59b">
        <header>
            <div id="main-header" class="text-dark">
                <div class="container text-white">
                    <div class="row">
                        <div class="col-12 text-center"> 
                            <p class="fs-1"> HORARIO</p>
                                <br/>
                                <p class="fs-1"><i class="fa-solid fa-clock"></i> Control Horario</p>
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
                               id="btn-agregar">Agregar Horario</a>
                        </div>
                    </div>
                </div>
                
            </section>
                        
            <section>
                <div class="container mt-3 mb-5 pb-5">
                    <div class="row">
                        <div class="col-12 col-md-10">
                            <div class="card">
                                <div id="cabecera-tabla" class="card-header text-center">
                                    <h4>Listado de horarios</h4>
                                </div>
                            </div>
                            <table class="table table-striped">
                                <thead class="head-atributos" id="elementos-tabla">
                                    <tr>
                                        <th>#</th>
                                        <th>Horario Inicio</th>
                                        <th>Horario Final</th>
                                        <th>Lunes</th>
                                        <th>Martes</th>
                                        <th>Miercoles</th>
                                        <th>Jueves</th>
                                        <th>Viernes</th>
                                        <th>Sabado</th>
                                        <th>Domingo</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody class="contenido-tabla">
                                    <c:forEach items="${data}" var="horario">
                                        <tr id = "atributos">
                                            <td>
                                                ${horario.idHorario}
                                            </td>
                                            <td>
                                                ${horario.horarioInicio}
                                            </td>
                                            <td>
                                                ${horario.horarioFinal}
                                            </td>
                                            <td>
                                                ${horario.lunes}
                                            </td>
                                            <td>
                                                ${horario.martes}
                                            </td>
                                            <td>
                                                ${horario.miercoles}
                                            </td>
                                            <td>
                                                ${horario.jueves}
                                            </td>
                                            <td>
                                                ${horario.viernes}
                                            </td>
                                            <td>
                                                ${horario.sabado}
                                            </td>
                                            <td>
                                                ${horario.domingo}
                                            </td>
                                            <td>
                                                <i class="fa fa-edit"></i> Editar
                                            </td>
                                            <td>
                                                <a class="btn btn-success text-black bg-opacity-50" href="${pageContext.request.contextPath}/ServletHorario?accion=eliminar&id=${horario.idHorario}">
                                                <i class="fa fa-trash-alt"></i> Eliminar</a>
                                            </td>
                                        </tr>
                                    </c:forEach>    
                                </tbody>
                            </table>
                        </div>
                        <div class="col-12 col-md-2">
                            <div class="card text-center bg-success text-white mb-3">
                                <div class="card-body">
                                        <h4>Total de Registros: </h3>
                                        <h4>${totalHorarios}</h4>     
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
