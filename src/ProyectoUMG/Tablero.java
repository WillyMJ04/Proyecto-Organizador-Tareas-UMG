/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoUMG;

import java.io.Serializable;

/**
 *
 * @author Willy
 */

//Indicamos que todas las instancias puedan añadirce al vector
// con "implements Serializable"
public class Tablero implements Serializable {
    
    //Atributos
    
    private String nombre;
    private int Id;
    
    // Constructor
    
    public Tablero(String nombre, int Id) {
        this.nombre = nombre;
        this.Id = Id;
    }
    
    //Consultor
    public String getNombre() {
        return nombre;
    }

    //Modificador
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    //Consultor
    public int getId() {
        return Id;
    }

    
    //Modificador
    public void setId(int Id) {
        this.Id = Id;
    }
    
    // Metodo analizador
    // podemos agregar atributos para imprimir las instancias
    public String toString(){
        return "Nombre del tablero " + this.Id + "-"+ this.nombre;
    }
   
            
            
            
            
            
            
            
}
