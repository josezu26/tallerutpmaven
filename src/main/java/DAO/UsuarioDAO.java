package DAO;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Util.Conexion;

public class UsuarioDAO {
    
    //VATIABLES PARA CONEXION 
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuario obtenerUsuario(int codigoUsuario){
        
        Usuario usuario = new Usuario();
        int codigoPersona = 0;
        int codigoDeUsuario = 0;
        String password = "";
        int codigoTipoUsuario = 0;
        int codigoEstadoUsuario = 0;
        
        String sql = "select * from usuario where Cod_Usuario='"+codigoUsuario+"'";
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                codigoDeUsuario = rs.getInt("Cod_Usuario");
                codigoPersona = rs.getInt("Cod_Per");
                password = rs.getString("Password");
                codigoTipoUsuario = rs.getInt("Cod_Tipo");
                codigoEstadoUsuario = rs.getInt("Cod_Estado");
            }
            usuario.setCodigoUsuario(codigoDeUsuario);
            usuario.setPersona(this.obtenerPersona(codigoPersona));
            usuario.setPassword(password);
            usuario.setTipoUsuario(this.obtenerTipoUsuario(codigoTipoUsuario));
            usuario.setEstadoUsuario(this.obtenerEstadoUsuario(codigoEstadoUsuario));
            
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return usuario;
    }
    
    public Persona obtenerPersona(int codigoPersona){
        
        Persona persona = new Persona();
        String nombre = "";
        String appat = "";
        String apmat = "";
        String telefono = "";
        String correo = "";
        int codigoEspecialidad=0;
        int codigoDireccion=0;
        int codigoDePersona = 0;
        
        String sql = "select * from persona where Cod_Per='"+codigoPersona+"'";
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                codigoDePersona = rs.getInt("Cod_Per");
                nombre = rs.getString("Nombre");
                appat = rs.getString("Appat");
                apmat = rs.getString("Apmat");
                codigoEspecialidad = rs.getInt("Cod_Esp");
                codigoDireccion = rs.getInt("Cod_Dir");
                correo = rs.getString("Correo");
                telefono = rs.getString("Telefono");
            }
            
            persona.setCodigoPersona(codigoDePersona);
            persona.setNombre(nombre);
            persona.setApellidoPaterno(appat);
            persona.setApellidoMaterno(apmat);
            persona.setCorreo(correo);
            persona.setTelefono(telefono);
            persona.setEspecialidad(this.obtenerEspecialidad(codigoEspecialidad));
            persona.setDireccion(this.obtenerDireccion(codigoDireccion));
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return persona;
    }
    
    public TipoUsuario obtenerTipoUsuario(int codigoTipoUsuario){
        
        TipoUsuario tipoUsuario = new TipoUsuario();
        
        String sql = "select * from tipo where Cod_Tipo='"+codigoTipoUsuario+"'";
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                tipoUsuario.setCodigoTipoUsuario(rs.getInt("Cod_Tipo"));
                tipoUsuario.setDescripcionTipoUsuario(rs.getString("Tipo"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return tipoUsuario;
    }
    
    public EstadoUsuario obtenerEstadoUsuario(int codigoEstadoUsuario){
        
        EstadoUsuario estadoUsuario = new EstadoUsuario();
        
        String sql = "select * from estado where Cod_Estado='"+codigoEstadoUsuario+"'";
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                estadoUsuario.setCodigoEstadoUsuario(codigoEstadoUsuario);
                estadoUsuario.setDescripcionEstadoUsuario(rs.getString("Estado"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return estadoUsuario;
    }
    
    public Especialidad obtenerEspecialidad(int codigoEspecialidad){
        
        Especialidad especialidad = new Especialidad();
        
        String sql = "select * from especializacion where Cod_Esp='"+codigoEspecialidad+"'";
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                especialidad.setCodigoEspecialidad(codigoEspecialidad);
                especialidad.setDescripcionEspecialidad(rs.getString("Especializacion"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return especialidad;
    }
    
    public Direccion obtenerDireccion(int codigoDireccion){
        Direccion direccion = new Direccion();
        
        String sql = "select * from direccion where Cod_Dir='"+codigoDireccion+"'";
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                direccion.setCodigoDireccion(codigoDireccion);
                direccion.setDescripcionDireccion(rs.getString("Direccion"));
                Distrito d = this.obtenerDistrito(rs.getInt("Cod_Dist"));
                direccion.setDistrito(d);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return direccion;
    }
    
    public Distrito obtenerDistrito(int codigoDistrito){
        Distrito distrito = new Distrito();
        
        String sql = "select * from distrito where Cod_Dist='"+codigoDistrito+"'";
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                distrito.setCodigoDistrito(codigoDistrito);
                distrito.setDescripcionDistrito(rs.getString("Distrito"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return distrito;
    }
        
}
