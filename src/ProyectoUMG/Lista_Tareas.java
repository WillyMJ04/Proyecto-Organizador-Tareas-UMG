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
public class Lista_Tareas implements Serializable { 
    
    
       //Creacion de atributos
    private String nombreListaTarea;
    private int Id;
    
     //Metodo contructor 

    public Lista_Tareas(String nombreListaTarea, int Id) {
        this.nombreListaTarea = nombreListaTarea;
        this.Id = Id;
    }

        //Metodo consultor
    public String getNombreListaTarea() {
        return nombreListaTarea;
    }

     //Metodo modificador
    public void setNombreListaTarea(String nombreListaTarea) {
        this.nombreListaTarea = nombreListaTarea;
    }

    //Metodo consultor
    public int getId() {
        return Id;
    }

      //Metodo modificador
    public void setId(int Id) {
        this.Id = Id;
    }
    
    // Metodo analizador
    // podemos agregar atributos para imprimir las instancias
     public String mostrarDatos (){
        return "Lista de tareas " + this.nombreListaTarea ;
              
    }  
    
    
    
    
}
