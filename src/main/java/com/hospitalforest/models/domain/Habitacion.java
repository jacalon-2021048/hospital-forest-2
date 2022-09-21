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
//sdsdsdsdsdsdsd
@Entity
@Table (name= "habitaciones")
@NamedQueries({
    @NamedQuery(name="Habitacion.findAll", query = "from Habitacion"),
    @NamedQuery(name="Habitacion.find", query = "from Habitacion WHERE id = :id")
})


public class Habitacion implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_habitacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private int nivel;
    
    @Column
    private boolean ocupado;
    
    @Column(name = "id_edificio")
    private int edificioId;

    public Habitacion() {
    }

    public Habitacion(int id) {
        this.id = id;
    }

    public Habitacion(int id, int nivel, boolean ocupado, int edificioId) {
        this.id = id;
        this.nivel = nivel;
        this.ocupado = ocupado;
        this.edificioId = edificioId;
    }

    public Habitacion(int nivel, boolean ocupado, int edificioId) {
        this.nivel = nivel;
        this.ocupado = ocupado;
        this.edificioId = edificioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getEdificioId() {
        return edificioId;
    }

    public void setEdificioId(int edificioId) {
        this.edificioId = edificioId;
    }

    @Override
    public String toString() {
        return "Habitacion = " + "id: " + id + ", nivel: " + nivel + ", ocupado: " + ocupado + ", edificioId: " + edificioId + "\n";
    }
    
    
}
