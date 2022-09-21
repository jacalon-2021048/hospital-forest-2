package com.hospitalforest.controllers;

import com.hospitalforest.models.domain.Edificios;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.hospitalforest.models.dao.EdificioDaoImpl;
import com.hospitalforest.models.dao.EdificioDaoJPA;

/**
 *
 * @author Henry Sanum
 */

@WebServlet("/ServletEdificio")
public class ServletEdificios extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarEdificio(request, response);
                    break;
                case "actualizar":
                    actualizarEdificio(request, response);
                    break;
            }
        }
    }
    
     
    private void actualizarEdificio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("idEdificio"));
        String nombreEdificio = request.getParameter("edificio");
        
        
        Edificios edificio = new Edificios(id, nombreEdificio);
        
        System.out.println(edificio.toString());
        
        //Con JDBC---------------------------------------------------------------
        //int registrosActualizados = new EdificioDaoImpl().update(edificio);
        //-----------------------------------------------------------------------

        //Con JPA-----------------------------------------------------------------
        int registrosActualizados = new EdificioDaoJPA().update(edificio);
        //-----------------------------------------------------------------------
       
        listarEdificios(request, response);

    }
    
    private void insertarEdificio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombreEdificio = request.getParameter("edificio");

        Edificios edificio = new Edificios(nombreEdificio);
        System.out.println(edificio);

        //JDBC------------------------------------------------------------------
        //int registrosInsertados = new EdificioDaoImpl().add(edificio);
        //----------------------------------------------------------------------
        
        //JPA-------------------------------------------------------------------
        int registrosInsertados = new EdificioDaoJPA().add(edificio);
        //----------------------------------------------------------------------

        listarEdificios(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarEdificios(request, response);
                    break;
                case "editar":
                    editarEdificio(request, response);
                    break;
                case "eliminar":
                    eliminarEdificio(request, response);
                    break;
                default:
                    System.out.println("No hay ninguna opcion asi");
                    break;
            }
        } 
    }
    
    private void editarEdificio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEdificio = Integer.parseInt(request.getParameter("idEdificio"));
        
        Edificios edificio = new EdificioDaoImpl().get(new Edificios(idEdificio));
        
        System.out.println(edificio.toString());
        HttpSession sesion = request.getSession();
        sesion.setAttribute("edificio", edificio);
        response.sendRedirect(request.getContextPath() + "/" + "edificio/editar-edificios.jsp");
    }

    
    private void eliminarEdificio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEdificio = Integer.parseInt(request.getParameter("idEdificio"));
        
        //Con JDBC--------------------------------------------------------------------------
        //Edificios edificio = new Edificios(idEdificio);
        //int registrosEliminados = new EdificioDaoImpl().delete(edificio);
        //----------------------------------------------------------------------------------
        
        //Con JPA---------------------------------------------------------------------------
        Edificios edificio = new EdificioDaoJPA().get(new Edificios(idEdificio));
        int registrosEliminados = new EdificioDaoJPA().delete(edificio);
        //----------------------------------------------------------------------------------

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.err.println("Se produjo un error al eliminar el siguiente habitacion " + edificio.toString());
        }

        listarEdificios(request, response);
    }

    
    private void listarEdificios(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Con JDBC---------------------------------------------------------------
        List<Edificios> listaEdificios = new EdificioDaoImpl().getAll();
        //-----------------------------------------------------------------------
        
        //Con JPA-----------------------------------------------------------------
        //List <Edificios> listaEdificios = new EdificioDaoJPA().getAll();
        //-----------------------------------------------------------------------
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaEdificios);
        sesion.setAttribute("totalEdificios", listaEdificios.size());
        response.sendRedirect("edificio/edificios.jsp");
        
    }
    
}
