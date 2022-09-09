package com.apiVendasLivros.entities;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.apiVendasLivros.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;

@Entity
@Table(name = "pedidos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pedidos implements Serializable {	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Date momento;
	
	@Column(name = "status_pedido")
	private Integer status;	
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "dados_conta_pedidos", 
	joinColumns = @JoinColumn(name = "id_dados_conta", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "id_pedidos", referencedColumnName = "id"))
	private List<DadosConta> conta = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "pedidos_item_pedido", 
	joinColumns = @JoinColumn(name = "id_pedidos", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "id_item_pedido", referencedColumnName = "id"))
	private List<ItemPedido> itemPedido = new ArrayList<>();	
	
	public Pedidos() {		
	}

	public Pedidos(Integer id, Date momento, StatusPedido status) {
		this.id = id;
		this.momento = momento;
		this.status = status.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusPedido getStatus() {
		return StatusPedido.toEnum(status);
	}

	public void setStatus(StatusPedido status) {
		this.status = status.getCod();
	}

	public Date getMomento() {
		return momento;
	}

	public List<DadosConta> getConta() {
		return conta;
	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}		
	
	public Double getTotal() {		
		return itemPedido.stream().map(x -> x.getSubTotal()).reduce(0.0, (x, y) -> x+y);		
	}	
	
	@Override
	public String toString() {	
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido número: ");
		builder.append(getId());
		builder.append(", Instante: ");
		builder.append(sdf.format(getMomento()));
		builder.append(", Situação do Pagamento: ");
		builder.append(getStatus().getDescricao());
		builder.append("\nDetalhes:\n");
		for (ItemPedido ip : getItemPedido()) {
			builder.append(ip.toString());
		}
		builder.append("Valor Total: ");
		builder.append(nf.format(getTotal()));
		return builder.toString();
	}	
}