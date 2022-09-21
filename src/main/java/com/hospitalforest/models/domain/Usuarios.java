package com.hospitalforest.models.domain;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
/**
 *
 * @author Jhonatan Jose Acalón Ajanel <jacalon-2021048@kinal.edu.gt>
 * @date 2/09/2022
 * @time 16:35:37
 * @codigo IN5BM
 * @jornada Matutina
 * @grupo 1
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "from Usuarios"),
    @NamedQuery(name = "Usuarios.find", query = "from Usuarios where id=:id")
})
public class Usuarios implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @Column(name = "user")
    private String user;
    @Column(name = "pass")
    private String pass;
    @Column(name = "rol_id")
    private String rolNombre;
    @Column(name = "persona_id")
    private String nombrePersona;

    public Usuarios() {
        
    }

    public Usuarios(String user, String pass, String rolNombre, String nombrePersona) {
        this.user = user;
        this.pass = pass;
        this.rolNombre = rolNombre;
        this.nombrePersona = nombrePersona;
    }

    public Usuarios(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "user=" + user + ", pass=" + pass + 
                ", rolNombre=" + rolNombre + 
                ", nombrePersona=" + nombrePersona + '}';
    }
}