package br.edu.ifpb.emailclientpod;

import br.edu.ifpb.emailsharedpod.Fachada;
import br.edu.ifpb.emailsharedpod.Pessoa;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FILIPE
 */
public class Principal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ip = request.getParameter("ip");
        Testes testes = new Testes();
        if (testes.testaServer(ip)) {
            try {
                Registry registry = LocateRegistry.getRegistry(ip, 9999);
                Fachada fachada = (Fachada) registry.lookup("Fachada");
                List<Pessoa> pessoas = fachada.listaPessoas();
                request.getSession().setAttribute("pessoas", pessoas);

                request.getSession().setAttribute("ip", ip);

                request.getRequestDispatcher("email.jsp").forward(request, response);
            } catch (Exception e) {
                request.setAttribute("result", "Servidor indisponível no momento!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("result", "Servidor indisponível no momento!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
        processRequest(request, response);
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
