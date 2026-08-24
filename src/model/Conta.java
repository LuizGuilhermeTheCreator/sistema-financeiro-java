package model;

import java.math.BigDecimal;

public class Conta {

	private int id;
	private String nome;
	private BigDecimal saldo;

	public Conta(String nome) {

		this.nome = nome;
		this.saldo = BigDecimal.ZERO;

	}

	public int getId() {

		return id;
	}

	public String getNome() {

		return nome;
	}

	public BigDecimal getSaldo() {

		return saldo;
	}

	public void setId(int id) {

		this.id = id;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public void setSaldo(BigDecimal saldo) {

		this.saldo = saldo;
	}

}
