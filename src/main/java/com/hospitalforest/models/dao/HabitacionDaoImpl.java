package com.hospitalforest.models.dao;

import com.hospitalforest.models.domain.Habitacion;
import com.hospitalforest.models.idao.IHabitacionDAO;
import com.hospitalforest.db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author Henry Sanum
 */
public class HabitacionDaoImpl implements IHabitacionDAO {

    private static final String SQL_SELECT = "SELECT id_habitacion, nivel, ocupado, edificio_id FROM habitaciones";
    private static final String SQL_DELETE = "DELETE FROM habitaciones WHERE id_habitacion=?";

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Habitacion habitaciones = null;
    private List<Habitacion> listaHabitaciones = new ArrayList<>();

    @Override
    public List<Habitacion> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                habitaciones = new Habitacion(
                        rs.getInt("id_habitacion"),
                        rs.getInt("nivel"),
                        rs.getBoolean("Ocupado"),
                        rs.getInt("edificio_id")
                );
                listaHabitaciones.add(habitaciones);
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
        return listaHabitaciones;
    }

    @Override
    public int add(Habitacion habitaciones) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Habitacion habitaciones) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Habitacion habitaciones) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, habitaciones.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("se produjo un error al intentar  eliminar el registro del id: " + habitaciones.getId());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return rows;
    }

}
