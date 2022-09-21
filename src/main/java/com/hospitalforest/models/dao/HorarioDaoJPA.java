package com.hospitalforest.models.dao;

import com.hospitalforest.models.domain.Horario;
import com.hospitalforest.models.idao.IHorarioDAO;
import java.util.List;
import com.hospitalforest.db.ConexionPu;
import java.util.ArrayList;
        

/**
 *
 * @author Alberto Moisés Gerardo Lemus Alvarado
 * @date 9 sept. 2022
 * @time 19:30:17
 * @Carne: 2021062
 * @Codigo Tecnico: IN5BM
 */
public class HorarioDaoJPA implements IHorarioDAO{

    private ConexionPu con = ConexionPu.getInstance();
    
    @Override
    public List<Horario> getAll() {
        return con.getEntityManager().createNamedQuery("Horario.findAll").getResultList();
    }

    @Override
    public int updateHorario(Horario horario) {
        return 2;
    }

    @Override
    public int addHorario(Horario horario) {
        return 3;
    }
    
    public Horario get(Horario horario){
        return (Horario) con.getEntityManager().createNamedQuery("Horario.find").
                setParameter("id", horario.getIdHorario()).getSingleResult();
    }

    @Override
    public int deleteHorario(Horario horario) {
       int row = 0;
       try{
           con.getEntityManager().getTransaction().begin();
           con.getEntityManager().remove(horario);
           con.getEntityManager().getTransaction().commit();
       }catch(Exception e){
           e.printStackTrace(System.out);
       }
       return row;
    }


}
