package com.hospitalforest.controllers;

import com.hospitalforest.models.dao.PersonaDaoJPA;
import com.hospitalforest.models.dao.RolDaoJPA;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.hospitalforest.models.dao.UsuariosDaoImpl;
import com.hospitalforest.models.domain.Persona;
import com.hospitalforest.models.domain.Rol;
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
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarUsuario(request, response);
                    break;
                case "actualizar":
                    actualizarUsuario(request, response);
                    break;
            }
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");
        String accion=request.getParameter("accion");
        if(accion!=null){
            switch(accion){
                case "listar":
                    listarUsuarios(request,response);
                    listarPersonas(request, response);
                    listarRol(request, response);
                    break;
                    
                case "editar":
                    editarUsuario(request,response);
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
    
    private void listarPersonas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Persona> listaPersonas = new PersonaDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("dataPersona", listaPersonas);
    }
    
    public void listarRol(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        List <Rol> listarRol = new RolDaoJPA().getAll();
        System.out.println(listarRol.size());
        HttpSession sesion = req.getSession();
        sesion.setAttribute("dataRol", listarRol);
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
    
    private void insertarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user=request.getParameter("nombre");
        String pass=request.getParameter("pass");
        String rolId=request.getParameter("rol");
        String personaId=request.getParameter("person");
        Usuarios usuario=new Usuarios(user,pass,rolId,personaId);
        System.out.println(usuario.toString());
        int registrosInsertados=new UsuariosDaoImpl().add(usuario);
        listarUsuarios(request, response);
    }
    
    private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user=request.getParameter("user");
        Usuarios usuario=new UsuariosDaoImpl().get(new Usuarios(user));
        HttpSession sesion=request.getSession();
        sesion.setAttribute("usuario", usuario);
        response.sendRedirect(request.getContextPath() + "/" + "usuario/editar-usuario.jsp");
    }
    
    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user=request.getParameter("nombre");
        String pass=request.getParameter("pass");
        String rolId=request.getParameter("rol");
        String personaId=request.getParameter("person");
        Usuarios usuario=new Usuarios(user,pass,rolId,personaId);
        int registrosInsertados = new UsuariosDaoImpl().update(usuario);
        listarUsuarios(request, response);
    }
}