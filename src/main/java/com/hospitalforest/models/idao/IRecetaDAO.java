package com.hospitalforest.models.idao;

import com.hospitalforest.models.domain.Receta;
import java.util.List;

/**
 *
 * @author Alberto Moisés Gerardo Lemus Alvarado
 * @date 3 sept. 2022
 * @time 16:17:28
 * @Carne: 2021062
 * @Codigo Tecnico: IN5BM
 */
public interface IRecetaDAO {

    public List <Receta> getAll();
    
    public int addReceta(Receta receta);
    
    public int updateReceta(Receta receta);
    
    public int deleteReceta(Receta receta);
    
}
