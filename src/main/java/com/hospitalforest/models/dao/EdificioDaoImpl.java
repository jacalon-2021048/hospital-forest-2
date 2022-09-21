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
    private static final String SQL_SELECT_BY_ID = "SELECT id_edificio, nombre_edificio FROM edificios WHERE id_edificio = ?";
    private static final String SQL_DELETE = "DELETE FROM edificios WHERE id_edificio=?";
    private static final String SQL_INSERT = "INSERT INTO edificios (nombre_edificio) VALUES (?)";
    private static final String SQL_UPDATE = "UPDATE edificios SET nombre_edificio=? WHERE id_edificio=?";


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
            System.out.println("con: " + con);
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, edificio.getId());
            System.out.println("pstmt: " + pstmt);
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            System.out.println("rs: " + rs);

            while (rs.next()) {
                System.out.println("Hay registros");
                edificio = new Edificios(rs.getInt("id_edificio"),rs.getString("nombre_edificio"));
                System.out.println("edificios: " + edificio);
                System.out.println("listaEdificios: " + listaEdificios);
            }
            System.out.println("edificio" + edificio);
        } catch (SQLException e) {
            System.out.println("\nSQLException\n");
            e.printStackTrace(System.out);
        } catch (Exception e) {
            System.out.println("\nSQLException\n");
            e.printStackTrace(System.out);
        } finally {
            System.out.println("\nfinally");
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return edificio;
    }

    @Override
    public int add(Edificios edificio) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, edificio.getNombreEdificio());

            System.out.print(pstmt.toString());
            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar insertar el siguiente registro " + edificio);
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
    public int update(Edificios edificio) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, edificio.getNombreEdificio());
            pstmt.setInt(2, edificio.getId());

            System.out.print(pstmt.toString());
            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar insertar el siguiente registro " + edificio.toString());
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
