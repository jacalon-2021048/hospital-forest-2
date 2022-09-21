package com.hospitalforest.models.idao;

import java.util.List;
import com.hospitalforest.models.domain.Especialidades;
/**
 *
 * @author Jhonatan Jose Acalón Ajanel <jacalon-2021048@kinal.edu.gt>
 * @date 2/09/2022
 * @time 16:33:56
 * @codigo IN5BM
 * @jornada Matutina
 * @grupo 1
 */
public interface IEspecialidadDAO {
    public List<Especialidades> getAll();
    
    public int add(Especialidades especialidades);
    
    public int update(Especialidades especialidades);
    
    public int delete(Especialidades especialidades);
}