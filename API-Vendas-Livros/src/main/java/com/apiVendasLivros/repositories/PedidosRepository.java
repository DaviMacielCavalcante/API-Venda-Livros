package com.apiVendasLivros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apiVendasLivros.entities.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {
	
	@Query(nativeQuery = true, value = "")
	default void insertPedido(Pedidos pedido) {
		
	}
	
}
