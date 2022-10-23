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
public class Tareas implements Serializable {
    
    
    //Creacion de atributos
    private String nombreTareas;
    private int Id;
    
    
    //Metodo contructor 
    public Tareas(String nombreTareas, int Id) {
        this.nombreTareas = nombreTareas;
        this.Id = Id;
    
    }

      //Metodo consultor
    public String getNombreTareas() {
        return nombreTareas;
    }

    //Metodo modificador
    public void setNombreTareas(String nombreTareas) {
        this.nombreTareas = nombreTareas;
    }

       //Metodo consultor
    public int getId() {
        return Id;
    }

      //Metodo consultor
    public void setId(int Id) {
        this.Id = Id;
    }

     
    
        
  
    
    
    // Metodo analizador
    // podemos agregar atributos para imprimir las instancias
 
    public String mostrarDatos (){
        return "Nombre de tarea " + this.nombreTareas;
              
    }   
   
}
