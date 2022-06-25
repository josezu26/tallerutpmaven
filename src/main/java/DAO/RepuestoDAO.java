package DAO;

import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.*;

public class RepuestoDAO {
    
    //VATIABLES PARA CONEXION 
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public void registrarRepuesto(String nombreRepuesto, String descripcionRepuesto,
            double precioRepuesto, int stockRepuesto){
        String sql = "insert into repuestos(nombreRepuesto, Desc_Rep, Precio, Stock)values(?,?,?,?)";
         try{
            con = cn.getConnection(); 
            ps = con.prepareStatement(sql); 
            //LLENAR PREPARED STATEMENT
            ps.setString(1, nombreRepuesto);
            ps.setString(2, descripcionRepuesto);
            ps.setDouble(3, precioRepuesto);
            ps.setInt(4, stockRepuesto);
            ps.executeUpdate();
         }catch(Exception e){
             e.printStackTrace();
         }
    }
    
    public void actualizarRepuesto(int codigoRepuesto, String nombreRepuesto, String descripcionRepuesto,
            double precioRepuesto, int stockRepuesto){
        String sql = "UPDATE repuestos SET nombreRepuesto='"+nombreRepuesto+"', Desc_Rep='"+descripcionRepuesto+"',"
                + " Precio="+precioRepuesto+", Stock="+stockRepuesto+" where Cod_Rep="+codigoRepuesto;
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Repuesto obtenerRepuesto(int codigoRepuesto){
        Repuesto repuesto = new Repuesto();
        
        String sql = "select * from repuestos where Cod_Rep="+codigoRepuesto;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                repuesto.setCodigoRepuesto(rs.getInt("Cod_Rep"));
                repuesto.setNombreRepuesto(rs.getString("nombreRepuesto"));
                repuesto.setDescripcionRepuesto(rs.getString("Desc_Rep"));
                repuesto.setPrecioRepuesto(rs.getDouble("Precio"));
                repuesto.setStockRepuesto(rs.getInt("Stock"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return repuesto;
    }
    
    public List listarRepuestos(){
        List<Repuesto> listaRepuestos = new ArrayList<>();
        String sql = "select * from repuestos";
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Repuesto repuesto = new Repuesto();
                repuesto.setCodigoRepuesto(rs.getInt("Cod_Rep"));
                repuesto.setNombreRepuesto(rs.getString("nombreRepuesto"));
                repuesto.setDescripcionRepuesto(rs.getString("Desc_Rep"));
                repuesto.setPrecioRepuesto(rs.getDouble("Precio"));
                repuesto.setStockRepuesto(rs.getInt("Stock"));
                listaRepuestos.add(repuesto);
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return listaRepuestos;
    }
    
    public void eliminarRepuesto(int codigoRepuesto){
        
        String sql = "DELETE FROM repuestos WHERE Cod_Rep="+codigoRepuesto;
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ingresarHojaServicioRepuesto(int codigoHojaServicio, int codigoRepuesto, int cantidad, double subtotal){
        
        String sql = "insert into hs_rep(Cod_HS,Cod_Rep,Cantidad,Subtotal)values(?,?,?,?)";
        try{
            con = cn.getConnection(); 
            ps = con.prepareStatement(sql); 
            //LLENAR PREPARED STATEMENT
            ps.setInt(1, codigoHojaServicio);
            ps.setInt(2, codigoRepuesto);
            ps.setInt(3, cantidad);
            ps.setDouble(4, subtotal);
            ps.executeUpdate();
         }catch(Exception e){
             
         }
        
    }
    
}
