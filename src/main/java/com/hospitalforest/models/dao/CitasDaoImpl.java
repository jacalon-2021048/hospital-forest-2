package com.hospitalforest.models.dao;

import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import com.hospitalforest.models.domain.Citas;
import com.hospitalforest.models.idao.ICitasDAO;
import com.hospitalforest.db.Conexion;
import java.sql.SQLException;
/**
 *
 * @author Jhonatan Jose Acalón Ajanel <jacalon-2021048@kinal.edu.gt>
 * @date 2/09/2022
 * @time 16:36:02
 * @codigo IN5BM
 * @jornada Matutina
 * @grupo 1
 */
public class CitasDaoImpl implements ICitasDAO{
    private static final String SQL_SELECT="SELECT id_cita, descripcion, fecha, hora, doctor_id, paciente_id, habitacion_id FROM citas";
    private static final String SQL_DELETE="DELETE FROM citas WHERE id_cita=?";
    private Connection con=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;
    private Citas citas=null;
    private List<Citas> listaCitas=new ArrayList<>();

    @Override
    public List<Citas> getAll() {
        try {
            con=Conexion.getConnection();
            pstmt=con.prepareStatement(SQL_SELECT);
            rs=pstmt.executeQuery();
            while (rs.next()) {
                citas=new Citas(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate()
                        , rs.getTime(4).toLocalTime(), rs.getInt(5), rs.getInt(6), rs.getInt(7));                
                listaCitas.add(citas);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);            
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return listaCitas;
    }

    @Override
    public int add(Citas citas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Citas citas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Citas citas) {
        int rows=0;
        try {
            con=Conexion.getConnection();
            pstmt=con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1,citas.getIdCita());
            System.out.println(pstmt.toString());
            rows=pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar eliminar el registro con el id: " + citas.getIdCita());
            e.printStackTrace(System.out);
        } catch (Exception e){
            e.printStackTrace(System.out);
        }
        return rows;
    }
}