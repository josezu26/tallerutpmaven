/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Modelo.*;
import DAO.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ControladorTecnico", urlPatterns = {"/ControladorTecnico"})
public class ControladorTecnico extends HttpServlet {

    HojaServicioDAO hojaservicioDAO = new HojaServicioDAO();
    ServicioDAO servicioDAO = new ServicioDAO();
    RepuestoDAO repuestoDAO = new RepuestoDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorTecnico</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorTecnico at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    List<Servicio> carritoServicios = new ArrayList<>();
    List<CarritoRepuesto> carritoRepuestos = new ArrayList<>();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        HttpSession sesion = request.getSession();
        switch(accion){
            case "listarHojasServicioPendientes":
                int codEstadoHS = Integer.parseInt(request.getParameter("Cod_EstadoHS"));
                int codTecnico = Integer.parseInt(request.getParameter("codigoUsuario"));
                //List<HojaServicio> listaHojaServicio = hojaservicioDAO.listarHojaServicio(codEstadoHS);
                List<HojaServicio> listaHojaServicioTecnico = hojaservicioDAO.listarHojaServicioTecnico(codEstadoHS, codTecnico);
                
                sesion.setAttribute("listaHojaServicioTecnico", listaHojaServicioTecnico);
                request.getRequestDispatcher("listarHojaServicioTecnico.jsp").forward(request, response);
            break;
            
            case "procesar":
                int codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));
                HojaServicio hojaServicio = hojaservicioDAO.obtenerHojaServicio(codigoHojaServicio);
                List<Servicio> listaServiciosBrindados = servicioDAO.obtenerServiciosBrindados(codigoHojaServicio);
                
                sesion.setAttribute("codigoHojaServicio", codigoHojaServicio);
                sesion.setAttribute("listaServiciosBrindados", listaServiciosBrindados);
                request.getRequestDispatcher("./hojaServicioTecnico/prueba.jsp").forward(request, response);
                break;
                
            case "agregarServicioBrindado":
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));
                List<Servicio> listaServicios = servicioDAO.listarServicios();
                
                sesion.setAttribute("codigoHojaServicio", codigoHojaServicio);
                sesion.setAttribute("listaServicios", listaServicios);
                request.getRequestDispatcher("./hojaServicioTecnico/procesoServicioTecnico1.jsp").forward(request, response);
                break;
                
            case "eliminarServicioBrindado":
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));
                int codigoServicioBrindado = Integer.parseInt(request.getParameter("codigoServicioBrindado"));
                servicioDAO.eliminarServicioBrindado(codigoServicioBrindado, codigoHojaServicio);
                
                request.setAttribute("codigoHojaServicio", codigoHojaServicio);
                request.getRequestDispatcher("ControladorTecnico?accion=procesar").forward(request, response);
                break;
                
            /*
            --------------------------FUNCIONAMIENTO ANTERIOR----------------------------------------------
            case "procesar":
                int codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));
                List<Servicio> listaServicios = servicioDAO.listarServicios();
                
                sesion.setAttribute("codigoHojaServicio", codigoHojaServicio);
                sesion.setAttribute("listaServicios", listaServicios);
                request.getRequestDispatcher("./hojaServicioTecnico/procesoServicioTecnico1.jsp").forward(request, response);
            break;*/
            case "agregarServicioCarrito":
                
                int codigoServicio = Integer.parseInt(request.getParameter("codigoServicio"));
                Servicio servicioAgregado = servicioDAO.obtenerServicio(codigoServicio);
                carritoServicios.add(servicioAgregado);
                listaServicios = servicioDAO.listarServicios();
                
                sesion.setAttribute("listaServicios", listaServicios);
                request.getRequestDispatcher("./hojaServicioTecnico/procesoServicioTecnico1.jsp").forward(request, response);
                
                break;
                
            case "eliminarServicioCarrito":
                codigoServicio = Integer.parseInt(request.getParameter("codigoServicio"));
                Servicio servicioEliminado = servicioDAO.obtenerServicio(codigoServicio);
                for(Servicio i : carritoServicios){
                    if(i.getCodigoServicio() == servicioEliminado.getCodigoServicio()){
                        servicioEliminado = i;
                    }
                }
                
                carritoServicios.remove(servicioEliminado);
                listaServicios = servicioDAO.listarServicios();
                
                sesion.setAttribute("listaServicios", listaServicios);
                request.getRequestDispatcher("./hojaServicioTecnico/procesoServicioTecnico1.jsp").forward(request, response);
                
                break;
            case "Continuar":
                List<Repuesto>listaRepuestos = repuestoDAO.listarRepuestos();
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));

                sesion.setAttribute("listaRepuestos", listaRepuestos);
                sesion.setAttribute("codigoHojaServicio", codigoHojaServicio);
                request.getRequestDispatcher("./hojaServicioTecnico/procesoServicioTecnico2.jsp").forward(request, response);
                
            break;
            case "agregarRepuestoCarrito":
                CarritoRepuesto carritoRepuesto = new CarritoRepuesto();
                String contiene = "no";
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));
                int codigoRepuesto = Integer.parseInt(request.getParameter("codigoRepuesto"));
                Repuesto repuestoAgregado = repuestoDAO.obtenerRepuesto(codigoRepuesto);
                for(CarritoRepuesto repuesto : carritoRepuestos){
                    if(repuesto.getRepuesto().getCodigoRepuesto() == repuestoAgregado.getCodigoRepuesto()){
                        repuesto.setCantidad(repuesto.getCantidad()+1);
                        repuesto.getRepuesto().setPrecioRepuesto(repuesto.getRepuesto().getPrecioRepuesto() + repuestoAgregado.getPrecioRepuesto());
                        contiene = "si";
                    }
                }
                if(contiene.equals("no")){
                    carritoRepuesto.setRepuesto(repuestoAgregado);
                    carritoRepuesto.setCantidad(1);
                    carritoRepuestos.add(carritoRepuesto);
                }
                
                listaRepuestos = repuestoDAO.listarRepuestos();
                
                sesion.setAttribute("listaRepuestos", listaRepuestos);
                sesion.setAttribute("codigoHojaServicio", codigoHojaServicio);

                request.getRequestDispatcher("./hojaServicioTecnico/procesoServicioTecnico2.jsp").forward(request, response);
                break;
                
            case "eliminarRepuestoCarrito":
                carritoRepuesto = new CarritoRepuesto();
                contiene = "no";
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));
                codigoRepuesto = Integer.parseInt(request.getParameter("codigoRepuesto"));
                Repuesto repuestoEliminado = repuestoDAO.obtenerRepuesto(codigoRepuesto);
                for(CarritoRepuesto repuesto : carritoRepuestos){
                    if(repuesto.getRepuesto().getCodigoRepuesto() == repuestoEliminado.getCodigoRepuesto()){
                        if(repuesto.getCantidad()==1){
                            carritoRepuesto = repuesto;
                        }else if(repuesto.getCantidad()>= 2){
                            int cantidad = repuesto.getCantidad();
                            double precio = repuesto.getRepuesto().getPrecioRepuesto();
                            precio = precio - repuestoEliminado.getPrecioRepuesto();
                            cantidad--;
                            repuesto.setCantidad(cantidad);
                            repuesto.getRepuesto().setPrecioRepuesto(precio);
                        }
                    }
                }
                carritoRepuestos.remove(carritoRepuesto);
                listaRepuestos = repuestoDAO.listarRepuestos();
                
                sesion.setAttribute("codigoHojaServicio", codigoHojaServicio);
                sesion.setAttribute("listaRepuestos", listaRepuestos);
                request.getRequestDispatcher("./hojaServicioTecnico/procesoServicioTecnico2.jsp").forward(request, response);
                break;
            case "Siguiente":
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));
                sesion.setAttribute("codigoHojaServicio", codigoHojaServicio);
                sesion.setAttribute("carritoRepuestos", carritoRepuestos);
                sesion.setAttribute("carritoServicios", carritoServicios);
                
                request.getRequestDispatcher("./hojaServicioTecnico/procesoServicioTecnico3.jsp").forward(request, response);
                break;
            case "Finalizar":
                double precioVisita = Double.parseDouble(request.getParameter("precioVisita"));
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));
                double precioRepuestos = 0;
                double precioServicios = 0;
                hojaServicio = hojaservicioDAO.obtenerHojaServicio(codigoHojaServicio);
                
                for(CarritoRepuesto i : carritoRepuestos){
                    precioRepuestos = precioRepuestos + i.getRepuesto().getPrecioRepuesto();
                }
                for(Servicio i: carritoServicios){
                    precioServicios = precioServicios + i.getPrecioServicio();
                }
                
                double totalFinal = precioVisita + hojaServicio.getTotal() + precioRepuestos + precioServicios;
                hojaservicioDAO.finalizarAtencionTecnico(hojaServicio.getCodigoHojaServicio(), 
                        precioVisita, totalFinal, 3, carritoServicios, carritoRepuestos);
                
                carritoRepuestos.clear();
                carritoServicios.clear();
               
                request.getRequestDispatcher("inicioTecnico.jsp").forward(request, response);
                break;
        }
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
