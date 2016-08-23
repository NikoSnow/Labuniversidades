/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Niko
 * 
 */
public class Cliente {
    public static void main(String arg[]){
        try {
        Socket cliente = new Socket("localhost",8000);
        System.out.println("Conexion exitosa");
        InputStream entrada = cliente.getInputStream();
        
        OutputStream salida= cliente.getOutputStream();
        //Decoradores
        PrintStream escribir = new PrintStream(salida);
        BufferedReader leer =  new BufferedReader(new InputStreamReader(entrada));
        BufferedReader teclado = new BufferedReader(new InputStreamReader (System.in));
        
        boolean flag=true;
        while(flag){
            System.out.println("Digite su universidad");
            String uni;
            uni = teclado.readLine();
            System.out.println("Digite su Cargo");
            String tipe;
            tipe= teclado.readLine();
            
            String cadena = uni + tipe;
            escribir.println(cadena);
            
            
            String enviadoxServidor = leer.readLine();
            System.out.println(enviadoxServidor);
                 
        if(uni.contains("cerrar")){
            flag = false;
          }
        }
            leer.close();
            escribir.close();
            entrada.close();
            salida.close();
            cliente.close();
        
       
    }catch (Exception ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
