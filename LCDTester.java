import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LCDTester
{
	//Entrada final para comenzar ha imprimir los numeros
    static final String CADENA_FINAL = "0,0";
	private static Scanner lector;

    public static void main(String[] args)
    {
    	lector = new Scanner(System.in);
    	ImpresorLCD impresorLCD = new ImpresorLCD();

        // Establece los segmentos de cada numero
        List<String> listaComando = new ArrayList<>();

        //variables
        String comando;
        int espacioDig;

        try
        {
        	System.out.print("Espacio entre Digitos (0 a 5): ");
        	comando = lector.nextLine();

             // Valida si es un numero
             if (ImpresorLCD.isNumeric(comando))
             {

                 espacioDig = Integer.parseInt(comando);

                 // se valida que el espaciado este entre 0 y 5
                 if(espacioDig <0 || espacioDig >5)
                 {
                	 throw new IllegalArgumentException("El espacio entre "
                                + "digitos debe estar entre 0 y 5");
                  }
              }
              else
              {
            	  throw new IllegalArgumentException("Cadena " + comando
                            + " no es un entero, esta vacia o contiene espacios");
              }

              //Inserta cada entrada a la lista
              do
              {

                  System.out.print("Entrada: ");
                  comando = lector.next();
                  if(!comando.equalsIgnoreCase(CADENA_FINAL))
                  {

                      listaComando.add(comando);
                  }

              }while (!comando.equalsIgnoreCase(CADENA_FINAL));


              //Iterador de la lista de entradas
              Iterator<String> iterator = listaComando.iterator();

              while (iterator.hasNext())
             {
                 try
                 {
                     impresorLCD.procesoEntradas(iterator.next(), espacioDig);
                 }
                 catch (Exception ex)
                 {
                     System.out.println("Error1: "+ex.getMessage());
                 }
             }
        }
        catch (Exception ex)
        {
            System.out.println("Error2: "+ex.getMessage());
        }

    }

}
