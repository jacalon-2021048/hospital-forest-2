package com.hospitalforest.models.dao;

/**
 *
 * @author Juan Pablo Cáceres Enriquez
 * @date 02-09-2022
 * @timee 21:32:45 PM Codigo Tecnico: IN5BM
 */
import com.hospitalforest.models.domain.Doctor;
import com.hospitalforest.models.idao.IDoctorDAO;
import com.hospitalforest.db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements IDoctorDAO {

    private static final String SQL_SELECT = "SELECT id_doctor, horario_id, persona_id, especialidad_id FROM doctores";
    
    private static final String SQL_DELETE = "DELETE FROM doctores WHERE id_doctor= ?";

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Doctor doctor = null;
    private List<Doctor> listaDoctores = new ArrayList<>();

    @Override
    public List<Doctor> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                doctor = new Doctor(
                        rs.getInt("id_doctor"),
                        rs.getInt("horario_id"),
                        rs.getInt("persona_id"),
                        rs.getInt("especialidad_id")
                );
                listaDoctores.add(doctor);
            }
           
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return listaDoctores;
    }

    @Override
    public int add(Doctor doctor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Doctor doctor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Doctor doctor) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, doctor.getIdDoctor());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
            
            while(rs.next()){
                doctor = new Doctor(
                    rs.getInt("id_doctor")
                );
                listaDoctores.remove(doctor);
            }
            
        }catch(SQLException e){
            e.printStackTrace(System.out);
            System.err.println("No se pudo eliminar el ID en" + e);
            System.err.println("No se muestra nada porque: " + doctor.toString());
        }catch(Exception e){
            e.printStackTrace(System.out);
            System.err.println("solo exception No se muestra nada porque: " + doctor.toString());            
        }
        
        return rows; 
    }


}
