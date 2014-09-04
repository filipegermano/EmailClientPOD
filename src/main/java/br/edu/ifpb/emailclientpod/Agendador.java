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
            EmailDAO emailDAO = new EmailDAO();
            List<Email> emails = emailDAO.emailsNaoEnviados();
            
            if (emails != null){
                for (Email email : emails) {
                    Long tempoInicial = System.currentTimeMillis();                    
                    Registry registry = LocateRegistry.getRegistry(email.getIpServidor(), 9999);
                    Fachada fachada = (Fachada) registry.lookup("Fachada");
                    
                    byte[] b = new byte[1024];
                    
                    b[0] = 'A';
                    b[0] = 'B';
                    b[0] = 'C';
                    b[0] = 'D';
                    b[0] = 'E';
                    
                    Long tempoOperacao = fachada.latencia(b);
                    Long tempoFinal = System.currentTimeMillis();
                    
                    Long tempoTotal = tempoFinal - tempoInicial;
                    
                    float latencia = tempoTotal - tempoOperacao;
                    float banda = (1024 / (latencia /2)) * 1000;
                    
                    email.setMensagem(email.getMensagem() + " - " + String.valueOf(banda));                    
                    
                    fachada.enviaEmail(email);
                    emailDAO.setStatus(email);
                }
            }            
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Agendador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}