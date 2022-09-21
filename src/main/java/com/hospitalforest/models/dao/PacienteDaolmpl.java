package com.hospitalforest.models.dao;

import com.hospitalforest.models.domain.Paciente;
import com.hospitalforest.models.idao.IPacienteDAO;
import com.hospitalforest.db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author Christofer Geovanni Quel Guerra
 * @date 3 sep. 2022
 * @time 19:50:44
 */
public class PacienteDaolmpl implements IPacienteDAO{
    
    private static final String SQL_SELECT = "SELECT id_paciente, seguro_medico, contacto_emergencia, persona_id FROM pacientes";

    private static final String SQL_DELETE = "DELETE FROM pacientes WHERE id_paciente = ?";

    
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Paciente paciente = null;
    private List<Paciente> listaPacientes = new ArrayList<>();
    
    
    @Override
    public List<Paciente> getAll() {   
        try{
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                paciente = new Paciente(
                        rs.getInt("id_paciente"),
                        rs.getInt("seguro_medico"),
                        rs.getString("contacto_emergencia"),
                        rs.getInt("persona_id")
                );
                listaPacientes.add(paciente);
            }
            
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }catch(Exception e){
            e.printStackTrace(System.out);
        } finally{
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return listaPacientes;
    }
    
    

    @Override
    public int add(Paciente paciente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Paciente paciente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Paciente paciente) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, paciente.getIdPacientes());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.err.println("Se produjo un error al intentar eliminar el registro con el id " + paciente.getIdPacientes());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }
    
}
