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
    
    private void listarPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Paciente> listarPacientes = new PacienteDaolmpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listarPacientes);
        sesion.setAttribute("totalPacientes", listarPacientes.size());
        response.sendRedirect("pacientes/pacientes.jsp");
        
    }
    
    
    
}
