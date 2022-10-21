/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoUMG;

/**
 *
 * @author Willy
 */
public class Actividades {
    
     //Creacion de atributos
    private String NombreActividades ;
    private int Id;
    
       //Metodo contructor 
    public Actividades(String NombreActividades, int Id) {
        this.NombreActividades = NombreActividades;
        this.Id = Id;
    }

    //Metodo consultor
    public String getNombreActividades() {
        return NombreActividades;
    }

    //Metodo modificador
    public void setNombreActividades(String NombreActividades) {
        this.NombreActividades = NombreActividades;
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
        return "Actividades " + this.NombreActividades;
              
    }  
    
    
    
    
    
}
