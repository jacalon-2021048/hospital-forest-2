package com.hospitalforest.models.dao;

/**
 *
 * @author Juan Pablo Cáceres Enriquez
 * @date 8/09/2022
 * @time 16:31:46
 */

import com.hospitalforest.db.ConexionPu;
import com.hospitalforest.models.domain.Medicamento;
import com.hospitalforest.models.idao.IMedicamentoDAO;
import java.util.List;

public class MedicamentoDaoJPA implements IMedicamentoDAO{
    
    private ConexionPu con = ConexionPu.getInstance();

    @Override
    public List<Medicamento> getAll() {
        return con.getEntityManager().createNamedQuery("Medicamento.findAll").getResultList();
    }

    @Override
    public int add(Medicamento medicamento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Medicamento medicamento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public Medicamento get(Medicamento medicamento) {
        return (Medicamento) con.getEntityManager().createNamedQuery("Medicamento.find").setParameter("id", medicamento.getIdMedicamento()).getSingleResult();
    }

    @Override
    public int delete(Medicamento medicamento) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().remove(medicamento);            
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }
    
}
