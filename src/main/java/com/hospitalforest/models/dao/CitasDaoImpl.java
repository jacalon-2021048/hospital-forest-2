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
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Jhonatan Jose Acalón Ajanel <jacalon-2021048@kinal.edu.gt>
 * @date 2/09/2022
 * @time 16:36:02
 * @codigo IN5BM
 * @jornada Matutina
 * @grupo 1
 */
public class CitasDaoImpl implements ICitasDAO {

    private static final String SQL_SELECT = "SELECT c.id_cita, c.descripcion, c.fecha, c.hora,  CONCAT(pe.nombre1,\" \",pe.apellido1), \n"
            + "CONCAT(per.nombre1,\" \",per.apellido1), h.id_habitacion\n"
            + "FROM citas AS c\n"
            + "INNER JOIN doctores AS d ON c.doctor_id=d.id_doctor\n"
            + "	INNER JOIN personas AS pe ON d.persona_id=pe.id_persona\n"
            + "INNER JOIN pacientes AS p ON c.paciente_id=p.id_paciente\n"
            + "	INNER JOIN personas AS per ON p.persona_id=per.id_persona\n"
            + "INNER JOIN habitaciones AS h ON c.habitacion_id=h.id_habitacion;";
    
    private static final String SQL_DELETE = "DELETE FROM citas WHERE id_cita=?";
    private static final String SQL_INSERT = "INSERT INTO citas(descripcion,fecha,hora,doctor_id,paciente_id,habitacion_id) VALUES (?,?,?,?,?,?);";
    private static final String SQL_UPDATE = "UPDATE citas SET descripcion=?,fecha=?,hora=?,doctor_id=?,paciente_id=?,habitacion_id=? WHERE id_cita=?";
    private static final String SQL_SELECT_BY_ID = "SELECT id_cita, descripcion, fecha, hora, doctor_id, paciente_id, habitacion_id FROM citas WHERE id_cita = ?";
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Citas citas = null;
    private List<Citas> listaCitas = new ArrayList<>();

    @Override
    public List<Citas> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                citas = new Citas(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(),
                         rs.getTime(4).toLocalTime(), rs.getString(5), rs.getString(6), rs.getInt(7));
                listaCitas.add(citas);
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
        return listaCitas;
    }

    @Override
    public int add(Citas citas) {
        int rows=0;
        try {
            con=Conexion.getConnection();
            pstmt=con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, citas.getDescripcion());
            pstmt.setString(2, String.valueOf(citas.getFecha()));
            pstmt.setString(3, String.valueOf(citas.getHora()));
            pstmt.setString(4, citas.getNombreDoctor());
            pstmt.setString(5, citas.getNombrePaciente());
            pstmt.setInt(6, citas.getHabitacionId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar insertar el siguiente registro: " + citas.toString());
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
    public int update(Citas citas) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, citas.getDescripcion());
            pstmt.setString(2, String.valueOf(citas.getFecha()));
            pstmt.setString(3, String.valueOf(citas.getHora()));
            pstmt.setString(4, citas.getNombreDoctor());
            pstmt.setString(5, citas.getNombrePaciente());
            pstmt.setInt(6, citas.getHabitacionId());
            pstmt.setInt(7, citas.getIdCita());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar modificar el siguiente registro: " + citas.toString());
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
    public int delete(Citas citas) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, citas.getIdCita());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar eliminar el registro con el id: " + citas.getIdCita());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }
    
    public Citas get(Citas citas) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, citas.getIdCita());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                citas = new Citas(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getTime(4).toLocalTime()
                        , rs.getString(5), rs.getString(6), rs.getInt(7));
            }
            System.out.println("usuario: " + citas);
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
        return citas;
    }
}