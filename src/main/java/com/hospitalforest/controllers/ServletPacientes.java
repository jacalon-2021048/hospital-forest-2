package com.hospitalforest.controllers;

import com.hospitalforest.models.domain.Paciente;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.hospitalforest.models.dao.PacienteDaolmpl;

/**
 *
 * @author Christofer Geovanni Quel Guerra
 * @date 3 sep. 2022
 * @time 19:00:47
 */


@WebServlet("/ServletPaciente")
public class ServletPacientes extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doPost");
        String accion = request.getParameter("accion");
        System.out.println(accion);
        
        if(accion != null){
            switch(accion){
                case "insertar":
                    //ACCION PARA AGREGAR
                    insertarPaciente(request, response);
                    break;
                case "actualizar":
                    //Accion para actualizar
                    actualizarPaciente(request, response);
                    listarPaciente(request, response);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
    
    public void insertarPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");
        int seguro = Integer.parseInt(request.getParameter("seguro"));
        String emergencia = request.getParameter("emergencia");
        String persona = request.getParameter("persona");
        
        Paciente paciente = new Paciente(seguro, emergencia, persona);
        System.out.println(paciente);
        
        int registrosInsertados = new PacienteDaolmpl().add(paciente);
        
        listarPaciente(request, response);
    }
    
    public void actualizarPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("Esta bien el metodo Actualizar");
        int id = Integer.parseInt(request.getParameter("id"));
        
        int seguro = Integer.parseInt(request.getParameter("seguro"));
        String contacto = request.getParameter("emergencia");
        String idPersona = request.getParameter("persona");
        
        Paciente paciente = new Paciente(id, seguro, contacto, idPersona);
        System.out.println(paciente.toString());
        
        int registrosActualizados = new PacienteDaolmpl().update(paciente);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarPaciente(request, response);
                    break;
                case "editar":
                    //otras acciones...
                    editarPacientes(request, response);
                    break;
                case "eliminar":
                    //eliminar...
                    eliminarPaciente(request, response);
                    break;
                default:
                    System.out.println("No hay ninguna opcion asi");
                    break;
            }
        } 
    }
    
    private void eliminarPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int idPaciente = Integer.parseInt(request.getParameter("id"));
        Paciente paciente = new Paciente(idPaciente);
        int registrosEliminados = new PacienteDaolmpl().delete(paciente);
        if(registrosEliminados >= 1){
            System.out.println("El registro fue eliminado con exito");
        }
        listarPaciente(request, response);
    }
    
    private void editarPacientes(HttpServletRequest request, HttpServletResponse response)throws IOException{
        //Recuperar el id del estudiante
        int idPaciente = Integer.parseInt(request.getParameter("id"));
        
        //Crear un objeto de tipo estudiante
        Paciente paciente = new PacienteDaolmpl()
                .get(new Paciente(idPaciente));
        
        System.out.println(paciente.toString());
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("paciente", paciente);
        response.sendRedirect(request.getContextPath() + "/" + "pacientes/editar-pacientes.jsp");
        }
    
    private void listarPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Paciente> listarPacientes = new PacienteDaolmpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listarPacientes);
        sesion.setAttribute("totalPacientes", listarPacientes.size());
        response.sendRedirect("pacientes/pacientes.jsp");
        
    }
    
    
    
}
