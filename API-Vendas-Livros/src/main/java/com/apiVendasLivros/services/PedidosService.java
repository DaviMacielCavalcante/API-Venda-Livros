package com.apiVendasLivros.services;

import java.util.Date;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apiVendasLivros.entities.ItemPedido;
import com.apiVendasLivros.entities.Pedidos;
import com.apiVendasLivros.enums.StatusPedido;
import com.apiVendasLivros.repositories.DadosContaRepository;
import com.apiVendasLivros.repositories.ItemPedidoRepository;
import com.apiVendasLivros.repositories.PedidosRepository;

@Service
public class PedidosService {

	@Autowired
	private PedidosRepository repository;	
	
	@Autowired
	private LivrosService livrosService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;	
	
	@Autowired
	private DadosContaService dadosContaService;
	
	@Autowired
	private DadosContaRepository dadosContaRepository;
	
	public Pedidos findById(Integer id) {
		Optional<Pedidos> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id, "Tipo: " + Pedidos.class.getName()));
	}
	
	@Transactional
	public Pedidos insert(Pedidos obj) {
		obj.setId(null);
		obj.setMomento(new Date());
		obj.setStatus(StatusPedido.EM_PROCESSAMENTO);
		obj = repository.save(obj);
		for (ItemPedido ip : obj.getItemPedido()) {
			ip.setId(null);
			ip.setLivro(livrosService.findById(ip.getLivro().getId()));
			ip.setQuantidade(ip.getQuantidade());
		}
		itemPedidoRepository.saveAll(obj.getItemPedido());
		obj.setDadosConta(dadosContaService.findById(obj.getDadosConta().getId()));
		System.out.println(obj);
		dadosContaRepository.save(obj.getDadosConta());	
		System.out.println(obj);
		return obj;
	}
	
	public Pedidos update(Integer id, Pedidos obj) {
		Pedidos entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Pedidos entity, Pedidos obj) {
		entity.setId(obj.getId());
		entity.setStatus(obj.getStatus());		
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
