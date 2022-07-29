package DAO;

import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.*;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    
    //VATIABLES PARA CONEXION 
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public List listarMarcasEquipo(){
        List<MarcaEquipo> listaMarcas = new ArrayList<>();
        
        String sql = "select * from marca";
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MarcaEquipo marcaEquipo = new MarcaEquipo();
                marcaEquipo.setCodigoMarcaEquipo(rs.getInt("Cod_Marca"));
                marcaEquipo.setDescripcionMarcaEquipo(rs.getString("Marca"));
                listaMarcas.add(marcaEquipo);
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaMarcas;
    }
    
    public List listarTiposEquipo(){
        
        List<TipoEquipo> listaTipos = new ArrayList<>();
        
        String sql = "select * from tipo_eq";
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoEquipo tipoEquipo = new TipoEquipo();
                tipoEquipo.setCodigoTipoEquipo(rs.getInt("Cod_TipEq"));
                tipoEquipo.setDescripcionTipoEquipo(rs.getString("TipoEquipo"));
                listaTipos.add(tipoEquipo);
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaTipos;
    }
    
    //Registrar un equipo
    public void registrarEquipo(int codigoMarcaEquipo, int codigoTipoEquipo, int codigoUsuario, String descripcionEquipo){
        
        String sql = "insert into equipo(Cod_Marca,Cod_TipEq,Cod_Usuario,Descripcion,Cod_EstadoEq)values(?,?,?,?,?) ";
        
        try{
            con = cn.getConnection(); 
            ps = con.prepareStatement(sql); 
            //LLENAR PREPARED STATEMENT
            ps.setInt(1, codigoMarcaEquipo);
            ps.setInt(2, codigoTipoEquipo);
            ps.setInt(3, codigoUsuario);
            ps.setString(4, descripcionEquipo);
            ps.setInt(5, 1);
            ps.executeUpdate();
         }catch(Exception e){
             e.printStackTrace();
         }
        
    }
    
    public MarcaEquipo obtenerMarcaEquipo(int codigoMarcaEquipo){
        MarcaEquipo marcaEquipo = new MarcaEquipo();
        String sql = "select * from marca where Cod_Marca="+codigoMarcaEquipo;
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                marcaEquipo.setCodigoMarcaEquipo(rs.getInt("Cod_Marca"));
                marcaEquipo.setDescripcionMarcaEquipo(rs.getString("Marca"));
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return marcaEquipo;
    }
    
    public TipoEquipo obtenerTipoEquipo(int codigoTipoEquipo){
        TipoEquipo tipoEquipo = new TipoEquipo();
        String sql = "select * from tipo_eq where Cod_TipEq="+codigoTipoEquipo;
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                tipoEquipo.setCodigoTipoEquipo(rs.getInt("Cod_TipEq"));
                tipoEquipo.setDescripcionTipoEquipo(rs.getString("TipoEquipo"));
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return tipoEquipo;
    }
    public EstadoEquipo obtenerEstadoEquipo(int codigoEstado){
        
        EstadoEquipo estadoEquipo = new EstadoEquipo();
        String sql = "select * from estado_equipo where Cod_EstadoEq="+codigoEstado;
        
        try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               estadoEquipo.setCodigoEstadoEquipo(rs.getInt("Cod_EstadoEq"));
               estadoEquipo.setDescripcionEstadoEquipo(rs.getString("Desc_EstadoEq"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return estadoEquipo;
        
    }
    
    public Equipo obtenerEquipoClienteDescripcion(int codigoCliente, String descripcionEquipo){
        Equipo equipo = new Equipo();
        String sql = "select * from equipo where Cod_Usuario="+codigoCliente+" AND Descripcion='"+descripcionEquipo+"'";
        int codigoEquipo = 0;
        int codigoMarcaEquipo = 0;
        int codigoTipoEquipo = 0;
        int codigoUsuario = 0;
        descripcionEquipo = "";
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                codigoEquipo = rs.getInt("Cod_Equipo");
                codigoMarcaEquipo = rs.getInt("Cod_Marca");
                codigoTipoEquipo = rs.getInt("Cod_TipEq");
                codigoUsuario = rs.getInt("Cod_Usuario");
                descripcionEquipo = rs.getString("Descripcion");
            }
            equipo.setCodigoEquipo(codigoEquipo);
            equipo.setMarcaEquipo(this.obtenerMarcaEquipo(codigoMarcaEquipo));
            equipo.setTipoEquipo(this.obtenerTipoEquipo(codigoTipoEquipo));
            equipo.setUsuarioEquipo(usuarioDAO.obtenerUsuario(codigoUsuario));
            equipo.setDescripcionEquipo(descripcionEquipo);
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return equipo;
    }
    
//P4 controladorCliente?accion=listarEquipoCliente;
    public List listarEquipoCliente(int codigoCliente){
        List<Equipo> listaEquipoCliente = new ArrayList<>();
        List<Integer> listaCodigos = new ArrayList<>();
        
        String sql = "select * from equipo where Cod_Usuario="+codigoCliente;
        

        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                listaCodigos.add(rs.getInt("Cod_Equipo"));
            }
            
            for(int x : listaCodigos){
                listaEquipoCliente.add(this.obtenerEquipo(x));
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        return listaEquipoCliente;
    }
    public List listarEquipo(){
        List<Equipo> listaEquipos = new ArrayList<>();
        List<Integer> listaCodigos = new ArrayList<>();
        
        String sql = "select * from equipo";
        

        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                listaCodigos.add(rs.getInt("Cod_Equipo"));
            }
            
            for(int x : listaCodigos){
                listaEquipos.add(this.obtenerEquipo(x));
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        return listaEquipos;
    }
    
    public List listarEquipoRegistrado(){
                
        List<Equipo> listaEquipos = new ArrayList<>();
        List<Integer> listaCodigos = new ArrayList<>();
        
        String sql = "select * from equipo where Cod_EstadoEq ="+2;
        

        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                listaCodigos.add(rs.getInt("Cod_Equipo"));
            }
            
            for(int x : listaCodigos){
                listaEquipos.add(this.obtenerEquipo(x));
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        return listaEquipos;
        
    }
    
    //P.4 ACTUALIZAR EQUIPO !!!
    public void actualizarEquipo(int codigoEquipo, int marcaEquipo, int tipoEquipo, String descripcionEquipo){
        String sql = "UPDATE equipo SET Cod_Marca="+marcaEquipo+", Cod_TipEq="+tipoEquipo + ", "
                + "Descripcion='"+descripcionEquipo+"' WHERE Cod_Equipo="+ codigoEquipo;
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    //P.4 BORRAR EQUIPO
    //SOLO BORRA SI EL EQUIPO NO ESTÁ ASOCIADO A UNA HOJA DE SERVICIO
    //PARA BORRAR FORZOSAMENTE SE PUEDE TRABAJAR CON ESTADOS (PREPARAR PARA SIGUIENTES PRESENTACIONES xd) 
    public String eliminarEquipo(int codigoEquipo){
        //DELETE FROM `equipo` WHERE `equipo`.`Cod_Equipo` = 10
        String sql = "DELETE FROM equipo WHERE Cod_Equipo="+codigoEquipo;
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch (Exception e) {
            //e.printStackTrace();
            return e.toString();
        }
        return "";
    }
    
    public Equipo obtenerEquipo(int codigo){
        Equipo equipo = new Equipo();
        
        String sql = "select * from equipo where Cod_Equipo="+codigo;
        
        int codigoEquipo = 0;
        int codigoMarcaEquipo = 0;
        int codigoTipoEquipo = 0;
        int codigoUsuario = 0;
        int codigoEstado =0;
        String descripcionEquipo = "";
        
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                codigoEquipo = rs.getInt("Cod_Equipo");
                codigoMarcaEquipo = rs.getInt("Cod_Marca");
                codigoTipoEquipo = rs.getInt("Cod_TipEq");
                codigoUsuario = rs.getInt("Cod_Usuario");
                descripcionEquipo = rs.getString("Descripcion");
                codigoEstado = rs.getInt("Cod_EstadoEq");
            }
            equipo.setCodigoEquipo(codigoEquipo);
            equipo.setMarcaEquipo(this.obtenerMarcaEquipo(codigoMarcaEquipo));
            equipo.setTipoEquipo(this.obtenerTipoEquipo(codigoTipoEquipo));
            equipo.setUsuarioEquipo(usuarioDAO.obtenerUsuario(codigoUsuario));
            equipo.setDescripcionEquipo(descripcionEquipo);
            equipo.setEstadoEquipo(this.obtenerEstadoEquipo(codigoEstado));
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return equipo;
    }
    public void cambioEstado(int codigoEstadoNuevo, int codigo ){
        
        String sql = "UPDATE equipo SET Cod_EstadoEq = "+ codigoEstadoNuevo+" where Cod_Equipo = "+codigo;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
}
