package com.hospitalforest.models.idao;

import java.util.List;
import com.hospitalforest.models.domain.Usuarios;
/**
 *
 * @author Jhonatan Jose Acalón Ajanel <jacalon-2021048@kinal.edu.gt>
 * @date 2/09/2022
 * @time 16:34:57
 * @codigo IN5BM
 * @jornada Matutina
 * @grupo 1
 */
public interface IUsuariosDAO {
    public List<Usuarios> getAll();
    
    public int add(Usuarios usuario);
    
    public int update(Usuarios usuario);
    
    public int delete(Usuarios usuario);
}