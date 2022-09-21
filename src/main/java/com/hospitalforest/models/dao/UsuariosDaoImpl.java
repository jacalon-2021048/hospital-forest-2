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
public class UsuariosDaoImpl implements IUsuariosDAO{
    private static final String SQL_SELECT="SELECT user, pass, rol_id, persona_id FROM usuarios";
    private static final String SQL_DELETE="DELETE FROM usuarios WHERE user=?";
    private Connection con=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;
    private Usuarios usuarios=null;
    private List<Usuarios> listaUsuarios=new ArrayList<>();

    @Override
    public List<Usuarios> getAll() {
        try {
            con=Conexion.getConnection();
            pstmt=con.prepareStatement(SQL_SELECT);
            rs=pstmt.executeQuery();
            while (rs.next()) {
                usuarios=new Usuarios(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                listaUsuarios.add(usuarios);
            }
        } catch(SQLException e){
            e.printStackTrace(System.out);
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);            
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return listaUsuarios;
    }

    @Override
    public int add(Usuarios usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Usuarios usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Usuarios usuario) {
        int rows=0;
        try {
            con=Conexion.getConnection();
            pstmt=con.prepareStatement(SQL_DELETE);
            pstmt.setString(1,usuario.getUser());
            System.out.println(pstmt.toString());
            rows=pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar eliminar el registro del usuario: " + usuario.getUser());
            e.printStackTrace(System.out);
        } catch (Exception e){
            e.printStackTrace(System.out);
        }
        return rows;
    }
}