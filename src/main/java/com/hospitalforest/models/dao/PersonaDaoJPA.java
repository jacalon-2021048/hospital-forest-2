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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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