<%-- 
    Document   : citas
    Created on : 29/08/2022, 18:22:48
    Author        : Jhonatan Jose Acalón Ajanel <jacalon-2021048@kinal.edu.gt>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_GT" />

<!DOCTYPE html>
<html lang="es-GT">
    <head>
        <meta charset="utf-8" />        
        <meta name="viewport" content="width=device-width, initial-scale=1">      
       <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css" /> 
        <link rel="icon" href="../assets/images/hospital.jpg">
        <link rel="stylesheet" type="text/css" href="../assets/css/hoja-estilo-hospital-entidades.css" />
        <script type="text/javascript" src="../assets/js/099af0269d.js" ></script>
        <title>Hospital Forest</title>
    </head>
    <body style="background-color: #e3f59b">
        <header>
            <h1>Citas</h1>
            <div id="main-header" class="py-2 text-light mt-5">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <h1>
                                <i class="fas fa-user-cog"></i> Control 
                                Citas
                            </h1>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        
        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp" />
        
        <main>
            <section id="accions" class="py-4 mb-4">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <a href="#" class="btn btn-primary" id="btn-agregar">
                                Agregar cita
                            </a>
                        </div>
                    </div>
                </div>
            </section>
            
            <section>
                <div class="container mb-5 pb-5">
                    <div class="row">
                        <div class="col-12 col-md-10">
                            <div class="card">
                                <div class="card-header" id="cabecera-tabla">
                                    <h4>Listado de citas</h4>
                                </div>
                            </div>
                            <table class="table table-striped">
                                <thead class="table" id="elementos-tabla">
                                    <tr>
                                        <th>#</th>
                                        <th>Descripción cita</th>
                                        <th>Fecha</th>
                                        <th>Hora</th>
                                        <th>ID doctor</th>
                                        <th>ID paciente</th>
                                        <th>ID habitación</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody class="contenido-tabla">
                                    <c:forEach items="${data}" var="cita">
                                        <tr>
                                            <td>${cita.idCita}</td>
                                            <td>${cita.descripcion}</td>
                                            <td>${cita.fecha}</td>
                                            <td>${cita.hora}</td>
                                            <td>${cita.doctorId}</td>
                                            <td>${cita.pacienteId}</td>
                                            <td>${cita.habitacionId}</td>
                                            <td><i class="fa fa-edit"></i> Editar</td>
                                            <td>
                                                <a class="btn btn-success text-black bg-opacity-50" href="${pageContext.request.contextPath}/ServletCitas?accion=eliminar&id=${cita.idCita}">
                                                    <i class="fa fa-trash-alt"></i>Eliminar
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-12 col-md-2">
                            <div class="card text-center bg-success text-white mb-3">
                                <div class="card-body">
                                    <h3>Total Citas:</h3>
                                    <h4>${cantidadRegistros}</h4>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </section>
        </main>
        
        <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
        <script type="text/javascript" src="../assets/js/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="../assets/js/script.js"></script>
        <script type="text/javascript" src="../assets/js/bootstrap.bundle.js" ></script>
    </body>
</html>