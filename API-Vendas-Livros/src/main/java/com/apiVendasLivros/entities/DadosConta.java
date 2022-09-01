package com.apiVendasLivros.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DadosConta {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String email;
	private String nome;
	private String sobreNome;
	private String cpf;
	private Date dataNasc;
	private Integer telefone;
	private List<Enderecos> enderecos = new ArrayList<>();
	private List<Pedidos> pedidos = new ArrayList<>();
	private List<ListaDesejos> listaDesejos = new ArrayList<>();
	
	public DadosConta() {		
	}

	public DadosConta(Integer id, String email, String nome, String sobreNome, String cpf, Date dataNasc,
			Integer telefone) {
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}	
}