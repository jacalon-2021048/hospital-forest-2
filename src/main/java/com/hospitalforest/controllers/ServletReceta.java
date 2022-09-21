package com.hospitalforest.controllers;

import com.hospitalforest.models.dao.RecetaDaoImpl;
import com.hospitalforest.models.domain.Receta;
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
 * @time 16:16:42
 * @Carne: 2021062
 * @Codigo Tecnico: IN5BM
 */




@WebServlet("/ServletReceta")
public class ServletReceta extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String accion = req.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "insertar":
                        insertarReceta(req, resp);
                        listarReceta(req, resp);
                    break;
                case "actualizar":
                        actualizarReceta(req, resp);
                        listarReceta(req,resp);
                    break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String accion = req.getParameter("accion");
        if (accion != null)
        {
            switch (accion)
            {
                case "listar":
                        listarReceta(req, resp);
                    break;
                case "editar":
                        editarReceta(req,resp);
                    break;
                case "eliminar":
                        eliminarReceta(req,resp);
                    break;
                default:
                    System.out.println("Esa no es una opcion");
                    break;
            }
        }
    }
    
    public void listarReceta(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        List <Receta> listarReceta = new RecetaDaoImpl().getAll();
        HttpSession sesion = req.getSession();        
        sesion.setAttribute("data",listarReceta);
        sesion.setAttribute("totalRecetas", listarReceta.size());
        resp.sendRedirect("recetas/recetas.jsp");
    }           

    public void insertarReceta(HttpServletRequest req, HttpServletResponse resp){
        String dosisRecomendada = req.getParameter("dosisRecomendada");
        String medicamentoId = req.getParameter("medicamentoId");
        String citaId = req.getParameter("citaId");
        
        Receta receta = new Receta(dosisRecomendada, medicamentoId, citaId);
        System.out.println(receta.toString());
        
        int insertarRegistros = new RecetaDaoImpl().addReceta(receta);
    }
    
    public void actualizarReceta(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        int idReceta = Integer.parseInt(req.getParameter("id"));
        String dosisRecomendada = req.getParameter("dosisRecomendada");
        String medicamentoId = req.getParameter("medicamentoId");
        String citaId = req.getParameter("citaId");

        Receta receta = new Receta(idReceta, dosisRecomendada, medicamentoId, citaId);
        System.out.println(receta.toString());
        
        int actualizarRegistro = new RecetaDaoImpl().updateReceta(receta);
    }
    
    public void editarReceta(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        int idReceta = Integer.parseInt(req.getParameter("id"));
        Receta receta = new RecetaDaoImpl().get(new Receta(idReceta));
        System.out.println(receta.toString());
        HttpSession sesion = req.getSession();
        sesion.setAttribute("receta", receta);
        resp.sendRedirect(req.getContextPath() + "/" + "recetas/editar-recetas.jsp");
    }
    
    public void eliminarReceta(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        int receta = Integer.parseInt(req.getParameter("id"));
        Receta recetas = new Receta(receta);
        int registroEliminado = new RecetaDaoImpl().deleteReceta(recetas);
        System.out.println("Cantidad de registros eliminados: " + registroEliminado);
        
        if(registroEliminado>=1){
            System.out.println("El registro se elimino con exito");
        }else{
            System.out.println("Se produjo un error al intentar eliminar el siguiente usuario: " + recetas.toString());
        }
        listarReceta(req, resp);
    }
    
}
