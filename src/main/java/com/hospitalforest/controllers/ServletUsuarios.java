package com.hospitalforest.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.hospitalforest.models.dao.UsuariosDaoImpl;
import com.hospitalforest.models.domain.Usuarios;
/**
 *
 * @author Jhonatan Jose Acalón Ajanel <jacalon-2021048@kinal.edu.gt>
 * @date 2/09/2022
 * @time 16:38:10
 * @codigo IN5BM
 * @jornada Matutina
 * @grupo 1
 */
@WebServlet("/ServletUsuarios")
public class ServletUsuarios extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String accion=request.getParameter("accion");
        if(accion!=null){
            switch(accion){
                case "listar":
                    listarUsuarios(request,response);
                    break;
                    
                case "editar":
                    //acciones
                    break;
                    
                case "eliminar":
                    eliminarUsuario(request, response);
                    break;
            }
        }
    }
    
    private void listarUsuarios(HttpServletRequest request,HttpServletResponse response) throws IOException{
        List<Usuarios> listaUsuarios=new UsuariosDaoImpl().getAll();
        HttpSession sesion=request.getSession();
        sesion.setAttribute("data", listaUsuarios);
        sesion.setAttribute("cantidadRegistros",listaUsuarios.size());
        response.sendRedirect("usuario/usuario.jsp");
    }
    
    private void eliminarUsuario(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String user=request.getParameter("usuario");
        Usuarios usuario=new Usuarios(user);
        int registroEliminado=new UsuariosDaoImpl().delete(usuario);
        System.out.println("Cantidad de registros eliminados: " + registroEliminado);
        
        if(registroEliminado>=1){
            System.out.println("El registro se elimino con exito");
        }else{
            System.out.println("Se produjo un error al intentar eliminar el siguiente usuario: " + usuario.toString());
        }
        listarUsuarios(request, response);
    }
}