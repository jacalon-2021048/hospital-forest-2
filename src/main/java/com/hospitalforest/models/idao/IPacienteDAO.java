package com.hospitalforest.models.idao;

import com.hospitalforest.models.domain.Paciente;
import java.util.List;

/**
 *
 * @author Christofer Geovanni Quel Guerra
 */
public interface IPacienteDAO {
    
     // Listar todos los registros
    public List<Paciente> getAll();
    
    //Insertar un Registro
    public int add(Paciente paciente);
    
    //Actualizar un registro
    public int update(Paciente paciente);
    
    //Eliminar un registro
    public int delete(Paciente paciente);
    
}
