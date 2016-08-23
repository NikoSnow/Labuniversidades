/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 * Clase que gestiona la informacion de las personas
 * @author Nicolas
 * @since 29/07/2016
 * @version 1
 */
public class Person {
    protected String id;
    protected String name;

    /**
     * Constructor de la clase 
     * @param id Identificar unico de la persona
     * @param name  Nombre de la persona
     */
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id +"," + name;
    }
    
    
    
    
}
