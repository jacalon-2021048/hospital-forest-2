<%-- 
    Document   : editar-cita
    Created on : 15/09/2022, 19:34:47
    Author     : Jhonatan Jose Acalón Ajanel <jacalon-2021048@kinal.edu.gt>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_GT" />
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />        
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css" /> 
        <link rel="icon" href="../assets/images/hospital.jpg">
        <script type="text/javascript" src="../assets/js/099af0269d.js" ></script>
        <link rel="stylesheet" type="text/css" href="../assets/css/hoja-estilo-hospital-entidades.css" />
        <title>Hospital Forest</title>
    </head>

    <body style="background-image: linear-gradient(175deg, #ffffa6 0, #efffa2 25%, #d5f29d 50%, #bde298 75%, #a8d394 100%);">
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
            <div class="container">
                <div class="row">
                    <div class="col-3    col-md-3">
                    </div>
                    <div class="col-6  col-md-6">
                        <div class="container">
                            <div class="row">
                                <div class="col-4  m-2">
                                    <a class="btn btn-info" href="${pageContext.request.contextPath}/ServletCitas?accion=listar">
                                        <i class="fa fa-arrow-left"></i> Cancelar/Regresar
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar cita</h4>
                            </div>
                        </div>
                        <div class="card-body bg-light shadow-lg p-3 mb-5 bg-body rounded">
                            <form method="POST" action="${pageContext.request.contextPath}/ServletCitas" class="was-validated">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="id" class="col-form-label">Número cita</label>
                                        <input type="text" class="form-control" id="id" value="${cita.idCita}" name="id" readonly>
                                    </div>
                                    <div class="mb-3">
                                        <label for="descripcion" class="col-form-label">Descripción</label>
                                        <input type="text" class="form-control" id="descripcion" name="descripcion" value="${cita.descripcion}" required="">
                                    </div>
                                    <div class="mb-3">
                                        <label for="fecha" class="col-form-label">Fecha*</label>
                                        <input type="date" class="form-control" id="fecha" name="fecha" min="2005-01-01" max="2022-12-31" value="${cita.fecha}" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="hora" class="col-form-label">Hora*</label>
                                        <input type="time" class="form-control" id="hora" name="hora" value="${cita.hora}" required>
                                    </div>
                                    <div class="mb-3">
                                        <div class="btn-group dropstart col-12">
                                            <button class="btn btn-success dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" data-bs-auto-close="inside">
                                                Doctor elegido: ${cita.nombreDoctor}*
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
                                                Paciente elegido: ${cita.nombrePaciente}*
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
                                                Habitacion elegida: ${cita.habitacionId}*
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
                                    <input type="hidden" value="actualizar" name="accion">
                                    <h6>*Campos obligatorios</h6>
                                </div>
                                <div class="container mb-5">
                                    <div class="row">
                                        <div class="col-6 text-center">
                                            <button type="submit" class="btn btn-success">
                                                <i class="fas fa-check"></i> Guardar Cambios
                                            </button>
                                        </div>
                                        <div class="col-6 text-center">
                                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletCitas?accion=eliminar&id=${cita.idCita}">
                                                <i class="fa fa-trash"></i> Eliminar Registro  
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-3  col-md-3">
                    </div>
                </div>
            </div>
        </div>
    </main>

    <script type="text/javascript" src="../assets/js/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="../assets/js/bootstrap.bundle.js"></script>
</body>
</html>