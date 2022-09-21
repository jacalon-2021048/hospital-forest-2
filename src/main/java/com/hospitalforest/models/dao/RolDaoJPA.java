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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateRol(Rol rol) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
