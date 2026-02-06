package clases;

public class Cafetera 
{
	// Constructores
	// -------------
	public Cafetera(int capacidadTotal, int capacidadRestante, int volumenTaza, int volumenVaso) throws CafeteraException 
	{
		setCapacidadTotal(capacidadTotal);
		setCapacidadRestante(capacidadRestante);
		
		setVolumenTaza(volumenTaza);
		setVolumenVaso(volumenVaso);
		
		// La cafetera se encuentra apagada 
		setEstado(false);
	}
	
	// Campos
	// ------
	private int capacidadTotal; 	// cantidad máxima de agua que se puede almacenar en la cafetera
	private int capacidadRestante;  // cantidad de agua que queda en la cafetera
	private int volumenTaza; 		// cantidad de agua que cabe en una taza
	private int volumenVaso; 		// cantidad de agua que cabe en un vaso
	private boolean estado; 		// indica si la cafetera está apagada o encendida
	
	// Métodos
	// -------
	public String servirTaza() throws CafeteraException 
	{
		// Validamos
		// ---------
		// - La cafetera está apagada
		if(getEstado() == false)
		{
			throw new CafeteraException("La cafetera está apagada. No se ha servido la taza.");
		}
		// - No queda agua
		else if( getCapacidadRestante() < getVolumenTaza() )
		{
			throw new CafeteraException("No queda suficienta agua. No se ha servido la taza.");
		}
		// Si todo es correcto servimos la taza...
		else
		{
			setCapacidadRestante(getCapacidadRestante() - getVolumenTaza()); 
			
		}
		
		return "Taza servida";
	}
	
	public String servirVaso() throws CafeteraException
	{
		// Validamos
		// ---------
		// - La cafetera está apagada
		if( getEstado() == false)
		{
			throw new CafeteraException("La cafetera está apagada. No se ha servido el vaso.");
		}
		// - No queda agua
		else if( getCapacidadRestante() < getVolumenVaso() )
		{
			throw new CafeteraException("No queda suficiente agua. No se ha servido el vaso.");
		}
		// - Si todo es correcto servimos el vaso
		else
		{
			setCapacidadRestante(getCapacidadRestante() - getVolumenVaso());
		}
		
		return "Vaso servido";
	}
	
	public void encender()
	{
		setEstado(true);
	}
	
	public void apagar()
	{
		setEstado(false);
	}
	
	public void rellenar() throws CafeteraException
	{
		setCapacidadRestante( getCapacidadTotal() );
	}
	
	public String mostrarCapacidad()
	{
		return "Queda(n) " + getCapacidadRestante() + " ml de agua";
	}
	
	// - Getters y setters	
	public int getCapacidadTotal() 
	{
		return capacidadTotal;
	}
	public void setCapacidadTotal(int capacidadTotal) 
	{
		this.capacidadTotal = capacidadTotal;
	}
	
	public int getCapacidadRestante() 
	{
		return capacidadRestante;
	}
	public void setCapacidadRestante(int capacidadRestante) throws CafeteraException 
	{
		if(capacidadRestante > getCapacidadTotal())
		{
			throw new CafeteraException("Campo CAPACIDAD RESTANTE incorrecto. No puede superar la capacidad de la cafetera.");
		}
		else
		{
			this.capacidadRestante = capacidadRestante;	
		}
	}
	
	public int getVolumenTaza() 
	{
		return volumenTaza;
	}
	public void setVolumenTaza(int volumenTaza) 
	{
		this.volumenTaza = volumenTaza;
	}
	
	public int getVolumenVaso() 
	{
		return volumenVaso;
	}
	public void setVolumenVaso(int volumenVaso) 
	{
		this.volumenVaso = volumenVaso;
	}

	public boolean getEstado() 
	{
		return estado;
	}
	public void setEstado(boolean estado) 
	{
		this.estado = estado;
	}
	
}
