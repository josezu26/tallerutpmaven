package DAO;

import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.*;
import java.util.ArrayList;
import java.util.List;

public class HojaServicioDAO {

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    EquipoDAO equipoDAO = new EquipoDAO();

    //VATIABLES PARA CONEXION 
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public void registrarHojaServicio(int codigoUsuario, int codigoEquipo, String descripcionHojaServicio,
            double total, String fecha, String hora, int codigoEstadoHojaServicio, List<Servicio> listaServicios) {

        int codigoHojaServicio = 0;
        double nuevoTotal = 0.00;

        String sql = "insert into hojaservicio(Cod_Usuario,Cod_Equipo,Desc_HS,Total,PrecioVisita,Fecha,"
                + "Hora,Cod_EstadoHS)values(?,?,?,?,?,?,?,?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            //LLENAR PREPARED STATEMENT
            ps.setInt(1, codigoUsuario);
            ps.setInt(2, codigoEquipo);
            ps.setString(3, descripcionHojaServicio);
            ps.setDouble(4, total);
            ps.setString(5, null);
            ps.setString(6, fecha);
            ps.setString(7, hora);
            ps.setInt(8, codigoEstadoHojaServicio);
            ps.executeUpdate();

            sql = "Select @@IDENTITY AS Cod_HS";
            rs = ps.executeQuery(sql);
            rs.next();
            codigoHojaServicio = rs.getInt("Cod_HS");
            rs.close();

            for (Servicio servicio : listaServicios) {
                sql = "insert into serviciosbrindados(Cod_Serv,Cod_HS,Precio)values(?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, servicio.getCodigoServicio());
                ps.setInt(2, codigoHojaServicio);
                ps.setDouble(3, servicio.getPrecioServicio());
                ps.executeUpdate();
            }

            for (Servicio servicio : listaServicios) {
                nuevoTotal = nuevoTotal + servicio.getPrecioServicio();
            }

            sql = "update hojaservicio SET Total=" + nuevoTotal + " WHERE Cod_HS=" + codigoHojaServicio;
            try {
                ps = con.prepareStatement(sql);
                ps.executeUpdate();
            } catch (Exception e3) {
            }

        } catch (Exception e) {

        }
    }
    
    public void registrarHojaServicioTecnico(int codigoUsuario, int codigoEquipo, String descripcionHojaServicio,
             double total, String fecha, String hora, int codigoEstadoHojaServicio, List<Servicio> listaServicios) {

        int codigoHojaServicio = 0;
        double nuevoTotal = 0.00;

        String sql = "insert into hojaservicio(Cod_Usuario,Cod_Equipo,Desc_HS,Cod_TipoServ,Total,PrecioVisita,Fecha,"
                + "Hora,Cod_EstadoHS)values(?,?,?,?,?,?,?,?,?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            //LLENAR PREPARED STATEMENT
            ps.setInt(1, codigoUsuario);
            ps.setInt(2, codigoEquipo);
            ps.setString(3, descripcionHojaServicio);
            ps.setInt(4, 2);
            ps.setDouble(5, total);
            ps.setString(6, null);
            ps.setString(7, fecha);
            ps.setString(8, hora);
            ps.setInt(9, codigoEstadoHojaServicio);
            ps.executeUpdate();

            sql = "Select @@IDENTITY AS Cod_HS";
            rs = ps.executeQuery(sql);
            rs.next();
            codigoHojaServicio = rs.getInt("Cod_HS");
            rs.close();

            for (Servicio servicio : listaServicios) {
                sql = "insert into serviciosbrindados(Cod_Serv,Cod_HS,Precio)values(?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, servicio.getCodigoServicio());
                ps.setInt(2, codigoHojaServicio);
                ps.setDouble(3, servicio.getPrecioServicio());
                ps.executeUpdate();
            }

            for (Servicio servicio : listaServicios) {
                nuevoTotal = nuevoTotal + servicio.getPrecioServicio();
            }

            sql = "update hojaservicio SET Total=" + nuevoTotal + " WHERE Cod_HS=" + codigoHojaServicio;
            try {
                ps = con.prepareStatement(sql);
                ps.executeUpdate();
            } catch (Exception e3) {
            }

        } catch (Exception e) {

        }
    }

    public EstadoHojaServicio obtenerEstadoHojaServicio(int codigoEstadoHojaServicio) {
        EstadoHojaServicio estadoHojaServicio = new EstadoHojaServicio();

        String sql = "select * from estado_hojaservicio where Cod_EstadoHS=" + codigoEstadoHojaServicio;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                estadoHojaServicio.setCodigoEstadoHojaServicio(rs.getInt("Cod_EstadoHS"));
                estadoHojaServicio.setDescripcionEstadoHojaServicio(rs.getString("Desc_EstadoHS"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return estadoHojaServicio;
    }

    public HojaServicio obtenerHojaServicio(int codigo) {
        HojaServicio hojaServicio = new HojaServicio();

        String sql = "select * from hojaservicio where Cod_HS=" + codigo;
        int codigoHojaServicio = 0;
        int codigoTecnico = 0;
        int codigoEquipo = 0;
        String descripcionEquipo = "";
        double total = 0;
        String fecha = "";
        String hora = "";
        int codigoEstadoHojaServicio = 0;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                codigoHojaServicio = rs.getInt("Cod_HS");
                codigoTecnico = rs.getInt("Cod_Usuario");
                codigoEquipo = rs.getInt("Cod_Equipo");
                descripcionEquipo = rs.getString("Desc_HS");
                total = rs.getDouble("Total");
                fecha = rs.getString("Fecha");
                hora = rs.getString("Hora");
                codigoEstadoHojaServicio = rs.getInt("Cod_EstadoHS");
            }

            hojaServicio.setCodigoHojaServicio(codigoHojaServicio);
            hojaServicio.setTecnicoHojaServicio(usuarioDAO.obtenerUsuario(codigoTecnico));
            hojaServicio.setEquipoHojaServicio(equipoDAO.obtenerEquipo(codigoEquipo));
            hojaServicio.setTotal(total);
            hojaServicio.setFechaHojaServicio(fecha);
            hojaServicio.setHoraHojaServicio(hora);
            hojaServicio.setEstadoHojaServicio(this.obtenerEstadoHojaServicio(codigoEstadoHojaServicio));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hojaServicio;
    }

    public List listarHojaServicio(int codigoEstadoHojaServicio) {

        List<Integer> listaCodigoHojaServicio = new ArrayList<>();
        List<HojaServicio> listaHojaServicio = new ArrayList<>();
        String sql = "select * from hojaservicio where Cod_EstadoHS=" + codigoEstadoHojaServicio;

        int codigoHojaServicio = 0;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listaCodigoHojaServicio.add(rs.getInt("Cod_HS"));
            }

            for (int codigo : listaCodigoHojaServicio) {
                listaHojaServicio.add(this.obtenerHojaServicio(codigo));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaHojaServicio;
    }
    public List listarHojaServicioTecnico(int codigoEstadoHojaServicio, int codigoTecnico){
        
        List<HojaServicio> listaHojaServicioTecnico = new ArrayList<>();
        List<Integer> listaCodigoHojaServicio = new ArrayList<>();
        
        String sql = "select * from hojaservicio where Cod_Usuario=" +codigoTecnico+" and Cod_EstadoHS="+codigoEstadoHojaServicio;
        try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    listaCodigoHojaServicio.add(rs.getInt("Cod_HS"));
                }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        for (int codigo : listaCodigoHojaServicio) {
                    listaHojaServicioTecnico.add(this.obtenerHojaServicio(codigo));
                }
        
        return listaHojaServicioTecnico;
    }
    public List listarHojaServicioCliente(int codigoEstadoHojaServicio, int codigoCliente) {

        List<Integer> listaCodigoHojaServicio = new ArrayList<>();
        List<Equipo> listaEquipos = this.listarEquipoCliente(codigoCliente);
        List<HojaServicio> listaHojaServicio = new ArrayList<>();
        
        for(Equipo e : listaEquipos){
            String sql = "select * from hojaservicio where Cod_EstadoHS=" + codigoEstadoHojaServicio + " and Cod_Equipo="+e.getCodigoEquipo();

            //int codigoHojaServicio = 0;

            try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    listaCodigoHojaServicio.add(rs.getInt("Cod_HS"));
                }

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
        for (int codigo : listaCodigoHojaServicio) {
                    listaHojaServicio.add(this.obtenerHojaServicio(codigo));
                }
        

        return listaHojaServicio;
    }
    public List listarEquipoCliente(int codigoUsuario){
        List<Equipo> listaEquipoCliente = new ArrayList<>();
        List<Integer> listaCodigos = new ArrayList<>();
        
        String sql = "select * from equipo where Cod_Usuario="+codigoUsuario;
        

        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                listaCodigos.add(rs.getInt("Cod_Equipo"));
            }
            
            for(int x : listaCodigos){
                listaEquipoCliente.add(equipoDAO.obtenerEquipo(x));
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        return listaEquipoCliente;
    }
    //***********METODO PARA FINALIZAR ATENCION TECNICO**********************
    public void finalizarAtencionTecnico(int codigoHojaServicio, double precioVisita, double totalFinal, int codigoEstado,
            List<Servicio> carritoServicios, List<Repuesto> carritoRepuestos){
        
        this.asignarPresupuesto(codigoHojaServicio, precioVisita, totalFinal, codigoEstado);
        this.serviciosbrindados(carritoServicios, codigoHojaServicio);
        
    }
    //***********MODIFICA TABLA HOJA SERVICIO********************************

    //MODIFICAR FECHA Y HORA EN LA HOJA DE SERVICIO
    public void verificarFechaHora(int codigoHojaServicio, String fechaFinal, String horaFinal, int codigoEstado){
        String sql = "UPDATE hojaservicio SET Fecha='" + fechaFinal + "', Hora='" + horaFinal + "', Cod_EstadoHS="
                + codigoEstado + " WHERE Cod_HS=" + codigoHojaServicio;
        
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e3) {
        }
        
    }
    
    private void asignarPresupuesto(int codigoHojaServicio, double precioVisita, double totalFinal, int codigoEstado) {

        String sql = "UPDATE hojaservicio SET PrecioVisita=" + precioVisita + ", Total=" + totalFinal + ", Cod_EstadoHS="
                + codigoEstado + " WHERE Cod_HS=" + codigoHojaServicio;
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e3) {
        }
    }
    //************MODIFICA TABLA SERVICIOSBRINDADOS************************
    private void serviciosbrindados(List<Servicio> carritoServicios, int codigoHojaServicio){
        
        try{
            String sql = "insert into serviciosbrindados(Cod_Serv,Cod_HS,Precio)values(?,?,?)";
            for (Servicio servicio : carritoServicios) {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, servicio.getCodigoServicio());
                ps.setInt(2, codigoHojaServicio);
                ps.setDouble(3, servicio.getPrecioServicio());
                ps.executeUpdate();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void repuestosHojaServicio(List<Repuesto> carritoRepuestos, int codigoHojaServicio){
        try{
            String sql = "insert into hs_rep(Cod_HS,Cod_Rep,Cantidad,Subtotal)values(?,?,?,?)";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            for (Repuesto repuesto : carritoRepuestos) {
         
                ps = con.prepareStatement(sql);
                ps.setInt(1, codigoHojaServicio);
                ps.setInt(2, repuesto.getCodigoRepuesto());
                ps.setDouble(3, codigoHojaServicio/*MOMENTANEO*/);
                ps.executeUpdate();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void actualizarTotal(int codigoHojaServicio, double subtotal) {

        String sql = "UPDATE hojaservicio SET Total="+ subtotal +" WHERE Cod_HS=" + codigoHojaServicio;
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e3) {
        }
    }
}
