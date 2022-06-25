package DAO;

import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.*;

public class SesionDAO {
    
    //VATIABLES PARA CONEXION 
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    
    //METODO PARA INICIAR SESION
    public int iniciarSesion(int user, String pass){

        int codigoUsuario = 0;
        
        String sql = "select * from usuario where Cod_Usuario="+user+" and Password='"+pass+"'";
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                codigoUsuario = rs.getInt("Cod_Usuario");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return codigoUsuario;
    }
    
    //METODO PARA REGISTRAR UN USUARIO
    public void registrarDireccion(String descripcion, int codigoDistrito){
        
        String sql = "insert into direccion(Direccion,Cod_Dist)values(?,?)";
         try{
            con = cn.getConnection(); 
            ps = con.prepareStatement(sql); 
            //LLENAR PREPARED STATEMENT
            ps.setString(1, descripcion);
            ps.setInt(2, codigoDistrito);
            ps.executeUpdate();
         }catch(Exception e){
             
         }
    }
    
    public int obtenerCodigoDireccion(String descripcion){
        int codigoDireccion = 0;
        
        String sql = "select * from direccion where Direccion='"+descripcion+"'";
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                codigoDireccion = rs.getInt("Cod_Dir");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return codigoDireccion;
    }
    
    public void registrarPersona(int codigoPersona, String nombre, String apellidoPaterno, String apellidoMaterno, int codigoDireccion, int codigoEspecialidad, String telefono, String correo){
        String sql = "insert into persona(Cod_Per,Nombre, Appat, Apmat, Cod_Dir, Cod_Esp,Telefono,Correo)values(?,?,?,?,?,?,?,?)";
         try{
            con = cn.getConnection(); 
            ps = con.prepareStatement(sql); 
            //LLENAR PREPARED STATEMENT
            ps.setInt(1, codigoPersona);
            ps.setString(2, nombre);
            ps.setString(3, apellidoPaterno);
            ps.setString(4, apellidoMaterno);
            ps.setInt(5, codigoDireccion);
            if(codigoEspecialidad==0){ps.setString(6, null);} 
            else {ps.setInt(6, codigoEspecialidad);}
            ps.setString(7, telefono);
            ps.setString(8, correo);
            ps.executeUpdate();
         }catch(Exception e){
             e.printStackTrace();
         }
    }
    
    public void registrarUsuario(int codigoPersona, String password, int codigoTipoUsuario, int codigoEstadoUsuario) {
        
        String sql = "insert into usuario(Cod_Per,Password, Cod_Tipo,Cod_Estado)values(?,?,?,?)";
         try{
            con = cn.getConnection(); 
            ps = con.prepareStatement(sql); 
            //LLENAR PREPARED STATEMENT
            ps.setInt(1, codigoPersona);
            ps.setString(2, password);
            ps.setInt(3, codigoTipoUsuario);
            if(codigoEstadoUsuario==0){ps.setString(4, null);}
            else{ps.setInt(4, codigoEstadoUsuario);}
            ps.executeUpdate();
         }catch(Exception e){
             
         }
    }
    
}
