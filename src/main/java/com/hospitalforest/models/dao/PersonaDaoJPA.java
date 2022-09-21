package com.hospitalforest.models.dao;

import com.hospitalforest.db.ConexionPu;
import com.hospitalforest.models.domain.Persona;
import com.hospitalforest.models.idao.IPersonaDAO;
import java.util.List;

/**
 *
 * @author Christofer Geovanni Quel Guerra
 * @date 9 sep. 2022
 * @time 17:55:31
 */
public class PersonaDaoJPA implements IPersonaDAO {

    private ConexionPu con = ConexionPu.getInstance();
    
    
    @Override
    public List<Persona> getAll() {
        return con.getEntityManager().createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public int add(Persona persona) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().persist(persona);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            System.out.println("Se produjo un error al intentar insertar el siguiente registro " + persona.toString());
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int update(Persona persona) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().merge(persona);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
            System.out.println("Se produjo un error al intentar actualizar el siguiente registro " + persona.toString());
            
        }
        return rows;
    }
    
    
    public Persona get(Persona persona){
        return (Persona) con.getEntityManager().createNamedQuery("Persona.find").
                setParameter("id", persona.getId()).getSingleResult();
    }

    @Override
    public int delete(Persona persona) {
        int row = 0;
        try{
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().remove(persona);
            con.getEntityManager().getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return row;
    }

}