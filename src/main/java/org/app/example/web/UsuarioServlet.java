package org.app.example.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.app.example.model.Usuario;
import org.app.example.service.UsuarioService;

/**
 *
 * @author rober
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/usuario/listado", "/usuario/nuevo", "/usuario/submit", "/usuario/editar", "/usuario/eliminar"})
public class UsuarioServlet extends HttpServlet {
    
     private static Logger log = Logger.getLogger(UsuarioServlet.class);
    
    @Inject
    UsuarioService usuarioService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, IllegalAccessException, InvocationTargetException {

        String url = request.getServletPath();
        log.info("CONTEXT PATH: " + url);

        switch (url) {
            case "/usuario/listado":
                this.listado(request, response);
                break;
            case "/usuario/nuevo":
                this.nuevo(request, response);
                break;
            case "/usuario/editar":
                this.editar(request, response);
                break;
            case "/usuario/submit":
                this.submit(request, response);
                break;
            case "/usuario/eliminar":
                this.eliminar(request, response);
                break;
        }
    }

    protected void listado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> lista = usuarioService.getAll();
        request.setAttribute("lista", lista);
        request.setAttribute("totalRec", lista.size());
        String path = "/WEB-INF/jsp/usuario_list.jsp";
        processUrl(path, request, response);

    }
    
    protected void nuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        request.setAttribute("operacion", "Nuevo");    
        String path = "/WEB-INF/jsp/usuario_form.jsp";
        processUrl(path, request, response);

    }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cod = request.getParameter("codigo");
        Usuario bean = usuarioService.read(cod);
        request.setAttribute("usuario", bean);
        request.setAttribute("operacion", "Editar");    
        String path = "/WEB-INF/jsp/usuario_form.jsp";
        processUrl(path, request, response);

    }
    
    protected void submit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
        
        Usuario bean = new Usuario();
        BeanUtils.populate(bean, request.getParameterMap());
        String strategy = request.getParameter("strategy");
        switch(strategy){
            case "Nuevo":
                bean = usuarioService.create(bean);
                request.getSession().setAttribute("resultado", 1);
                response.sendRedirect(request.getContextPath()+"/usuario/nuevo");
                break;
            case "Editar":
                bean = usuarioService.update(bean);
                request.getSession().setAttribute("resultado", 1);
                response.sendRedirect(request.getContextPath()+"/usuario/editar?codigo="+bean.getCodigo());
                break;
        }     

    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
        
        String cod = request.getParameter("codigo");
        usuarioService.delete(cod);
        response.sendRedirect(request.getContextPath()+"/usuario/listado");
        
    }
    
    protected void processUrl(String path, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext ctx = getServletContext();
        RequestDispatcher rd = ctx.getRequestDispatcher(path);
        
        if (rd != null) {
            rd.forward(request, response);
        } else{
            log.error("LA RUTA NO ES VALIDA.");
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
         try {
             processRequest(request, response);
         } catch (IllegalAccessException | InvocationTargetException ex) {
             log.error(ex);
         }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (IllegalAccessException | InvocationTargetException ex) {
             log.error(ex);
         }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
