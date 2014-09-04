package br.edu.ifpb.emailclientpod;

import br.edu.ifpb.emailsharedpod.Email;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Timer;
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
public class SendEmail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String ip = (String) request.getSession().getAttribute("ip");
            
            //Registry registry = LocateRegistry.getRegistry(ip, 9999);
            
            //Fachada fachada = (Fachada) registry.lookup("Fachada");
            
            Email email = new Email();
            
            email.setIpServidor(ip);
            email.setRemetente(request.getParameter("remetente"));
            email.setAssunto(request.getParameter("assunto"));
            email.setDestinatarios(request.getParameter("destinatarios"));
            email.setMensagem(request.getParameter("mensagem"));
            
            EmailDAO emailDAO = new EmailDAO();
            emailDAO.salvar(email);
            
            Agendador agendador = new Agendador(ip);
            Timer timer = new Timer();
            timer.schedule(agendador, 0, 3000*60);
            
            //String result = fachada.enviaEmail(email);
            
            request.setAttribute("result", "Enviado com sucesso!!!"); 
            
            request.getRequestDispatcher("email.jsp").forward(request, response);
            
        } catch (RemoteException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
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
