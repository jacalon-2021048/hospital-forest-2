package com.hospitalforest.controllers;

/**
 *
 * @author Juan Pablo Cáceres Enriquez
 * @date 02-09-2022
 * @timee 22:53:45 PM Codigo Tecnico: IN5BM
 */
import com.hospitalforest.models.domain.Doctor;
import com.hospitalforest.models.dao.DoctorDaoImpl;
import com.hospitalforest.models.dao.EspecialidadesDaoJPA;
import com.hospitalforest.models.dao.HorarioDaoJPA;
import com.hospitalforest.models.dao.PersonaDaoJPA;
import com.hospitalforest.models.domain.Especialidades;
import com.hospitalforest.models.domain.Horario;
import com.hospitalforest.models.domain.Persona;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ServletDoctor")
public class ServletDoctor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarDoctor(request, response);
                    break;
                case "actualizar":
                    actualizarDoctor(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarDoctores(request, response);
                    listarHorario(request,response);
                    listarPersonas(request, response);
                    listarEspecialidades(request,response);
                    break;
                case "editar":
                    editarDoctor(request,response);
                    break;
                case "eliminar":
                    eliminarDoctor(request, response);
                    listarDoctores(request, response);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
    
    private void listarDoctores(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Doctor> listarDoctores = new DoctorDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("arrayListDoctor", listarDoctores);
        sesion.setAttribute("totalDoctores", listarDoctores.size());
        response.sendRedirect("doctor/doctor.jsp");
    }
    
    public void listarHorario(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List <Horario> listaHorario = new HorarioDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("dataHorario", listaHorario);
    }
    
    private void listarPersonas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Persona> listaPersonas = new PersonaDaoJPA().getAll();        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("dataPersona", listaPersonas);
    }
    
    private void listarEspecialidades(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Especialidades> listaEspecialidades = new EspecialidadesDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("dataEspecialidad", listaEspecialidades);
    }

    private void eliminarDoctor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int doctor = Integer.parseInt(request.getParameter("id"));
        Doctor doctores = new Doctor(doctor);
        int registroEliminado = new DoctorDaoImpl().delete(doctores);
        System.out.println("Cantidad de registros eliminados: " + registroEliminado);

        if (registroEliminado >= 1) {
            System.out.println("El rigistro fue eliminado con exito");
        } else {
            System.err.println("Se prodijo un error al intetar eliminar el siguiente doctor" + doctores.toString());
        }
    }
    
    private void editarDoctor(HttpServletRequest request,HttpServletResponse response) throws IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        Doctor doctor=new DoctorDaoImpl().get(new Doctor(id));
        HttpSession sesion=request.getSession();
        sesion.setAttribute("doctor", doctor);
        response.sendRedirect(request.getContextPath() + "/" + "doctor/editar-doctor.jsp");
    }
    
    private void insertarDoctor(HttpServletRequest request,HttpServletResponse response) throws IOException{        
        int horarioId=Integer.parseInt(request.getParameter("horario"));
        String nombrePersona=request.getParameter("persona");      
        String nombreEspecialidad=request.getParameter("especialidad");
        Doctor doctor=new Doctor(horarioId, nombrePersona, nombreEspecialidad);
        System.out.println(doctor.toString());
        int registrosInsertados=new DoctorDaoImpl().add(doctor);
        listarDoctores(request, response);
    }
    
    private void actualizarDoctor(HttpServletRequest request,HttpServletResponse response) throws IOException{
        int id=Integer.parseInt(request.getParameter("id"));       
        int horarioId=Integer.parseInt(request.getParameter("horario"));
        String nombrePersona=request.getParameter("persona");
        String nombreEspecialidad=request.getParameter("especialidad");
        Doctor doctor=new Doctor(id, horarioId, nombrePersona, nombreEspecialidad);
        int registrosInsertados=new DoctorDaoImpl().update(doctor);
        listarDoctores(request, response);
    }
   
}
