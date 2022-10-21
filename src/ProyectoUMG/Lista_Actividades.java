/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoUMG;

/**
 *
 * @author Willy
 */
public class Lista_Actividades {
    
      //Creacion de atributos
    private String ListaArctividades;
    private int Id;
    
        //Metodo contructor 

    public Lista_Actividades(String ListaArctividades, int Id) {
        this.ListaArctividades = ListaArctividades;
        this.Id = Id;
    }

    //Metodo consultor
    public String getListaArctividades() {
        return ListaArctividades;
    }

     //Metodo modificador
    public void setListaArctividades(String ListaArctividades) {
        this.ListaArctividades = ListaArctividades;
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
        return "Lista Actividades " + this.ListaArctividades;
              
    }  
     
    
}
