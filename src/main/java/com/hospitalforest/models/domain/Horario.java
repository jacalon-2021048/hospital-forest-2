package com.hospitalforest.models.domain;

import java.time.LocalTime;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

/**
 *
 * @author Alberto Moisés Gerardo Lemus Alvarado
 * @date 2 sept. 2022
 * @time 16:23:31
 * @Carne: 2021062
 * @Codigo Tecnico: IN5BM
 */

@Entity
@Table(name = "horarios")
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "from Horario"),
    @NamedQuery(name = "Horario.find", query = "from Horario Where id = :id")
})
public class Horario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_horario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHorario;
    
    @Column(name="horario_inicio")
    private LocalTime horarioInicio;
    
    @Column(name = "horario_final")
    private LocalTime horarioFinal;
    
    @Column
    private boolean lunes;
    
    @Column
    private boolean martes;
    
    @Column
    private boolean miercoles;
    
    @Column
    private boolean jueves;
    
    @Column
    private boolean viernes;
    
    @Column
    private boolean sabado;
    
    @Column
    private boolean domingo;
    
    public Horario (){
        
    }
    
    public Horario(int idHorario){
        this.idHorario = idHorario;
    }
    
    public Horario(int id, LocalTime horarioInicio, LocalTime horarioFinal, boolean lunes, boolean martes, boolean miercoles, boolean jueves,
           boolean viernes, boolean sabado, boolean domingo){      
        this.idHorario = id;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;
    }

    public Horario(LocalTime horarioInicio, LocalTime horarioFinal, boolean lunes, boolean martes, boolean miercoles, boolean jueves, 
            boolean viernes, boolean sabado, boolean domingo) {
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public LocalTime getHorarioFinal() {
        return horarioFinal;
    }

    public boolean isLunes() {
        return lunes;
    }

    public boolean isMartes() {
        return martes;
    }

    public boolean isMiercoles() {
        return miercoles;
    }

    public boolean isJueves() {
        return jueves;
    }

    public boolean isViernes() {
        return viernes;
    }

    public boolean isSabado() {
        return sabado;
    }

    public boolean isDomingo() {
        return domingo;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public void setHorarioFinal(LocalTime horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public void setLunes(boolean lunes) {
        this.lunes = lunes;
    }

    public void setMartes(boolean martes) {
        this.martes = martes;
    }

    public void setMiercoles(boolean miercoles) {
        this.miercoles = miercoles;
    }

    public void setJueves(boolean jueves) {
        this.jueves = jueves;
    }

    public void setViernes(boolean viernes) {
        this.viernes = viernes;
    }

    public void setSabado(boolean sabado) {
        this.sabado = sabado;
    }

    public void setDomingo(boolean domingo) {
        this.domingo = domingo;
    }

    @Override
    public String toString() {
        return "Horario: " + "idHorario: " + idHorario + ", horarioInicio: " + horarioInicio + ", horarioFinal: " + horarioFinal + ", lunes: " + lunes 
           + ", martes: " + martes + ", miercoles: " + miercoles + ", jueves: " + jueves + ", viernes: " + viernes + ", sabado: " + sabado + ", domingo: " + domingo + "\n";
    }
    
    
    
    
}
