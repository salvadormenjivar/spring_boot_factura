package com.salvador.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salvador.springboot.app.dao.IClienteDao;
import com.salvador.springboot.app.dao.IFacturaDao;
import com.salvador.springboot.app.dao.IProductoDao;
import com.salvador.springboot.app.entidades.Cliente;
import com.salvador.springboot.app.entidades.Factura;
import com.salvador.springboot.app.entidades.Producto;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	IClienteDao clienteDao;
	
	@Autowired
	IProductoDao productoDao;
	
	@Autowired
	IFacturaDao facturaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);

	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		clienteDao.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {	
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String term) {
		//FORMA 1:
		//return productoDao.findByNombre(term);
		
		//FORMA 2:
		return productoDao.findByNombreLikeIgnoreCase("%" + term + "%"); 
	}

	@Override
	@Transactional
	public void saveFactura(Factura factura) {
		facturaDao.save(factura);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findProductoById(Long id) {		
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Factura findFacturaById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteFactura(Long id) {
		facturaDao.deleteById(id);		
	}

	@Override
	@Transactional
	public Factura obtenerFacturaCompleta(Long id) {
		return facturaDao.obtenerFacturaCompleta(id);		
	}

	@Override
	public Cliente obtenerClienteCompleto(Long id) {
		return clienteDao.obtenerClienteCompleto(id);
	}

}
