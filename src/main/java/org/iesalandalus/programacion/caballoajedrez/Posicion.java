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
    
    /*Creamos un constructor para la clase Posicion con parámetros 
    fila y columna y que los asigne a los atributos si son correctos
    y si no lance una excepción IllegalArgumentException*/
    public Posicion(int fila, char columna)
    {
        setFila(fila);
        setColumna(columna);
    }
    
    //Creamos el constructor copia para esta clase.
    
    public Posicion(Posicion copia)
    {
        this.fila=copia.fila;
        this.columna=copia.columna;
    }
    
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
    
     //Creamos el método equals para comparar la igualdad de dos objetos de esta clase.

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.fila;
        hash = 17 * hash + this.columna;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Posicion other = (Posicion) obj;
        if (this.fila != other.fila) {
            return false;
        }
        if (this.columna != other.columna) {
            return false;
        }
        return true;
    }
    
    //Creamos el método toString que devolverá un String y será la representación de la fila y la columna.

    @Override
    public String toString() {
        return "Posicion{" + "fila=" + fila + ", columna=" + columna + '}';
    }
    
    
    
    
    
    
}
