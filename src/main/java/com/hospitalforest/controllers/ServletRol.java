package com.hospitalforest.controllers;

import com.hospitalforest.models.dao.RolDaoJPA;
import com.hospitalforest.models.domain.Rol;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alberto Moisés Gerardo Lemus Alvarado
 * @date 3 sept. 2022
 * @time 14:32:09
 * @Carne: 2021062
 * @Codigo Tecnico: IN5BM
 */

@WebServlet("/ServletRol")
public class ServletRol extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String accion = req.getParameter("accion");
        
        if(accion != null){
            switch(accion){
                case "listar":
                        listarRol(req, resp);
                    break;
                case "editar":
                    
                    break;
                case "eliminar":
                        eliminarRol(req, resp);
                        listarRol(req, resp);
                    break;
                default:
                    System.out.println("Esa no es una opcion");    
                    break;
            }
        }
    }
    
    public void listarRol(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        List <Rol> listarRol = new RolDaoJPA().getAll();
        HttpSession sesion = req.getSession();
        sesion.setAttribute("data", listarRol);
        sesion.setAttribute("totalRoles", listarRol.size());
        resp.sendRedirect("rol/rol.jsp");
    }
    
    private void eliminarRol(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        int idRol = Integer.parseInt(req.getParameter("id"));
        Rol rol = new RolDaoJPA().get(new Rol(idRol));
        int registrosEliminados = new RolDaoJPA().deleteRol(rol);
        
        if(registrosEliminados >= 1){
            System.out.println("El registro fue eliminada con exito");
        }else{
            System.out.println("Se produjo un error al intentar eliminar un registro(metodo eliminarRol)" + rol.toString());
        }
    }
    
    
}
