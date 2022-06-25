package DAO;

import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.*;
import java.util.ArrayList;
import java.util.List;

public class TecnicoDAO {
    
    //VATIABLES PARA CONEXION 
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    //LISTAR TECNICOS
    public List listarTecnicos(){
        List<Usuario> listaTecnicos = new ArrayList<>();
        List<Integer> listaCodigoTecnicos = new ArrayList<>();
        
        String sql = "select * from usuario where Cod_Tipo=2";
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listaCodigoTecnicos.add(rs.getInt("Cod_Usuario"));
            }
            
            for(int i : listaCodigoTecnicos){
                listaTecnicos.add(usuarioDAO.obtenerUsuario(i));
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaTecnicos;
    }
    
    //ACTUALIZAR USUARIOS
    public void actualizarDireccionTecnico(int codigoDireccion, String descripcionDireccion, int codigoDistrito){
        
        String sql = "UPDATE direccion SET Direccion='"+descripcionDireccion+"', Cod_Dist='"+codigoDistrito+"' where "
                + "Cod_Dir="+codigoDireccion;
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void actualizarPersonaTecnico(int codigoPersona, String nombre, String apellidoPaterno, String apellidoMaterno, 
            int codigoEspecialidad, String telefono, String correo){
        
        String sql = "UPDATE persona SET Nombre='"+nombre+"', Appat='"+apellidoPaterno+ "', Apmat='"+apellidoMaterno+"' "
                + ", Cod_Esp="+codigoEspecialidad+", Telefono='"+telefono+"', Correo='"+correo+"' where Cod_Per="+codigoPersona;
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void actualizarUsuarioTecnico(int codigoUsuario, String password){
        
        String sql = "UPDATE usuario SET Password='"+password+"' where Cod_Usuario="+codigoUsuario;
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    //ELIMINAR USUARIO
    public void eliminarUsuario(int codigoTecnico){
        
        int codigoPersona=0;
        int codigoDireccion=0;
        
        Usuario usuario = new Usuario();
        usuario = usuarioDAO.obtenerUsuario(codigoTecnico);
        
        String sql = "DELETE from usuario where Cod_Usuario="+codigoTecnico;
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            this.eliminarPersona(usuario.getPersona().getCodigoPersona());
            this.eliminarDireccion(usuario.getPersona().getDireccion().getCodigoDireccion());
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarPersona(int codigoPersona){
        
        String sql = "DELETE from persona where Cod_Per="+codigoPersona;
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void eliminarDireccion(int codigoDireccion){
        
        String sql = "DELETE from direccion where Cod_Dir="+codigoDireccion;
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
