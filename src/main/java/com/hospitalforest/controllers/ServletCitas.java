package com.hospitalforest.controllers;

import com.hospitalforest.models.dao.CitasDaoImpl;
import com.hospitalforest.models.domain.Citas;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author Jhonatan Jose Acalón Ajanel <jacalon-2021048@kinal.edu.gt>
 * @date 2/09/2022
 * @time 16:37:47
 * @codigo IN5BM
 * @jornada Matutina
 * @grupo 1
 */
@WebServlet("/ServletCitas")
public class ServletCitas extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String accion=request.getParameter("accion");
        if (accion!=null) {
            switch (accion){
                case "listar":
                    listarCitas(request, response);
                    break;
                    
                case "eliminar":
                    eliminarCita(request, response);
                    break;
            }
        }
    }
    
    private void listarCitas(HttpServletRequest request,HttpServletResponse response) throws IOException{
        List<Citas> listaCitas=new CitasDaoImpl().getAll();
        HttpSession sesion=request.getSession();
        sesion.setAttribute("data", listaCitas);
        sesion.setAttribute("cantidadRegistros", listaCitas.size());
        response.sendRedirect("cita/cita.jsp");
    }
    
    private void eliminarCita(HttpServletRequest request,HttpServletResponse response) throws IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        Citas cita=new Citas(id);
        int registroEliminado=new CitasDaoImpl().delete(cita);
        System.out.println("Cantidad de registros eliminados: " + registroEliminado);
        
        if(registroEliminado>=1){
            System.out.println("El registro se elimino con exito");
        }else{
            System.out.println("Se produjo un error al intentar eliminar la siguiente cita: " + cita.toString());
        }
        listarCitas(request, response);
    }
}