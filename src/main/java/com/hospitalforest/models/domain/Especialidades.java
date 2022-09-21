package com.hospitalforest.models.domain;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
/**
 *
 * @author Jhonatan Jose Acalón Ajanel <jacalon-2021048@kinal.edu.gt>
 * @date 2/09/2022
 * @time 16:35:26
 * @codigo IN5BM
 * @jornada Matutina
 * @grupo 1
 */
@Entity
@Table(name = "especialidades")
@NamedQueries({
    @NamedQuery(name = "Especialidades.findAll", query = "from Especialidades"),
    @NamedQuery(name = "Especialidades.find", query = "from Especialidades where id=:id")
})
public class Especialidades implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @Column(name = "id_especialidad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEspecialidad;
    @Column(name = "nombre_especialidad")
    private String nombreEspecialidad;

    public Especialidades() {
    
    }

    public Especialidades(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Especialidades(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public Especialidades(int idEspecialidad, String nombreEspecialidad) {
        this.idEspecialidad = idEspecialidad;
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
}