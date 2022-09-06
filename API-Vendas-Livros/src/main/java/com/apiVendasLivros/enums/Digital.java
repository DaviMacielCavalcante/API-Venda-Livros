package com.apiVendasLivros.enums;

public enum Digital {	
	
	SIM(1, "Sim"),	
	NAO(2, "Não");
	
	private int cod;
	private String descricao;
	
	private Digital(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Digital toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Digital a : Digital.values()) {
			if (cod.equals(a.getCod())) {
				return a;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
