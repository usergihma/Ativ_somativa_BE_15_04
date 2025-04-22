package com.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.map.entities.Venda;
import com.map.service.VendaService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/venda")
public class VendaController {
	
private final VendaService vendaService;
	
	@Autowired
	public VendaController(VendaService vendaService) {
		this.vendaService = vendaService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Venda> buscavendas(@PathVariable Long id) {
		Venda venda = vendaService.buscaVendas(id);
		if(venda != null) {
			return ResponseEntity.ok(venda);
			
		}
		else {
			return ResponseEntity.notFound().build();
			
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Venda>> buscaTodosVendasControl() {
		List<Venda> Venda = vendaService.buscaTodosVendas();
		return ResponseEntity.ok(Venda);
	}
	
	@PostMapping("/")
	public ResponseEntity<Venda> salvaVendasControl(@RequestBody @Valid Venda venda)  {
		Venda salvaVenda = vendaService.salvarVenda(venda);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaVenda);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Venda> alteraVendaControl(@PathVariable Long id, @RequestBody @Valid Venda venda) {
		Venda alteraVenda = vendaService.alterarVenda(id, venda);
		if(alteraVenda != null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Venda> apagaVendaControl(@PathVariable Long id) {
		boolean apagar = vendaService.apagarVenda(id);
	
	if (apagar)  {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	else {
		return ResponseEntity.notFound().build();
	}
}
}

	
