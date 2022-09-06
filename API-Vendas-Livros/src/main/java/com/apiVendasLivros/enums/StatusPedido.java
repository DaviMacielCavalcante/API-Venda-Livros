package com.apiVendasLivros.enums;

public enum StatusPedido {
	
	EM_PROCESSAMENTO(1, "Em processamento"), 
	PAGO(2, "Pago"),
	ENVIADO(3, "Enviado"),
	ENTREGUE(4, "Entregue"),
	CANCELADO(5, "Cancelado");
	
	private int cod;
	private String descricao;
	
	private StatusPedido(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static StatusPedido toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (StatusPedido a : StatusPedido.values()) {
			if (cod.equals(a.getCod())) {
				return a;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
