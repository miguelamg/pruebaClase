package hibernate.repositorios;

import java.util.List;

public interface ICrud<PK, ENTIDAD> 
{
	boolean nuevo(ENTIDAD entidad);
	ENTIDAD leer(PK id);
	List<ENTIDAD> listar();
	boolean editar(PK id, ENTIDAD entidad);
	
	boolean eliminar(PK id);
	boolean eliminarEntidad(ENTIDAD entidad);
}
