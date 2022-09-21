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
                            <a class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addModal" id="btn-agregar">
                                Agregar cita
                            </a>
                        </div>
                    </div>
                </div>
            </section>

            <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar cita</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form method="POST" action="${pageContext.request.contextPath}/ServletCitas" class="was-validated">
                            <div class="modal-body">
                                <div class="mb-3">
                                    <label for="descripcion" class="col-form-label">Descripción</label>
                                    <input type="text" class="form-control" id="descripcion" name="descripcion">
                                </div>
                                <div class="mb-3">
                                    <label for="fecha" class="col-form-label">Fecha*</label>
                                    <input type="date" class="form-control" id="fecha" name="fecha" min="2005-01-01" max="2022-12-31" required>
                                </div>
                                <div class="mb-3">
                                    <label for="hora" class="col-form-label">Hora*</label>
                                    <input type="time" class="form-control" id="hora" name="hora" required>
                                </div>
                                <div class="mb-3">
                                    <div class="btn-group dropstart col-12">
                                        <button class="btn btn-success dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" data-bs-auto-close="inside">
                                            Doctores*
                                        </button>
                                        <ul class="dropdown-menu">
                                            <ul class="list-group">
                                                <c:forEach items="${dataDoctor}" var="doctor">
                                                    <li class="list-group-item">
                                                        <input type="radio" class="form-check-input" id="doctor" name="doctor" value="${doctor.idDoctor}" required>
                                                        <label for="doctor" class="form-check-label">${doctor.idDoctor}  |  ${doctor.nombrePersona}</label>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </ul>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <div class="btn-group dropend col-12">
                                        <button class="btn btn-success dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" data-bs-auto-close="inside">
                                            Pacientes*
                                        </button>
                                        <ul class="dropdown-menu">
                                            <ul class="list-group">
                                                <c:forEach items="${dataPaciente}" var="paciente">
                                                    <li class="list-group-item">
                                                        <input type="radio" class="form-check-input" id="paciente" name="paciente" value="${paciente.idPacientes}" required>
                                                        <label for="paciente" class="form-check-label">${paciente.idPacientes}  |  ${paciente.nombrePersona}</label>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </ul>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <div class="btn-group col-12">
                                        <button class="btn btn-success dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" data-bs-auto-close="inside">
                                            Habitaciones*
                                        </button>
                                        <ul class="dropdown-menu">
                                            <ul class="list-group">
                                                <c:forEach items="${dataHabitaciones}" var="habitacion">
                                                    <li class="list-group-item">
                                                        <input type="radio" class="form-check-input" id="habitacion" name="habitacion" value="${habitacion.id}" required>
                                                        <label for="habitacion" class="form-check-label">${habitacion.id}</label>
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
                                        <th>Nombre doctor</th>
                                        <th>Nombre paciente</th>
                                        <th>Número habitación</th>
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
                                            <td>${cita.nombreDoctor}</td>
                                            <td>${cita.nombrePaciente}</td>
                                            <td>${cita.habitacionId}</td>
                                            <td>
                                                <a class="btn btn-danger"
                                                   href="${pageContext.request.contextPath}/ServletCitas?accion=editar&id=${cita.idCita}">
                                                    <i class="fa fa-edit"></i> Editar
                                                </a>
                                            </td>
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

        <script type="text/javascript" src="../assets/js/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="../assets/js/bootstrap.bundle.js" ></script>
    </body>
</html>