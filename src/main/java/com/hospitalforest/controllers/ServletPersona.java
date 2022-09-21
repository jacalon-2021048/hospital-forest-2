package com.hospitalforest.controllers;

import com.hospitalforest.models.domain.Persona;
import com.hospitalforest.models.dao.PersonaDaoJPA;
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
 * @author Christofer Geovanni Quel Guerra
 * @date 3 sep. 2022
 * @time 19:00:47
 */


@WebServlet("/ServletPersona")
public class ServletPersona extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
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
        sesion.setAttribute("data", listaPersonas);
        sesion.setAttribute("totalPersonas", listaPersonas.size());
        response.sendRedirect("personas/personas.jsp");
    }
    
    private void eliminarPersona(HttpServletRequest request, HttpServletResponse response) throws IOException{
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
