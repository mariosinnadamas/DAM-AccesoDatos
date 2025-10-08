/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios15.pokemon.excepciones;

/**
 *
 * @author Sergio Cuesta
 */
public class DataDestFullException extends Exception {
    public DataDestFullException(){
        super("El almacén esta lleno");
    }

    public DataDestFullException(String message){
        super(message);
    }

    public DataDestFullException(String message, Throwable cause){
        super(message, cause);
    }
}
