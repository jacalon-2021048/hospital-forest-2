package com.hospitalforest.models.idao;

import com.hospitalforest.models.domain.Doctor;
import java.util.List;

/**
 *
 * @author Juan Pablo Cáceres Enriquez
 * @date 02-09-2022
 * @timee 19:21:45 pM 
 * Codigo Tecnico: IN5BM
 */
public interface IDoctorDAO {
    
    // Listar todos los registros
    public List<Doctor> getAll();

    // Insertar un registro
    public int add(Doctor doctor);

    // Actualizar un registro
    public int update(Doctor doctor);

    // Eliminar un registro
    public int delete(Doctor doctor);

}
