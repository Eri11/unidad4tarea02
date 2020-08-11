/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tarea4.pkg2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Erick Hernández
 */
public class Producto {
    private Nodo inicio;
    String nombre;
    String descripcion;
    String cantidad;
    String costo;
    String precio;
    // Variable para registrar el tamaño de la lista.
    private int tamanio;
    // Constructor que inicializamos el valor de la variable.
    public void Producto(){
        inicio = null;
        tamanio = 0;
    }
    //Getter y setter
    public int getTamanio(){
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    
    
    
     public boolean esVacia(){
         //Si el valor de la variable inicio es null, se regresa un true, indicando que la lista esta vacía
        if (inicio == null) {
            return true;
         //Si el valor de la variable inicio no es null, se regresa un false, indicando que la lista no esta vacía
        }else{
            return false;
        }     
    }
      //Metodo que manda a pantalla los  valores de todos los nodos.
     public void listar(){
        // Verifica si la lista esta vacia.
        float total=0;
        if (!esVacia()) {
            // Crea una copia de la lista.
            Nodo aux = inicio;
            // Posicion de los elementos de la lista.
            //Se inicia en 1 porque asi inician las listas normalmente
            int i = 1;
            // Recorre la lista hasta el final.
            System.out.println("*******************************************************************");
            System.out.println("           PRODUCTOS: ");
            System.out.println("*******************************************************************\n");
            System.out.println("# | Descripción            |   Cantidad  | Costo    | Precio");
            while(aux != null){
                // Imprime en pantalla los valores del nodo.
                System.out.println(i +" | "+aux.getNombre() +" "+aux.getDescripcion()+"  |  "+ aux.getCantidad()+"         |    "+ aux.getCosto()+" |  "+ aux.getPrecio());
                total=total+ (Float.parseFloat(aux.getPrecio()));
                // Avanza al siguiente nodo.
                aux = aux.getSiguiente();
                // Incrementa el contador de la posión.
                i++;
                
                
            }
            //Se manda a pantalla el total de lo que se va a pagar
            System.out.println("*******************************************************************");
            System.out.println("                                               TOTAL: "+ total);
            
        }
    }
    //Elimina productos de la lista
     public void eliminar(int posicion){
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if(posicion>=0 && posicion<tamanio){
            // Consulta si el nodo a eliminar es el primero
            if(posicion == 0){
                // Elimina el primer nodo apuntando al siguinte.
                inicio = inicio.getSiguiente();
            }
            // En caso que el nodo a eliminar este por el medio 
            // o sea el ultimo
            else{
                // Crea una copia de la lista.
                Nodo aux = inicio;
                // Recorre la lista hasta lleger al nodo anterior al eliminar.
                for (int i = 0; i < posicion-1; i++) {
                    aux = aux.getSiguiente();
                }
                // Guarda el nodo siguiente al nodo a eliminar.
                Nodo siguiente = aux.getSiguiente();
                // Elimina la referencia del nodo apuntando al nodo siguiente.
                aux.setSiguiente(siguiente.getSiguiente());
            }
            // Disminuye el contador de tamaño de la lista.
          //  setTamanio(getTamanio()-1);
          tamanio--;
        }
    }
     public void eliminarLista(){
        // Elimina el valor y la referencia a los demas nodos.
        inicio = null;
        // Reinicia el contador de tamaño de la lista a 0.
        tamanio = 0;
    }
     
     public void agregarProd(String nom, String des, String cantidad, String costo, String precio){
        // Define un nuevo nodo y agrega el valor.
        Nodo nuevo = new Nodo(nom,des,cantidad,costo, precio);
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = nuevo;
        // Caso contrario recorre la lista hasta llegar al ultimo nodo
        //y agrega el nuevo.
        } else{
            // Crea ua copia de la lista.
            Nodo aux = inicio;
            // Recorre la lista hasta llegar al ultimo nodo.
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            // Agrega el nuevo nodo al final de la lista.
            // usando el mé todo llamado setSiguiente de la clase Nodo, este crea el nuevo enlace entre el ultimo nodo y el nuevo,
            //ya que hace referencia a otro nodo.
            aux.setSiguiente(nuevo);
        }
         // Incrementa el contador de tamaño de la lista
         tamanio++;
        
    }
     
