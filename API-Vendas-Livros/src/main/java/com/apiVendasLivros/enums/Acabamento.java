package com.apiVendasLivros.enums;

public enum Acabamento {
	
	BROCHURA(1, "Brochura"), 
	CAPA_DURA(2, "Capa Dura");
	
	private int cod;
	private String descricao;
	
	private Acabamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Acabamento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Acabamento a : Acabamento.values()) {
			if (cod.equals(a.getCod())) {
				return a;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
