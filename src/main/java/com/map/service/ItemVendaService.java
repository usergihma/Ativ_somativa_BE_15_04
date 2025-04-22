package com.map.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.entities.ItemVenda;
import com.map.repository.ItemVendaRepository;

@Service
public class ItemVendaService {
	private final ItemVendaRepository itemVendaRepository;
	@Autowired
	public ItemVendaService(ItemVendaRepository itemVendaRepository) {
		this.itemVendaRepository = itemVendaRepository;
	}
	
	public List<ItemVenda>buscaTodosItemVendas() {
		return itemVendaRepository.findAll();
	}
	public ItemVenda buscaItemVenda(Long id) {
		Optional <ItemVenda> ItemVenda = itemVendaRepository.findById(id);
		return ItemVenda.orElse(null);
	}
	public ItemVenda salvarItemVenda(ItemVenda ItemVenda) {
		return itemVendaRepository.save(ItemVenda);
	}
	public ItemVenda alterarItemVenda(Long id, ItemVenda alterarI) {
		Optional <ItemVenda> existeItemVenda = itemVendaRepository.findById(id);
		if (existeItemVenda.isPresent()) {
			alterarI.setId(id);
			return itemVendaRepository.save(alterarI);
		}
		return null;
	}
	public boolean apagarItemVenda(Long Id) {
		Optional <ItemVenda> existeItemVenda = itemVendaRepository.findById(Id);
		if (existeItemVenda.isPresent()) {
			itemVendaRepository.deleteById(Id);
			return true;
		}
		return false;
	}

}

