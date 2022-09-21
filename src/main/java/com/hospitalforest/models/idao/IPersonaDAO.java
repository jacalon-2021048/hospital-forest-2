package com.hospitalforest.models.idao;

import com.hospitalforest.models.domain.Persona;
import java.util.List;

/**
 *
 * @author Christofer Geovanni Quel Guerra
 */

public interface IPersonaDAO {
    
     // Listar todos los registros
    public List<Persona> getAll();
    
    //Insertar un Registro
    public int add(Persona persona);
    
    //Actualizar un registro
    public int update(Persona persona);
    
    //Eliminar un registro
    public int delete(Persona persona);
    
    
    
}
