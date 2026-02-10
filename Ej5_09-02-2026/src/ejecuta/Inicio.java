// Último cambio 10/02/2026 
package ejecuta;

import java.util.Scanner;

import clases.Cuenta;
import clases.CuentaException;

public class Inicio
{ 
	public static void main(String[] args) 
	{
		// Declaramos las variables
		// ------------------------
		String menu = "MENU CUENTA\n"
					+ "-----------\n"
					+ "1. Abrir cuenta bancaria\n"
					+ "2. Ingresar dinero\n"
					+ "3. Retirar dinero\n"
					+ "4. Consultar saldo\n"
					+ "5. Liquidar intereses\n"
					+ "6. Salir\n"
					+ "Introduce una opción: ";
		
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		Cuenta miCuenta = null;
		long dinero;
		long dineroIngresado;
		final String MENSAJE = "No dispones de una cuenta bancaria. No se ha realizado la operación."; 
		
		do
		{
			try
			{
				System.out.println(menu);
				opcion = Integer.valueOf( sc.nextLine() );
				
				switch(opcion)
				{
					case 1:
						miCuenta = new Cuenta();
						
						System.out.println("Introduce tu DNI (8 números seguidos de una letra): ");
						miCuenta.setDni( sc.nextLine() );
						
						miCuenta.setSaldo(0);
						miCuenta.setInteres( 10F ); // el banco ofrece un interés de 0.125F
						
						System.out.println("Enhorabuena, has abierto tu cuenta.");
					break;
					
					case 2:
						if(miCuenta != null)
						{
							System.out.println("Introduce la cantidad que deseas ingresar: ");
							dinero = Long.valueOf( sc.nextLine() );
							dineroIngresado = miCuenta.ingresar(dinero);
							
							System.out.println("Confirmación: has ingresado " + dineroIngresado + " euros");							
						}
						else
						{
							System.out.println(MENSAJE);
						}
					break;
					
					case 3:
						if(miCuenta != null)
						{
							System.out.println("Introduce la cantidad que deseas retirar: ");
							dinero = Long.valueOf( sc.nextLine() );
							
							miCuenta.retirar(dinero);
							System.out.println("Confirmación: Dinero retirado con éxito. Su saldo es " + miCuenta.getSaldo() + "€");							
						}
						else
						{
							System.out.println(MENSAJE);
						}
					break;
					
					case 4:
						if(miCuenta != null)
						{
							dinero = miCuenta.getSaldo();
							System.out.println("El saldo es de " + dinero + "€");							
						}
						else
						{
							System.out.println(MENSAJE);
						}
						break;

					case 5:
						if(miCuenta != null)
						{
							miCuenta.actualizarSaldo();
							System.out.println("Confirmación: Intereses anuales liquidados.");
							System.out.println("Su saldo es de " + miCuenta.getSaldo() + "€");							
						}
						else
						{
							System.out.println(MENSAJE);
						}
					break;
					
					case 6:
						System.out.println("Gracias. Hasta pronto.");
					break;
					
					default:
					System.out.println("Opción incorrecta.");
				}				
			}
			catch(NumberFormatException e)
			{
				System.out.println("La opción del menú debe ser numérica");
			}
			catch(CuentaException e)
			{
				System.out.println( e.getMessage() );
			}
			catch(Exception e) 
			{
				System.out.println("Esto no debería estar pasando. Si sucede de nuevo, contacte con el administrador");
			}
		}while(opcion != 6);
			
		sc.close();
	}
}
