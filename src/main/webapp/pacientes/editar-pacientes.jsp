<%-- 
    Document   : editar-pacientes
    Created on : 15 sep. 2022, 19:31:56
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
        <title>Hospital Forest | Editar Pacientes</title>
    </head>
    <body>
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
                <div class="container">
                    <div class="row">
                        <div class="col-3    col-md-3">
                        </div>
                        <div class="col-6  col-md-6">
                            <div class="container">
                                <div class="row">
                                    <div class="col-4  m-2">
                                        <a class="btn btn-info" href="${pageContext.request.contextPath}/ServletPaciente?accion=listar">
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
                            <form method="POST" action="${pageContext.request.contextPath}/ServletPaciente" class="was-validated">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="id-paciente" class="col-form-label">Id del Paciente:</label>
                                        <input type="text" class="form-control" id="id-paciente" name="id" value="${paciente.idPacientes}" readonly="true">
                                    </div>
                                    <div class="mb-3">
                                        <label for="seguro" class="col-form-label">Seguro Medico:</label>
                                        <input type="number" class="form-control" id="seguro" name="seguro" value="${paciente.seguroMedico}" required>
                                    </div>

                                    <div class="mb-3">
                                        <label for="emergencia" class="col-form-label">Contacto de Emergencia:</label>
                                        <input type="text" class="form-control" id="emergencia" name="emergencia" value="${paciente.contactoEmergencia}" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="persona" class="col-form-label">Id de la Persona Elegida: ${persona.getnombrePersona()}</label>
                                        <input type="number" class="form-control" id="persona" name="persona" value="${persona.getPersonaId()}" step="any" min="1" max="20" required>
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
                                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletPaciente?accion=eliminar&id=${paciente.idPacientes}">
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
        </main>

    </body>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="../assets/js/jquery.flexslider-min.js"></script>
    <script type="text/javascript" src="../assets/js/script.js"></script>
    <script type="text/javascript" src="../assets/js/bootstrap.bundle.js" ></script>
    <script type="text/javascript" src="../assets/js/099af0269d.js" ></script>

</html>
