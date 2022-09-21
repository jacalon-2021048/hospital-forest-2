package com.hospitalforest.controllers;

import com.hospitalforest.models.dao.HorarioDaoJPA;
import com.hospitalforest.models.domain.Horario;
import java.io.IOException;
import java.util.List;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alberto Moisés Gerardo Lemus Alvarado
 * @date 2 sept. 2022
 * @time 16:21:59
 * @Carne: 2021062
 * @Codigo Tecnico: IN5BM
 */

@WebServlet("/ServletHorario")
public class ServletHorario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String accion = req.getParameter("accion");
        
        if(accion != null){
            switch(accion){
                case "listar" :
                        listarHorario(req,resp);
                    break;
                case "editar" :
                    
                    break;
                case "eliminar":
                        eliminarHorario(req, resp);
                        listarHorario(req, resp);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
    
    public void listarHorario(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        List <Horario> listaHorario = new HorarioDaoJPA().getAll();
        HttpSession sesion = req.getSession();
        sesion.setAttribute("data", listaHorario);
        sesion.setAttribute("totalHorarios", listaHorario.size());
        resp.sendRedirect("horario/horario.jsp");
    }

    private void eliminarHorario(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        int idHorario = Integer.parseInt(req.getParameter("id"));
        Horario horario = new HorarioDaoJPA().get(new Horario(idHorario));
        int registrosEliminados = new HorarioDaoJPA().deleteHorario(horario);
        
        if(registrosEliminados >=1){
            System.out.println("El registro fue eliminado con exito");
        }else{
            System.out.println("Se produjo un error al intentar eliminar un registro(metodo EliminarHorario)" + horario.toString());
        }
    }
    
    
    
}
