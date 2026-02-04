package ejecuta;

import clases.Alumno;
import clases.Curso;

public class Inicio 
{

	public static void main(String[] args) 
	{
		Alumno[] alumnos = new Alumno[15];
		
		Curso curso1 = new Curso(1, "JAVA ANGULAR", alumnos);
		
		curso1.matricular(new Alumno(1, "MARIA"));
		curso1.matricular(new Alumno(2, "JUAN"));
		
		curso1.matricular(new Alumno(3, "SUSANA"));
		curso1.matricular(new Alumno(4, "RUBEN"));
		
		System.out.println(curso1);
	}
}
