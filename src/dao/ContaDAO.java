package dao;

import model.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaDAO {

	public void inserir(Conta conta) {

		String sql = "INSERT INTO conta (nome, saldo) VALUES (?, ?)";

		try {

			Connection conn = Conexao.conectar();

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, conta.getNome());

			stmt.setBigDecimal(2, conta.getSaldo());

			stmt.executeUpdate();

			System.out.println("Conta cadastrada!");

			stmt.close();

			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

}