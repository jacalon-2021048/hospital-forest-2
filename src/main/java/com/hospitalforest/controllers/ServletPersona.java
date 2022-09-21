package com.hospitalforest.controllers;

import com.hospitalforest.models.domain.Persona;
import com.hospitalforest.models.dao.PersonaDaoJPA;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Christofer Geovanni Quel Guerra
 * @date 3 sep. 2022
 * @time 19:00:47
 */
@WebServlet("/ServletPersona")
public class ServletPersona extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("doPost");
        String accion = request.getParameter("accion");
        System.out.println(accion);

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    //ACCION PARA AGREGAR
                    insertarPersonas(request, response);
                    break;
                case "actualizar":
                    //Accion para actualizar
                    actualizarPersonas(request, response);
                    listarPersonas(request, response);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
    
    
    public void insertarPersonas(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");
        String nombre = request.getParameter("nombre1");
        String nombre2 = request.getParameter("nombre2");
        String nombre3 = request.getParameter("nombre3");
        String apellido = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        char sexo = String.valueOf(request.getParameter("sexo")).charAt(0);
        Date fecha = Date.valueOf(request.getParameter("fecha"));
        String correo = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        
        Persona persona = new Persona(nombre, nombre2,
                nombre3, apellido, apellido2, sexo, fecha, correo, telefono);
        System.out.println(persona);
        
        int registrosInsertados = new PersonaDaoJPA().add(persona);
        
        listarPersonas(request, response);
    }
    
    public void actualizarPersonas(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("Esta bien el metodo Actualizar");
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre1");
        String nombre2 = request.getParameter("nombre2");
        String nombre3 = request.getParameter("nombre3");
        String apellido = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        char sexo = String.valueOf(request.getParameter("sexo")).charAt(0);
        Date fecha = Date.valueOf(request.getParameter("fecha"));
        String correo = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        
        Persona persona = new Persona(id, nombre, nombre2, nombre3, apellido,
                apellido2, sexo, fecha, correo, telefono);
        System.out.println(persona.toString());
        
        int registrosActualizados = new PersonaDaoJPA().update(persona);
        
        
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String accion = request.getParameter("accion");

            if (accion != null) {
                switch (accion) {
                    case "listar":
                        listarPersonas(request, response);
                        break;
                    case "editar":
                        // Otras acciones
                        editarPersonas(request, response);
                        break;
                    case "eliminar":
                        eliminarPersona(request, response);
                        listarPersonas(request, response);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("\n-------------------------------------------\n");
            System.out.println("\nError doGet\n");
            e.printStackTrace();
        }
    }

    private void listarPersonas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Persona> listaPersonas = new PersonaDaoJPA().getAll();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("dataPersona", listaPersonas);
        sesion.setAttribute("totalPersonas", listaPersonas.size());
        response.sendRedirect("personas/personas.jsp");
    }
    
    private void editarPersonas(HttpServletRequest request, HttpServletResponse response)throws IOException{
        //Recuperar el id del estudiante
        int idPersona = Integer.parseInt(request.getParameter("id"));
        
        //Crear un objeto de tipo estudiante
        Persona persona = new PersonaDaoJPA()
                .get(new Persona(idPersona));
        
        System.out.println(persona);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("persona", persona);
        response.sendRedirect(request.getContextPath() + "/" + "personas/editar-personas.jsp");
        listarPersonas(request, response);
    }

    private void eliminarPersona(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idPersona = Integer.parseInt(request.getParameter("id"));
        Persona persona = new PersonaDaoJPA().get(new Persona(idPersona));
        int registrosEliminados = new PersonaDaoJPA().delete(persona);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.err.println("Se produjo un error al intentar eliminar el siguiente estudiante: " + persona.toString());
        }

    }

}
