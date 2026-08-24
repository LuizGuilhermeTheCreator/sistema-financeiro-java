package view;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {

			try {

				JanelaPrincipal frame = new JanelaPrincipal();

				frame.setVisible(true);

			} catch (Exception e) {

				e.printStackTrace();

			}

		});

	}

	public JanelaPrincipal() {

		setTitle("Sistema Financeiro");

		setSize(500, 250);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();

		contentPane.setLayout(null);

		setContentPane(contentPane);

		JLabel titulo = new JLabel("Sistema Financeiro");

		titulo.setFont(new Font("Tahoma", Font.BOLD, 26));

		titulo.setBounds(110, 20, 300, 40);

		contentPane.add(titulo);

		JButton btnMovimentacao = new JButton("Adicionar Movimentação");

		btnMovimentacao.setBounds(20, 100, 180, 30);

		contentPane.add(btnMovimentacao);

		JButton btnListagem = new JButton("Ver Movimentações");

		btnListagem.setBounds(210, 100, 180, 30);

		contentPane.add(btnListagem);

		JButton btnResumo = new JButton("Ver Resumo");

		btnResumo.setBounds(150, 150, 180, 30);

		contentPane.add(btnResumo);



		btnMovimentacao.addActionListener(e -> {

			TelaMovimentacao tela = new TelaMovimentacao();

			tela.setVisible(true);

		});

		btnListagem.addActionListener(e -> {

			TelaListagem tela = new TelaListagem();

			tela.setVisible(true);

		});

		btnResumo.addActionListener(e -> {

			TelaResumo tela = new TelaResumo();

			tela.setVisible(true);

		});

	}

}