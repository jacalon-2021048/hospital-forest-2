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
public class PacienteDaolmpl implements IPacienteDAO {

    private static final String SQL_SELECT = "SELECT id_paciente, seguro_medico, contacto_emergencia, CONCAT(p.nombre1,\" \",p.apellido1) FROM pacientes AS pa\n"
            + "INNER JOIN personas AS p ON pa.persona_id=p.id_persona;";
    
    private static final String SQL_INSERT = "INSERT INTO pacientes "
            + "(seguro_medico, contacto_emergencia, persona_id) VALUES (?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE pacientes SET seguro_medico = ?, contacto_emergencia = ?,"
            + " persona_id = ? Where id_paciente = ?";

    private static final String SQL_SELECT_BY_ID = "SELECT id_paciente, seguro_medico, contacto_emergencia,"
            + " persona_id FROM pacientes WHERE id_paciente = ?";   

    private static final String SQL_DELETE = "DELETE FROM pacientes WHERE id_paciente = ?";

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Paciente paciente = null;
    private List<Paciente> listaPacientes = new ArrayList<>();

    @Override
    public List<Paciente> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                paciente = new Paciente(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                listaPacientes.add(paciente);
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
        return listaPacientes;
    }
    
   public Paciente get(Paciente paciente){
       try {
           con = Conexion.getConnection();
           pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
           pstmt.setInt(1, paciente.getIdPacientes());
           System.out.println(pstmt.toString());
           rs = pstmt.executeQuery();
           while(rs.next()){
               paciente = new Paciente(
                       rs.getInt(1),
                       rs.getInt(2),
                       rs.getString(3),
                       rs.getString(4));
           }
           System.out.println("paciente: " + paciente);
       }catch(SQLException e){
           System.out.println("\nSQLException\n");
           e.printStackTrace(System.out);
       }catch(Exception e){
           e.printStackTrace(System.out);
       }finally {
           
       }
       return paciente;
   }
    
    

    @Override
    public int add(Paciente paciente) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, paciente.getSeguroMedico());
            pstmt.setString(2, paciente.getContactoEmergencia());
            pstmt.setString(3, paciente.getNombrePersona());
            System.out.println(pstmt.toString());
            
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar insertar el siguiente registros " + paciente.toString());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(con);
            Conexion.close(pstmt);
            
        }
        return rows;
    }

    @Override
    public int update(Paciente paciente) {
       int rows = 0;
       try{
           con = Conexion.getConnection();
           pstmt = con.prepareStatement(SQL_UPDATE);
           pstmt.setInt(1, paciente.getSeguroMedico());
           pstmt.setString(2, paciente.getContactoEmergencia());
           pstmt.setString(3, paciente.getNombrePersona());
           pstmt.setInt(4, paciente.getIdPacientes());
           
           System.out.println(pstmt.toString());
           rows = pstmt.executeUpdate();
       }catch(SQLException e){
           System.err.println("Se produjo un error al intentar actualizar"
                   + " el siguiente registro: " + paciente.toString());
           e.printStackTrace(System.out);
       }catch(Exception e){
           e.printStackTrace(System.out);
           System.err.println("Se produjo un error al intentar actualizar "
                   + "el siguiente registro: " + paciente.toString());
       }finally{
           Conexion.close(pstmt);
           Conexion.close(con);
       }
       return rows;
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