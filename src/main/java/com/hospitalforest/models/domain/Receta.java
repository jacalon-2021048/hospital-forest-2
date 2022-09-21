package com.hospitalforest.models.domain;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
/**
 *
 * @author Alberto Moisés Gerardo Lemus Alvarado
 * @date 3 sept. 2022
 * @time 16:17:12
 * @Carne: 2021062
 * @Codigo Tecnico: IN5BM
 */

@Entity
@Table(name = "recetas")
public class Receta implements Serializable{

    @Id
    @Column(name = "id_recetas")
    private int idReceta;
    
    @Column(name = "dosis_recomendada")
    private String dosisRecomendada;
    
    @Column(name = "medicamento_id")
    private String medicamentoId;
    
    @Column(name = "cita_id")
    private String citaId;
    
    public Receta(){
        
    }
    
    public Receta(int idReceta){
        this.idReceta = idReceta;
    }
    
    public Receta(String dosisRecomendada, String medicamentoId, String citaId){
        this.dosisRecomendada = dosisRecomendada;
        this.medicamentoId = medicamentoId;
        this.citaId = citaId;
    }

    public Receta(int idReceta, String dosisRecomendada, String medicamentoId, String citaId) {
        this.idReceta = idReceta;
        this.dosisRecomendada = dosisRecomendada;
        this.medicamentoId = medicamentoId;
        this.citaId = citaId;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public String getDosisRecomendada() {
        return dosisRecomendada;
    }

    public void setDosisRecomendada(String dosisRecomendada) {
        this.dosisRecomendada = dosisRecomendada;
    }

    public String getMedicamentoId() {
        return medicamentoId;
    }

    public void setMedicamentoId(String medicamentoId) {
        this.medicamentoId = medicamentoId;
    }

    public String getCitaId() {
        return citaId;
    }

    public void setCitaId(String citaId) {
        this.citaId = citaId;
    }

    @Override
    public String toString() {
        return "Receta " + "idReceta: " + idReceta + ", dosisRecomendada: " + dosisRecomendada + ", medicamentoId: " + medicamentoId + ", citaId: " + citaId + "\n";
    }
    
    
    
}
