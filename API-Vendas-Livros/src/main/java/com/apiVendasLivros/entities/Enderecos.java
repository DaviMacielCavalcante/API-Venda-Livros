package com.apiVendasLivros.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "enderecos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Enderecos {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String paisdeOrigem;
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "id_enderecos")
	private DadosConta conta;
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setPaisdeOrigem(String paisdeOrigem) {
		this.paisdeOrigem = paisdeOrigem;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}	
}
