package com.hospitalforest.controllers;

/**
 *
 * @author Juan Pablo Cáceres Enriquez
 * @date 02-09-2022
 * @timee 22:53:45 PM Codigo Tecnico: IN5BM
 */
import com.hospitalforest.models.domain.Medicamento;
import com.hospitalforest.models.dao.MedicamentoDaoJPA;
import java.io.IOException;

import java.sql.Date;

import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ServletMedicamento")
public class ServletMedicamento extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarMedicamento(request, response);
                    break;
                case "actualizar":
                    actualizarMedicamento(request, response);
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
                    listarMedicamentos(request, response);
                    break;
                case "editar":
                    editarMedicamento(request,response);
                    break;
                case "eliminar":
                    eliminarMedicamento(request, response);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

    private void listarMedicamentos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Medicamento> listarMedicamentos = new MedicamentoDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("arrayListMedicamento", listarMedicamentos);
        sesion.setAttribute("totalMedicamentos", listarMedicamentos.size());
        response.sendRedirect("medicamento/medicamento.jsp");
    }
    
    private void eliminarMedicamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Medicamento medicamento = new MedicamentoDaoJPA().get(new Medicamento(id));
        int registrosEliminados = new MedicamentoDaoJPA().delete(medicamento);
        System.out.println("Cantidad de registros eliminados: " + registrosEliminados);
        if (registrosEliminados >= 1) {
            System.out.println("El rigistro fue eliminado con exito");
        } else {
            System.err.println("Se prodijo un error al intetar eliminar el siguiente medicamento" + medicamento.toString());
        }
        listarMedicamentos(request, response);
    }
    
    
    private void insertarMedicamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre=request.getParameter("medicamento");
        String descripcion=request.getParameter("descripcion");
        Date fechaCaducidad = Date.valueOf(request.getParameter("fecha"));
        Medicamento medicamento=new Medicamento(nombre, descripcion, fechaCaducidad);
        System.out.println(medicamento.toString());
        int registrosInsertados=new MedicamentoDaoJPA().add(medicamento);
        listarMedicamentos(request, response);
    }
    
    private void actualizarMedicamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String nombre=request.getParameter("medicamento");
        String descripcion=request.getParameter("descripcion");
        Date fechaCaducidad = Date.valueOf(request.getParameter("fecha"));
        Medicamento medicamento=new Medicamento(id, nombre, descripcion, fechaCaducidad);
        int registrosInsertados=new MedicamentoDaoJPA().update(medicamento);
        listarMedicamentos(request, response);
    }
    
    private void editarMedicamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Medicamento medicamento=new MedicamentoDaoJPA().get(new Medicamento(id));
        HttpSession sesion = request.getSession();
        sesion.setAttribute("medicamento", medicamento);
        response.sendRedirect(request.getContextPath() + "/" + "medicamento/editar-medicamento.jsp");
    
    }

}
