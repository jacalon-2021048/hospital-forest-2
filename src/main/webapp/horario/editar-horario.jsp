<%-- 
    Document   : editar-horario
    Created on : 2 sept. 2022, 17:52:54
    Author     : Alberto Moisés Gerardo Lemus Alvarado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_GT" />


<!DOCTYPE html>
<html lang="es">
<head>
    <title>Horario</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../assets/css/hoja-estilo-hospital.css" />
    <link rel="stylesheet" type="text/css" href="../assets/css/hoja-estilo-hospital-entidades.css"/>
    <link rel="icon" href="../assets/images/hospital.jpg">    
    <script src="../assets/js/099af0269d.js"></script>
    <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css" />   
</head>
    <body style="background-color: #e3f59b">
        <header>
            <div id="main-header" class="text-dark">
                <div class="container text-white">
                    <div class="row">
                        <div class="col-12 text-center"> 
                                <p class="fs-1"><i class="fa-solid fa-clock"></i> Editar Horario</p>
                        </div>
                    </div>
                </div>
            </div>       
        </header>       
        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp" />    
        <main>
            <div class="container">
                <div class="row">
                    <div class="col-3 col-md-3">
                    </div>
                    <div class="col-6 col-md-6">
                        <div class="container">
                            <div class="row">
                                <div class="col-4  m-2">
                                    <a class="btn btn-info" href="${pageContext.request.contextPath}/ServletHorario?accion=listar">
                                        <i class="fa fa-arrow-left"></i> Cancelar/Regresar
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar Horario</h4>
                            </div>
                        </div>
                        <div class="card-body bg-light shadow-lg p-3 mb-5 bg-body rounded">
                            <form method="POST" action="${pageContext.request.contextPath}/ServletHorario" class="was-validated">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="id-horario" class="col-form-label">ID del horario</label>
                                        <input type="text" class="form-control" id="id-horario" value="${horario.getIdHorario()}" name="id" readonly>
                                    </div>
                                    <div class="mb-3">
                                        <label for="horarioInicio-id" class="col-form-label">Horario Inicio*</label>
                                        <input type="time" class="form-control" id="horarioInicio-id" name="horarioInicio" value="${horario.getHorarioInicio()}" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="horarioFinal-id" class="col-form-label">Horario Final*</label>
                                        <input type="time" class="form-control" id="horarioFinal-id" name="horarioFinal" value="${horario.getHorarioFinal()}" required>
                                    </div>
                                    <div class="mb-3 form-check form-switch form-check-reverse float-start text-start">
                                        <input type="checkbox" class="form-check-input" id="lunes-id" name="lunes" value="${true}">
                                        <label for="lunes-id" class="form-check-label">Lunes </label>    
                                    </div>             
                                    <br/><p></p>
                                    <div class="mb-3 form-check form-switch form-check-reverse float-start text-start">
                                        <input type="checkbox" class="form-check-input" id="martes-id" name="martes" value="${true}">
                                        <label for="martes-id" class="form-check-label">Martes</label>
                                    </div>
                                    <br/><p></p>
                                    <div class="mb-3 form-check form-switch form-check-reverse float-start text-start">
                                        <input type="checkbox" class="form-check-input" id="miercoles-id" name="miercoles" value="${true}">
                                        <label for="miercoles-id" class="form-check-label">Miercoles</label>                                        
                                    </div>  
                                    <br/><p></p>
                                    <div class="mb-3 form-check form-switch form-check-reverse float-start text-start">
                                        <input type="checkbox" class="form-check-input" id="jueves-id" name="jueves" value="${true}">
                                        <label for="jueves-id" class="form-check-label">Jueves</label>                               
                                    </div> 
                                    <br/><p></p>
                                    <div class="mb-3 form-check form-switch form-check-reverse float-start text-start">
                                        <input type="checkbox" class="form-check-input" id="viernes-id" name="viernes" value="${true}">
                                        <label for="viernes-id" class="form-check-label">Viernes</label>    
                                    </div> 
                                    <br/><p></p>
                                    <div class="mb-3 form-check form-switch form-check-reverse float-start text-start">
                                        <input type="checkbox" class="form-check-input" id="sabado-id" name="sabado" value="${true}">
                                        <label for="sabado-id" class="form-check-label">Sabado</label>   
                                    </div>  
                                    <br/><p></p>
                                    <div class="mb-3 form-check form-switch form-check-reverse float-start text-start">
                                        <input type="checkbox" class="form-check-input" id="domingo-id" name="domingo" value="${true}">
                                        <label for="domingo-id" class="form-check-label">Domingo</label>  
                                    </div>
                                    <br/><p></p>
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
                                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletHorario?accion=eliminar&id=${horario.idHorario}">
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
        <footer>
        </footer>
        <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
        <script type="text/javascript" src="../assets/js/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="../assets/js/script.js"></script>
        <script type="text/javascript" src="../assets/js/bootstrap.bundle.js" ></script>
    </body>
</html>
