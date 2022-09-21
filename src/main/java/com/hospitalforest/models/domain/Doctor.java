package com.hospitalforest.models.domain;

/**
 *
 * @author Juan Pablo Cáceres Enriquez
 * @date 02-09-2022
 * @timee 19:25:45 PM
 * Codigo Tecnico: IN5BM
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
@Table(name = "doctores")
@NamedQueries({
    @NamedQuery(name="Doctor.finAll", query = "from Doctor"),
    @NamedQuery(name="Doctor.find", query = "from Doctor WHERE id = :id_doctor")
})

public class Doctor implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @Column(name = "id_doctor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDoctor;

    @Column(name = "horario_id")
    private int horarioId;
    
    @Column(name = "persona_id")
    private String nombrePersona;
    
    @Column(name = "especialidad_id")
    private String nombreEspecialidad;
        
    public Doctor(){
        
    }
    
    public Doctor(int idDoctor){
        this.idDoctor = idDoctor;
    }
    
    public Doctor(int horarioId, String nombrePersona, String especialidadId){
        this.horarioId = horarioId;
        this.nombrePersona = nombrePersona;
        this.nombreEspecialidad = especialidadId;
    }
    
    public Doctor(int idDoctor, int horarioId, String nombrePersona, String nombreEspecialidad){
        this.idDoctor = idDoctor;
        this.horarioId = horarioId;
        this.nombrePersona = nombrePersona;
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(int horarioId) {
        this.horarioId = horarioId;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    @Override
    public String toString() {
        return "Doctor{" + "id_doctor=" + idDoctor
                + ", horario_id=" + horarioId 
                + ", persona_id=" + nombrePersona 
                + ", especialidad_id=" + nombreEspecialidad;
    }
}