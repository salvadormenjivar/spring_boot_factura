package com.salvador.springboot.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salvador.springboot.app.entidades.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{	

	@Query("select c from Cliente c left join fetch c.facturas f where c.id = ?1")
	public Cliente obtenerClienteCompleto(Long id); 
	
}
