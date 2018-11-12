/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.caballoajedrez;

/**
 *
 * @author Galina
 * 
 * //Crea la clase Posicion. Crea los atributos fila (int) y columna (char)
 */
public class Posicion {
    private int fila;
    private char columna;
    
    
    /*Creamos los métodos get y set para los atributos:
    (las filas van del 1 al 8 -ambos inclusive- y las columnas 
    de la 'a' a la 'h' -ambos inclusive-)  y si no se lance 
    una excepción del tipo IllegalArgumentException con el mensaje. */
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        if(fila<1 | fila>8)
        {
            throw new IllegalArgumentException ("ERROR - La fila introducida no es correcta");
        }
        else
        {
        this.fila = fila;
        }
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        if(columna!='a'& columna!='b' & columna!='c'& columna!='d' & columna!='e' & columna!='f' & columna!='g' & columna!='h')
        {
            throw new IllegalArgumentException ("ERROR - La columna introducida no es correcta");
        }
        else
        {
        this.columna = columna;
        }
    }
    
}
