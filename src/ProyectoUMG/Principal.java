
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
        
        
        // Varibles universales tipo int
        int id = 1;
        int opc1 = 0;
        int contador = 1;
        int idOpc = 0;
        int opc3 = 0;
        int pivote = 0; // para restar 1 a la opc 3 tomandola de referencia
        int idLista = 1; // para otorgar id lista de tareas
        int iterador = 1; // para lista de tareas
        
         // Varibles universales tipo String
        String error = "Error, ingrese una opcion valida";
        String nombre = " ";
        String opc2 = " ";
        String opc4 = " ";
        String opc5 = " "; // para cambiar nombre del tablero
        String nuevoNombre = " "; 
        String opc6 = " "; //para la lista de tareas
        
        
        // Clase Scaner
        Scanner tc = new Scanner(System.in);
        
        //Creacion de archivo
        File archivo = new File("C:\\Users\\acer\\Desktop\\OrganizadorProyecto\\Tablero\\Tablero.txt");
        File archivo2 = new File("C:\\Users\\acer\\Desktop\\OrganizadorProyecto\\Tablero\\ListaTareas\\Lista.txt");
        
        //Creando referencia al objeto tipo tablero
        Tablero tab;
        // Creando referencia al objeto tipo Lista tareas
        Lista_Tareas LisTareas; 
          
        // Almacenamiento de las instancias tipo tablero 
        Vector tableros = new Vector ();
        
        // Almacenamiento de las instancias tipo lista tareas
        Vector  listaTareas = new Vector ();
       

        do{
            System.out.println("BIENVENIDO A SU ORGANIZADOR \n ------DE TAREAS------ \n");
            System.out.println("POR FAVOR INGRESE UNA OPCION : ");
            System.out.println("1. Visualizar lista tableros");
            System.out.println("2. Crear tablero ");
            System.out.println("3. Salir");
            
            opc1 = tc.nextInt();
            
            switch (opc1){ // switch 1 inicio
                
                case 1:
                   
                    //Evaluacion de error cuando
                    if(!archivo.isFile()){ // Inicio if 1
                        System.out.println("No cuenta con tableros disponibles\n Cree un tablero para iniciar ");
                    } // fin if 1
                        else{

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
                    
                        
                        for (int j = 0; j < tableros.size(); j++) {
                           
                            //Metodo para agregar elementos almacenados en los objetos tableros
                           
                          tab = (Tablero)tableros.elementAt(j);
                          System.out.println(contador + ") " + tab.toString());
                          contador++; 
                        }
                        
                        contador = 1;
                        
                        
                        System.out.println("¿Desea ingresar a algun tablero disponible?");
                        System.out.println("Si\nNo ");
                        opc2 = tc.next();
                        
                        if(opc2.equals("Si")){
                            System.out.println("Ingrese el Id del tablero a visualizar: ");
                            idOpc = tc.nextInt();
                            
                            if(idOpc <= tableros.size()){
                                
                                pivote = idOpc-1;
                           
                               do {
                                   System.out.println("POR FAVOR INGRESE UNA OPCION : ");
                                   System.out.println("1. Ver lista de tareas");
                                   System.out.println("2. Crear lista de tareas ");
                                   System.out.println("3. Cambiar nombre de tablero ");
                                   System.out.println("4. Borrar tablero ");
                                   System.out.println("5. Regresar al menu principal");
                                       
                                   opc3 = tc.nextInt();
                                       
                                     switch (opc3){ // Inicio switch 2
                                         
                                   //*************************************************************************  
                                         case 1:
                                              if(!archivo2.isFile()){
                                                  System.out.println("No cuenta con lista de tareas\n Cree una lista de tareas: ");
                                                  
                                              } else{ // Inicio else
                                                  
                                                  try{
                                                  FileInputStream flujo3 = new FileInputStream(archivo2);
                                                  ObjectInputStream read = new ObjectInputStream(flujo3);
                                                  
                                                  //casting
                                                  listaTareas = (Vector)read.readObject();

                                              }catch(FileNotFoundException e){
                                                 e.printStackTrace();
                                                 
                                             } catch (IOException e){
                                                 e.printStackTrace();
                                                 
                                                 //excepcion del casting
                                             }catch (ClassNotFoundException e){
                                                 e.printStackTrace();
                                             }
                                                  for (int w = 0; w < listaTareas.size(); w++) {
                                                      LisTareas = (Lista_Tareas)listaTareas.elementAt(w);
                                                      System.out.println(iterador + ") " + LisTareas.mostrarDatos()); 
                                                      iterador++;
                                                  }
                                                  iterador = 1;
                                                  
                                              }//Fin else
                                              
                                    //*************************************************************************               
                                             break;
                                            
                                         case 2:
                                             System.out.println("Ingrese el nombre de su lista de tareas: ");
                                             opc6 = tc.next();
                                             
                                             try {
                                                 //Filtro para los Id
                                                 if(idLista!= listaTareas.size()){
                                                     idLista = listaTareas.size()+1;
                                                 }
                                                 //Instancia de nuestro objeto
                                                 LisTareas = new Lista_Tareas(opc6,idLista);
                                                 //Incremento del Id
                                                 idLista++;
                                                 FileOutputStream w = new FileOutputStream(archivo2);
                                                 ObjectOutputStream z = new ObjectOutputStream (w);
                                                 listaTareas.add(LisTareas);
                                                 z.writeObject(listaTareas);

                                             }catch(FileNotFoundException e){
                                                 e.printStackTrace();
                                                 
                                             } catch (IOException e){
                                                 e.printStackTrace();
                                                 
                                             }
                                             System.out.println("Su lista de tareas fue creada exitosamente!!\n");
                                            
                                             break;
                                     
                                         case 3:
                                             
                                        //System.out.println("El tablero cambiara el nombre actual\n desea continuar?");
                                             System.out.println("Ingrese el nuevo nombre de su tablero: ");
                                             opc5 = tc.next();
                                             tableros.remove(pivote);
                                             tab = new Tablero(opc5,pivote);
                                             
                                             try {
                                                 
                                                 FileOutputStream x = new FileOutputStream(archivo);
                                                 ObjectOutputStream y = new ObjectOutputStream(x);
                                                 tableros.add(pivote,tab);
                                                 y.writeObject(tableros);
                                                 
                                                 
                                             } catch(FileNotFoundException e){
                                                 e.printStackTrace();
                                                 
                                             } catch (IOException e){
                                                 e.printStackTrace();
                                                 
                                             }
                                             System.out.println("\n Nombre modificado exitosamente!!\n");
                                           
                                             break;
                                     
                                         case 4:
                                             System.out.println("El tablero se eliminará permanentemente\n desea continuar? ");
                                             System.out.println("Si\nNo ");
                                             opc4 = tc.next();
                                             if(opc4.equals("Si")){
                                             
                                             //Elimina el metodo en el vector, con el id especificado
                                             tableros.remove(idOpc);
                                                 System.out.println("Tablero eliminado exitosamente!");  
                                                 System.out.println("La lista de tableros fue actualizada...");
                                                 
                                                 //Reescribir el listado de tableros
                                                try {
                                                FileOutputStream input = new FileOutputStream(archivo);
                                                ObjectOutputStream write = new ObjectOutputStream (input);

                                                    //Escribiendo el vector en un archivo.txt
                                                    write.writeObject(tableros);

                                                } catch(FileNotFoundException e){
                                                    e.printStackTrace();

                                                } catch(IOException e){
                                                    e.printStackTrace();

                                                }

                                                 //Para mostrar los tableros
                                                 for (int j = 0; j < tableros.size(); j++) {
                           
                                                //Metodo para agregar elementos almacenados en los objetos tableros
                           
                                                tab = (Tablero)tableros.elementAt(j);
                                                System.out.println(contador + ") " + tab.toString());
                                                contador++; 
                                                }
                                                contador = 1;  
                                                opc3 = 5;
                                             }
                                             
                                             else{
                                                 opc3 = 5;
                                             }
                                             
                                             break;
                             
                                         case 5:
                                             System.out.println("Regresó al menu principal \n");
                                             opc3 =5;
                                             break;
                                         default:
                                               System.out.println(error);
                                     } // Fin swich
                                              
                                }while(opc3 !=5);
                            
                            } else{
                                System.out.println("El Id ingresado no es valido, intente nuevamente: ");
                            }
                            
                        }
                         
                        else{
                            System.out.println("!!Regreso al menu principal!!");
                            
                        }
                        
  
                        } // Fin else 1
                        break;
                case 2:
                    System.out.println("\n\n Ingrese el nombre del tablero");
                    nombre = tc.next();
                    
                    try {
                    
                        if(id != tableros.size()){
                            id = tableros.size()+1;    
                        }
                            // instancia del objeto Tablero
                        tab = new Tablero(nombre, id);
                        id++;

                        
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
