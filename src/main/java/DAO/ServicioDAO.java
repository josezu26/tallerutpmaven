package DAO;

import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioDAO {
    
    //VATIABLES PARA CONEXION 
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listarServicios(){
        List<Servicio> listaServicios = new ArrayList<>();
        
        String sql = "select * from servicio";
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Servicio servicio = new Servicio();
                servicio.setCodigoServicio(rs.getInt("Cod_Serv"));
                servicio.setNombreServicio(rs.getString("NombreServicio"));
                servicio.setDescripcionServicio(rs.getString("Descripcion"));
                servicio.setPrecioServicio(rs.getDouble("Precio"));
                listaServicios.add(servicio);
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaServicios;
    }
    
    public Servicio obtenerServicio(int codigoServicio){ 
        
        Servicio servicio = new Servicio();
        String sql = "select * from servicio where Cod_Serv="+codigoServicio;
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                servicio.setCodigoServicio(rs.getInt("Cod_Serv"));
                servicio.setNombreServicio(rs.getString("NombreServicio"));
                servicio.setDescripcionServicio(rs.getString("Descripcion"));
                servicio.setPrecioServicio(rs.getDouble("Precio"));
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return servicio;
    }
    public void actualizarServicio(int codigoServicio, String nombreServicio, double precioServicio, String descripcionServicio){
        
        /* String sql = "UPDATE repuestos SET nombreRepuesto='"+nombreRepuesto+"', Desc_Rep='"+descripcionRepuesto+"',"
                + " Precio="+precioRepuesto+", Stock="+stockRepuesto+" where Cod_Rep="+codigoRepuesto;*/
        String sql = "UPDATE servicio SET NombreServicio='"+nombreServicio+"', Precio="+precioServicio+","
                + " Descripcion='"+descripcionServicio+"' where Cod_Serv="+codigoServicio;
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void agregarServicio(String nombreServicio, double precioServicio, String descripcionServicio){
        String sql = "insert into servicio(nombreServicio, Precio, Descripcion)values(?,?,?)";
         try{
            con = cn.getConnection(); 
            ps = con.prepareStatement(sql); 
            //LLENAR PREPARED STATEMENT
            ps.setString(1, nombreServicio);
            ps.setDouble(2, precioServicio);
            ps.setString(3, descripcionServicio);    
            ps.executeUpdate();
         }catch(Exception e){
             e.printStackTrace();
         }
    }
    
    public void eliminarServicio(int codigoServicio){
        String sql = "DELETE FROM servicio WHERE Cod_Serv="+codigoServicio;
        
        try {
            con = cn.getConnection();           
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
