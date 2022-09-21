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
    
    @Id
    @Column(name = "id_doctor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDoctor;
    
    @Id
    @Column(name = "horario_id")
    private int horarioId;
    
    @Id
    @Column(name = "persona_id")
    private int personaId;
    
    @Id
    @Column(name = "especialidad_id")
    private int especialidadId;
    
    @Column
    private String nombre1;
    
    public Doctor(){
        
    }
    
    public Doctor(int idDoctor){
        this.idDoctor = idDoctor;
    }
    
    public Doctor(int horarioId, int personaId, int especialidadId){
        this.horarioId = horarioId;
        this.personaId = personaId;
        this.especialidadId = especialidadId;
    }
    
    public Doctor(int idDoctor, int horarioId, int personaId, int especialidadId){
        this.idDoctor = idDoctor;
        this.horarioId = horarioId;
        this.personaId = personaId;
        this.especialidadId = especialidadId;
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

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public int getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(int especialidadId) {
        this.especialidadId = especialidadId;
    }
    
    public String getNombre1(){
        return nombre1;
    }
    
    public void setNombre1(){
        this.nombre1 = nombre1;
    }

    @Override
    public String toString() {
        return "Doctor{" + "id_doctor=" + idDoctor
                + ", horario_id=" + horarioId 
                + ", persona_id=" + personaId 
                + ", especialidad_id=" + especialidadId 
                + ", Nombre" + "\n";
    }
    
    
}
