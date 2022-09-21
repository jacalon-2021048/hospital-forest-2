package com.hospitalforest.models.dao;

import com.hospitalforest.db.ConexionPu;
import com.hospitalforest.models.domain.Rol;
import com.hospitalforest.models.idao.IRolDAO;
import java.util.List;

/**
 *
 * @author Alberto Moisés Gerardo Lemus Alvarado
 * @date 11 sept. 2022
 * @time 18:35:41
 * @Carne: 2021062
 * @Codigo Tecnico: IN5BM
 */
public class RolDaoJPA implements IRolDAO{

    private ConexionPu con = ConexionPu.getInstance();
    
    @Override
    public List<Rol> getAll() {
        return con.getEntityManager().createNamedQuery("Rol.findAll").getResultList();
    }

    @Override
    public int addRol(Rol rol) {
        int rows = 0;
        try{
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().persist(rol);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Ocurrio un erro en el metodo addRol en el JPA al intentar insertar " + rol.toString());
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int updateRol(Rol rol) {
        int rows = 0;
        try{
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().merge(rol);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Ocurrio un erro en el metodo updateRol en el JPA al intentar insertar " + rol.toString());
            con.getEntityManager().getTransaction().rollback();            
        }
        return rows;
    }
    
    public Rol get(Rol rol){
        return (Rol) con.getEntityManager().createNamedQuery("Rol.find").
            setParameter("id", rol.getIdRol()).getSingleResult();
    }

    @Override
    public int deleteRol(Rol rol) {
        int row = 0;
        try{
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().remove(rol);
            con.getEntityManager().getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return row;
    }

}
