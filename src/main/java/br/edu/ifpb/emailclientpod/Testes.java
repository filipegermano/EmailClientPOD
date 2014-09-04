package br.edu.ifpb.emailclientpod;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

/**
 *
 * @author FILIPE
 */
public class Testes {

    Integer count = 0;

    public boolean testaServer(String ip) throws IOException {
        try{
            Socket socket = new Socket(ip, 9999);
            return true;           
        } catch (Exception e){
            return false;
        }
    }

}
