<%-- 
    Document   : index
    Created on : 25/08/2022, 07:19:26
    Author     : Alberto Moisés Gerardo Lemus Alvarado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8" />        
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <link rel="stylesheet" type="text/css" href="./assets/css/bootstrap.css" /> 
        <link rel="icon" href="./assets/images/hospital.jpg">
        <script type="text/javascript" src="./assets/js/099af0269d.js" ></script>
        <link rel="stylesheet" type="text/css" href="./assets/css/hoja-estilo-hospital.css" />
        <title>Hospital Forest</title>
    </head>
    <body style="background-image: linear-gradient(175deg, #ffffa6 0, #efffa2 25%, #d5f29d 50%, #bde298 75%, #a8d394 100%);">
        <header>
            <div class="card text-white bg-success ">
                <div class="card-body" id="contacto">
                    <div class="container">
                        <div class="row">
                            <div class="col-12">
                                <p class="info text-end text-white fs-5">
                                    Contactanos : 2264-2953 | Siguenos :
                                    <a href="https://es-la.facebook.com/" target="blank" class="redes">
                                        <img src="./assets/images/facebook.png" />
                                    </a>
                                    |
                                    <a href="https://www.instagram.com/" target="blank" class="redes">
                                        <img src="./assets/images/instagram.png"/>
                                    </a>
                                    |
                                    <a href="https://twitter.com/?lang=es" target="blank" class="redes">
                                        <img src="./assets/images/twitter.png"/>
                                    </a>
                                </p>
                            </div>                    
                        </div>
                    </div>
                </div>
            </div>            
        </header>
        <jsp:include page="./WEB-INF/paginas/comunes/cabecera.jsp"></jsp:include>
        <main>
            <section class="p-3">
                <div class="p-4">
                    <div class="container pt-5 pb-5 bg-success rounded-5">
                        <div class="row">
                            <div class="col-lg-3 col-sm-12">
                                <div class="card" style="width: 20rem;">
                                    <img src="./assets/images/hospital-forest-slide-1.jpg" class="card-img-top" alt="...">
                                </div>
                            </div>
                            <div class="col-lg-9 col-sm-12">
                                <div class="card">
                                    <div class="card-body texto-interno">
                                        <h4 class="fs-3">Acerca de Nosotros</h4>
                                        <p class="fs-4"> Somos un Hospital especializado en diferentes areas medicas, un hospital con los que 
                                            podras contar en todo momento, en el Hospital Forest siempre velamos por tu seguridad y tu 
                                            bienestar.
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>    
                <div class="p-4">
                    <div class="container pt-5 pb-5 bg-success rounded-5">
                        <div class="row">
                            <div class="col-lg-9 col-sm-12">
                                <div class="card">
                                    <div class="card-body texto-interno">
                                        <h4 class="fs-3">Horarios</h4>
                                        <p class="fs-4"> Tenemos muchos horarios variados en el Hospital Forest, podras ver en que horarios estamos 
                                            disponibles y con quienes puedes hacer tu cita dependiendo de la hora y dia que escojas  
                                            siempre estaremos a tu disposicion. 
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-12">
                                <div class="card" style="width: 18rem;">
                                    <img src="./assets/images/hospital-forest-slide-2.jpg" class="card-img-top" alt="...">
                                </div>
                            </div>                        
                        </div>
                    </div>
                </div>
                <div class="p-4">
                    <div class="container pt-5 pb-5 bg-success rounded-5">
                        <div class="row">
                            <div class="col-lg-3 col-sm-12">
                                <div class="card" style="width: 18rem;">
                                    <img src="./assets/images/hospital-forest-slide-5.jpg" class="card-img-top" alt="...">
                                </div>
                            </div>
                            <div class="col-lg-9 col-sm-12">
                                <div class="card">
                                    <div class="card-body texto-interno">
                                        <h4 class="fs-3">Especialidades</h4>
                                        <p class="fs-4"> Nuestros Doctores tienen conocimiento en diferentes areas de la medicina pero si te interesa conocer 
                                            mas de las areas en las que trabajamos puedes ir a Especialidades para ver todas las Especialidades 
                                            que tenemos en el Hospital Forest.
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="p-4">
                    <div class="container pt-5 pb-5 bg-success rounded-5">
                        <div class="row">
                            <div class="col-lg-9 col-sm-12">
                                <div class="card">
                                    <div class="card-body texto-interno">
                                        <h4 class="fs-3">Medicamentos</h4>
                                        <p class="fs-4"> En el Hospital Forest tenemos varios medicamentos a disponibilidad para las diferentes enfermedades 
                                            o problemas de salud que tengan nuestros pacientes, si tienes dudas sobre que medicamentos manejamos
                                            puedes ir a Medicamentos para saber sobre ellos.
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-12">
                                <div class="card" style="width: 18rem;">
                                    <img src="./assets/images/hospital-forest-slide-4.jpg" class="card-img-top" alt="...">
                                </div>
                            </div>                        
                        </div>
                    </div>
                </div>                
            </section>            
         <!--   <div class="container-fluid">
                <div class="row">
                    <div class="col-9">
                        <section>
                            <div class="card">
                                <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                                    <div class="carousel-inner">
                                        <div class="carousel-item active">
                                            <img src="./assets/images/hospital-forest-slide-2.jpg" class="d-block w-100" alt="...">
                                        </div>
                                        <div class="carousel-item">
                                            <img src="./assets/images/hospital-forest-slide-3.jpg" class="d-block w-100" alt="...">
                                        </div>
                                        <div class="carousel-item">
                                            <img src="./assets/images/hospital-forest-slide-5.jpg" class="d-block w-100" alt="...">
                                        </div>
                                        <div class="carousel-item">
                                            <img src="./assets/images/hospital-forest-slide-6.jpg" class="d-block w-100" alt="...">
                                        </div>
                                    </div>
                                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                        <span class="visually-hidden">Previous</span>
                                    </button>
                                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                        <span class="visually-hidden">Next</span>
                                    </button>
                                </div>
                            </div>
                        </section>
                    </div>
                    <div class="col-3">
                        <div class="container-fluid p-1 ">
                            <img src="./assets/images/imagen-hospital-vertical.jpg" />
                        </div>
                    </div>
                </div>
                <div class="row p-2">
                        <div class="col-12">
                            <div class="container float-lg-start p-2">
                                <img src="./assets/images/imagen-horizontal-forest.jpg"/>
                            </div>
                        </div>
                </div>
            </div> -->
         
        </main>
        <aside>
        
        </aside>            
        <footer>
            
        </footer>        
        
        <script type="text/javascript" src="./assets/js/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="./assets/js/bootstrap.bundle.js" ></script>
    </body>
</html>
