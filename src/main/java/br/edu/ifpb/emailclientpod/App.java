package br.edu.ifpb.emailclientpod;

import br.edu.ifpb.emailsharedpod.Email;

/**
 *
 * @author FILIPE
 */
public class App {

    public static void main(String[] args) {
        EmailDAO emailDAO = new EmailDAO();
        Email email = new Email();
        
        email.setAssunto("teste4");
        email.setDestinatarios("filipegermano89@gmail.com");
        email.setRemetente("Filipe Teste");
        email.setMensagem("testando o email carai");
        email.setIpServidor("127.0.0.1");
        
        emailDAO.salvar(email);
        
    }

}
