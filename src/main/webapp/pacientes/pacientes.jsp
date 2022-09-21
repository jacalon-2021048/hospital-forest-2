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
                                <a href="#" class="btn btn-primary" id="btn-agregar" data-bs-toggle="modal" data-bs-target="#addModal">
                                    Agregar Paciente
                                </a>
                            </div>
                        </div>
                    </div>
                </section>

                <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Agregar Paciente</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form method="POST" action="${pageContext.request.contextPath}/ServletPaciente?accion=insertar" class="was-validated">
                            <div class="modal-body">

                                <div class="mb-3">
                                    <label for="seguro" class="col-form-label">Seguro Medico:</label>
                                    <input type="number" class="form-control" id="seguro" name="seguro" required>
                                </div>

                                <div class="mb-3">
                                    <label for="emergencia" class="col-form-label">Contacto de Emergencia:</label>
                                    <input type="text" class="form-control" id="emergencia" name="emergencia" required>
                                </div>
                                <div class="mb-3">
                                        <label for="persona" class="col-form-label">Persona a elegir: </label>
                                        <input type="number" class="form-control" id="persona" name="persona" step="any" min="1" max="20" required>
                                    </div>
                                <input type="hidden" value="insertar" id="accion" name="accion">


                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                <button type="submit" class="btn btn-primary">Guardar</button>
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
                                <tbody class="contenido-tabla text-center">
                                    <c:forEach items="${data}" var="paciente">
                                        <tr>
                                            <td>${paciente.idPacientes}</td>
                                            <td>${paciente.seguroMedico}</td>
                                            <td>${paciente.contactoEmergencia}</td>
                                            <td>${paciente.nombrePersona}</td>
                                            <td>
                                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/ServletPaciente?accion=editar&id=${paciente.idPacientes}">
                                                    <i class="fa fa-edit"></i>
                                                </a>
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

