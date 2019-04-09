package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Usuario;
import module.garcon.ListennerGarcon;
import util.Log;

public class Server {

    private static ServerSocket serverSocket;
    private static boolean cont = true;
    private static final int TIMEOUT = 1000;
    
    public Server() {
        
        try {
            Server.serverSocket = new ServerSocket(6666);
            Server.serverSocket.setSoTimeout(TIMEOUT);
            System.out.println("Start up server sucessful");
            Server.start();            
        } catch (IOException e) {
            // TODO Auto-generated catch block

        }
    }
    
    public static void start() {
        cont = true;
        while (cont) {
            try {
                System.out.println("Waitting for a new connection socket...");
                Socket socket = serverSocket.accept();
                socket.setSoTimeout(TIMEOUT);
                socketAutentication(socket);
                
                Log.print("Connection sucefull");
            } catch (IOException e) {
                // TODO Auto-generated catch block

            }
        }
    }
    
    private static void socketAutentication(Socket socket) {
        String message;
        try {
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            message = (String) input.readObject();
            if (message != null) {
                Usuario usuario = new Usuario(1,"", "");
                //Faça autenticaçao aqui
                if ("login".equals(usuario.getLogin()) || "senha".equals(usuario.getPassword())) {
                    
                    startListenner(new ListennerGarcon(socket));
                    
                }
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void stop() {
        cont = false;
    }    
    
    private static void startListenner(Listenner listenner) {
        new Thread(listenner).start();
    }
    
}
