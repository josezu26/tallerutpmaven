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
    EquipoDAO equipoDAO = new EquipoDAO();
    RepuestoDAO repuestoDAO = new RepuestoDAO();
    TecnicoDAO tecnicoDAO = new TecnicoDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
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
    List<Repuesto> carritoRepuestos = new ArrayList<>();
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
                List<Servicio> listaServicios = servicioDAO.listarServicios();
                
                sesion.setAttribute("codigoHojaServicio", codigoHojaServicio);
                sesion.setAttribute("listaServicios", listaServicios);
                request.getRequestDispatcher("./hojaServicioTecnico/procesoServicioTecnico1.jsp").forward(request, response);
            break;
            case "agregarServicioCarrito":
                
                int codigoServicio = Integer.parseInt(request.getParameter("codigoServicio"));
                Servicio servicioAgregado = servicioDAO.obtenerServicio(codigoServicio);
                carritoServicios.add(servicioAgregado);
                listaServicios = servicioDAO.listarServicios();
                
                sesion.setAttribute("listaServicios", listaServicios);
                request.getRequestDispatcher("./hojaServicioTecnico/procesoServicioTecnico1.jsp").forward(request, response);
                
                break;
            case "agregarServicioCarritoTaller":
                codigoServicio = Integer.parseInt(request.getParameter("codigoServicio"));
                servicioAgregado = servicioDAO.obtenerServicio(codigoServicio);
                carritoServicios.add(servicioAgregado);
                listaServicios = servicioDAO.listarServicios();
                
                sesion.setAttribute("listaServicios", listaServicios);
                request.getRequestDispatcher("./hojaServicioTecnicoTaller/procesoServicioTecnicoTaller1.jsp").forward(request, response);
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
                
            case "eliminarServicioCarritoTaller":
                codigoServicio = Integer.parseInt(request.getParameter("codigoServicio"));
                servicioEliminado = servicioDAO.obtenerServicio(codigoServicio);
                for(Servicio i : carritoServicios){
                    if(i.getCodigoServicio() == servicioEliminado.getCodigoServicio()){
                        servicioEliminado = i;
                    }
                }
                carritoServicios.remove(servicioEliminado);
                listaServicios = servicioDAO.listarServicios();
                sesion.setAttribute("listaServicios", listaServicios);
                request.getRequestDispatcher("./hojaServicioTecnicoTaller/procesoServicioTecnicoTaller1.jsp");
            break;
            
            case "Continuar":
                List<Repuesto>listaRepuestos = repuestoDAO.listarRepuestos();
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));

                sesion.setAttribute("listaRepuestos", listaRepuestos);
                sesion.setAttribute("codigoHojaServicio", codigoHojaServicio);
                request.getRequestDispatcher("./hojaServicioTecnico/procesoServicioTecnico2.jsp").forward(request, response);
                
            break;
            case "agregarRepuestoCarrito":
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));
                int codigoRepuesto = Integer.parseInt(request.getParameter("codigoRepuesto"));
                Repuesto repuestoAgregado = repuestoDAO.obtenerRepuesto(codigoRepuesto);
                carritoRepuestos.add(repuestoAgregado);
                listaRepuestos = repuestoDAO.listarRepuestos();
                
                sesion.setAttribute("listaRepuestos", listaRepuestos);
                sesion.setAttribute("codigoHojaServicio", codigoHojaServicio);

                request.getRequestDispatcher("./hojaServicioTecnico/procesoServicioTecnico2.jsp").forward(request, response);
                break;
                
            case "eliminarRepuestoCarrito":
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));
                codigoRepuesto = Integer.parseInt(request.getParameter("codigoRepuesto"));
                Repuesto repuestoEliminado = repuestoDAO.obtenerRepuesto(codigoRepuesto);
                for(Repuesto i : carritoRepuestos){
                    if(i.getCodigoRepuesto() == repuestoEliminado.getCodigoRepuesto()){
                        repuestoEliminado = i;
                    }
                }
                
                carritoRepuestos.remove(repuestoEliminado);
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
                HojaServicio hojaServicio = hojaservicioDAO.obtenerHojaServicio(codigoHojaServicio);
                
                for(Repuesto i : carritoRepuestos){
                    precioRepuestos = precioRepuestos + i.getPrecioRepuesto();
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
            case "ListarEquipos":
                List<Equipo> listaEquipo = new ArrayList<>();
                listaEquipo = equipoDAO.listarEquipo();
                
                sesion.setAttribute("listaEquipo", listaEquipo);
                request.getRequestDispatcher("listaEquipos.jsp").forward(request, response);
                
            break;
            case "ListarEquipoCliente":
                
                int codigoCliente = Integer.parseInt(request.getParameter("codigo"));
                listaEquipo = equipoDAO.listarEquipoCliente(codigoCliente);
                
                sesion.setAttribute("listaEquipo", listaEquipo);
                request.getRequestDispatcher("listaEquipos.jsp").forward(request, response);
            break;
            case "FormularioIngresoEquipo":
                List<MarcaEquipo> listaMarca = equipoDAO.listarMarcasEquipo();
                List<TipoEquipo> listaTipo = equipoDAO.listarTiposEquipo();
                
                
                sesion.setAttribute("listaMarcas", listaMarca);
                sesion.setAttribute("listaTipos", listaTipo);
                request.getRequestDispatcher("agregarEquipoTecnico.jsp").forward(request, response);
            break;
            case "agregarEquipo":
                int codigoMarca = Integer.parseInt(request.getParameter("codigoMarca"));
                int codigoTipo = Integer.parseInt(request.getParameter("codigoTipo"));
                
                codigoCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                String descripcionEquipo = request.getParameter("descripcionEquipo");
                
                equipoDAO.registrarEquipo(codigoMarca, codigoTipo, codigoCliente, descripcionEquipo);
                request.getRequestDispatcher("inicioTecnico.jsp").forward(request, response);
                
            break;
            
            
            case "cambiarEstadoEquipo":
                int codigoEstado = Integer.parseInt(request.getParameter("codigoEstado"));
                int codigoEquipo = Integer.parseInt(request.getParameter("codigoEquipo"));
                
                if(codigoEstado == 1){
                    int codigoEstadoNuevo = 2;
                    equipoDAO.cambioEstado(codigoEstadoNuevo, codigoEquipo);
                }else{
                    if(codigoEstado == 2){
                        int codigoEstadoNuevo = 1;
                        equipoDAO.cambioEstado(codigoEstadoNuevo, codigoEquipo);
                    }
                }
                
                //equipoDAO.cambioEstado(codigoEstadoNuevo, codigoEquipo);
                request.getRequestDispatcher("ControladorTecnico?accion=ListarEquipos").forward(request, response);
            break;
            case "SeleccionarEquipo":
                //listaEquipo = equipoDAO.listarEquipo();
                listaEquipo = equipoDAO.listarEquipoRegistrado();
                
                sesion.setAttribute("listaEquipo", listaEquipo);
                request.getRequestDispatcher("SeleccionarEquipoTaller.jsp").forward(request, response);
                
            break;
            case "seleccionarServicioTaller":
                
                codigoEquipo = Integer.parseInt(request.getParameter("codigoEquipo"));
                listaServicios = servicioDAO.listarServicios();
                carritoServicios.clear();
                
                sesion.setAttribute("codigoEquipo", codigoEquipo);
                sesion.setAttribute("listaServicios", listaServicios);
                sesion.setAttribute("carritoServicios", carritoServicios);
                request.getRequestDispatcher("./hojaServicioTecnicoTaller/procesoServicioTecnicoTaller1.jsp").forward(request, response);   
            break;
            
            case "continuar":
                codigoEquipo = Integer.parseInt(request.getParameter("codigoEquipo"));
                List listaTecnicos = tecnicoDAO.listarTecnicos();
                
                sesion.setAttribute("listaTecnicos", listaTecnicos);
                sesion.setAttribute("carritoServicios", carritoServicios);
                sesion.setAttribute("codigoEquipo", codigoEquipo);
                request.getRequestDispatcher("./hojaServicioTecnicoTaller/procesoServicioTaller2.jsp").forward(request, response);
                
                
            break;
            case "ingresarSolicitud":
                int codigoTecnico = Integer.parseInt(request.getParameter("codigoTecnico"));
                String descripcionProblema = request.getParameter("descripcionProblema");
                String fechaHojaServicio = request.getParameter("fechaHojaServicio");
                String horaHojaServicio = request.getParameter("horaHojaServicio");
                codigoEquipo = Integer.parseInt(request.getParameter("codigoEquipo"));
                int codigoEstadoHS = 1;
                //int codigoEstadoAtencion =2;
                double total = 0.00;
                
                Equipo equipo = equipoDAO.obtenerEquipo(codigoEquipo);
                Usuario tecnico = usuarioDAO.obtenerUsuario(codigoTecnico);
                hojaservicioDAO.registrarHojaServicioTecnico(tecnico.getCodigoUsuario(), equipo.getCodigoEquipo(), 
                descripcionProblema, total, fechaHojaServicio, horaHojaServicio, codigoEstadoHS, carritoServicios);
                
                request.getRequestDispatcher("inicioTecnico.jsp").forward(request, response);
            break;
        }
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
