package com.hospitalforest.controllers;

/**
 *
 * @author Juan Pablo Cáceres Enriquez
 * @date 02-09-2022
 * @timee 22:53:45 PM Codigo Tecnico: IN5BM
 */
import com.hospitalforest.models.domain.Doctor;
import com.hospitalforest.models.dao.DoctorDaoImpl;
import java.io.IOException;
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

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");
        
        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarDoctores(request, response);
                    break;
                case "editar":
                    // Otras acciones
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

    private void listarDoctores(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Doctor> listarDoctores = new DoctorDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("arrayListDoctor", listarDoctores);
        sesion.setAttribute("totalDoctores", listarDoctores.size());
        response.sendRedirect("doctor/doctor.jsp");
    }
}
