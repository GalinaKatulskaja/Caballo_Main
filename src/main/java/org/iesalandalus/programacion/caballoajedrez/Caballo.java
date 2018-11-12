/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.caballoajedrez;

import java.util.Objects;
import javax.naming.OperationNotSupportedException;

/**
 *
 * @author Galina
 */
public class Caballo {
    
     /* Creamos la clase Caballo, cuyos atributos son; color (del tipo enumerado Color)
    y posicion (de la clase Posicion)*/
    
    private Color color;
    private Posicion posicion;
    private static final String ERROR_MOVIMIENTO = "Movimiento no permitido: ";
    
    //Creamos un constructor por defecto para la clase Caballo que cree un caballo negro en la posición '8b'
    public Caballo()
    {
        color = Color.NEGRO;
        posicion = new Posicion(8,'b');
    }
    
    
    /*Creamos un constructor para la clase Caballo que acepte como parámetro el color
    que creará un caballo de dicho color cuya posición será '1b' si es blanco 
    o '8b' si es negro*/
     public Caballo(Color color)
     {
       this.color=color;
            
             switch(color){
                 case BLANCO:
                     posicion=new Posicion(1,'b');
                     break;
                 case NEGRO:
                     posicion=new Posicion(8,'b');
                     break;
             }
     }
     //Creamos un Constructor para la clase Caballo que acepte como parámetros el color y la columnaInicial
     
     public Caballo(Color color, char columnaInicial)
        {
            this.color=color;
            
             switch(color){
                 case BLANCO:
                     posicion=new Posicion(1,'b');
                     break;
                 case NEGRO:
                     posicion=new Posicion(8,'b');
                     break;
                    
             }
             if(columnaInicial!='b'& columnaInicial!='g')
        {
            throw new IllegalArgumentException ("ERROR: La columna introducida no es correcta");
        }
         
         if(columnaInicial=='b'& this.color==Color.BLANCO)
         {
             this.posicion= new Posicion(1,'b');
         }
         
         if(columnaInicial=='b'& this.color==Color.NEGRO)
         {
             this.posicion= new Posicion(8,'b');
         }
         
         if(columnaInicial=='g'& this.color==Color.BLANCO)
         {
             this.posicion= new Posicion(1,'g');
         }
         
         if(columnaInicial=='g'& this.color==Color.NEGRO)
         {
             this.posicion= new Posicion(8,'g');
         }
    }
     
     
     /*Crea el método mover que dependiendo del movimiento modificará la
posición del mismo o si no puede realizar dicho movimiento debe lanzar una
excepción del tipo OperationNotSupportedException con un mensaje adecuado
y no modificará la posición del caballo.*/
     public void moverCaballo(Direccion direccion, int x, char y) throws OperationNotSupportedException 
     {
        if (direccion == null) {
			throw new IllegalArgumentException("La dirección no puede ser nula.");
		}
		if ((posicion.getFila()) <= 0 && posicion.getColumna()<=0) {
			throw new IllegalArgumentException("El número de pasos debe ser mayor que cero.");
		}
		switch (direccion) {
			case ARRIBA_DERECHA:
                              
                                try {
                                        posicion.setFila(posicion.getFila()+2);
                                        posicion.setColumna((char) (posicion.getColumna()+1));
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException(ERROR_MOVIMIENTO);
				}
				break;
			case ARRIBA_IZQUIERDA:
				try {
					posicion.setFila(posicion.getFila()+2);
                                        posicion.setColumna((char) (posicion.getColumna()-1));
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException(ERROR_MOVIMIENTO);
				}
				break;
			case DERECHA_ARRIBA:
				try {
                                        posicion.setColumna((char) (posicion.getColumna()+2));
                                        posicion.setFila(posicion.getFila()+1);
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException(ERROR_MOVIMIENTO);
				}
				break;
                        case DERECHA_ABAJO:
				try {
					posicion.setColumna((char) (posicion.getColumna()+2));
                                        posicion.setFila(posicion.getFila()-1);
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException(ERROR_MOVIMIENTO);
				}
				break;
			case IZQUIERDA_ARRIBA:
				try {
					posicion.setColumna((char) (posicion.getColumna()-2));
                                        posicion.setFila(posicion.getFila()+1);
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException(ERROR_MOVIMIENTO);
				}
				break;
                        case IZQUIERDA_ABAJO:
				try {
					posicion.setColumna((char) (posicion.getColumna()-2));
                                        posicion.setFila(posicion.getFila()-1);
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException(ERROR_MOVIMIENTO);
				}
				break;
                        case ABAJO_IZQUIERDA:
				try {
					posicion.setFila(posicion.getFila()-2);
                                        posicion.setColumna((char) (posicion.getColumna()-1));
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException(ERROR_MOVIMIENTO);
				}
				break;
                        case ABAJO_DERECHA:
				try {
					posicion.setFila(posicion.getFila()-2);
                                        posicion.setColumna((char) (posicion.getColumna()+1));;
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException(ERROR_MOVIMIENTO);
				}
				break;
                                
			default:
				break;
		}
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
    
    
    //Crea el método equals para comparar la igualdad de objetos de la clase. 

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.color);
        hash = 79 * hash + Objects.hashCode(this.posicion);
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
        final Caballo other = (Caballo) obj;
        if (this.color != other.color) {
            return false;
        }
        if (!Objects.equals(this.posicion, other.posicion)) {
            return false;
        }
        return true;
    }
    
    
    /*Crea el método toString que devuelva un String que será la representación
    de dicho objeto (color y posición).*/

    @Override
    public String toString() {
        return "Caballo{" + "color=" + color + ", posicion=" + posicion + '}';
    }
    
    
    
}
