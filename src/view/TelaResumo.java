package view;

import javax.swing.*;
import java.awt.Font;

import controller.MovimentacaoController;

public class TelaResumo extends JFrame {

	private static final long serialVersionUID = 1L;

	public TelaResumo() {

		setTitle("Resumo");

		setSize(350, 250);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		getContentPane().setLayout(null);

		JLabel lblSaldoTitulo = new JLabel("Saldo:");

		lblSaldoTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblSaldoTitulo.setBounds(20, 30, 100, 25);

		add(lblSaldoTitulo);

		JLabel lblSaldoValor = new JLabel("R$ 0");

		lblSaldoValor.setBounds(120, 30, 200, 25);

		add(lblSaldoValor);

		JLabel lblMaiorTitulo = new JLabel("Maior gasto:");

		lblMaiorTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblMaiorTitulo.setBounds(20, 80, 120, 25);

		add(lblMaiorTitulo);

		JLabel lblMaiorValor = new JLabel("-");

		lblMaiorValor.setBounds(120, 80, 200, 25);

		add(lblMaiorValor);

		JButton btnAtualizar = new JButton("Atualizar");

		btnAtualizar.setBounds(100, 140, 120, 30);

		add(btnAtualizar);

		MovimentacaoController controller = new MovimentacaoController();

		btnAtualizar.addActionListener(e -> {

			lblSaldoValor.setText("R$ " + controller.saldo());

			lblMaiorValor.setText(controller.maiorGasto());

		});

	}

}