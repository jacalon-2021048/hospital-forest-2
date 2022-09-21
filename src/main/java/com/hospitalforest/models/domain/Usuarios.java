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
    private int rolId;
    @Column(name = "persona_id")
    private int personaId;

    public Usuarios() {
        
    }

    public Usuarios(String user, String pass, int rolId, int personaId) {
        this.user = user;
        this.pass = pass;
        this.rolId = rolId;
        this.personaId = personaId;
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

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }
}