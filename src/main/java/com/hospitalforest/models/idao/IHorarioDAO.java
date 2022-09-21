package com.hospitalforest.models.idao;

import com.hospitalforest.models.domain.Horario;
import java.util.List;

/**
 *
 * @author Alberto Moisés Gerardo Lemus Alvarado
 * @date 2 sept. 2022
 * @time 16:26:12
 * @Carne: 2021062
 * @Codigo Tecnico: IN5BM
 */
public interface IHorarioDAO {

    public List <Horario> getAll();
    
    public int updateHorario(Horario horario);
    
    public int addHorario(Horario horario);
    
    public int deleteHorario(Horario horario);
    
    
}
