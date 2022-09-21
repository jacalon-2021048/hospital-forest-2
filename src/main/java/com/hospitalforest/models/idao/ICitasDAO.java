package com.hospitalforest.models.idao;

import java.util.List;
import com.hospitalforest.models.domain.Citas;
/**
 *
 * @author Jhonatan Jose Acalón Ajanel <jacalon-2021048@kinal.edu.gt>
 * @date 2/09/2022
 * @time 16:34:39
 * @codigo IN5BM
 * @jornada Matutina
 * @grupo 1
 */
public interface ICitasDAO {
    public List<Citas> getAll();
    
    public int add(Citas citas);
    
    public int update(Citas citas);
    
    public int delete(Citas citas);
}