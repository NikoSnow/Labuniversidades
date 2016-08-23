package servidor;

import datos.ByContract;
import datos.Student;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.BaseDatos;

/**
 *
 * @author B106 PC-11
 */
public class Hilo implements Runnable {

    private Socket cliente = null;
    private PrintStream escribir = null;
    private BufferedReader leer = null;

    public Hilo(Socket cliente) {
      InputStream entrada = null;
      try {
        this.cliente = cliente;
       entrada = cliente.getInputStream();
       OutputStream salida = cliente.getOutputStream();
            //Decoradores
      this.escribir = new PrintStream(salida);
      this.leer = new BufferedReader(new InputStreamReader(entrada));
        } catch (IOException ex) {
         ex.printStackTrace();
        } 
    }

    @Override
    public void run() {
     String universidad;
     String datos;
     try {
      
      universidad = leer.readLine();
      Date fecha = new Date("12/12/2016");
      Student contrato = new Student("Escuela Ing",fecha, "1015460746", "Nicolas");
      BaseDatos dt = new BaseDatos();
      dt.almacenar(universidad, contrato);
      
      
      
      escribir.println("Gracias");
    } catch (IOException ex) {
       ex.printStackTrace();
    }finally{
         try {
           leer.close();
           escribir.close();
           this.cliente.close();
         } catch (IOException ex) {
             Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
         }
      
    }
    
    }

}
