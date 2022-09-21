package com.apiVendasLivros.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

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
public class Enderecos implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(max = 45, message = "O campo comporta até 45 caracteres.")
	private String rua;
	
	private Integer numero;
	
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(max = 20, message = "O campo comporta até 20 caracteres.")
	private String bairro;
	
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(max = 45, message = "O campo comporta até 45 caracteres.")
	private String cidade;
	
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(max = 45, message = "O campo comporta até 45 caracteres.")
	private String estado;
	
	@Column(name = "pais_de_origem")
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(max = 45, message = "O campo comporta até 45 caracteres.")
	private String paisdeOrigem;
	
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(max = 45, message = "O campo comporta até 45 caracteres.")
	private String cep;		
	
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
