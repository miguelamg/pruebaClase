package aplicacion;

import java.util.List;

import aplicacion.viewmodels.DepartamentosDesplegable;
import aplicacion.viewmodels.EmpleadoViewModel;
import hibernate.entidades.ThDepartamento;
import hibernate.entidades.ThEmpleado;
import hibernate.repositorios.ThDepartamentoRepositorio;
import hibernate.repositorios.ThEmpleadoRepositorio;

public class Inicio 
{
	public static void main(String[] args)
	{
		// Repositorios
		ThEmpleadoRepositorio repoEmple;
		ThDepartamentoRepositorio repoDepart;
		
		// Entidades
		ThEmpleado entidadEmpleado; 					 // contiene un registro de la tabla ThEmpleado con los datos del empleado
		ThEmpleado entidadDirector;					 // contiene un registro de la tabla ThEmpleado con los datos del director
		List<ThDepartamento> lsEntidadesDepartamento; //contiene todos los registros de la tabla ThDepartamento, para poblar el desplegable con los departamentos
		
		// Modelo
		EmpleadoViewModel modelo;
		
		// Campos PK
		short empNo = 7521;
		
		String cadena;
		
		// Poblamos las entidades con la información de la bbdd
		repoEmple = new ThEmpleadoRepositorio();
		entidadEmpleado = repoEmple.leer(empNo);
		entidadDirector = repoEmple.leer(entidadEmpleado.getDir());
		
		repoDepart = new ThDepartamentoRepositorio();
		lsEntidadesDepartamento = repoDepart.listar();
		
		// ¡Comenzamos!!
		// --------------
		// - Poblamos el modelo desde las entidades
		modelo = EmpleadoViewModel.entidadToModelo(entidadEmpleado, entidadDirector, lsEntidadesDepartamento);

		// - Imprimimos
		cadena = "DATOS DEL EMPLEADO: \n"
				+ "EMPNO: " + modelo.getEmpNo() + ", DEPTNO: " + modelo.getDeptNo() 
				+ ", APELLIDO: " + modelo.getApellido() + ", OFICIO: " + modelo.getOficio() 
				+ ", DIRECTOR: " + modelo.getDir() + " " + modelo.getApellidoDirector() + ", F.ALTA: " + modelo.getFechaAlt() 
				+ ", SALARIO: " + modelo.getSalario() + ", COMISIÓN: " + modelo.getComision() + "\n";
		
		cadena += "DATOS DE SU DEPARTAMENTO: \n"
				+ "DNOMBRE: " + modelo.getDnombre() + ", LOCALIDAD: " + modelo.getLoc() + "\n";
		
		cadena += "DEPARTAMENTOS PARA EL DESPLEGABLE: \n";
		for(DepartamentosDesplegable item: modelo.getLsDepartamentos())
		{
			cadena += "\tDEPTNO: " + item.getDeptNo() + ", DNOMBRE: " + item.getDnombre() + "\n";
		}
		
		System.out.println(cadena);
	}
}
