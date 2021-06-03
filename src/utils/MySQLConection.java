package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConection {
	public static Connection getConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hospital?useSSL=false&useTimezone=true&serverTimezone=UTC";
			String usr = "root";
<<<<<<< HEAD:src/utils/MySQLConection.java
//			String psw = "2211mysqlM1122";
			String psw = "Forever_hi5.";
=======
			String psw = "";
>>>>>>> develop:src/utils/MySQLConection8.java
			con = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado!!" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error >> de conexi�n con la BD" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error >> general : " + e.getMessage());
		} 
		return con;
	}

}
