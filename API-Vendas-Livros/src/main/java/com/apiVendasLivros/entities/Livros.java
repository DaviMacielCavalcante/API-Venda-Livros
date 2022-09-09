package com.apiVendasLivros.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apiVendasLivros.enums.Acabamento;
import com.apiVendasLivros.enums.Digital;
import com.apiVendasLivros.enums.ForaDeLinha;

import lombok.EqualsAndHashCode;

@Entity
@Table(name = "livros")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Livros implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String titulo;
	private String autor;
	private String tradutor;
	private Integer acabamento;	
	
	@Column(name = "sob_encomenda")
	private String encomenda;
	
	private Integer edicao;	
	private String isbn;
	private Double preco;
	private String idioma;
	
	@Column(name = "fora_de_linha")
	private Integer foraDeLinha;
	
	@Column(name = "formato_digital")
	private Integer formatoDigital;
	
	@Column(name = "produto_digital")
	private Integer produtoDigital;
	
	@Column(name = "numero_edicao")
	private Integer numeroEdicao;
	
	@Column(name = "numero_paginas")
	private Integer numeroPaginas;
	
	@Column(name = "pais_de_origem")
	private String paisDeOrigem;
	
	private String genero;
	private String editora;
	
	@OneToMany
	private List<ItemPedido> pedido = new ArrayList<>();
	
	public Livros() {		
	}

	public Livros(Integer id, String titulo, String autor, String tradutor, Acabamento acabamento, String encomenda,
			Integer edicao, String isbn, Double preco, String idioma, ForaDeLinha foraDeLinha, Digital formatoDigital,
			Digital produtoDigital, Integer numeroEdicao, Integer numeroPaginas, String paisDeOrigem, String genero,
			String editora) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.tradutor = tradutor;
		this.acabamento = acabamento.getCod();
		this.encomenda = encomenda;
		this.edicao = edicao;
		this.isbn = isbn;
		this.preco = preco;
		this.idioma = idioma;
		this.foraDeLinha = foraDeLinha.getCod();
		this.formatoDigital = (formatoDigital==null)? null : formatoDigital.getCod();;
		this.produtoDigital = produtoDigital.getCod();
		this.numeroEdicao = numeroEdicao;
		this.numeroPaginas = numeroPaginas;
		this.paisDeOrigem = paisDeOrigem;
		this.genero = genero;
		this.editora = editora;
	}	

	public Integer getId() {
		return id;
	}	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTradutor() {
		return tradutor;
	}

	public void setTradutor(String tradutor) {
		this.tradutor = tradutor;
	}

	public String getEncomenda() {
		return encomenda;
	}

	public void setEncomenda(String encomenda) {
		this.encomenda = encomenda;
	}

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Integer getNumeroEdicao() {
		return numeroEdicao;
	}

	public void setNumeroEdicao(Integer numeroEdicao) {
		this.numeroEdicao = numeroEdicao;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getPaisDeOrigem() {
		return paisDeOrigem;
	}

	public void setPaisDeOrigem(String paisDeOrigem) {
		this.paisDeOrigem = paisDeOrigem;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Acabamento getAcabamento() {
		return Acabamento.toEnum(acabamento);
	}

	public void setAcabamento(Acabamento acabamento) {
		this.acabamento = acabamento.getCod();
	}

	public ForaDeLinha getForaDeLinha() {
		return ForaDeLinha.toEnum(foraDeLinha);
	}

	public void setForaDeLinha(ForaDeLinha foraDeLinha) {
		this.foraDeLinha = foraDeLinha.getCod();
	}

	public Digital getFormatoDigital() {
		return Digital.toEnum(formatoDigital);
	}

	public void setFormatoDigital(Digital formatoDigital) {
		this.formatoDigital = formatoDigital.getCod();
	}

	public Digital getProdutoDigital() {
		return Digital.toEnum(produtoDigital);
	}

	public void setProdutoDigital(Digital produtoDigital) {
		this.produtoDigital = produtoDigital.getCod();
	}

	@Override
	public String toString() {
		return "Livros [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", tradutor=" + tradutor
				+ ", acabamento=" + acabamento + ", encomenda=" + encomenda + ", edicao=" + edicao + ", isbn=" + isbn
				+ ", preco=" + preco + ", idioma=" + idioma + ", foraDeLinha=" + foraDeLinha + ", formatoDigital="
				+ formatoDigital + ", produtoDigital=" + produtoDigital + ", numeroEdicao=" + numeroEdicao
				+ ", numeroPaginas=" + numeroPaginas + ", paisDeOrigem=" + paisDeOrigem + ", genero=" + genero
				+ ", editora=" + editora + "]";
	}
}