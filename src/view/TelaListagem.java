package view;

import javax.swing.*;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.Conexao;

public class TelaListagem extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextArea area;

	public TelaListagem() {

		setTitle("Movimentações");

		setSize(500, 400);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		getContentPane().setLayout(null);

		JLabel titulo = new JLabel("Movimentações");

		titulo.setFont(new Font("Tahoma", Font.BOLD, 22));

		titulo.setBounds(140, 20, 250, 30);

		add(titulo);

		area = new JTextArea();

		JScrollPane scroll = new JScrollPane(area);

		scroll.setBounds(20, 70, 440, 220);

		add(scroll);

		JButton btnAtualizar = new JButton("Atualizar");

		btnAtualizar.setBounds(170, 310, 120, 30);

		add(btnAtualizar);

		btnAtualizar.addActionListener(e -> {

			carregarMovimentacoes();

		});

	}

	public void carregarMovimentacoes() {

		area.setText("");

		String sql = "SELECT * FROM movimentacao";

		try {

			Connection conn = Conexao.conectar();

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String descricao = rs.getString("descricao");

				String valor = rs.getString("valor");

				boolean entrada = rs.getBoolean("entrada");

				area.append(descricao + " | R$ " + valor + " | Entrada: " + entrada + "\n");

			}

			rs.close();

			stmt.close();

			conn.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());

		}

	}

}