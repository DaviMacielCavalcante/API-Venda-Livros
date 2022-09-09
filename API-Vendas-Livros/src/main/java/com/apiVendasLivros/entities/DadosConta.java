package com.apiVendasLivros.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "dados_conta")
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DadosConta implements Serializable {	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String email;
	private String nome;
	
	@Column(name = "sobre_nome")
	private String sobreNome;
	private String cpf;
	
	@Column(name = "data_nascimento")
	private Date dataNasc;
	private Integer telefone;
	
	
	@ManyToMany
	@JoinTable(name = "dados_conta_enderecos", 
	joinColumns = @JoinColumn(name = "id_dados_conta", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "id_enderecos", referencedColumnName = "id"))
	private List<Enderecos> enderecos = new ArrayList<>();		
	
	@ManyToMany	
	@JoinTable(name = "dados_conta_pedidos", 
	joinColumns = @JoinColumn(name = "id_dados_conta", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "id_pedidos", referencedColumnName = "id"))	
	private List<Pedidos> pedidos = new ArrayList<>();	
	
	@ManyToMany
	@JoinTable(name = "lista_desejos", 
	joinColumns = @JoinColumn(name = "id_dados_conta", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "id_livros", referencedColumnName = "id"))
	private List<Livros> listaDesejos = new ArrayList<>();
	
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