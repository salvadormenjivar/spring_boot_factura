package com.salvador.springboot.app.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.salvador.springboot.app.entidades.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long>{
	@Query("select f from Factura f join fetch f.cliente join fetch f.items i join fetch i.producto where f.id = ?1")
	public Factura obtenerFacturaCompleta(Long id);

}
