package com.hospitalforest.models.idao;

import java.util.List;
import com.hospitalforest.models.domain.Habitacion;

/**
 *
 * @author Henry Sanum
 */

public interface IHabitacionDAO {
    
    // Listar todos los registros
    public List<Habitacion> getAll();
    
    //Insertar un Registro
    public int add(Habitacion habitaciones);
    
    //Actualizar un registro
    public int update(Habitacion habitaciones);
    
    //Eliminar un registro
    public int delete(Habitacion habitaciones);
    
}
