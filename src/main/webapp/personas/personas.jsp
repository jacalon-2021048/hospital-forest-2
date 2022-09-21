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
        <link rel="icon" href="../assets/images/hospital.jpg">
        <script type="text/javascript" src="../assets/js/099af0269d.js" ></script>
        <link rel="stylesheet" type="text/css" href="../assets/css/hoja-estilo-hospital-entidades.css" />
        <title>Hospital Forest | Personas</title>
    </head>
    <body style="background-color: #F9F7FA">
        <header>
            <h1>Personas</h1>
            <div id="main-header" class="py-2 text-light mt-5">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <h1>
                                <i class="fas fa-user-cog"></i> Control de Personas
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
                                <a href="#" class="btn btn-primary" id="btn-agregar">
                                    Agregar Persona
                                </a>
                            </div>
                        </div>
                    </div>
                </section>
                <section>
                    <div class="container mb-5 pb-5">
                        <div class="row">
                            <div class="col-12 col-md-10">
                                <div class="card">
                                    <div class="card-header" id="cabecera-tabla">
                                        <h4>Listado de Personas</h4>
                                    </div>
                                </div>
                                <table class="table table-striped">
                                    <thead class="table" id="elementos-tabla">
                                        <tr>
                                            <th>#</th>
                                            <th>Nombres</th>
                                            <th>Apellidos</th>
                                            <th>Sexo</th>
                                            <th>Fecha 
                                                de
                                                nacimiento</th>
                                            <th>Correo 
                                                Electronico</th>
                                            <th>Telefono</th>
                                            <th>Editar</th>
                                            <th>Eliminar</th>
                                        </tr>
                                    </thead>
                                    <tbody class="contenido-tabla">
                                    <c:forEach items="${data}" var="persona">
                                        <tr>
                                            <td>${persona.id}</td>
                                            <td>${persona.nombre1} ${persona.nombre2} ${persona.nombre3}</td>
                                            <td>${persona.apellido1} ${persona.apellido2}</td>
                                            <td>${persona.sexo}</td>
                                            <td>${persona.fechaNacimiento}</td>
                                            <td>${persona.correoElectronico}</td>
                                            <td>${persona.telefono}</td>
                                            <td>
                                                <i class="fa fa-edit"></i> Editar
                                            </td>
                                            <td>
                                                <a class="btn btn-success text-black bg-opacity-50" href="${pageContext.request.contextPath}/ServletPersona?accion=eliminar&id=${persona.id}">
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
                                        <h3>Total de Personas:</h3>
                                        <h4>${totalPersonas}</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div> 
    </div>
</div>
</section>
</main>


</div>

<footer>
</footer>        
<script type="text/javascript" src="../assets/js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.bundle.js"></script>

</body>

</html>

