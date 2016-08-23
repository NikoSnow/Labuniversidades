package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nico
 */
public class Servidor {
  public static void main(String arg[]){
      try {
        //Creando el servidor  
        ServerSocket servidor = new
                  ServerSocket(8000);
        
        //Esperando conexion
        System.out.println("Esperando conexiones");
        
        while(true){
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado...");
            Hilo hilo = new Hilo(cliente);
            Thread ejecutar = new Thread(hilo);
            ejecutar.start();
        }
        
      } catch (IOException ex) {
         ex.printStackTrace();
      }
      
  
  
  }   
    
}
