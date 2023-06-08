package com.salvador.springboot.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.salvador.springboot.app.entidades.Cliente;
import com.salvador.springboot.app.entidades.Factura;
import com.salvador.springboot.app.entidades.Producto;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);

	public void save(Cliente cliente);

	public Cliente findOne(Long id);

	public void eliminar(Long id);
	
	public List<Producto> findByNombre(String term);
	
	public void saveFactura(Factura factura);
	
	public Producto findProductoById(Long id);
	
	public Factura findFacturaById(Long id);
	
	public void deleteFactura(Long id);
	
	public Factura obtenerFacturaCompleta(Long id);
	
	public Cliente obtenerClienteCompleto(Long id);
}
