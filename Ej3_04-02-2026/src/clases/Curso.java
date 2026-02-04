package clases;

public class Curso 
{
	public int idCurso;
	public String denominacion;
	public Alumno[] alumnos;
	
	private int posicion = 0;
	

	public Curso(int idCurso, String denominacion, Alumno[] alumnos)
	{
		this.idCurso = idCurso;
		this.denominacion = denominacion;
		this.alumnos = alumnos;
	}
	
	public void matricular(Alumno p_alumno)
	{
		if(posicion < this.alumnos.length)
		{
			alumnos[this.posicion] = p_alumno;
			this.posicion++;			
		}
		else
		{
			System.out.println("Ya no quedan plazas");
		}
	}

	@Override
	public String toString() 
	{
		String cadena;
		
		cadena = "ID CURSO: " + this.idCurso + "\n"
				+ "DENOMINACIÓN: " + this.denominacion + "\n" 
				+ "ALUMNOS MATRICULADOS: \n";
		
		for(int i=0; i<this.posicion; i++)
		{
			cadena += "\t" + this.alumnos[i] + "\n";
		}
	
		return cadena;
	}
}
