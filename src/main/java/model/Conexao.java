package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	// Parâmetros de conexão
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String URL = "jdbc:mysql://127.0.0.1:3306/programa_saude_maranguape?useTimezone=true&serverTimezone=UTC";
	private final static String USER = "root";
	private final static String PASSWORD = "Linux@1991V4";

	public Conexao() {
		// TODO Auto-generated constructor stub
	}
	
	protected static Connection conectar() {
		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);

			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
