import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class CRUD {
	
	protected String url;
	protected String root;
	protected String db;
	protected String password;
	protected String nombre;
	protected float precio;
	protected int cantidad;
	protected int id;
	protected int correcto;

	public CRUD()
	{
		url="jdbc:mysql://localhost:3306/";
		db="tienda";
		root="root";
		password="";
		nombre=nombre;
		precio=precio;
		cantidad=cantidad;
		
	}
	
	
	public void create(String nombre, float precio, int cantidad)
	{
		Connection conexion;
		try {
			conexion = (Connection) DriverManager.getConnection(url+db, root, password);
			Statement peticion=(Statement) conexion.createStatement();
			peticion.executeUpdate("INSERT INTO `productos` (`id`, `nombre`, `precio`, `cantidad`) VALUES (NULL, '"+nombre+"', '"+precio+"', '"+cantidad+"');");                       
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void read()
	{	
		try {
		Connection conexion = (Connection) DriverManager.getConnection(url+db , root, password);
		Statement peticion=(Statement) conexion.createStatement();
		ResultSet resultados=(ResultSet)peticion.executeQuery("SELECT * FROM `productos` ORDER by id ASC");  
		
		while(resultados.next())
		{
			System.out.println(resultados.getInt("id")+" - "+resultados.getString("nombre")+" - "+resultados.getFloat("precio")+"€  - "+resultados.getInt("cantidad")+" unidades ");                    

		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	
	public void Update(int id, String nombre, float precio, int cantidad)
	{
		correcto=-1;
		Connection conexion;
		try {
			
			conexion = (Connection) DriverManager.getConnection(url+db , root, password);
			Statement peticion=(Statement) conexion.createStatement();
			correcto=peticion.executeUpdate("UPDATE `productos` SET `nombre` = '"+nombre+"', `precio` = '"+precio+"', `cantidad` = '"+cantidad+"' WHERE `productos`.`id` = "+id+"");
			if(correcto==1)
			{
				System.out.println("Producto modificado correctamente");
			}else 
			{
				System.out.println("El producto no se ha podido modificar");
			}
			System.out.println("");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	
	public void delete(int id)
	{
		try {
			Connection conexion=(Connection) DriverManager.getConnection(url+db , root, password);
			Statement peticion=(Statement) conexion.createStatement();
			correcto=peticion.executeUpdate("DELETE FROM `productos` WHERE `productos`.`id` = "+id +"");
			if(correcto==1)
			{
				System.out.println("Producto borrado correctamente");
			}
			else
			{
				System.out.println("El producto no pudo ser eliminado");
			}
			System.out.println("");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	public int getCorrecto() {
		return correcto;
	}


	public void setCorrecto(int correcto) {
		this.correcto = correcto;
	}


	public String getDb() {
		return db;
	}


	public void setDb(String db) {
		this.db = db;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}


	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	
	

}
