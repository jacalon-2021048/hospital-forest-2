<%-- 
    Document   : editar-personas
    Created on : 15 sep. 2022, 19:31:34
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
        <title>Hospital Forest | Editar Personas</title>
    </head>
    <body>
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
                <div class="container">
                    <div class="row">
                        <div class="col-3 col-md-3">
                        </div>
                        <div class="col-6  col-md-6">
                            <div class="container">
                                <div class="row">
                                    <div class="col-4  m-2">
                                        <a class="btn btn-info" href="${pageContext.request.contextPath}/ServletPersona?accion=listar">
                                        <i class="fa fa-arrow-left"></i> Cancelar/Regresar
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar Persona</h4>
                            </div>
                        </div>
                        <div class="card-body bg-light shadow-lg p-3 mb-5 bg-body rounded">
                            <form method="POST" action="${pageContext.request.contextPath}/ServletPersona" class="was-validated">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="id-persona" class="col-form-label">Id de la Persona</label>
                                        <input type="text" class="form-control" id="id-persona" name="id" value="${persona.getId()}" readonly="true">
                                    </div>


                                    <div class="mb-3">
                                        <label for="nombre" class="col-form-label">Primer Nombre:</label>
                                        <input type="text" class="form-control" id="nombre" name="nombre1"  value="${persona.getNombre1()}" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="nombre" class="col-form-label">Segundo Nombre:</label>
                                        <input type="text" class="form-control" id="nombre" name="nombre2"  value="${persona.getNombre2()}" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="nombre" class="col-form-label">Tercer Nombre:</label>
                                        <input type="text" class="form-control" id="nombre" name="nombre3"  value="${persona.getNombre3()}" required>
                                    </div>


                                    <div class="mb-3">
                                        <label for="apellido" class="col-form-label">Primer Apellido:</label>
                                        <input type="text" class="form-control" id="apellido" name="apellido1" value="${persona.getApellido1()}" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="apellido" class="col-form-label">Segundo Apellido:</label>
                                        <input type="text" class="form-control" id="apellido" name="apellido2" value="${persona.getApellido2()}" required>
                                    </div>

                                    <div class="mb-3">
                                        <label for="sexo" class="col-form-label">
                                            <p>Ingrese solo "M" o "F"</p>
                                            Sexo:</label>
                                        <input type="text" class="form-control" id="sexo" name="sexo" value="${persona.getSexo()}" required>

                                        
                                    </div>

                                    <div class="mb-3">
                                        <label for="fecha" class="col-form-label">Fecha de Nacimiento:</label>
                                        <input type="date" class="form-control" id="fecha" name="fecha" value="${persona.getFechaNacimiento()}" required>
                                    </div>

                                    <div class="mb-3">
                                        <label for="email" class="col-form-label">Correo Electronico:</label>
                                        <input type="email" class="form-control" id="email" name="email" value="${persona.getCorreoElectronico()}" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="telefono" class="col-form-label">Telefono:</label>
                                        <input type="tel" class="form-control" id="telefono" name="telefono" value="${persona.getTelefono()}" required>
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
                                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletPersona?accion=eliminar&id=${persona.id}">
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
</main>
</body>

<script type="text/javascript" src="../assets/js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.bundle.js"></script>

</html>
