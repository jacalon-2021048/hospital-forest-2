<%-- 
    Document   : personas
    Created on : 3 sep. 2022, 18:51:24
    Author     : Christofer Geovanni Quel Guerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT"/>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />        
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="../assets/css/hoja-estilo-hospital-entidades.css"/>        
        <link rel="icon" href="../assets/images/hospital.jpg">
        <script type="text/javascript" src="../assets/js/099af0269d.js" ></script>
        <link rel="stylesheet" type="text/css" href="../assets/css/hoja-estilo-hospital-entidades.css" />
        <title>Hospital Forest | Pacientes</title>
    </head>
    <body style="background-color: #F9F7FA">
        <header>
            <h1>Pacientes</h1>
            <div id="main-header" class="py-2 text-light mt-5">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <h1>
                                <i class="fas fa-user-cog"></i> Control
                                de Pacientes
                            </h1>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp"></jsp:include>
            <main>
                <section id="accions" class="py-4 mb-4">
                    <div class="container">
                        <div class="row">
                            <div class="col-12">
                                <a href="#" class="btn btn-primary" id="btn-agregar">
                                    Agregar Paciente
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
                                        <h4>Listado de Pacientes</h4>
                                    </div>
                                </div>
                                <table class="table table-striped">
                                    <thead class="table text-center" id="elementos-tabla">
                                        <tr>
                                            <th>#</th>
                                            <th>Seguro Medico</th>
                                            <th>Contacto Emergencia</th>
                                            <th>No. Persona</th>
                                            <th>Editar</th>
                                            <th>Eliminar</th>
                                        </tr>
                                    </thead>
                                    <tbody class="contenido-tabla">
                                    <c:forEach items="${data}" var="paciente">
                                        <tr>
                                            <td>${paciente.idPacientes}</td>
                                            <td>${paciente.seguroMedico}</td>
                                            <td>${paciente.contactoEmergencia}</td>
                                            <td>${paciente.personaId}</td>
                                            <td>
                                                <i class="fa fa-edit"></i> Editar
                                            </td>
                                            <td>
                                                <a class="btn btn-success text-black bg-opacity-50" href="${pageContext.request.contextPath}/ServletPaciente?accion=eliminar&id=${paciente.idPacientes}">
                                                    <i class="fa fa-trash-alt"></i> Eliminar
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
                                        <h3>Total de Pacientes:</h3>
                                        <h4>${totalPacientes}</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>


    </div>

    <footer>
    </footer>        
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="../assets/js/jquery.flexslider-min.js"></script>
    <script type="text/javascript" src="../assets/js/script.js"></script>
    <script type="text/javascript" src="../assets/js/bootstrap.bundle.js" ></script>
    <script type="text/javascript" src="../assets/js/099af0269d.js" ></script>

</body>

</html>

