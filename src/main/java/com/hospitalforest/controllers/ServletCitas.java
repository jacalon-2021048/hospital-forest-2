package com.hospitalforest.controllers;

import com.hospitalforest.models.dao.CitasDaoImpl;
import com.hospitalforest.models.dao.DoctorDaoImpl;
import com.hospitalforest.models.dao.HabitacionDaoImpl;
import com.hospitalforest.models.dao.PacienteDaolmpl;
import com.hospitalforest.models.domain.Citas;
import com.hospitalforest.models.domain.Doctor;
import com.hospitalforest.models.domain.Habitacion;
import com.hospitalforest.models.domain.Paciente;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author Jhonatan Jose Acalón Ajanel <jacalon-2021048@kinal.edu.gt>
 * @date 2/09/2022
 * @time 16:37:47
 * @codigo IN5BM
 * @jornada Matutina
 * @grupo 1
 */
@WebServlet("/ServletCitas")
public class ServletCitas extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarCita(request, response);
                    break;
                case "actualizar":
                    actualizarCita(request, response);
                    break;
            }
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");
        String accion=request.getParameter("accion");
        if (accion!=null) {
            switch (accion){
                case "listar":
                    listarCitas(request, response);
                    listarDoctores(request, response);
                    listarPaciente(request, response);
                    listarHabitaciones(request, response);
                    break;
                    
                case "editar":
                    editarCita(request,response);
                    break;
                    
                case "eliminar":
                    eliminarCita(request, response);
                    break;
            }
        }
    }
    
    private void listarCitas(HttpServletRequest request,HttpServletResponse response) throws IOException{
        List<Citas> listaCitas=new CitasDaoImpl().getAll();
        HttpSession sesion=request.getSession();
        sesion.setAttribute("data", listaCitas);
        sesion.setAttribute("cantidadRegistros", listaCitas.size());
        response.sendRedirect("cita/cita.jsp");
    }
    
    private void listarDoctores(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Doctor> listarDoctores = new DoctorDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("dataDoctor", listarDoctores);
    }
    
    private void listarPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Paciente> listarPacientes = new PacienteDaolmpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("dataPaciente", listarPacientes);
    }

    private void listarHabitaciones(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Habitacion> listarHabitaciones = new HabitacionDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("dataHabitaciones", listarHabitaciones);
    }
    
    private void eliminarCita(HttpServletRequest request,HttpServletResponse response) throws IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        Citas cita=new Citas(id);
        int registroEliminado=new CitasDaoImpl().delete(cita);
        System.out.println("Cantidad de registros eliminados: " + registroEliminado);
        
        if(registroEliminado>=1){
            System.out.println("El registro se elimino con exito");
        }else{
            System.out.println("Se produjo un error al intentar eliminar la siguiente cita: " + cita.toString());
        }
        listarCitas(request, response);
    }
    
    private void editarCita(HttpServletRequest request,HttpServletResponse response) throws IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        Citas cita=new CitasDaoImpl().get(new Citas(id));
        HttpSession sesion=request.getSession();
        sesion.setAttribute("cita", cita);
        response.sendRedirect(request.getContextPath() + "/" + "cita/editar-cita.jsp");
    }
    
    private void insertarCita(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String descripcion=request.getParameter("descripcion");
        String fecha=request.getParameter("fecha");
        String hora=request.getParameter("hora");
        String doctorId=request.getParameter("doctor");
        String pacienteId=request.getParameter("paciente");
        int habitacionId=Integer.parseInt(request.getParameter("habitacion"));
        Citas cita=new Citas(descripcion, LocalDate.parse(fecha), LocalTime.parse(hora), doctorId, pacienteId, habitacionId);
        System.out.println(cita.toString());
        int registrosInsertados=new CitasDaoImpl().add(cita);
        listarCitas(request, response);
    }
    
    private void actualizarCita(HttpServletRequest request,HttpServletResponse response) throws IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        String descripcion=request.getParameter("descripcion");
        String fecha=request.getParameter("fecha");
        String hora=request.getParameter("hora");
        String doctorId=request.getParameter("doctor");
        String pacienteId=request.getParameter("paciente");
        int habitacionId=Integer.parseInt(request.getParameter("habitacion"));
        Citas cita=new Citas(id,descripcion, LocalDate.parse(fecha), LocalTime.parse(hora), doctorId, pacienteId, habitacionId);
        int registrosInsertados=new CitasDaoImpl().update(cita);
        listarCitas(request, response);
    }
}