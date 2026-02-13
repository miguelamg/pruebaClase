package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos 
{
	// Constructores
	// -------------
	public BaseDatos(String p_url)
	{
		this.url = p_url;
	}
	public BaseDatos(String p_host, int p_puerto, String p_usuario, String p_password, String p_catalogo)
	{
		this.url = "jdbc:oracle:thin:" + p_usuario + "/" + p_password + "@" + p_host 
				 + ":" + p_puerto + "/" + p_catalogo;
	}
	
	// Campos
	// ------
	private String url; // jdbc:oracle:thin:system/admin@localhost:1521/FREE
	// 									    ------ ----- --------- ---- ----
	//									  usuario  pass     host   puerto catalogo  
	public Connection conexion;
	public PreparedStatement ps;
	public Statement st;
	public String sql;
	public int cantidad;
	public ResultSet rs;
	
	// Métodos
	// -------
	public void conectar() throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		this.conexion = DriverManager.getConnection(this.url);
	}
	
	public void desconectar() throws SQLException
	{
		this.conexion.close();
	}
}