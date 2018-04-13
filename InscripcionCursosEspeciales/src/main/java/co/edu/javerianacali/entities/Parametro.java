/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javerianacali.entities;

/**
 *
 * @author jamespayan
 */
public class Parametro {
       String nombre;
       Object value;
       
       public Parametro(String nombre, Object value) {
             this.nombre = nombre;
             this.value = value;
       }
       public String getNombre() {
             return nombre;
       }
       public void setNombre(String nombre) {
             this.nombre = nombre;
       }
       public Object getValue() {
             return value;
       }
       public void setValue(Object value) {
             this.value = value;
       }
}

