<!--<nav class="navbar navbar-expand-lg bg-light p-2">
  <div class="container-fluid">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"> <img src="./assets/images/logo-hospital-forest-pequeño.png"/> </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link fs-2" aria-current="page" href="#">Cita</a>
        </li>
        <li class="nav-item">
          <a class="nav-link fs-2" href="#">Especialidades</a>
        </li>
        <li class="nav-item">
          <a class="nav-link fs-2" href="#">Horarios</a>
        </li>
        <li class="nav-item">
          <a class="nav-link fs-2" href="#">Doctores</a>
        </li>
        <li class="nav-item">
          <a class="nav-link fs-2" href="${pageContext.request.contextPath}/acerca-de.jsp">Acerca De...</a>
        </li>
      </ul>
    </div>
  </div>
</nav>  -->
        
<nav class="navbar navbar-expand-lg p-2 fs-3 " style="background-color: #DCE155;">
  <div class="container-fluid">
      <a class="navbar-brand fs-3" href="${pageContext.request.contextPath}/index.jsp"> - Inicio - </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/ServletHorario?accion=listar"><i class="fa-solid fa-clock"></i> Horarios</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/ServletEspecialidades?accion=listar"><i class="fa-solid fa-user-doctor"></i> Especialidades</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/ServletMedicamento?accion=listar"><i class="fa-solid fa-capsules"></i> Medicamentos</a>
        </li>                
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Modulos
          </a>
          <ul class="dropdown-menu">
            <li>
                <a class="nav-link" href="${pageContext.request.contextPath}/ServletCitas?accion=listar"><i class="fa-regular fa-calendar"></i> Cita</a>
            </li>
            <li>
                <a class="nav-link" href="${pageContext.request.contextPath}/ServletRol?accion=listar"><i class="fa-sharp fa-solid fa-address-book"></i> Rol</a>
            </li>
            <li>
                <a class="nav-link" href="${pageContext.request.contextPath}/ServletReceta?accion=listar"><i class="fa-solid fa-prescription"></i> Recetas</a>
            </li>
            <li>
                <a class="nav-link" href="${pageContext.request.contextPath}/ServletDoctor?accion=listar"><i class="fa-solid fa-user-doctor"></i> Doctores</a>
            </li>   
            <li>
                <a class="nav-link" href="${pageContext.request.contextPath}/ServletUsuarios?accion=listar"><i class="fa-solid fa-user"></i> Usuarios</a>
            </li>            
            <li>
                <a class="nav-link" href="${pageContext.request.contextPath}/ServletEdificio?accion=listar"><i class="fa-solid fa-building"></i> Edificios</a>
            </li>            
            <li>
                <a class="nav-link" href="${pageContext.request.contextPath}/ServletHabitacion?accion=listar"><i class="fa-solid fa-bed"></i> Habitaciones</a>
            </li>            
            <li>
                <a class="nav-link" href="${pageContext.request.contextPath}/ServletPersona?accion=listar"><i class="fa-solid fa-person"></i> Personas</a>
            </li>            
            <li>
                <a class="nav-link" href="${pageContext.request.contextPath}/ServletPaciente?accion=listar"><i class="fa-solid fa-head-side-cough"></i> Pacientes</a>
            </li>            
          </ul>
        </li> 
      </ul>
    </div>
  </div>
</nav>       

<!--
<nav class="navbar navbar-expand-lg p-2 fs-6" style="background-color: #c7eb7a;">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"> <img src="${pageContext.request.contextPath}/assets/images/logo-hospital-forest-pequeño.png"/> </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletCitas?accion=listar"><i class="fa-regular fa-calendar"></i> Cita</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletEspecialidades?accion=listar"><i class="fa-solid fa-user-doctor"></i> Especialidades</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletRol?accion=listar"><i class="fa-sharp fa-solid fa-address-book"></i> Rol</a>
                </li>        
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletHorario?accion=listar"><i class="fa-solid fa-clock"></i> Horarios</a>
                </li>   
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletReceta?accion=listar"><i class="fa-solid fa-prescription"></i> Recetas</a>
                </li>    
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletDoctor?accion=listar"><i class="fa-solid fa-user-doctor"></i> Doctores</a>
                </li> 
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletMedicamento?accion=listar"><i class="fa-solid fa-capsules"></i> Medicamentos</a>
                </li>      
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletUsuarios?accion=listar"><i class="fa-solid fa-user"></i> Usuarios</a>
                </li>      
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletEdificio?accion=listar"><i class="fa-solid fa-building"></i> Edificios</a>
                </li>      
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletHabitacion?accion=listar"><i class="fa-solid fa-bed"></i> Habitaciones</a>
                </li>      
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletPersonas?accion=listar"><i class="fa-solid fa-person"></i> Personas</a>
                </li>      
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletPaciente?accion=listar"><i class="fa-solid fa-head-side-cough"></i> Pacientes</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
                -->