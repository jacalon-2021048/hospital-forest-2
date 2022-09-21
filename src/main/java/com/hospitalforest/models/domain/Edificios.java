package com.hospitalforest.models.domain;

/**
 *
 * @author Henry Sanum
 */

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table (name= "edificios")
@NamedQueries({
    @NamedQuery(name="Edificios.findAll", query = "from Edificios"),
    @NamedQuery(name="Edificios.find", query = "from Edificios WHERE id = : id_edificio")
})

public class Edificios implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_edificio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre_edificio")
    private String nombreEdificio;
    
    public Edificios(){
        
    }
    
    public Edificios(int id){
        this.id = id;
    }

    
    
    public Edificios(int id,String nombreEdificio){
        this.id = id;
        this.nombreEdificio = nombreEdificio;
    }
    
    public Edificios(String nombreEdificio){
        this.nombreEdificio = nombreEdificio;
                
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }
    
    
    @Override
    public String toString() {
        return "Edificios{" + "id=" + id + ", nombreEdificio=" + nombreEdificio + '}';
    }
}
