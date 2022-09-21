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
                    //otras acciones...
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
        //List<Edificios> listarEdificios = new EdificioDaoImpl().getAll();
        //-----------------------------------------------------------------------
        
        //Con JPA-----------------------------------------------------------------
        List <Edificios> listaEdificios = new EdificioDaoJPA().getAll();
        //-----------------------------------------------------------------------
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaEdificios);
        sesion.setAttribute("totalEdificios", listaEdificios.size());
        response.sendRedirect("edificio/edificios.jsp");
        
    }
    
}
