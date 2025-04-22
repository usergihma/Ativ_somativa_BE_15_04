package com.map.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.entities.Cliente;
import com.map.repository.ClienteRepository;

@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public List<Cliente>buscaTodosClientes() {
		return clienteRepository.findAll();
	}
	public Cliente buscaClientes(Long id) {
		Optional <Cliente> Cliente = clienteRepository.findById(id);
		return Cliente.orElse(null);
	}
	public Cliente salvarCliente(Cliente Cliente) {
		return clienteRepository.save(Cliente);
	}
	public Cliente alterarCliente(Long id, Cliente alterarC) {
		Optional <Cliente> existeCliente = clienteRepository.findById(id);
		if (existeCliente.isPresent()) {
			alterarC.setId(id);
			return clienteRepository.save(alterarC);
		}
		return null;
	}
	public boolean apagarCliente(Long Id) {
		Optional <Cliente> existeCliente = clienteRepository.findById(Id);
		if (existeCliente.isPresent()) {
			clienteRepository.deleteById(Id);
			return true;
		}
		return false;
	}

}
