/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoUMG;

/**
 *
 * @author Willy
 */
public class Tareas {
    
    
    //Creacion de atributos
    private String nombreTareas;
    private int Id;
    private String descripcion;
    
    //Metodo contructor 
    public Tareas(String nombreTareas, int Id, String descripcion) {
        this.nombreTareas = nombreTareas;
        this.Id = Id;
        this.descripcion = descripcion;
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

      //Metodo consultor
    public String getDescripcion() {
        return descripcion;
    }
        
      //Metodo consultor
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    // Metodo analizador
    // podemos agregar atributos para imprimir las instancias
 
    public String mostrarDatos (){
        return "Nombre de tarea " + this.nombreTareas + " " + " Descripcion: " + this.descripcion;
              
    }   
   
}
