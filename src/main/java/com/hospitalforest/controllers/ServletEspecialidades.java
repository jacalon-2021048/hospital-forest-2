package com.hospitalforest.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.hospitalforest.models.dao.EspecialidadesDaoJPA;
import com.hospitalforest.models.domain.Especialidades;
/**
 *
 * @author Jhonatan Jose Acalón Ajanel <jacalon-2021048@kinal.edu.gt>
 * @date 2/09/2022
 * @time 16:37:59
 * @codigo IN5BM
 * @jornada Matutina
 * @grupo 1
 */
@WebServlet("/ServletEspecialidades")
public class ServletEspecialidades extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String accion=request.getParameter("accion");
        if(accion!=null){
            switch(accion){
                case "listar":
                    listarEspecialidades(request,response);
                    break;
                    
                case "editar":
                    //acciones
                    break;
                    
                case "eliminar":
                    eliminarEspecialidad(request, response);
                    break;
            }
        }
    }
    
    private void listarEspecialidades(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //      List<Especialidades> listaEspecialidades= new EspecialidadesDaoImpl().getAll();
        List<Especialidades> listaEspecialidades = new EspecialidadesDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaEspecialidades);
        sesion.setAttribute("cantidadRegistros", listaEspecialidades.size());
        response.sendRedirect("especialidad/especialidad.jsp");
    }

    private void eliminarEspecialidad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Especialidades especialidad=new Especialidades(id);
        int registroEliminado=new EspecialidadesDaoJPA().delete(especialidad);
        System.out.println("Cantidad de registros eliminados: " + registroEliminado);
        
        if(registroEliminado>=1){
            System.out.println("El registro se elimino con exito");
        }else{
            System.out.println("Se produjo un error al intentar eliminar la siguiente especialidad: " + especialidad.toString());
        }
        listarEspecialidades(request, response);
    }
}