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

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarMedicamentos(request, response);
                    break;
                case "editar":
                    // Otras acciones
                    break;
                case "eliminar":
                    eliminarMedicamento(request, response);
                    listarMedicamentos(request, response);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

    private void eliminarMedicamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idMedicamento = Integer.parseInt(request.getParameter("id"));
        Medicamento medicamento = new MedicamentoDaoJPA().get(new Medicamento(idMedicamento));
        int registrosEliminados = new MedicamentoDaoJPA().delete(medicamento);

        if (registrosEliminados >= 1) {
            System.out.println("El rigistro fue eliminado con exito");
        } else {
            System.err.println("Se prodijo un error al intetar eliminar el siguiente medicamento" + medicamento.toString());
        }
    }

    private void listarMedicamentos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Medicamento> listarMedicamentos = new MedicamentoDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("arrayListMedicamento", listarMedicamentos);
        sesion.setAttribute("totalMedicamentos", listarMedicamentos.size());
        response.sendRedirect("medicamento/medicamento.jsp");
    }
}
