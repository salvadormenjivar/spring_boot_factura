package com.salvador.springboot.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.salvador.springboot.app.entidades.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{
	 
	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> findByNombre(String term);

	// Otra forma de escribir la consulta anterios (dos lineas anteriores):
	public List<Producto> findByNombreLikeIgnoreCase(String term);
}
