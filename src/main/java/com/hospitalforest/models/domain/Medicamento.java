package com.hospitalforest.models.domain;

import java.util.Date;

/**
 *
 * @author Juan Pablo Cáceres Enriquez
 * @date 02-09-2022
 * @timee 20:25:45 PM
 * Codigo Tecnico: IN5BM
 */

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@Table(name = "medicamentos")

@NamedQueries({
    @NamedQuery(name="Medicamento.findAll", query = "from Medicamento"),
    @NamedQuery(name="Medicamento.find", query = "from Medicamento WHERE id = :id")
})

public class Medicamento implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_medicamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedicamento;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "fecha_caducidad")
    private Date fechaCaducidad;
    
    public Medicamento(){
        
    }
    
    public Medicamento(int idMedicamento){
        this.idMedicamento = idMedicamento;
    }
    
    public Medicamento(String nombre, String descripcion, Date fechaCaducidad){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCaducidad = fechaCaducidad;
    }
    
    public Medicamento(int idMedicamento, String nombre, String descripcion, Date fechaCaducidad){
        this.idMedicamento = idMedicamento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "Medicamento{" + "id_medicamento=" + idMedicamento 
                + ", nombre=" + nombre 
                + ", descripcion=" + descripcion 
                + ", fecha_caducidad=" + fechaCaducidad + "\n";
    }
    
    
}
