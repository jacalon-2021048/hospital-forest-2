package com.hospitalforest.models.dao;

import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import com.hospitalforest.models.domain.Usuarios;
import com.hospitalforest.models.idao.IUsuariosDAO;
import com.hospitalforest.db.Conexion;
import java.sql.SQLException;

/**
 *
 * @author Jhonatan Jose Acalón Ajanel <jacalon-2021048@kinal.edu.gt>
 * @date 2/09/2022
 * @time 16:37:18
 * @codigo IN5BM
 * @jornada Matutina
 * @grupo 1
 */
public class UsuariosDaoImpl implements IUsuariosDAO {

    private static final String SQL_SELECT = "SELECT u.user, u.pass, r.tipo_rol, CONCAT(p.nombre1,\" \",p.apellido1)  \n"
            + "FROM usuarios AS u\n"
            + "INNER JOIN roles AS r ON u.rol_id=r.id_rol\n"
            + "INNER JOIN personas AS p ON u.persona_id=p.id_persona;";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE user=?";
    private static final String SQL_INSERT = "INSERT INTO usuarios(user,pass,rol_id,persona_id) VALUES (?,?,?,?);";
    private static final String SQL_UPDATE = "UPDATE usuarios SET pass=?,rol_id=?,persona_id=? WHERE user=?";
    private static final String SQL_SELECT_BY_ID = "SELECT user, pass, rol_id, persona_id FROM usuarios WHERE user = ?";
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Usuarios usuarios = null;
    private List<Usuarios> listaUsuarios = new ArrayList<>();

    @Override
    public List<Usuarios> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                usuarios = new Usuarios(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                listaUsuarios.add(usuarios);
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
        return listaUsuarios;
    }

    @Override
    public int add(Usuarios usuario) {
        int rows=0;
        try {
            con=Conexion.getConnection();
            pstmt=con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, usuario.getUser());
            pstmt.setString(2, usuario.getPass());
            pstmt.setString(3, usuario.getRolNombre());
            pstmt.setString(4, usuario.getNombrePersona());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar insertar el siguiente registro: " + usuario.toString());
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
    public int update(Usuarios usuario) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, usuario.getPass());
            pstmt.setString(2, usuario.getRolNombre());
            pstmt.setString(3, usuario.getNombrePersona());
            pstmt.setString(4, usuario.getUser());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar modificar el siguiente registro: " + usuario.toString());
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
    public int delete(Usuarios usuario) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setString(1, usuario.getUser());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar eliminar el registro del usuario: " + usuario.getUser());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }
    
    public Usuarios get(Usuarios usuario) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setString(1, usuario.getUser());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuarios(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            System.out.println("usuario: " + usuario);
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
        return usuario;
    }
}
