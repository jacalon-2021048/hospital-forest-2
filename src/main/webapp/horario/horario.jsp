<%-- 
    Document   : horario
    Created on : 2 sept. 2022, 17:53:07
    Author     : Alberto Moisés Gerardo Lemus Alvarado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_GT" />


<!DOCTYPE html>
<html lang="es">
<head>
    <title>Hospital Forest | Horario</title>
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
                            <p class="fs-1"> HORARIO</p>
                                <br/>
                                <p class="fs-1"><i class="fa-solid fa-clock"></i> Control Horario</p>
                        </div>
                    </div>
                </div>
            </div>       
        </header>       
        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp" />    
        <main>
            <section id="accions" class="py-4 mb-2 ">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <a href="#" class="btn btn-primary btn-block" data-bs-toggle="modal" data-bs-target="#addModal" data-bs-whatever="@mdo"
                               id="btn-agregar">Agregar Horario</a>
                        </div>
                    </div>
                </div>

                <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Agregar Horario</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form method="POST" action="${pageContext.request.contextPath}/ServletHorario" class="was-validated">
                                <div class="modal-body">

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

                                    <input type="hidden" value="insertar" id="accion" name="accion"/>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                    <button type="submit" class="btn btn-primary">Guardar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>                

            </section>
                        
            <section>
                <div class="container mt-3 mb-5 pb-5">
                    <div class="row">
                        <div class="col-12 col-md-10">
                            <div class="card">
                                <div id="cabecera-tabla" class="card-header text-center">
                                    <h4>Listado de horarios</h4>
                                </div>
                            </div>
                            <table class="table table-striped">
                                <thead class="head-atributos" id="elementos-tabla">
                                    <tr>
                                        <th>#</th>
                                        <th>Horario Inicio</th>
                                        <th>Horario Final</th>
                                        <th>Lunes</th>
                                        <th>Martes</th>
                                        <th>Miercoles</th>
                                        <th>Jueves</th>
                                        <th>Viernes</th>
                                        <th>Sabado</th>
                                        <th>Domingo</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody class="contenido-tabla">
                                    <c:forEach items="${data}" var="horario">
                                        <tr id = "atributos">
                                            <td>
                                                ${horario.idHorario}
                                            </td>
                                            <td>
                                                ${horario.horarioInicio}
                                            </td>
                                            <td>
                                                ${horario.horarioFinal}
                                            </td>
                                            <td>
                                                ${horario.lunes}
                                            </td>
                                            <td>
                                                ${horario.martes}
                                            </td>
                                            <td>
                                                ${horario.miercoles}
                                            </td>
                                            <td>
                                                ${horario.jueves}
                                            </td>
                                            <td>
                                                ${horario.viernes}
                                            </td>
                                            <td>
                                                ${horario.sabado}
                                            </td>
                                            <td>
                                                ${horario.domingo}
                                            </td>
                                            <td>
                                                <a class="btn btn-success text-black bg-opacity-50" href="${pageContext.request.contextPath}/ServletHorario?accion=editar&id=${horario.idHorario}">
                                                <i class="fa fa-edit"></i> Editar</a>
                                            </td>
                                            <td>
                                                <a class="btn btn-success text-black bg-opacity-50" href="${pageContext.request.contextPath}/ServletHorario?accion=eliminar&id=${horario.idHorario}">
                                                <i class="fa fa-trash-alt"></i> Eliminar</a>
                                            </td>
                                        </tr>
                                    </c:forEach>    
                                </tbody>
                            </table>
                        </div>
                        <div class="col-12 col-md-2">
                            <div class="card text-center bg-success text-white mb-3">
                                <div class="card-body">
                                        <h4>Total de Registros: </h3>
                                        <h4>${totalHorarios}</h4>     
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <footer>
        </footer>
        <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
        <script type="text/javascript" src="../assets/js/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="../assets/js/script.js"></script>
        <script type="text/javascript" src="../assets/js/bootstrap.bundle.js" ></script>
    </body>
</html>
