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
       req.setCharacterEncoding("UTF-8");
       String accion = req.getParameter("accion");
       switch(accion){
           case "insertar":
                    insertarRegistro(req, resp);
               break;
           case "actualizar":
                    actualizarRegistro(req, resp);
                    listarRol(req, resp);
               break;
       }
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
                        editarRol(req, resp);
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
    
    public void insertarRegistro(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        String tipoRol = req.getParameter("tipoRol");
        
        Rol rol = new Rol(tipoRol);
        System.out.println(rol.toString());
        
        int insertarRol = new RolDaoJPA().addRol(rol);
        listarRol(req, resp);
    }
    
    public void actualizarRegistro(HttpServletRequest req, HttpServletResponse resp){
        int idRol = Integer.parseInt(req.getParameter("id"));
        String tipoRol = req.getParameter("tipoRol");
        
        Rol rol = new Rol(idRol, tipoRol);
        System.out.println(rol.toString());
        
        int registroActualizar = new RolDaoJPA().updateRol(rol);
        
    }
    
    public void editarRol(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        int idRol = Integer.parseInt(req.getParameter("id"));
        Rol rol = new RolDaoJPA().get(new Rol(idRol));
        System.out.println(rol.toString());
        HttpSession sesion = req.getSession();
        sesion.setAttribute("rol", rol);
        resp.sendRedirect(req.getContextPath() + "/" + "rol/editar-rol.jsp");
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