    // Método que muestra el menú de opciones que se pueden realizar en este programa
      public void menu(){
       Scanner s = new Scanner(System.in);
       //Se declara un objeto de la clase Alumno
       Producto pedido = new Producto();
       //variables a usar
       int opcion; //Guardaremos la opcion del usuario
       int opc;
       //Variables de apoyo
       float cost=0;
       float aux=0;
       int cant=0;
       boolean salir = false;
        //While que mantiene al usuario
          while (!salir) {
            System.out.println("\n==================================");
            System.out.println("          MENÚ");
            System.out.println("==================================");
            System.out.println("1. Añadir Producto a la lista");
            System.out.println("2. Listar todos los productos en la lista");
            System.out.println("3. Eliminar Producto de la lista");
            System.out.println("4. Eliminar toda la lista");
            System.out.println("5. Salir");
            System.out.println("==================================\n");
                System.out.println("Escribe una de las opciones");
                opcion = s.nextInt();
                switch (opcion) {
                    //Caso 1 donde muetra los productos que puedes agragar
                    case 1:
                        //Pide valores al usuario                       
                        System.out.println("***************************");
                        System.out.println("        Productos    ");
                        System.out.println("***************************");
                        System.out.println("1. Hamburguesas");
                        System.out.println("2. Papas fritas");
                        System.out.println("3. Refrescos");
                        System.out.println("4. Aros de cebolla");
                        System.out.println("5. Cerveza");
                        System.out.println("***************************");
                        System.out.println("Elige una opcion");
                        opcion = s.nextInt();
                        //while que te manda a pantalla un error y solicita al usuario escribir un valor que este en el menu
                        while(opcion<1||opcion>5){
                                System.out.println("ERROR:");
                                System.out.println("Elige una opcion entre 1 y 5)");
                                 opcion=s.nextInt();
                            }
                        //If que te muestra las opciones de hamburguesas
                        if (opcion==1) {
                            System.out.println("\n////////////////////////////////////////////////////////////");
                            System.out.println("1. Hamburguesa sencilla: $50");
                            System.out.println("2. Hamburguesa especial: $80");
                            System.out.println("////////////////////////////////////////////////////////////");
                            System.out.println("Elige la opcion de hamburguesas:");
                            opc=s.nextInt();
                            nombre="Hamburguesa";
                            //while que te manda a pantalla un error y solicita al usuario escribir un valor que este en el menu
                            while(opc<1||opc>2){
                                System.out.println("ERROR:");
                                System.out.println("Elige la opcion de hamburguesas: (Entre 1 y 2)");
                                 opc=s.nextInt();
                            }
                            if (opc==1) {
                                descripcion= "Sencilla";
                                cost=50;
                                System.out.println("¿Cuántas quieres?");
                                cant=s.nextInt();
                                aux=cost*cant;
                            }
                            if(opc==2){
                                descripcion="Especial";
                                cost=80;
                                System.out.println("¿Cuántas quieres?");
                                cant=s.nextInt();
                                aux=cost*cant;
                            }
                        }
                        //If que te muestra las opciones de las papas fritas
                        if (opcion==2) {
                            System.out.println("\n////////////////////////////////////////////////////////////");
                            System.out.println("1. Papas chicas: $20");
                            System.out.println("2. Papas medianas: $25");
                            System.out.println("3. Papas grandes: $30");
                            System.out.println("////////////////////////////////////////////////////////////");
                            System.out.println("Elige la opcion de papas fritas:");
                            opc=s.nextInt();
                            nombre="Papas_fritas";
                            //while que te manda a pantalla un error y solicita al usuario escribir un valor que este en el menu
                            while(opc<1 || opc>3){
                                System.out.println("ERROR:");
                                System.out.println("Elige la opcion de papas fritas: (Entre 1 y 3)");
                                 opc=s.nextInt();
                            }
                            if (opc==1) {
                                descripcion="Chicas";
                                cost=20;
                                System.out.println("¿Cuántas quieres?");
                                cant=s.nextInt();
                                aux=cost*cant;
                            }
                            if (opc==2) {
                                descripcion="Medianas";
                                cost=25;
                                System.out.println("¿Cuántas quieres?");
                                cant=s.nextInt();
                                aux=cost*cant;
                            }
                            if (opc==3) {
                                descripcion="Grandes";
                                cost=30;
                                System.out.println("¿Cuántas quieres?");
                                cant=s.nextInt();
                                aux=cost*cant;
                            }
                        }
                        //If que te muestra las opciones de los refrescos
                        if (opcion==3) {
                            System.out.println("\n////////////////////////////////////////////////////////////");
                            System.out.println("1. Refresco coca_cola: $15");
                            System.out.println("2. Refresco pepsi: $ 16");
                            System.out.println("////////////////////////////////////////////////////////////");
                            System.out.println("Elige la opcion de refresco:");
                            opc=s.nextInt();
                            nombre="Refresco";
                            //while que te manda a pantalla un error y solicita al usuario escribir un valor que este en el menu
                            while(opc<1||opc>2){
                                System.out.println("ERROR:");
                                System.out.println("Elige la opcion de de refresco: (Entre 1 y 2)");
                                 opc=s.nextInt();
                            }
                            if (opc==1) {
                                descripcion= "Coca_cola";
                                cost=15;
                                System.out.println("¿Cuántas quieres?");
                                cant=s.nextInt();
                                aux=cost*cant;
                            }
                            if(opc==2){
                                descripcion="Pepsi";
                                cost=16;
                                System.out.println("¿Cuántas quieres?");
                                cant=s.nextInt();
                                aux=cost*cant;
                            }
                        }
                        //If que te muestra las opciones de los aros de cebolla
                        if (opcion==4) {
                            System.out.println("\n////////////////////////////////////////////////////////////");
                            System.out.println("1. Aros de cebolla chicos: $20");
                            System.out.println("2. Aros de cebolla medianos: $25");
                            System.out.println("3. Aros de cebolla grandes: 30");
                            System.out.println("////////////////////////////////////////////////////////////");
                            System.out.println("Elige la opcion de aros de cebolla:");
                            opc=s.nextInt();
                            nombre="Aros_de_cebolla";
                            //while que te manda a pantalla un error y solicita al usuario escribir un valor que este en el menu
                            while(opc<1||opc>3){
                                System.out.println("ERROR:");
                                System.out.println("Elige la opcion de aros de cebolla: (Entre 1 y 3)");
                                 opc=s.nextInt();
                            }
                            if (opc==1) {
                                descripcion="Chicos";
                                cost=20;
                                System.out.println("¿Cuántas quieres?");
                                cant=s.nextInt();
                                aux=cost*cant;
                            }
                            if (opc==2) {
                                descripcion="Medianos";
                                cost=25;
                                System.out.println("¿Cuántas quieres?");
                                cant=s.nextInt();
                                aux=cost*cant;
                            }
                            if (opc==3) {
                                descripcion="Grandes";
                                cost=30;
                                System.out.println("¿Cuántas quieres?");
                                cant=s.nextInt();
                                aux=cost*cant;
                            }
                        }
                        //If que te muestra las opciones de cervezas
                        if (opcion==5) {
                            System.out.println("\n////////////////////////////////////////////////////////////");
                            System.out.println("1. Cerveza tecate: $30");
                            System.out.println("2. Cerveza modelo: $28");
                            System.out.println("////////////////////////////////////////////////////////////");
                            System.out.println("Elige la opcion de cerveza: ");
                            opc=s.nextInt();
                            nombre="Cerveza";
                            //while que te manda a pantalla un error y solicita al usuario escribir un valor que este en el menu
                            while(opc<1||opc>2){
                                System.out.println("ERROR:");
                                System.out.println("Elige la opcion de cerveza: (Entre 1 y 2)");
                                 opc=s.nextInt();
                            }
                             if (opc==1) {
                                descripcion= "Tecate";
                                cost=30;
                                System.out.println("¿Cuántas quieres?");
                                cant=s.nextInt();
                                aux=cost*cant;
                            }else{
                                descripcion="Modelo";
                                cost=28;
                                System.out.println("¿Cuántas quieres?");
                                cant=s.nextInt();
                                aux=cost*cant;
                            }
                             
                        }
                        //se les asigna el valor a las variables que se enviaran al nodo
                        cantidad=Integer.toString(cant);
                             costo= Float.toString(cost);
                             precio=Float.toString(aux);
                             //se mandan  los valores  al nuevo nodo
                        pedido.agregarProd(nombre,descripcion, cantidad, costo, precio);
                        break;
                   //Caso 2 donde te muestra los productos que llevas, y si no te mostrara que no hay productos     
                    case 2:
                         if (pedido.getTamanio() ==0) {
                             System.out.println(pedido.getTamanio());
                             System.out.println("\n#####################");
                             System.out.println("NO HAY PRODUCTOS");
                             System.out.println("#####################");
                        }else{
                            pedido.listar();
                        }
                        break;
                    //Caso 3 donde elimina un producto de la lista
                    case 3:
                        //pido el nombre
                        int eliminarPro = 0;
                        System.out.println("Escribe el número del pedido que quieras eliminar: ");
                        eliminarPro= s.nextInt();
                        //se le resta uno, ya que internamente la lista inicia en la posicion cero
                        //y en pantalla se muestra que la lista inicia en la pocision 1.
                        pedido.eliminar(eliminarPro-1);
                        
                        break;
                    //Elimina todos los productos de la lista    
                    case 4:
                        pedido.eliminarLista();
                        break;
                     //opcion para salir del programa
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                        }
        }
      }
}


