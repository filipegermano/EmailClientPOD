package br.edu.ifpb.emailclientpod;

import br.edu.ifpb.emailsharedpod.Email;
import br.edu.ifpb.emailsharedpod.Fachada;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FILIPE
 */
public class Agendador extends TimerTask{
    private String ip;
    
    public Agendador(String ip){
        this.ip = ip;
    }

    @Override
    public void run() {
        try {            
            Registry registry = LocateRegistry.getRegistry(ip, 9999);
            Fachada fachada = (Fachada) registry.lookup("Fachada");
            
            EmailDAO emailDAO = new EmailDAO();
            List<Email> emails = emailDAO.emailsNaoEnviados();
            
            if (emails != null){
                for (Email email : emails) {
                    fachada.enviaEmail(email);
                    emailDAO.setStatus(email);
                }
            }
            
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Agendador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}