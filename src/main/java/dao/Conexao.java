package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static Connection getConectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/sql10344227", "sql10344227", "6Z3uZXK7y6");
			return conexao;
		} catch (Exception e) {
			System.out.println("Falha no Banco de Dados");
			return null;
		}
	}
	
}
