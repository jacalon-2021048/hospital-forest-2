<%-- 
    Document   : medicamento
    Created on : 25/08/2022, 08:26:57
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
            <h1>Medicamentos</h1>
            <div id="main-header" class="py-2 text-light mt-5">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <h1>
                                <i class="fa-solid fa-capsules"></i> Control Medicamentos
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
                                Agregar medicamento
                            </a>
                        </div>
                    </div>
                </div>
            </section>

            <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar medicamento</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form method="POST" action="${pageContext.request.contextPath}/ServletMedicamento" class="was-validated">
                            <div class="modal-body">
                                <div class="mb-3">
                                    <label for="medicamento" class="col-form-label">Nombre medicamento*</label>
                                    <input type="text" class="form-control" id="medicamento" value="${medicamento.nombre}" name="medicamento" required>
                                </div>
                                <div class="mb-3">
                                    <label for="descripcion" class="col-form-label">Descripción</label>
                                    <input type="text" class="form-control" id="descripcion" name="descripcion" value="${medicamento.descripcion}" required="">
                                </div>
                                <div class="mb-3">
                                    <label for="fecha" class="col-form-label">Fecha caducidad*</label>
                                    <input type="date" class="form-control" id="fecha" name="fecha" min="2005-01-01" max="2030-12-31" value="${medicamento.fechaCaducidad}" required>
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
                                    <h4>Listado de medicamentos</h4>
                                </div>
                            </div>

                            <table class="table table-striped">
                                <thead class="table" id="elementos-tabla">
                                    <tr>
                                        <th>Numero de medicamento</th>
                                        <th>Nombre</th>
                                        <th>Descripción</th>
                                        <th>Fecha de caducidad</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody class="contenido-tabla">
                                    <c:forEach items="${arrayListMedicamento}" var="medicamento">
                                        <tr>
                                            <td>
                                                ${medicamento.idMedicamento}
                                            </td>
                                            <td>
                                                ${medicamento.nombre}
                                            </td> 
                                            <td>
                                                ${medicamento.descripcion}
                                            </td>
                                            <td>
                                                ${medicamento.fechaCaducidad}
                                            </td>
                                            <td>
                                                <a class="btn btn-danger"
                                                   href="${pageContext.request.contextPath}/ServletMedicamento?accion=editar&id=${medicamento.idMedicamento}">
                                                    <i class="fa fa-edit"></i> Editar
                                                </a>
                                            </td>
                                            <td>
                                                <a class="btn btn-success text-black bg-opacity-50" href="${pageContext.request.contextPath}/ServletMedicamento?accion=eliminar&id=${medicamento.idMedicamento}">
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
                                    <h3>Total de Registros</h3>
                                    <h4>${totalMedicamentos}</h4>
                                </div>
                            </div>
                        </div>
                    </div>
            </section>  
        </main>

        <!-- Acá agregamos el javascript -->
        <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
        <script type="text/javascript" src="../assets/js/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="../assets/js/script.js"></script>
        <script type="text/javascript" src="../assets/js/bootstrap.bundle.js" ></script>
    </body>
</html>
