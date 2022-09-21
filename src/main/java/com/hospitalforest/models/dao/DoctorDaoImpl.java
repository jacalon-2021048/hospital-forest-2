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
import java.time.LocalTime;

public class DoctorDaoImpl implements IDoctorDAO {

    private static final String SQL_SELECT = "SELECT d.id_doctor, h.id_horario, CONCAT(p.nombre1,\" \",p.apellido1), e.nombre_especialidad\n"
            + "FROM doctores AS d\n"
            + "INNER JOIN horarios AS h ON d.horario_id=h.id_horario\n"
            + "INNER JOIN personas AS p ON d.persona_id=p.id_persona\n"
            + "INNER JOIN especialidades AS e ON d.especialidad_id=e.id_especialidad";

    private static final String SQL_DELETE = "DELETE FROM doctores WHERE id_doctor= ?";
    
    private static final String SQL_INSERT = "INSERT INTO doctores(horario_id,persona_id,especialidad_id) VALUES (?,?,?);";
    
    private static final String SQL_UPDATE = "UPDATE doctores SET horario_id=?,persona_id=?,especialidad_id=? WHERE id_doctor=?";
    
    private static final String SQL_SELECT_BY_ID = "SELECT id_doctor, horario_id, persona_id, especialidad_id FROM doctores WHERE id_doctor = ?";

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
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4)
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
        int rows=0;
        try {
            con=Conexion.getConnection();
            pstmt=con.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, doctor.getHorarioId());
            pstmt.setString(2, doctor.getNombrePersona());
            pstmt.setString(3, doctor.getNombreEspecialidad());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar insertar el siguiente registro: " + doctor.toString());
            e.printStackTrace(System.out);
        } catch (Exception e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return rows;
    }

    @Override
    public int update(Doctor doctor) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);            
            pstmt.setInt(1, doctor.getHorarioId());
            pstmt.setString(2, doctor.getNombrePersona());
            pstmt.setString(3, doctor.getNombreEspecialidad());
            pstmt.setInt(4, doctor.getIdDoctor());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar modificar el siguiente registro: " + doctor.toString());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return rows;
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
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar eliminar el registro con el id: " + doctor.getIdDoctor());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return rows;
    }
    
    public Doctor get(Doctor doctor) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, doctor.getIdDoctor());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                doctor = new Doctor(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
            }
            System.out.println("doctor: " + doctor);
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
        return doctor;
    }

}
