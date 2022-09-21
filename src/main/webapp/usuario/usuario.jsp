<%-- 
    Document   : usuarios
    Created on : 29/08/2022, 18:23:08
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
        <script type="text/javascript" src="../assets/js/099af0269d.js" ></script>
        <link rel="stylesheet" type="text/css" href="../assets/css/hoja-estilo-hospital-entidades.css" />
        <title>Hospital Forest</title>
    </head>
    <body style="background-image: linear-gradient(175deg, #ffffa6 0, #efffa2 25%, #d5f29d 50%, #bde298 75%, #a8d394 100%);">
        <header>
            <h1>Usuarios</h1>
            <div id="main-header" class="py-2 text-light mt-5">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <h1>
                                <i class="fas fa-user-cog"></i> Control 
                                Usuarios
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
                                Agregar usuario
                            </a>
                        </div>
                    </div>
                </div>
            </section>

            <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar usuario</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form method="POST" action="${pageContext.request.contextPath}/ServletUsuarios" class="was-validated">
                            <div class="modal-body">
                                <div class="mb-3">
                                    <label for="nombre" class="col-form-label">Nombre usuario*</label>
                                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                                </div>
                                <div class="mb-3">
                                    <label for="pass" class="col-form-label">Contraseña*</label>
                                    <input type="password" class="form-control" id="pass" name="pass" required>
                                </div>
                                <div class="mb-3">
                                    <div class="btn-group dropstart col-12">
                                        <button class="btn btn-success dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" data-bs-auto-close="inside">
                                            Roles*
                                        </button>
                                        <ul class="dropdown-menu">
                                            <ul class="list-group">
                                                <c:forEach items="${dataRol}" var="rol">
                                                    <li class="list-group-item">
                                                        <input type="radio" class="form-check-input" id="rol" name="rol" value="${rol.idRol}" required>
                                                        <label for="rol" class="form-check-label">${rol.idRol}  |  ${rol.tipoRol}</label>
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
                                                        <input type="radio" class="form-check-input" id="person" name="person" value="${persona.id}" required>
                                                        <label for="person" class="form-check-label">${persona.id}  |  ${persona.nombre1}  ${persona.apellido1}  | ${persona.sexo}  |  ${persona.telefono}</label>
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
                                    <h4>Listado de usuarios</h4>
                                </div>
                            </div>
                            <table class="table table-striped">
                                <thead class="table" id="elementos-tabla">
                                    <tr>
                                        <th>Nombre usuario</th>
                                        <th>Contraseña</th>
                                        <th>Tipo rol</th>
                                        <th>Nombre persona</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody class="contenido-tabla">
                                    <c:forEach items="${data}" var="usuario">
                                        <tr>
                                            <td>${usuario.user}</td>
                                            <td>${usuario.pass}</td>
                                            <td>${usuario.rolNombre}</td>
                                            <td>${usuario.nombrePersona}</td>
                                            <td>
                                                <a class="btn btn-danger"
                                                    href="${pageContext.request.contextPath}/ServletUsuarios?accion=editar&user=${usuario.user}">
                                                    <i class="fa fa-edit"></i>Editar
                                                </a>
                                            </td>
                                            <td>
                                                <a class="btn btn-success text-black bg-opacity-50" href="${pageContext.request.contextPath}/ServletUsuarios?accion=eliminar&usuario=${usuario.user}">
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
                                    <h3>Total usuarios:</h3>
                                    <h4>${cantidadRegistros}</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>

        <script type="text/javascript" src="../assets/js/jquery-3.6.0.js"></script>
        <script type="text/javascript" src="../assets/js/bootstrap.bundle.js"></script>
    </body>
</html>