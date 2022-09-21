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
        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarHabitacion(request, response);
                    break;
                case "actualizar":
                    actualizarHabitacion(request, response);
                    break;
            }
        }
    }
    
    
     private void actualizarHabitacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("idHabitaciones"));
        int nivel = Integer.parseInt(request.getParameter("nivel"));
        boolean ocupado = Boolean.parseBoolean(request.getParameter("ocupado"));
        int edificioId = Integer.parseInt(request.getParameter("edificio"));
        
        Habitacion habitacion = new Habitacion(id, nivel, ocupado, edificioId);
        
        System.out.println(habitacion.toString());
        
        //Con JDBC---------------------------------------------------------------
        int registrosActualizados = new HabitacionDaoImpl().update(habitacion);
        //-----------------------------------------------------------------------

        listarHabitaciones(request, response);

    }
    
    
    private void insertarHabitacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int nivel = Integer.parseInt(request.getParameter("nivel"));
        boolean ocupado = Boolean.parseBoolean(request.getParameter("ocupado"));
        int edificioId = Integer.parseInt(request.getParameter("edificio"));

        Habitacion habitacion = new Habitacion(nivel, ocupado, edificioId);
        System.out.println(habitacion);
        
        //JDBC------------------------------------------------------------------
        int registrosInsertados = new HabitacionDaoImpl().add(habitacion);
        //----------------------------------------------------------------------
        
        //JPA-------------------------------------------------------------------
        //int registrosInsertados = new EstudianteDaoJPA().add(estudiante);
        //----------------------------------------------------------------------
        
        listarHabitaciones(request, response);
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
                    editarHabitacion(request, response);
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
    
    private void editarHabitacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idHabitacion = Integer.parseInt(request.getParameter("idHabitacion"));
        
        Habitacion habitaciones = new HabitacionDaoImpl().get(new Habitacion(idHabitacion));
        
        //---------------------------------------------------------------------
        System.out.println(habitaciones.toString());
        HttpSession sesion = request.getSession();
        sesion.setAttribute("habitaciones", habitaciones);
        response.sendRedirect(request.getContextPath() + "/" + "habitaciones/editar-habitaciones.jsp");
        //---------------------------------------------------------------------
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
