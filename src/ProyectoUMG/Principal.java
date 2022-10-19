
package ProyectoUMG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Willy
 */
public class Principal { /// Inicio clase
    public static void main(String[] args) { //Inicio Main
        //Inicio del proyecto organizador UMG 01/10/2022
        
        
        // Varibles universales
        int i = 1;
        int opc1 = 0;
        String error = "Error, ingrese una opcion valida";
        String nombre = " ";
        
        // Clase Scaner
        Scanner tc = new Scanner(System.in);
        
        //Creacion de archivo
        File archivo = new File("C:\\Users\\acer\\Desktop\\OrganizadorProyecto\\Tablero\\Tablero.txt");
        
        // Creando referencia al objeto tipo tablero
        
        Tablero tab;
        
       // Almacenamiento de las instancias tipo tablero 
        Vector tableros = new Vector ();
        
        do{
            System.out.println("BIENVENIDO A SU ORGANIZADOR \n ------DE TAREAS------ \n");
            System.out.println("POR FAVOR INGRESE UNA OPCION : ");
            System.out.println("1. Crear tablero");
            System.out.println("2. Visualizar lista tableros");
            System.out.println("3. Salir");
            
            opc1 = tc.nextInt();
            
            switch (opc1){ // switch 1 inicio
                
                case 1:
                    System.out.println("\n\n Ingrese el nombre del tablero");
                    nombre = tc.next();
                    
                    try {
                        // instancia del objeto Tablero
                        tab = new Tablero(nombre, i);
                        i++;
                        
                        
                        // En cada creacion de instancias se añade al vector 
                        tableros.add(tab);
                        
                        // Escribir en el archivo creado
                        // para escribir objetos
                        FileOutputStream flujo = new FileOutputStream(archivo);
                        
                        ObjectOutputStream write = new ObjectOutputStream (flujo);
                        
                        //Escribiendo el vector en un archivo.txt
                        write.writeObject(tableros);
                        
                           
                        
                    } catch(FileNotFoundException e){
                        e.printStackTrace();
                        
                    } catch(IOException e){
                        e.printStackTrace();
                        
                    }
                    System.out.println("Tablero creado exitosamente\n!!");
                        break;
                case 2:
                   
                    try{
                        // cambio del formato txt "bytes" al objeto
                        FileInputStream flujo2 = new FileInputStream(archivo);
                        
                        // leer el objeto traducido
                        ObjectInputStream read = new ObjectInputStream(flujo2);
                        
                        // Casting para hacer el cambio de tipo
                        // leer el vector 
                        tableros = (Vector)read.readObject();
                        
                       
                     } catch(FileNotFoundException e){
                       e.printStackTrace();
                    } catch (IOException e){
                       e.printStackTrace();
                       } catch (ClassNotFoundException e){
                       e.printStackTrace();
                    }
                    
                     //uso de libreria Iterator
                     // leer e imprimir los objetos del vector 
                        Iterator it = tableros.iterator();
                        
                        // "has" para devolver un valor true mientras encuenta el objero
                        // cuando ya no hay objetos devuelve un false
                        while(it.hasNext()){ //Inicio while 1
                            
                            // buscar objetos de tipo tableros 
                            tab = (Tablero)it.next();
                            
                            //Mostrar el nombre del tablero
                            System.out.println(tab.toString());
                       
                        }//Fin del while 1
                        
                        break;
                case 3:        
                    System.out.println("Programa cerrado");
                    opc1 = 3;
                    //Para salir
                    System.exit(0);
                    
                        break;
                default:
                    System.out.println(error); 
                    
            } // switch 1 fin
            
        } while (opc1 !=3);
        
        
    } //Fin Main

} //fin clase
