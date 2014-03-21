package clases;

import java.io.*;
import java.net.*;
import java.util.logging.*;

public class Server {

    public static void main(String args[]) throws IOException, InterruptedException {

        ServerSocket ss;
        System.out.print("Inicializando servidor... ");
        try {
            ss = new ServerSocket(10578);
            System.out.println("\t[OK]");
            int idSession = 0;
            while (true) {
                Socket socket;
                socket = ss.accept();
                System.out.println("Nueva conexión "+idSession+" entrante: "+socket);
                ServerThread hola = new ServerThread(socket, idSession);
                hola.start();
                idSession++;
            }

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}