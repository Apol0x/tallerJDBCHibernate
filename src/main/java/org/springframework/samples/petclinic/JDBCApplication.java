package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCApplication {

	public static void main(String[] args) {
		System.out.println("-------- Test de conexión con MySQL ------------");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver en el Classpath");
			e.printStackTrace();
			return;
		}

		System.out.println("Driver instalado y funcionando");
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic","root", "root");
			if (connection != null)
				System.out.println("Conexión establecida");
			try {
				statement = connection.createStatement();
				String sql = "SELECT * FROM owners";
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					int id = rs.getInt("id");
					String firtName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					String address = rs.getString("address");
					String city = rs.getString("city");
					String telephone = rs.getString("telephone");
					
					System.out.println("id: 		"+id);
					System.out.println("firtName: 	"+firtName);
					System.out.println("lastName: 	"+lastName);
					System.out.println("address: 	"+address);
					System.out.println("city: 		"+city);
					System.out.println("telephone: 	"+telephone);
					System.out.println("");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				statement = connection.createStatement();
				String sql = "INSERT INTO owners VALUES ("+200+", antonio, polo, sevilla, sevilla, "+123456789+")";
				statement.executeUpdate(sql);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
		
		
	}

}
