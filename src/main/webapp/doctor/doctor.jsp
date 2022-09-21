<%-- 
    Document   : doctor
    Created on : 25/08/2022, 08:26:40
    Author     : Juan Pablo Cáceres Enriquez
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
    <body>
        <header>
            <h1>Doctores</h1>
            <div id="main-header" class="py-2 text-light mt-5">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <h1>
                                <i class="fa-solid fa-user-doctor"></i> Control Doctores
                            </h1>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <!-- Cabecera -->
        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp"/>

        <main>
            <section id="accions" class="py-4 mb-4">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <a href="#" class="btn btn-primary btn-block" id="btn-agregar">
                                Agregar doctor
                            </a>
                        </div>
                    </div>
                </div>
            </section>

            <!-- Tabla con listado de estudiantes -->
            <section id="estudiante">
                <div class="container mb-5 pb-5">
                    <div class="row">
                        <div class="col-12 col-md-10">
                            <div class="card">
                                <div class="card-header text-center" id="cabecera-tabla">
                                    <h4>Listado de Doctores</h4>
                                </div>
                            </div>

                            <table class="table table-striped">
                                <thead class="table" id="elementos-tabla">
                                    <tr>
                                        <th>#</th>
                                        <th>Horario</th>
                                        <th>Persona</th>
                                        <th>Especialidad</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody class="contenido-tabla">
                                    <c:forEach items="${arrayListDoctor}" var="doctor">
                                        <tr>
                                            <td>${doctor.idDoctor}</td>
                                            <td>${doctor.horarioId}</td> 
                                            <td>${doctor.personaId}</td>
                                            <td>${doctor.especialidadId}</td>
                                            <td>
                                                <i class="fa fa-edit"></i> Editar
                                            </td>
                                            <td>
                                                <a class="btn btn-success text-black bg-opacity-50" href="${pageContext.request.contextPath}/ServletDoctor?accion=eliminar&id=${doctor.idDoctor}">
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
                                    <h3>Total de Registros</h3>
                                    <h4>${totalDoctores}</h4>
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
