<%-- 
    Document   : editar-recetas
    Created on : 3 sept. 2022, 16:11:55
    Author     : Alberto Moisés Gerardo Lemus Alvarado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_GT" />


<!DOCTYPE html>
<html lang="es">
<head>
    <title>Receta</title>
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
                                <p class="fs-1"><i class="fa-solid fa-clock"></i> Editar Recetas</p>
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
                                    <a class="btn btn-info" href="${pageContext.request.contextPath}/ServletReceta?accion=listar">
                                        <i class="fa fa-arrow-left"></i> Cancelar/Regresar
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar Receta</h4>
                            </div>
                        </div>
                        <div class="card-body bg-light shadow-lg p-3 mb-5 bg-body rounded">
                            <form method="POST" action="${pageContext.request.contextPath}/ServletReceta" class="was-validated">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="id-receta" class="col-form-label">ID del horario</label>
                                        <input type="text" class="form-control" id="id-receta" value="${receta.getIdReceta()}" name="id" readonly>
                                    </div>
                                    <div class="mb-3">
                                        <label for="dosisRecomendada-id" class="col-form-label">Dosis Recomendada*</label>
                                        <input type="text" class="form-control" id="dosisRecomendada-id" name="dosisRecomendada" value="${receta.getDosisRecomendada()}" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="medicamentoId-id" class="col-form-label">Medicamento*</label>
                                        <input type="text" class="form-control" id="medicamentoId-id" name="medicamentoId" value="${receta.getMedicamentoId()}" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="citaId-id" class="col-form-label">Citas*</label>
                                        <input type="text" class="form-control" id="citaId-id" name="citaId" value="${receta.getCitaId()}" required>
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
                                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletReceta?accion=eliminar&id=${receta.idReceta}">
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
