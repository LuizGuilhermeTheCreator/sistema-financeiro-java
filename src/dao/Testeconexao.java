package dao;

import model.Conta;
import model.Movimentacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Testeconexao {

	public static void main(String[] args) {

		Conta conta = new Conta("Nubank");

		conta.setId(1);

		Movimentacao mov = new Movimentacao(

				conta,

				new BigDecimal("150"),

				"Mercado",

				false,

				LocalDateTime.now()

		);

		MovimentacaoDAO dao = new MovimentacaoDAO();

		dao.inserir(mov);

		dao.listar();

	}

}