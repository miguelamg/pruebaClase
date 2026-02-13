package repositorio;

import java.util.ArrayList;
import modelos.ProductoModelo;

public class ProductoRepositorio extends BaseDatos implements ICrud<Integer, ProductoModelo>
{
	// Constructores
	// -------------
	public ProductoRepositorio(String p_url)
	{
		super(p_url);
	}

	public ProductoRepositorio(String p_host, int p_puerto, String p_usuario, String p_password, String p_catalogo)
	{
		super(p_host, p_puerto, p_usuario, p_password, p_catalogo);
	}

	// Campos
	// ------
	
	// Métodos
	// -------
	@Override
	public ProductoModelo leer(Integer id) throws Exception 
	{
		ProductoModelo modelo;
		
		sql = "SELECT IDPRODUCTO, NOMBRE, PRECIO, STOCK "
				+ "FROM PRODUCTO "
				+ "WHERE IDPRODUCTO = ?";
		//							  1
		ps = conexion.prepareStatement(sql);
		ps.setInt(1, id);
		
		rs = ps.executeQuery(); // Nos situamos en la primera fila de datos
		if(rs.next() == true)
		{
			modelo = new ProductoModelo();
			
			modelo.setIdProducto( rs.getInt("IDPRODUCTO") );
			modelo.setNombre( rs.getString("NOMBRE") );
			modelo.setPrecio( rs.getFloat("PRECIO") );
			modelo.setStock( rs.getInt("STOCK") );
		}
		else
		{
			modelo = null;
		}
		
		return modelo;
	}

	@Override
	public ArrayList<ProductoModelo> listar() throws Exception 
	{
		ArrayList<ProductoModelo> productos = new ArrayList<ProductoModelo>();
		ProductoModelo modelo;
		
		sql = "SELECT IDPRODUCTO, NOMBRE, PRECIO, STOCK "
			+ "FROM PRODUCTO";
		
		st = conexion.createStatement();
		rs = st.executeQuery(sql);
		
		while(rs.next() == true)
		{
			modelo = new ProductoModelo();
			
			modelo.setIdProducto( rs.getInt("IDPRODUCTO") );
			modelo.setNombre( rs.getString("NOMBRE") );
			modelo.setPrecio( rs.getFloat("PRECIO") );
			modelo.setStock( rs.getInt("STOCK") );
			
			productos.add(modelo);
		}
		
		return productos;
	}

	@Override
	public boolean nuevo(ProductoModelo modelo) throws Exception 
	{
		boolean ok;
		
		sql = "INSERT INTO PRODUCTO(IDPRODUCTO, NOMBRE, PRECIO, STOCK) "
			+ "VALUES(?, ?, ?, ?)";
		//            1  2  3  4
		
		ps = conexion.prepareStatement(sql);
		
		ps.setInt(1, modelo.getIdProducto());
		ps.setString(2, modelo.getNombre());
		ps.setFloat(3, modelo.getPrecio());
		ps.setInt(4, modelo.getStock());
		
		cantidad = ps.executeUpdate();
		if(cantidad == 1)
		{
			ok = true;
		}
		else
		{
			ok = false;
		}
		
		return ok;
	}

	@Override
	public boolean editar(Integer id, ProductoModelo modelo) throws Exception 
	{
		boolean ok;
		
		sql = "UPDATE PRODUCTO "
			+ "SET IDPRODUCTO = ?, NOMBRE = ?, PRECIO = ?, STOCK = ? "
			+ "WHERE IDPRODUCTO = ?";
	
		ps = conexion.prepareStatement(sql);
		
		ps.setInt(1, modelo.getIdProducto());
		ps.setString(2, modelo.getNombre());
		ps.setFloat(3, modelo.getPrecio());
		ps.setInt(4, modelo.getStock());
		ps.setInt(5, id);
		
		cantidad = ps.executeUpdate();
		if(cantidad == 1)
		{
			ok = true;
		}
		else
		{
			ok = false;
		}
		return ok;
	}

	@Override
	public boolean eliminar(Integer id) throws Exception 
	{
		sql = "DELETE FROM PRODUCTO "
			+ "WHERE IDPRODUCTO = ?";
		
		ps = conexion.prepareStatement(sql);
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
		return ps.executeUpdate() == 1;
	}

	@Override
	public boolean eliminarModelo(ProductoModelo modelo) throws Exception 
	{
		return eliminar(modelo.getIdProducto());
	}
	
}