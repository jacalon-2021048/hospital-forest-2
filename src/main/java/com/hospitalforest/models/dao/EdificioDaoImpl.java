package com.hospitalforest.models.dao;

import com.hospitalforest.models.domain.Edificios;
import com.hospitalforest.models.idao.IEdificioDAO;
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
public class EdificioDaoImpl implements IEdificioDAO {

    private static final String SQL_SELECT = "SELECT id_edificio, nombre_edificio FROM edificios";
    private static final String SQL_SELECT_BY_ID = "SELECT id_edificio, nombre_edificio FROM edificios WHERE id_edificio=?";
    private static final String SQL_DELETE = "DELETE FROM edificios WHERE id_edificio=?";

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Edificios edificio = null;
    private List<Edificios> listaEdificios = new ArrayList<>();

    @Override
    public List<Edificios> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                edificio = new Edificios(
                        rs.getInt("id_edificio"),
                        rs.getString("nombre_edificio")
                );
                listaEdificios.add(edificio);
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
        return listaEdificios;
    }

    @Override
    public Edificios get(Edificios edificio) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, edificio.getId());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                edificio = new Edificios(
                        rs.getInt("id_edificio"),
                        rs.getString("nombre_edificio")
                );
                
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
        return edificio;
    }

    @Override
    public int add(Edificios edificio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Edificios edificio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Edificios edificio) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, edificio.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("se produjo un error al intentar  eliminar el registro del id: " + edificio.getId());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return rows;
    }

}
