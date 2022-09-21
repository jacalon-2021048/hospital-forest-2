<%-- 
    Document   : editar-usuario
    Created on : 15/09/2022, 13:15:21
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
            <div class="container">
                <div class="row">
                    <div class="col-3    col-md-3">
                    </div>
                    <div class="col-6  col-md-6">
                        <div class="container">
                            <div class="row">
                                <div class="col-4  m-2">
                                    <a class="btn btn-info" href="${pageContext.request.contextPath}/ServletUsuarios?accion=listar">
                                        <i class="fa fa-arrow-left"></i> Cancelar/Regresar
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar usuario</h4>
                            </div>
                        </div>
                        <div class="card-body bg-light shadow-lg p-3 mb-5 bg-body rounded">
                            <form method="POST" action="${pageContext.request.contextPath}/ServletUsuarios" class="was-validated">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="nombre" class="col-form-label">Nombre usuario</label>
                                        <input type="text" class="form-control" id="nombre" value="${usuario.getUser()}" name="nombre" readonly>
                                    </div>
                                    <div class="mb-3">
                                        <label for="pass" class="col-form-label">Contraseña*</label>
                                        <input type="password" class="form-control" id="pass" name="pass" value="${usuario.getPass()}" required>
                                    </div>
                                    <div class="mb-3">
                                        <div class="btn-group col-12">
                                            <button class="btn btn-success dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" data-bs-auto-close="inside">
                                                Rol elegido: ${usuario.getRolNombre()}*
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
                                                Persona elegida: ${usuario.getNombrePersona()}*
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
                                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletUsuarios?accion=eliminar&usuario=${usuario.getUser()}">
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