package com.hospitalforest.controllers;

import com.hospitalforest.models.dao.HorarioDaoJPA;
import com.hospitalforest.models.domain.Horario;
import java.io.IOException;
import java.time.LocalTime;
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
        req.setCharacterEncoding("UTF-8");
        String accion = req.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "insertar":
                    insertarHorario(req, resp);
                    
                    break;
                case "actualizar":
                    actualizarHorario(req, resp);
                    listarHorario(req, resp);
                    break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String accion = req.getParameter("accion");
        
        if(accion != null){
            switch(accion){
                case "listar" :
                        listarHorario(req,resp);
                    break;
                case "editar" :
                        editarHorario(req, resp);
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
    
    public void insertarHorario(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        LocalTime horarioInicio = LocalTime.parse(req.getParameter("horarioInicio"));
        LocalTime horarioFinal = LocalTime.parse(req.getParameter("horarioFinal"));
        boolean lunes = Boolean.parseBoolean(req.getParameter("lunes"));
        boolean martes = Boolean.parseBoolean(req.getParameter("martes"));
        boolean miercoles = Boolean.parseBoolean(req.getParameter("miercoles"));
        boolean jueves = Boolean.parseBoolean(req.getParameter("jueves"));
        boolean viernes = Boolean.parseBoolean(req.getParameter("viernes"));
        boolean sabado = Boolean.parseBoolean(req.getParameter("sabado"));
        boolean domingo = Boolean.parseBoolean(req.getParameter("domingo"));
        
        Horario horario = new Horario(horarioInicio, horarioFinal, lunes, martes, miercoles, jueves, viernes, sabado, domingo);
        System.out.println(horario);
        
        int registroHorario = new HorarioDaoJPA().addHorario(horario);
        listarHorario(req, resp);
        
    }
    
    public void actualizarHorario(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        LocalTime horarioInicio = LocalTime.parse(req.getParameter("horarioInicio"));
        LocalTime horarioFinal = LocalTime.parse(req.getParameter("horarioFinal"));
        boolean lunes = Boolean.parseBoolean(req.getParameter("lunes"));
        boolean martes = Boolean.parseBoolean(req.getParameter("martes"));
        boolean miercoles = Boolean.parseBoolean(req.getParameter("miercoles"));
        boolean jueves = Boolean.parseBoolean(req.getParameter("jueves"));
        boolean viernes = Boolean.parseBoolean(req.getParameter("viernes"));
        boolean sabado = Boolean.parseBoolean(req.getParameter("sabado"));
        boolean domingo = Boolean.parseBoolean(req.getParameter("domingo"));
        
        Horario horario = new Horario(id, horarioInicio, horarioFinal, lunes, martes, miercoles, jueves, viernes, sabado, domingo);
        System.out.println(horario.toString());
        
        int registroActualizado = new HorarioDaoJPA().updateHorario(horario);
        
    }
    
    public void editarHorario(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        int idHorario = Integer.parseInt(req.getParameter("id"));
        Horario horario = new HorarioDaoJPA().get(new Horario(idHorario));
        System.out.println(horario.toString());
        HttpSession sesion = req.getSession();
        sesion.setAttribute("horario", horario);
        resp.sendRedirect(req.getContextPath() + "/" + "horario/editar-horario.jsp");
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
