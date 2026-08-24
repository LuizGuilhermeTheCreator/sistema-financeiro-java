package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Movimentacao {

	private int id;
	private Conta conta;
	private BigDecimal valor;
	private String descricao;
	private boolean entrada;
	private LocalDateTime dataHora;

	public Movimentacao(Conta conta, BigDecimal valor, String descricao, boolean entrada, LocalDateTime dataHora) {

		this.conta = conta;
		this.valor = valor;
		this.descricao = descricao;
		this.entrada = entrada;
		this.dataHora = dataHora;

	}

	public int getId() {

		return id;

	}

	public Conta getConta() {

		return conta;
	}

	public BigDecimal getValor() {

		return valor;
	}

	public String getDescricao() {

		return descricao;
	}

	public boolean isEntrada() {

		return entrada;
	}

	public LocalDateTime getDataHora() {

		return dataHora;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setEntrada(boolean entrada) {
		this.entrada = entrada;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

}
