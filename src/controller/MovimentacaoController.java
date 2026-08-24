package controller;

import dao.MovimentacaoDAO;
import model.Movimentacao;

import java.math.BigDecimal;

public class MovimentacaoController {

	private MovimentacaoDAO dao = new MovimentacaoDAO();

	public void salvar(Movimentacao mov) {

		dao.inserir(mov);

	}

	public BigDecimal saldo() {

		return dao.calcularSaldo();

	}

	public String maiorGasto() {

		return dao.maiorGasto();

	}

}