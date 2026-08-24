package dao;

import model.Movimentacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.math.BigDecimal;

public class MovimentacaoDAO {

	public void inserir(Movimentacao mov) {

		String sql = "INSERT INTO movimentacao " + "(conta_id, descricao, valor, entrada, data_hora) "
				+ "VALUES (?, ?, ?, ?, ?)";

		try {

			Connection conn = Conexao.conectar();

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, mov.getConta().getId());

			stmt.setString(2, mov.getDescricao());

			stmt.setBigDecimal(3, mov.getValor());

			stmt.setBoolean(4, mov.isEntrada());

			stmt.setTimestamp(5,

					Timestamp.valueOf(mov.getDataHora()));

			stmt.executeUpdate();

			System.out.println("Movimentação salva com sucesso!");

			stmt.close();

			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public void listar() {

		String sql = "SELECT * FROM movimentacao";

		try {

			Connection conn = Conexao.conectar();

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String descricao = rs.getString("descricao");

				BigDecimal valor = rs.getBigDecimal("valor");

				boolean entrada = rs.getBoolean("entrada");

				System.out.println(descricao + " | R$ " + valor + " | Entrada: " + entrada);

			}

			rs.close();

			stmt.close();

			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public BigDecimal calcularSaldo() {

		String sql = "SELECT * FROM movimentacao";

		BigDecimal saldo = BigDecimal.ZERO;

		try {

			Connection conn = Conexao.conectar();

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				BigDecimal valor = rs.getBigDecimal("valor");

				boolean entrada = rs.getBoolean("entrada");

				if (entrada) {

					saldo = saldo.add(valor);

				} else {

					saldo = saldo.subtract(valor);

				}

			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return saldo;

	}

	public String maiorGasto() {

		String sql = "SELECT * FROM movimentacao";

		BigDecimal maior = BigDecimal.ZERO;

		String descricaoMaior = "";

		try {

			Connection conn = Conexao.conectar();

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				boolean entrada = rs.getBoolean("entrada");

				BigDecimal valor = rs.getBigDecimal("valor");

				String descricao = rs.getString("descricao");

				if (!entrada && valor.compareTo(maior) > 0) {

					maior = valor;

					descricaoMaior = descricao;
				}

			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return descricaoMaior + " - R$ " + maior;

	}

}