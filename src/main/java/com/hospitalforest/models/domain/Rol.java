package com.hospitalforest.models.domain;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 *
 * @author Alberto Moisés Gerardo Lemus Alvarado
 * @date 3 sept. 2022
 * @time 14:32:52
 * @Carne: 2021062
 * @Codigo Tecnico: IN5BM
 */
@Entity
@Table(name = "roles")
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "from Rol"),
    @NamedQuery(name = "Rol.find", query = "from Rol Where id=:id")
})
public class Rol implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    
    @Column(name = "tipo_rol")
    private String tipoRol;
    
    public Rol(){
        
    }
    
    public Rol(int idRol){
        this.idRol = idRol;
    }
    
    public Rol(int idRol, String tipoRol){
        this.idRol = idRol;
        this.tipoRol = tipoRol;
    }
    
    public Rol(String tipoRol){
        this.tipoRol = tipoRol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    @Override
    public String toString() {
        return "Rol: " + "idRol: " + idRol + ", tipoRol: " + tipoRol + "\n";
    }
    
    
    
}
