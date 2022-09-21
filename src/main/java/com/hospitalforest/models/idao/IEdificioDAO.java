package com.hospitalforest.models.idao;

import java.util.List;
import com.hospitalforest.models.domain.Edificios;

/**
 *
 * @author Henry Sanum
 */
public interface IEdificioDAO {
    
    // Listar todos los registros
    public List<Edificios> getAll();
    
    //Buscar un registro en especifico
    public Edificios get(Edificios edificio);
    
    //Insertar un Registro
    public int add(Edificios edificio);
    
    //Actualizar un registro
    public int update(Edificios edificio);
    
    //Eliminar un registro
    public int delete(Edificios edificio);
}
