package br.edu.ifpb.emailclientpod;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author FILIPE
 */
public class Testes {

    Integer count = 0;

    public boolean testaServer(String ip) throws IOException {
        try {
            Socket socket = new Socket(ip, 9999);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
