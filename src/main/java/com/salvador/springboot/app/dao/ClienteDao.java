package com.salvador.springboot.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.salvador.springboot.app.entidades.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClienteDao implements IClienteDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		if (cliente.getId() != null && cliente.getId() > 0) {
			em.merge(cliente);
		} else {
			em.persist(cliente);
		}
	}

	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id);
	}

}
