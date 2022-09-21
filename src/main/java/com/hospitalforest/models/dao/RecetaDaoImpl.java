
package com.hospitalforest.models.dao;

import com.hospitalforest.db.Conexion;
import com.hospitalforest.models.domain.Receta;
import com.hospitalforest.models.idao.IRecetaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alberto Moisés Gerardo Lemus Alvarado
 * @date 3 sept. 2022
 * @time 16:16:57
 * @Carne: 2021062
 * @Codigo Tecnico: IN5BM
 */
public class RecetaDaoImpl implements IRecetaDAO{

    private static final String SQL_SELECT="SELECT id_recetas, dosis_recomendada, medicamento_id, cita_id FROM recetas";
    
    private static final String SQL_DELETE = "DELETE FROM recetas Where id_recetas = ?";
    
    private static final String SQL_SALDO = "select SUM(saldo) FROM recetas;";    
    
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Receta receta = null;
    private List<Receta> listaReceta = new ArrayList<>();
    
    
    @Override
    public List<Receta> getAll() {
        try{
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            while(rs.next()){
                receta = new Receta(
                        rs.getInt("id_recetas"),
                        rs.getString("dosis_recomendada"),
                        rs.getInt("medicamento_id"),
                        rs.getInt("cita_id")
                );
                listaReceta.add(receta);
            }
            
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return listaReceta;
    }

    @Override
    public int addReceta(Receta receta) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int updateReceta(Receta receta) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int deleteReceta(Receta receta) {
        int rows = 0;
        try{
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, receta.getIdReceta());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
            
            while(rs.next()){
                receta = new Receta(
                    rs.getInt("id_receta")
                );
                listaReceta.remove(receta);
            }
            
        }catch(SQLException e){
            e.printStackTrace(System.out);
            System.err.println("No se pudo eliminar el ID en" + e);
            System.err.println("No se muestra nada porque: " + receta.toString());
        }catch(Exception e){
            e.printStackTrace(System.out);
            System.err.println("solo exception No se muestra nada porque: " + receta.toString());            
        } /*finally{
            
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(con);          
        }*/
        return rows;
    }

}
