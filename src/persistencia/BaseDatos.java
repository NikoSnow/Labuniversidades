/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import datos.Person;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Nico
 */
public class BaseDatos {
    public void almacenar(String universidad, Person person){
        FileWriter escritura = null;
        try {
            File archivo = new File(universidad + ".txt");
            if(archivo.exists()){
                System.out.println("existe");
            }else{
              archivo.createNewFile();
            }   
        escritura = new FileWriter(archivo,true);
        escritura.write(person.toString() + "\n");
        escritura.flush();
        escritura.close();
           
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                escritura.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    
    }
}
