<%-- 
    Document   : editar-habitaciones
    Created on : 17/09/2022, 16:30:29
    Author     : UNICOM
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="es">
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
            <h1>Habitaciones</h1>
            <div id="main-header" class="py-2 text-light mt-5">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <h1>
                                <i class="fas fa-user-cog"></i> Control 
                                Habitaciones
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
                                    <a class="btn btn-info" href="${pageContext.request.contextPath}/ServletHabitacion?accion=listar">
                                        <i class="fa fa-arrow-left"></i> Cancelar/Regresar
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar Habitaciones</h4>
                            </div>
                        </div>
                        <div class="card-body bg-light shadow-lg p-3 mb-5 bg-body rounded">
                            <form method="POST" action="${pageContext.request.contextPath}/ServletHabitacion" class="was-validated">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="idHabitaciones" class="col-form-label">Id Habitaciones</label>
                                        <input type="number" class="form-control" id="idHabitaciones" value="${habitaciones.getId()}" name="idHabitaciones" readonly="true">
                                    </div>
                                    <div class="mb-3">
                                        <label for="nivel" class="col-form-label">Nivel</label>
                                        <input type="number" class="form-control" id="nivel" value="${habitaciones.getNivel()}" min = "1"  name="nivel" required>
                                    </div>
                                 
                                    <div class="mb-3">
                                        <label for="ocupado" class="col-form-label">Ocupado</label>
                                        <input type="number" class="form-control" id="ocupado" value="${habitaciones.getOcupado()}"  step="any" min = "0" max="1" name="ocupado" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="edificio" class="col-form-label">No. Edificio</label>
                                        <input type="number" class="form-control" id="edificio" value="${habitaciones.getEdificioId()}" name="edificio" step="any" min = "1" max="5" required>
                                    </div>

                                    <input type="hidden"  name="accion" value="actualizar">
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
                                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletHabitacion?accion=eliminar&idHabitacion=${habitaciones.id}">
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

