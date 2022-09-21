
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

    //private static final String SQL_SELECT="SELECT id_recetas, dosis_recomendada, medicamento_id, cita_id FROM recetas";
    
    private static final String SQL_SELECT = "SELECT r.id_recetas, r.dosis_recomendada, CONCAT(\"nombre: \",m.nombre, \" descripcion: \", m.descripcion), CONCAT(\"Descripcion: \",c.descripcion,\" Fecha: \", c.fecha, \" Hora: \", c.hora) FROM recetas as r \n" +
"INNER JOIN medicamentos as m on r.medicamento_id = m.id_medicamento INNER JOIN citas as c on r.cita_id = c.id_cita;";
    
    private static final String SQL_DELETE = "DELETE FROM recetas Where id_recetas = ?";
    
    private static final String SQL_SALDO = "select SUM(saldo) FROM recetas;"; 
    
    private static final String SQL_INSERT = "INSERT INTO recetas (dosis_recomendada, medicamento_id, cita_id) VALUES (?,?,?) ";
    
    private static final String SQL_UPDATE = "UPDATE recetas SET dosis_recomendada = ?, medicamento_id = ?, cita_id = ?  Where id_recetas = ?";
    
    private static final String SQL_SELECT_BY_ID = "SELECT id_recetas, dosis_recomendada, medicamento_id, cita_id FROM recetas WHERE id_recetas = ?";
    
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
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
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
        int rows = 0;
        try{
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, receta.getDosisRecomendada());
            pstmt.setString(2, receta.getMedicamentoId());
            pstmt.setString(3, receta.getCitaId());
            
            System.out.println(receta.toString());
            rows = pstmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
            System.err.println("Erro en el metodo addReceta al intentar insertar el registro: " + receta.toString());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return rows;
    }

    @Override
    public int updateReceta(Receta receta) {
      int rows = 0;
        try{
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, receta.getDosisRecomendada());
            pstmt.setString(2, receta.getMedicamentoId());
            pstmt.setString(3, receta.getCitaId());
            pstmt.setInt(4, receta.getIdReceta());
            
            System.out.println(receta.toString());
            rows = pstmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
            System.err.println("Erro en el metodo updateReceta al intentar actualizar el registro: " + receta.toString());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return rows;  
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
    
    public Receta get(Receta receta) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, receta.getIdReceta());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                receta = new Receta(
                rs.getInt("id_recetas"),
                rs.getString("dosis_recomendada"),
                rs.getString("medicamento_id"),
                rs.getString("cita_id"));
            }
            System.out.println("receta: " + receta);
        } catch (SQLException e) {
            System.out.println("\nSQLException\n");
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return receta;
    }    

}
