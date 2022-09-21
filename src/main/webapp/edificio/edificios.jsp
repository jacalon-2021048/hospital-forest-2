<%-- 
    Author     : Henry Donaldo Sanum
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h1>Edificios</h1>
            <div id="main-header" class="py-2 text-light mt-5">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <h1>
                                <i class="fas fa-user-cog"></i> Control 
                                edificios
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
                            <a href="#" class="btn btn-primary" id="btn-agregar" data-bs-toggle="modal" data-bs-target="#addModal">

                                Agregar edificio
                            </a>
                        </div>
                    </div>
                </div>
            </section>

            <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar Edificios</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>

                        <form method="POST" action="${pageContext.request.contextPath}/ServletEdificio" class="was-validated">

                            <div class="modal-body">

                                <div class="mb-3">
                                    <label for="edificio" class="col-form-label">Nombre Edificio</label>
                                    <input type="text" class="form-control" id="edificio" name="edificio" required>
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
                <div class="container mt-5 mb-5 pb-5">
                    <div class="row">
                        <div class="col-12 col-md-10">
                            <div class="card" ">
                                <div class="card-header text-center" id="cabecera-tabla">
                                    <h4>Listado de Edificios</h4>
                                </div>
                            </div>

                            <table class="table table-striped"  >
                                <thead class="table" id="elementos-tabla">
                                    <tr>
                                        <th>#</th>
                                        <th>Nombre Del Edificio</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody class="contenido-tabla">
                                    <c:forEach items="${data}" var="edificio">
                                        <tr>
                                            <td>${edificio.id}</td>
                                            <td>${edificio.nombreEdificio}</td>
                                            <td>
                                                <a class="btn btn-success" href="${pageContext.request.contextPath}/ServletEdificio?accion=editar&idEdificio=${edificio.id}">

                                                    <i class="fa fa-edit"></i> Editar
                                                <a/>
                                            </td>
                                            <td>
                                                <a class="btn btn-success text-black bg-opacity-50" href="${pageContext.request.contextPath}/ServletEdificio?accion=eliminar&idEdificio=${edificio.id}">
                                                    <i class="fa fa-trash-alt"></i>Eliminar
                                                <a/>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div> 
                        <div class="col-12 col-md-2">
                            <div class="card text-center bg-success text-white mb-3">
                                <div class="card-body">
                                    <h3>Total De Edificios:</h3>
                                    <h4>${totalEdificios}</h4>
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