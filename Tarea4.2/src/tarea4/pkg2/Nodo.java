/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tarea4.pkg2;

/**
 * 
 * @author Erick Hernández
 */
public class Nodo {
     // Variables en las cuales se van a guardar los valores.
   String nombre;
   String descripcion;
   String cantidad;
   String costo;
   String precio;
    
    // Variable para enlazar los nodos.
    Nodo siguiente;
   // Constructor que inicializamos el valor de las variables.
/*
    public Nodo() {
        descripcion = "";
        cantidad = "";
        costo = "";
        precio = "";
        siguiente = null;
    }*/

    public Nodo(String nombre, String descripcion, String cantidad, String costo, String precio) {
        this.nombre= nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costo = costo;
        this.precio = precio;
        this.siguiente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
  
}
