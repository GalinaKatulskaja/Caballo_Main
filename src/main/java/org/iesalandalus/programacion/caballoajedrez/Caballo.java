/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.caballoajedrez;

/**
 *
 * @author Galina
 */
public class Caballo {
    
     /* Creamos la clase Caballo, cuyos atributos son; color (del tipo enumerado Color)
    y posicion (de la clase Posicion)*/
    
    private Color color;
    private Posicion posicion;
    
    //Creamos un constructor por defecto para la clase Caballo que cree un caballo negro en la posición '8b'
    public Caballo()
    {
        color = Color.NEGRO;
        posicion = new Posicion(8,'b');
    }
    
    //Creamos los métodos get y set para cada atributo

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
    
    
    
}
