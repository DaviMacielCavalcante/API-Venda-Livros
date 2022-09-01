package com.apiVendasLivros.enums;

public enum ForaDeLinha {
	
	SIM(1, "Sim"), NAO(2, "Não");
	
	private int cod;
	private String descricao;
	
	private ForaDeLinha(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static ForaDeLinha toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (ForaDeLinha a : ForaDeLinha.values()) {
			return a;
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
