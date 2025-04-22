package com.map.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.entities.Venda;
import com.map.repository.VendaRepository;

@Service
public class VendaService {
	private final VendaRepository vendaRepository;
	@Autowired
	public VendaService(VendaRepository vendaRepository) {
		this.vendaRepository = vendaRepository;
	}
	
	public List<Venda>buscaTodosVendas() {
		return vendaRepository.findAll();
	}
	public Venda buscaVendas(Long id) {
		Optional <Venda> Venda = vendaRepository.findById(id);
		return Venda.orElse(null);
	}
	public Venda salvarVenda(Venda Venda) {
		return vendaRepository.save(Venda);
	}
	public Venda alterarVenda(Long id, Venda alterarV) {
		Optional <Venda> existeVenda = vendaRepository.findById(id);
		if (existeVenda.isPresent()) {
			alterarV.setId(id);
			return vendaRepository.save(alterarV);
		}
		return null;
	}
	public boolean apagarVenda(Long Id) {
		Optional <Venda> existeVenda = vendaRepository.findById(Id);
		if (existeVenda.isPresent()) {
			vendaRepository.deleteById(Id);
			return true;
		}
		return false;
	}

}

