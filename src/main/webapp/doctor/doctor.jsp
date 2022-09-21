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
                            <a class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addModal" id="btn-agregar">
                                Agregar doctor
                            </a>
                        </div>
                    </div>
                </div>
            </section>
            
            <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar doctor</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form method="POST" action="${pageContext.request.contextPath}/ServletDoctor" class="was-validated">
                            <div class="modal-body">                               
                                <div class="mb-3">
                                    <div class="btn-group dropstart col-12">
                                        <button class="btn btn-success dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" data-bs-auto-close="inside">
                                            Horarios*
                                        </button>
                                        <ul class="dropdown-menu">
                                            <ul class="list-group">
                                                <c:forEach items="${dataHorario}" var="horario">
                                                    <li class="list-group-item">
                                                        <input type="radio" class="form-check-input" id="horario" name="horario" value="${horario.idHorario}" required>
                                                        <label for="horario" class="form-check-label">${horario.idHorario}</label>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </ul>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <div class="btn-group dropend col-12">
                                        <button class="btn btn-success dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" data-bs-auto-close="inside">
                                            Personas*
                                        </button>
                                        <ul class="dropdown-menu">
                                            <ul class="list-group">
                                                <c:forEach items="${dataPersona}" var="persona">
                                                    <li class="list-group-item">
                                                        <input type="radio" class="form-check-input" id="persona" name="persona" value="${persona.id}" required>
                                                        <label for="persona" class="form-check-label">${persona.id}  |  ${persona.nombre1} | ${persona.apellido1}</label>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </ul>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <div class="btn-group col-12">
                                        <button class="btn btn-success dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" data-bs-auto-close="inside">
                                            Especialidad*
                                        </button>
                                        <ul class="dropdown-menu">
                                            <ul class="list-group">
                                                <c:forEach items="${dataEspecialidad}" var="especialidad">
                                                    <li class="list-group-item">
                                                        <input type="radio" class="form-check-input" id="especialidad" name="especialidad" value="${especialidad.idEspecialidad}" required>
                                                        <label for="especialidad" class="form-check-label">${especialidad.idEspecialidad} |  ${especialidad.nombreEspecialidad}</label>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </ul>
                                    </div>
                                </div>
                                <input type="hidden" value="insertar" id="accion" name="accion">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                <button type="submit" class="btn btn-primary">Guardar</button>
                                <h6>*Campos obligatorios</h6>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

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
                                            <td>${doctor.nombrePersona}</td>
                                            <td>${doctor.nombreEspecialidad}</td>
                                            <td>
                                                <a class="btn btn-danger"
                                                   href="${pageContext.request.contextPath}/ServletDoctor?accion=editar&id=${doctor.idDoctor}">
                                                    <i class="fa fa-edit"></i> Editar
                                                </a>
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
