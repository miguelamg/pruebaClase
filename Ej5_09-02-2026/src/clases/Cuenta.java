/*
Crea una clase Cuenta (bancaria) con atributos para el número de cuenta (un entero largo), 
el DNI del cliente (String), el saldo actual y el interés anual que se aplica a la cuenta (porcentaje). 

Constructor por defecto y constructor con DNI, saldo e interés.

Getters y setters: Para el número de cuenta no habrá setter. El resto de campos tendrán getters y setters.

Métodos:
- actualizarSaldo(): actualizará el saldo de la cuenta aplicándole el interés diario (interés anual dividido entre 365 aplicado al saldo actual).
- ingresar(int): permitirá ingresar una cantidad en la cuenta.
- retirar(int): permitirá sacar una cantidad de la cuenta (si hay saldo, de lo contrario lanzar una excepción).
- Método que nos permita mostrar todos los datos de la cuenta.

El número de cuenta se asignará de forma correlativa a partir de 100001, asignando el siguiente número al último asignado.
 */

package clases;

public class Cuenta 
{
	// Constructores
	// -------------
	public Cuenta() throws CuentaException
	{
		this("", 0L, 0F);
	}
	public Cuenta(String p_dni, long p_saldo, float p_interes) throws CuentaException
	{
		// this.numero = Cuenta.idCuenta;
		// Cuenta.idCuenta++;
		this.numero = Cuenta.idCuenta++;
		
		setDni(p_dni);
		setSaldo(p_saldo);
		setInteres(p_interes);
	}
	
	// Campos
	// ------
	private static long idCuenta = 100001; 
	private long numero;
	
	private long saldo;
	private String dni;
	private float interes;
	
	// Métodos
	// -------
	// - De instancia de esta clase
	public void actualizarSaldo() throws CuentaException
	{
		setSaldo( (int) (getSaldo() + getSaldo() * getInteres() / 100) );
	}
	
	public long ingresar(long p_cantidad) throws CuentaException
	{
		if(p_cantidad > 0)
		{
			setSaldo(getSaldo() + p_cantidad);
		}
		else
		{
			throw new CuentaException("No se ha ingresado el dinero. La cantidad debe ser un valor positivo");
		}
		
		return p_cantidad;
	}
	
	public void retirar(long p_cantidad) throws CuentaException
	{
		if(getSaldo() >= p_cantidad)
		{
			setSaldo(getSaldo() - p_cantidad);
		}
		else
		{
			throw new CuentaException("No se ha podido retirar el dinero. No hay saldo suficiente");
		}
	}
	
	private boolean validarDni(String p_dni)
	{
		boolean ok = true;
		String cadena = "TRWAGMYFPDXBNJZSQVHLCKE";
		char letraOk;
		char letraUsuario;
		int posicion;
		int numeroSinLetra;
		
		// Validamos el DNI
		if(p_dni.length() != 9)
		{
			ok = false;
		}
		else
		{
			letraUsuario = p_dni.toUpperCase().charAt(8);  // 33344477J
			//								  			    012345678 9

			numeroSinLetra = Integer.valueOf( p_dni.substring(0, p_dni.length()-1) );
			posicion = numeroSinLetra % cadena.length(); 
			
			letraOk = cadena.charAt(posicion);
			
			if(letraOk != letraUsuario)
			{
				ok = false;
			}
		}
		
		return ok;
	}
	
	// - Métodos invalidados 
	@Override
	public String toString()
	{
		return "NUM. CTA: " + getNumero() + "\n"
				+ "SALDO: " + getSaldo() + "\n"
				+ "INTERÉS: " + getInteres() + "\n"
				+ "DNI TIT.: " + getDni() + "\n";
	}
	
	// - Getters y setters
	public long getSaldo() {
		return saldo;
	}
	public void setSaldo(long saldo) throws CuentaException 
	{
		// Esta cuenta bancaria no admite saldo negativo
		if(saldo >= 0)
		{
			this.saldo = saldo;	
		}
		else
		{
			throw new CuentaException("El saldo inicial de la cuenta no puede ser negativo");
		}
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) throws CuentaException 
	{
		// Si es correcto guardamos el dato en el campo
		if(dni.equals(""))
		{
			this.dni = dni;	
		}
		else if(validarDni(dni) == true)
		{
			this.dni = dni;	
		}
		else // si es incorrecto lanzamos una excepción
		{
			throw new CuentaException("DNI incorrecto.");
		}
	}
	
	public float getInteres() {
		return interes;
	}
	public void setInteres(float interes) {
		this.interes = interes;
	}
	
	public long getNumero() 
	{
		return numero;
	}

	
}





