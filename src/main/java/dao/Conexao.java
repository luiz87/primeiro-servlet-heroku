package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static Connection getConectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/sql10343221", "sql10343221", "eP7GZaD86t");
			return conexao;
		} catch (Exception e) {
			System.out.println("Falha no Banco de Dados");
			return null;
		}
	}
	
}
