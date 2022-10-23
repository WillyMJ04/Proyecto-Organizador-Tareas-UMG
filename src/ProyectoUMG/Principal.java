
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
        int idTareas = 1; //para las tareas
        int pivoteTarea = 0; // para restar 1 a la opc 3 tomandola de referencia
        int iterador1 = 1; // para tareas
        int opc8 =1; //para tareas
        int id1 = 1; // para filtro del caso 2 de tareas
        int id2 =1; // para eliminacion de tareas
        int contador1 = 1; //para las tareas caso 4
        
         // Varibles universales tipo String
        String error = "Error, ingrese una opcion valida";
        String nombre = " ";
        String opc2 = " ";
        String opc4 = " ";
        String opc5 = " "; // para cambiar nombre del tablero
        String nuevoNombre = " "; 
        String opc6 = " "; //para la lista de tareas
        String opc7 = " "; //Paara las tareas
        String opc9 = " "; //para el caso 2 de tareas
        String opc10 = " "; // para cambiar el nombre de la tarea
        String opc11 = " "; // opc para eliminar tarea
        
        // Clase Scaner
        Scanner tc = new Scanner(System.in);
        
        //Creacion de archivo
        File archivo = new File("C:\\Users\\acer\\Desktop\\OrganizadorProyecto\\Tablero\\Tablero.txt");
        File archivo2 = new File("C:\\Users\\acer\\Desktop\\OrganizadorProyecto\\Tablero\\ListaTareas\\Lista.txt");
        File archivo3 = new File("C:\\Users\\acer\\Desktop\\OrganizadorProyecto\\Tablero\\ListaTareas\\Tarea.txt");

        //Creando referencia al objeto tipo tablero
        Tablero tab;
        
        // Creando referencia al objeto tipo Lista tareas
        Lista_Tareas LisTareas;
        
        // Creando referencia al objeto tipo Lista tareas
        Tareas work;
          
        // Almacenamiento de las instancias tipo tablero 
        Vector tableros = new Vector ();
        
        // Almacenamiento de las instancias tipo lista tareas
        Vector  listaTareas = new Vector ();
        
        // Almacenamiento de las instancias tipo tareas
        Vector homeWork = new Vector ();
        
        do {
           
            System.out.println("BIENVENIDO A SU ORGANIZADOR \n ------DE TAREAS------ \n");
            System.out.println("POR FAVOR INGRESE UNA OPCION : ");
            System.out.println("1. Visualizar lista tableros");
            System.out.println("2. Crear tablero ");
            System.out.println("3. Salir");
            
            opc1 = tc.nextInt();
            
            switch(opc1){
                
                case 1:
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
                                             switch (opc3){
                    //*********************************************************************************************                             
                                                 case 1:
                                                     if(!archivo2.isFile()){
                                                        System.out.println("No cuenta con lista de tareas\n Cree una lista de tareas: ");

                                                     } else{
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
                                                         
                                                            System.out.println("Desea visualizar una lista de tareas? ");
                                                            System.out.println("Si\nNo ");
                                                            opc7 = tc.next();
                                                            
                                                            if(opc2.equals("Si")){
                                                                System.out.println("Ingrese el Id de la tarea a visualizar: ");
                                                                idOpc = tc.nextInt();
                                                                pivoteTarea = idTareas-1;
                                                               
                                                                do {
                                                                    System.out.println("POR FAVOR INGRESE UNA OPCION : ");
                                                                    System.out.println("1. Ver tareas");
                                                                    System.out.println("2. Crear tareas ");
                                                                    System.out.println("3. Cambiar nombre de la tarea ");
                                                                    System.out.println("4. Borrar tarea ");
                                                                    System.out.println("5. Regresar al menu principal");
                                       
                                                                    opc8 = tc.nextInt();
                                                                    
                                                                    switch(opc8){
                                                                        case 1:
                                                                            if(!archivo3.isFile()){
                                                                                System.out.println("No cuenta con tareas\n Cree una tareas: ");
                                                                                
                                                                            } else{
                                                                               try{
                                                                            FileInputStream flujo4 = new FileInputStream(archivo3);
                                                                            ObjectInputStream read = new ObjectInputStream(flujo4);

                                                                            //casting
                                                                            homeWork = (Vector)read.readObject();

                                                                            }catch(FileNotFoundException e){
                                                                           e.printStackTrace();

                                                                        } catch (IOException e){
                                                                           e.printStackTrace();

                                                                           //excepcion del casting
                                                                         }catch (ClassNotFoundException e){
                                                                           e.printStackTrace();
                                                                         }
                                                                            for (int m = 0; m < homeWork.size(); m++) {
                                                                                work = (Tareas)homeWork.elementAt(m);
                                                                                System.out.println(iterador1 + ") " + work.mostrarDatos()); 
                                                                                iterador1++;
                                                                            }
                                                                            iterador1 = 1;  
                                                                            }
                                                                            break;
                                                                            
                                                                        case 2:
                                                                            System.out.println("Ingrese el nombre de su tarea: ");
                                                                            opc9 = tc.next();

                                                                            try {
                                                                                //Filtro para los Id
                                                                                if(id1!= homeWork.size()){
                                                                                    id1 = homeWork.size()+1;
                                                                                }
                                                                                //Instancia de nuestro objeto
                                                                                work = new Tareas(opc9,id1);
                                                                                //Incremento del Id
                                                                                id1++;
                                                                                FileOutputStream e = new FileOutputStream(archivo3);
                                                                                ObjectOutputStream r = new ObjectOutputStream (e);
                                                                                homeWork.add(work);
                                                                                r.writeObject(homeWork);

                                                                            }catch(FileNotFoundException e){
                                                                                e.printStackTrace();

                                                                            } catch (IOException e){
                                                                                e.printStackTrace();

                                                                            }
                                                                            System.out.println("Su tareas fue creada exitosamente!!\n");
                                            
                                                                            break;
                                                                            
                                                                        case 3:
                                                                            System.out.println("Ingrese el nuevo nombre de su tarea: ");
                                                                            opc10 = tc.next();
                                                                            homeWork.remove(pivoteTarea);
                                                                            work = new Tareas(opc10,pivoteTarea);

                                                                            try {

                                                                                FileOutputStream a = new FileOutputStream(archivo3);
                                                                                ObjectOutputStream q = new ObjectOutputStream(a);
                                                                                homeWork.add(pivoteTarea,work);
                                                                                q.writeObject(homeWork);


                                                                            } catch(FileNotFoundException e){
                                                                                e.printStackTrace();

                                                                            } catch (IOException e){
                                                                                e.printStackTrace();

                                                                            }
                                                                                 System.out.println("\n Nombre modificado exitosamente!!\n");
                                                                            break;
                                                                            
                                                                        case 4:
                                                                            System.out.println("La tarea se eliminará permanentemente\n desea continuar? ");
                                                                            System.out.println("Si\nNo ");
                                                                            opc11 = tc.next();
                                                                            if(opc11.equals("Si")){

                                                                            //Elimina el metodo en el vector, con el id especificado
                                                                            homeWork.remove(id2);
                                                                            System.out.println("Tarea eliminado exitosamente!");  
                                                                            System.out.println("La tarea fue actualizada...");

                                                                                //Reescribir el listado de tareas
                                                                            try {
                                                                               FileOutputStream input = new FileOutputStream(archivo3);
                                                                               ObjectOutputStream write = new ObjectOutputStream (input);

                                                                                //Escribiendo el vector en un archivo.txt
                                                                                write.writeObject(homeWork);

                                                                               } catch(FileNotFoundException e){
                                                                                   e.printStackTrace();

                                                                               } catch(IOException e){
                                                                                   e.printStackTrace();

                                                                               }

                                                                                //Para mostrar las tareas
                                                                                for (int v = 0; v < homeWork.size(); v++) {

                                                                               //Metodo para agregar elementos almacenados en los objetos tareas

                                                                               work = (Tareas)homeWork.elementAt(v);
                                                                               System.out.println(contador1 + ") " + work.toString());
                                                                               contador1++; 
                                                                               }
                                                                               contador1 = 1;  
                                                                               opc8 = 5;
                                                                            }

                                                                            else{
                                                                                opc8 = 5;
                                                                            }
                                                                            break;
                                                                            
                                                                        case 5:
                                                                            System.out.println("Regresó al menu principal \n");
                                                                            opc3 =5;
                                                                            break;
                                                                        default:
                                                                              System.out.println(error);
                                                                            break;
                                                                            
                                                                      
                                                                    }//fin switch
                                                                    
                                                                } while (true);
                                                            }
                                                            
                                                     }//Fin else
                                                     break;
                    //*********************************************************************************************                                 
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
                                             
                                             
                                             }else{
                                                 opc3 = 5;
                                             }
                                                     break;
                                                     
                                                 case 5:
                                                     System.out.println("Regresó al menu principal \n");
                                                      opc3 =5;
                                                     break;
                                                     default:
                                               System.out.println(error);
                                                     break;
                                             }
                                        } while (true);
                                        
                                    }
                                }
                                
                                
                                
                            }//else
                    
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
                    
            } 
            
            
            
        } while (opc1!=3);
        
    
    } //fin main
    
} 
