package clases;

public class Alumno 
{
	public Alumno() 
	{
	}
	
	public Alumno(int idMatricula, String nombre) 
	{
		this.idMatricula = idMatricula;
		this.nombre = nombre;
	}
	
	public int idMatricula;
	public String nombre;
	
	@Override
	public String toString() 
	{
		return "ID MATRICULA: " + this.idMatricula + "\n"
				+ "NOMBRE: " + this.nombre + "\n";
	}
}
