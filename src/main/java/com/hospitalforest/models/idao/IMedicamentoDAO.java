package com.hospitalforest.models.idao;

import com.hospitalforest.models.domain.Medicamento;
import java.util.List;

/**
 *
 * @author Juan Pablo Cáceres Enriquez
 * @date 02-09-2022
 * @timee 19:21:45 pM
 * Codigo Tecnico: IN5BM
 */
public interface IMedicamentoDAO {
    
    // Listar todos los registros
    public List<Medicamento> getAll();    

    // Insertar un registro
    public int add(Medicamento medicamento);

    // Actualizar un registro
    public int update(Medicamento medicamento);

    // Eliminar un registro
    public int delete(Medicamento medicamento);

}