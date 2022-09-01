package com.apiVendasLivros.enums;

public enum Encomenda {
	
	SIM(1, "Sim"), NAO(2, "Não");
	
	private int cod;
	private String descricao;
	
	private Encomenda(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Encomenda toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Encomenda a : Encomenda.values()) {
			return a;
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
