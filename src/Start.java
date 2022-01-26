import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Start {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcion=0;
		String nombre="";
		float precio=0.0f;
		int cantidad=0;
		int id=0;
		Scanner entrada=new Scanner(System.in);
		
		try {
			Connection conexion=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda","root","");
			System.out.println("Conexión con la base de datos establecida.");
			System.out.println("");
		} catch (SQLException e) {
			System.out.println("Conexión errónea.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
		
		//	MENU
		do {
		
		System.out.println("*********GESTOR DE PRODUCTOS********");
		System.out.println("Seleccione una opción de las siguientes:");
		System.out.println("1) Crear un producto.");
		System.out.println("2) Listar todos los productos.");
		System.out.println("3) Modificar un producto ");
		System.out.println("4) Borrar un producto ");
		System.out.println("0) Salir del programa");
		
		System.out.print("Opción: "); 
		opcion=entrada.nextInt();
		entrada.nextLine();
		
		
		
		
		
		if(opcion==1)
		{
			System.out.println("");
			System.out.println("A seleccionado crear un producto.");
			System.out.print("Introduzca el nombre del producto que desea crear: ");
			nombre=entrada.nextLine();
			System.out.println();
			System.out.print("Introduzca el precio unitario del producto: ");
			precio=entrada.nextFloat();
			System.out.println("");
			System.out.print("Introduzca la cantidad del producto: ");
			cantidad=entrada.nextInt();
			System.out.println("");
			CRUD crud=new CRUD();
			crud.create(nombre, precio, cantidad);
			System.out.println("Producto creado correctamente");
			System.out.println("");
			
			
		}
		
		if(opcion==2)
		{
			System.out.println("Listado de productos: ");
			System.out.println("");
			CRUD crud=new CRUD();
			crud.read();
			System.out.println("");
		}
		
		
		if(opcion==3)
		{
			System.out.println("");
			CRUD crud=new CRUD();
			crud.read();
			System.out.println("");
			System.out.println("Introduzca el identificador del producto:  ");
			id=entrada.nextInt();
			
			entrada.nextLine();
			System.out.println("Introduzca el nombre del producto: ");
			nombre=entrada.nextLine();
			System.out.println("Introduzca el precio unitario del producto: ");
			precio=entrada.nextFloat();
			System.out.println("Introduzca la cantidad del producto: ");
			cantidad=entrada.nextInt();
			crud.Update(id,  nombre,  precio,  cantidad);
		
		}
		
		
		if(opcion==4)
		{
			System.out.println("");
			System.out.println("Introduzca el identificador del producto a eliminar: ");
			id=entrada.nextInt();
			CRUD crud=new CRUD();
			crud.delete(id);
		}
		
		
		
		if(opcion==0)
		{
			System.out.println("Salio del programa.");
		}
		
		if(opcion<0 || opcion>4)
		{
			System.out.println("");
			System.out.println("Opción errónea.");
			System.out.println("");
		}
		
		
		
		}while(opcion!=0);
		

	}

}
