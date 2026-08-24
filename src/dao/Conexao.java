package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String URL = "jdbc:postgresql://localhost:2103/postgres";

	private static final String USUARIO = "postgres";

	private static final String SENHA = "21052402";

	public static Connection conectar() throws SQLException {

		return DriverManager.getConnection(

				URL, USUARIO, SENHA

		);

	}

}
