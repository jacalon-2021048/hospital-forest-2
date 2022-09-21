package com.hospitalforest.controllers;

import com.hospitalforest.models.domain.Habitacion;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.hospitalforest.models.dao.HabitacionDaoImpl;

/**
 *
 * @author Henry Sanum
 */
@WebServlet("/ServletHabitacion")
public class ServletHabitaciones extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarHabitaciones(request, response);
                    break;
                case "editar":
                    //otras acciones...
                    break;
                case "eliminar":
                    eliminarHabitacion(request, response);
                    break;
                default:
                    System.out.println("No hay ninguna opcion asi");
                    break;
            }
        }
    }

    private void eliminarHabitacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idHabitacion = Integer.parseInt(request.getParameter("idHabitacion"));
        
        //Con JDBC--------------------------------------------------------------------------
        Habitacion habitacion = new Habitacion(idHabitacion);
        int registrosEliminados = new HabitacionDaoImpl().delete(habitacion);
        //----------------------------------------------------------------------------------

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.err.println("Sse produjo un error al eliminar el siguiente habitacion " + habitacion.toString());
        }

        listarHabitaciones(request, response);
    }

    private void listarHabitaciones(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Con JDBC---------------------------------------------------------------
        List<Habitacion> listarHabitaciones = new HabitacionDaoImpl().getAll();
        //-----------------------------------------------------------------------
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listarHabitaciones);
        sesion.setAttribute("totalHabitaciones", listarHabitaciones.size());
        response.sendRedirect("habitaciones/habitaciones.jsp");

    }

}
