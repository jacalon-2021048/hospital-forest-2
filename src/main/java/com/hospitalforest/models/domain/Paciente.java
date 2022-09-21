package com.hospitalforest.models.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Christofer Geovanni Quel Guerra
 * @date 3 sep. 2022
 * @time 19:50:57
 */
@Entity
@Table(name = "pacientes")
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "from Paciente"),
    @NamedQuery(name = "Paciente.find", query = "from Paciente WHERE id = :id")
})
public class Paciente implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_paciente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPacientes;
    
    @Column(name = "seguro_medico")
    private int seguroMedico;
    
    @Column(name = "contacto_emergencia")
    private String contactoEmergencia;
    
    @Column(name = "persona_id")
    private String nombrePersona;

    public Paciente() {
    }

    public Paciente(int idPacientes) {
        this.idPacientes = idPacientes;
    }

    public Paciente(int seguroMedico, String contactoEmergencia, String nombrePersona) {
        this.seguroMedico = seguroMedico;
        this.contactoEmergencia = contactoEmergencia;
        this.nombrePersona = nombrePersona;
    }

    public Paciente(int idPacientes, int seguroMedico, String contactoEmergencia, String nombrePersona) {
        this.idPacientes = idPacientes;
        this.seguroMedico = seguroMedico;
        this.contactoEmergencia = contactoEmergencia;
        this.nombrePersona = nombrePersona;
    }

    public int getIdPacientes() {
        return idPacientes;
    }

    public void setIdPacientes(int idPacientes) {
        this.idPacientes = idPacientes;
    }

    public int getSeguroMedico() {
        return seguroMedico;
    }

    public void setSeguroMedico(int seguroMedico) {
        this.seguroMedico = seguroMedico;
    }

    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    @Override
    public String toString() {
        return "Paciente{" + "idPacientes=" + idPacientes + ", seguroMedico=" + seguroMedico + ", contactoEmergencia=" + contactoEmergencia + ", personaId=" + nombrePersona + '}';
    }
}