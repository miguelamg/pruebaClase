package clases;

import java.io.PrintWriter;
import java.io.StringWriter;

@SuppressWarnings("serial")
public class CafeteraException extends Exception
{
	public CafeteraException(String p_mensaje)
	{
		super(p_mensaje);
	}
	
	public String detalleError()
	{
		StringWriter sw = new StringWriter();
		
		this.printStackTrace( new PrintWriter(sw) );
		String cadena = sw.toString();
		
		return cadena;		
	}
}
