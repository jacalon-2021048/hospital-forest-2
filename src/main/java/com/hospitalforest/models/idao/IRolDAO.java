package com.hospitalforest.models.idao;

import com.hospitalforest.models.domain.Rol;
import java.util.List;

/**
 *
 * @author Alberto Moisés Gerardo Lemus Alvarado
 * @date 3 sept. 2022
 * @time 14:33:08
 * @Carne: 2021062
 * @Codigo Tecnico: IN5BM
 */
public interface IRolDAO {

    public List <Rol> getAll();
    
    public int addRol(Rol rol);
    
    public int updateRol(Rol rol);
    
    public int deleteRol(Rol rol);
    
}
