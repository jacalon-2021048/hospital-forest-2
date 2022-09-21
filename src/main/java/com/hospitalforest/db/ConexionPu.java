package com.hospitalforest.db;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
/**
 *
 * @author Alberto Moisés Gerardo Lemus Alvarado
 * @date 9 sept. 2022
 * @time 19:16:14
 * @Carne: 2021062
 * @Codigo Tecnico: IN5BM
 */
public class ConexionPu {

    private static final String PERSISTENCE_UNIT_NAME = "hospital_forest_pu"; 
    private EntityManager entityManager;
    private static ConexionPu instance;
    
    private ConexionPu(){
        try
        {

            entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
            System.out.println("Conexion establecida a traves de una unidad de persistencia");
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
    }
    
    public static ConexionPu getInstance() {
        if (instance == null)
        {
            instance = new ConexionPu();
        }
        return instance;

    }
    
    public EntityManager getEntityManager(){
        return entityManager;
    }
    
}
