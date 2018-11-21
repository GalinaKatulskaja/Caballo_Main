package org.iesalandalus.programacion.caballoajedrez;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

    private static Caballo caballo;
    private static Color color;
    private static Posicion posicion;
    private static Direccion direccion;
    private static String ERROR_MOVIMIENTO;
    private static Posicion columna;
    
	public static void main(String[] args) throws OperationNotSupportedException 
        {
            int opcion;
            System.out.println("Programa para aprender a colocar y mover un caballo en el tablero de ajedrez");
	  
                do{
                    //Mostramos el menú con las distintas opciones del programa
                    mostrarMenu();
                    //Pedimos al usuario que elija una opción
                    opcion=elegirOpcion();
                    
                    //Ejecutamos la opción elegida por el usuario
                    ejecutarOpcion(opcion);
                   }while(opcion!=0);
            System.out.println("El juego se ha terminado corectamente");
        }
        
        /**
        * Método que nos muestra el menú de opciones
        */
        private static void mostrarMenu()
        {
                
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("         ~ELIGE LA OPCIÓN~        ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1) Crear caballo por defecto.");
            System.out.println("2) Crear caballo por defecto color.");
            System.out.println("3) Crear caballo color y posición");
            System.out.println("4) Elegir dirección." ); 
            System.out.println("5) Mover caballo.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
            System.out.println("0)Salida." );

     
        }
  
            /**
         * Método que valida y nos devuelve la opción elegida por el usuario
         * @return opcion
         */
        private static int elegirOpcion()
        {    
            int opcion;
            //Comprobamos que la opcion elegida es válida
            do{
                System.out.println("Elije la opción de 1 a 8");
                opcion=Entrada.entero();
                
            }while(opcion<0 || opcion>5);
 
            return opcion;     
        }
        
            /**
         * Método que ejecuta la opción elegida por el usuario llamando
         * al método asociado a la opción
         * @param opcion 
         */
        private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException
        {
            switch(opcion)
            {

                case 1:
                    crearCaballoDefecto();//Elmetodo que crea el caballo por defecto
                    break;
                case 2:
                    crearCaballoDefectoColor(); //El metodo que crea el caballo por defecto de color NEGRO
                    break;
                case 3:
                    crearCaballoColorPosicion(); //El metodo que crea un caballo con la posibilidad de elegir su color y posicion 
                    break;
                case 4:
                   elegirDireccion();// El metodo que nos muestra los opciones, que direccion puede toma el caballo
                    break;
                case 5:
                    move();// El metodo que ejecuta el movimiento del caballo
                    break;
                default:
                    break;
            }
        }
            
        /**
         * El metodo que crea el caballo por defecto
         */  
        private static void crearCaballoDefecto()
        {
            caballo = new Caballo();
                
            System.out.println("El caballo creado correctamente");
            System.out.println("-------------------------------");
            System.out.println(caballo);
            System.out.println("-------------------------------");
        }   
            /**
             * El metodo que crea el caballo por defecto de color 
             */
        private static void crearCaballoDefectoColor() throws OperationNotSupportedException
        {  
            
            elegirColor(); 
            caballo = new Caballo( color);

            System.out.println("-------------------------------");
            System.out.println("El caballo " + color );
            System.out.println("El caballo creado correctamente");
        }
        /**
         * El metodo que crea y devuleve el Color del caballo
         * @return color
         */
        private static Color elegirColor()
        {
            int opcion;
            do{
                //Pedimos a usuario que selecciona un color
                System.out.println("Elige el color de caballo: 1) BLANCO, 2) NEGRO");
                opcion=Entrada.entero();
                }while(opcion<1 || opcion>2);
            //Comprobamos la opción introducida por el usuario, y depende del número devolvemos el color 
            switch(opcion)
            {
               case 1://Blanco
                    color = Color.BLANCO;
                    break;
                case 2:// Negro
                    color = Color.NEGRO;
                    break;        
            }
            return color;
        }
        // El metodo que crea un caballo con la posibilidad de elegir su color y posicion 
        private static void crearCaballoColorPosicion() throws OperationNotSupportedException
        {
            
            elegirColor(); 
            elegirColumnaInicial();
           // char columnaInicial=;
            caballo=new Caballo(color,posicion.getColumna());
            System.out.println("El caballo creado correctamente");
            System.out.println("-------------------------------");
            System.out.println("El caballo es de color " + color + " la columna inicial es " + posicion.getColumna());
            System.out.println("El caballo esta en la " +posicion);
        }
        //EL metodo que crea el la columna inicial del caballo    
        private static char elegirColumnaInicial() throws OperationNotSupportedException 
        {
            char columnaInicial;
            do{
                
                System.out.println("Introduce un caracter g, b");
                columnaInicial = Entrada.caracter();
                }while(columnaInicial!='b'&& columnaInicial!='g');
                    

                     if(columnaInicial=='b' & color==Color.BLANCO)
                        {
                           posicion= new Posicion(1,'b');
                           columnaInicial=posicion.getColumna();
                            
                        }
                         if(columnaInicial=='b' & color == Color.NEGRO)
                         {
                            posicion= new Posicion(8,'b');
                            columnaInicial=posicion.getColumna();
                         }
                         if(columnaInicial=='g'& color==Color.BLANCO)
                         {
                            posicion= new Posicion(1,'g');
                            columnaInicial=posicion.getColumna();
                         }
                         if(columnaInicial=='g'  & color == Color.NEGRO)
                         {
                           posicion= new Posicion(8,'g');
                             columnaInicial=posicion.getColumna();
                         }
                     System.out.println("La columna inicial es " + columnaInicial +" y su " + posicion);
            return columnaInicial;
            
        }
        //El metodo que determina si el movimiento es valido o no
        private static void move() throws OperationNotSupportedException
        {
            mostrarMenuDirecciones();
           int opcion;
        try{
            do{
                System.out.println("Introduce la dirección de 1 a 8");
                opcion=Entrada.entero();

                }while(opcion<1 || opcion>8);
                switch(opcion){
                    case 1:
                        caballo.mover(Direccion.ARRIBA_DERECHA);                        
                        break;
                    case 2:
                         caballo.mover(Direccion.ARRIBA_IZQUIERDA);
                    case 3:
                        caballo.mover(Direccion.DERECHA_ARRIBA);
                        break;
                    case 4:
                         caballo.mover(Direccion.DERECHA_ABAJO);
                        break;
                    case 5:
                        caballo.mover(Direccion.ABAJO_DERECHA);
                        break;
                    case 6:
                        caballo.mover(Direccion.ABAJO_IZQUIERDA);
                        break;
                    case 7:
                       caballo.mover(Direccion.IZQUIERDA_ARRIBA);
                        break;
                    case 8:
                         caballo.mover(Direccion.IZQUIERDA_ABAJO);
                        break;
            }
        }catch (OperationNotSupportedException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                System.out.println(caballo);
        }
        //Mostramos el menu de direcciones al usuario    
        private static void mostrarMenuDirecciones()
        {
            System.out.println("-----------------------");
            System.out.println("--Menu de Direcciones--");
            System.out.println("-----------------------");
            System.out.println(" 1) ARRIBA_DERECHA");
            System.out.println(" 2) ARRIBA_IZQUIERDA");
            System.out.println(" 3) DERECHA_ARRIBA");
            System.out.println(" 4) DERECHA_ABAJO");
            System.out.println(" 5) ABAJO_DERECHA");
            System.out.println(" 6) ABAJO_IZQUIERDA");
            System.out.println(" 7) IZQUIERDA_ARRIBA");
            System.out.println(" 8) IZQUIERDA_ABAJO");
            System.out.println("-----------------------");
        }
        //El metodo que nos permite seleccionar la dirección en la cual queremos mover elcaballo    
        private static Direccion elegirDireccion()
        {    
            mostrarMenuDirecciones();
            int opcion;
            
            do{
                System.out.println("Introduce la dirección de 1 a 8");
                
                opcion=Entrada.entero();

                }while(opcion<1 || opcion>8);

                switch(opcion)
                {
                    case 1:
                        direccion= Direccion.ARRIBA_DERECHA;                        
                        break;
                    case 2:
                         direccion=Direccion.ARRIBA_IZQUIERDA;
                    case 3:
                        direccion=Direccion.DERECHA_ARRIBA;
                        break;
                    case 4:
                         direccion=Direccion.DERECHA_ABAJO;
                        break;
                    case 5:
                        direccion=Direccion.ABAJO_DERECHA;
                        break;
                    case 6:
                        direccion=Direccion.ABAJO_IZQUIERDA;
                        break;
                    case 7:
                       direccion=Direccion.IZQUIERDA_ARRIBA;
                        break;
                    case 8:
                         direccion=Direccion.IZQUIERDA_ABAJO;
                        break;
                }
               
                System.out.println("Mover caballo a la dirección: " + direccion);
                
            return direccion;    
        }               

}        
          
              
