package view;

import javax.swing.*;
import java.awt.Font;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import controller.MovimentacaoController;
import model.Conta;
import model.Movimentacao;

public class TelaMovimentacao extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField txtDescricao;
	private JTextField txtValor;

	public TelaMovimentacao() {

		setTitle("Adicionar Movimentação");

		setSize(400, 300);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		getContentPane().setLayout(null);

		JLabel lblDescricao = new JLabel("Descrição:");

		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblDescricao.setBounds(20, 30, 100, 25);

		add(lblDescricao);

		txtDescricao = new JTextField();

		txtDescricao.setBounds(120, 30, 200, 25);

		add(txtDescricao);

		JLabel lblValor = new JLabel("Valor:");

		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblValor.setBounds(20, 80, 100, 25);

		add(lblValor);

		txtValor = new JTextField();

		txtValor.setBounds(120, 80, 200, 25);

		add(txtValor);

		JCheckBox chkEntrada = new JCheckBox("Entrada");

		chkEntrada.setBounds(120, 120, 100, 25);

		add(chkEntrada);

		JButton btnSalvar = new JButton("Salvar");

		btnSalvar.setBounds(120, 170, 120, 30);

		add(btnSalvar);

		btnSalvar.addActionListener(e -> {

			try {

				String descricao = txtDescricao.getText();

				BigDecimal valor = new BigDecimal(txtValor.getText());

				boolean entrada = chkEntrada.isSelected();

				Conta conta = new Conta("Conta");

				conta.setId(1);

				Movimentacao mov = new Movimentacao(conta, valor, descricao, entrada, LocalDateTime.now());

				MovimentacaoController controller = new MovimentacaoController();

				controller.salvar(mov);

				JOptionPane.showMessageDialog(null, "Movimentação salva!");

				txtDescricao.setText("");

				txtValor.setText("");

			} catch (Exception ex) {

				JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());

			}

		});

	}

}