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
public final class Caballo {
    
     /* Creamos la clase Caballo, cuyos atributos son; color (del tipo enumerado Color)
    y posicion (de la clase Posicion)*/
    private Color color;
    private Posicion posicion;
    private static final String ERROR_MOVIMIENTO = "Movimiento no permitido: ";

    private Caballo caballo;
    

    //Creamos un constructor por defecto para la clase Caballo que cree un caballo negro en la posición '8b'
        public Caballo()
        {
            this.color = Color.NEGRO;
            this.posicion = new Posicion(8,'b');

        }
   
       /* public Caballo (final Caballo caballo)
        {
            this.color=caballo.color;
            this.posicion = caballo.posicion;
        }*/
        
         /*Creamos un constructor para la clase Caballo que acepte como parámetro el color
    que creará un caballo de dicho color cuya posición será '1b' si es blanco 
    o '8b' si es negro*/
    /**
     * 
     * @param color 
     * BLANCO
     * NEGRO
     */
     public Caballo(Color color)
     {
         setColor(color);
     }
     //Creamos un Constructor para la clase Caballo que acepte como parámetros el color y la columnaInicial
     /**
      * @param color
      * @param columnaInicial
      */
     public Caballo(Color color, char columnaInicial) throws OperationNotSupportedException
     {
         setColor(color);
         
         if( columnaInicial == 0)
        {
            throw new IllegalArgumentException ("ERROR: La columna introducida no es correcta");
        }
            if(columnaInicial!='b' && columnaInicial!='g')
            {
                throw new IllegalArgumentException ("ERROR: La columna introducida no es correcta");
            }
            //Comprobamos de que color el caballo, en caso de no tener ninguno se lanza la excepción      
        // Asignamos la columna Inicial al caballo   
        try{
                 if(columnaInicial=='b' & color==Color.BLANCO)
                        {
                            
                           posicion= new Posicion(1,'b');
                        }
                         if(columnaInicial=='b' & color == Color.NEGRO)
                         {
                             posicion= new Posicion(8,'b');
                         }
                         if(columnaInicial=='g'& color==Color.BLANCO)
                         {
                            posicion= new Posicion(1,'g');
                         }
                         if(columnaInicial=='g'  & color == Color.NEGRO)
                         {
                             posicion= new Posicion(8,'g');
                         }
        }     catch (IllegalArgumentException e) {
                System.out.println("EL MOVIMIENTO NO ES VALIDO");
                throw new OperationNotSupportedException(ERROR_MOVIMIENTO + e.getMessage());
            }    
    }
     
     
     /*Crea el método mover que dependiendo del movimiento modificará la
posición del mismo o si no puede realizar dicho movimiento debe lanzar una
excepción del tipo OperationNotSupportedException con un mensaje adecuado
y no modificará la posición del caballo.*/
    public void mover(Direccion direccion) throws OperationNotSupportedException 
    {
        
        if (direccion == null) 
        {
            throw new IllegalArgumentException("La dirección no puede ser nula.");
	}
           /* if ((posicion.getFila()) <= 0 && posicion.getColumna()<=0) 
            {
                throw new IllegalArgumentException("El número de pasos debe ser mayor que cero.");
            }*/
                switch (direccion) 
                {
                    case ARRIBA_DERECHA:

                        try {
                                posicion.setFila(posicion.getFila()+2);
                                posicion.setColumna((char) (posicion.getColumna()+1));
                            } catch (IllegalArgumentException e) {
                                System.out.println("EL MOVIMIENTO NO ES VALIDO");
                                throw new OperationNotSupportedException(ERROR_MOVIMIENTO + e.getMessage());
                            }
                                break;
                    case ARRIBA_IZQUIERDA:
                        try {
                                posicion.setFila(posicion.getFila()+2);
                                posicion.setColumna((char) (posicion.getColumna()-1));
                            } catch (IllegalArgumentException e) {
                                throw new OperationNotSupportedException(ERROR_MOVIMIENTO + e.getMessage() );
                            }
                                break;
                    case DERECHA_ARRIBA:
                        try {
                                posicion.setColumna((char) (posicion.getColumna()+2));
                                posicion.setFila(posicion.getFila()+1);
                            } catch (IllegalArgumentException e) {
                                throw new OperationNotSupportedException(ERROR_MOVIMIENTO + e.getMessage());
                            }
                                break;
                    case DERECHA_ABAJO:
                        try {
                                posicion.setColumna((char) (posicion.getColumna()+2));
                                posicion.setFila(posicion.getFila()-1);
                            } catch (IllegalArgumentException e) {
                                throw new OperationNotSupportedException(ERROR_MOVIMIENTO + e.getMessage());
                            }
                                break;
                    case IZQUIERDA_ARRIBA:
                        try {
                                posicion.setColumna((char) (posicion.getColumna()-2));
                                posicion.setFila(posicion.getFila()+1);
                            } catch (IllegalArgumentException e) {
                                throw new OperationNotSupportedException(ERROR_MOVIMIENTO + e.getMessage());
                            }
                                break;
                    case IZQUIERDA_ABAJO:
                        try {
                                posicion.setColumna((char) (posicion.getColumna()-2));
                                posicion.setFila(posicion.getFila()-1);
                            } catch (IllegalArgumentException e) {
                                throw new OperationNotSupportedException(ERROR_MOVIMIENTO + e.getMessage());
                            }
                                break;
                    case ABAJO_IZQUIERDA:
                        try {
                                posicion.setFila(posicion.getFila()-2);
                                posicion.setColumna((char) (posicion.getColumna()-1));
                            } catch (IllegalArgumentException e) {
                                throw new OperationNotSupportedException(ERROR_MOVIMIENTO + e.getMessage());
                            }
                                break;
                    case ABAJO_DERECHA:
                        try {
                                posicion.setFila(posicion.getFila()-2);
                                posicion.setColumna((char) (posicion.getColumna()+1));
                            } catch (IllegalArgumentException e) {
                                throw new OperationNotSupportedException(ERROR_MOVIMIENTO + e.getMessage());
                            }
                                break;
                }
    }
    //Creamos los métodos get y set para cada atributo
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) 
    {
        this.color=color;
        if(color==null)
        {
            throw new IllegalArgumentException ("ERROR: La columna introducida no es correcta");
        }
            switch(color)
            {
                 case BLANCO:
                    this.color=Color.BLANCO;
                    posicion=new Posicion(1,'b');
                     break;
                 case NEGRO:
                    this.color=Color.NEGRO;
                    posicion=new Posicion(8,'b');
                     break;
             }
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
       if (posicion == null) 
        {
            throw new IllegalArgumentException("La posición no puede ser nula.");
	}else
       
            this.posicion = new Posicion(posicion);
       
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
