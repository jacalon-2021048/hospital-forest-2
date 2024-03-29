package com.hospitalforest.models.dao;

import com.hospitalforest.db.ConexionPu;
import com.hospitalforest.models.domain.Edificios;
import com.hospitalforest.models.idao.IEdificioDAO;
import java.util.List;

/**
 *
 * @author Henry Donaldo Sanum Barrios
 * @date 7/09/2022
 */
public class EdificioDaoJPA implements IEdificioDAO {

    private ConexionPu con = ConexionPu.getInstance();

    @Override
    public List<Edificios> getAll() {
        return con.getEntityManager().createNamedQuery("Edificios.findAll").getResultList();
    }

    @Override
    public int add(Edificios edificio) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().persist(edificio);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            System.out.println("Se produjo un error al intentar insertar el registro " + edificio.toString());
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int update(Edificios edificio) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().merge(edificio);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public Edificios get(Edificios edificio) {
        return (Edificios) con.getEntityManager().createNamedQuery("Edificios.find").setParameter("id_edificio", edificio.getId()).getSingleResult();
    }

    @Override
    public int delete(Edificios edificio) {
        System.out.println(edificio);
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().remove(edificio);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }

        return rows;
    }
}
