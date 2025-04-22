package com.map.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.entities.Produto;
import com.map.repository.ProdutoRepository;

@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;
	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public List<Produto>buscaTodosProdutos() {
		return produtoRepository.findAll();
	}
	public Produto buscaProdutos(Long id) {
		Optional <Produto> Produto = produtoRepository.findById(id);
		return Produto.orElse(null);
	}
	public Produto salvarProduto(Produto Produto) {
		return produtoRepository.save(Produto);
	}
	public Produto alterarProduto(Long id, Produto alterarP) {
		Optional <Produto> existeProduto = produtoRepository.findById(id);
		if (existeProduto.isPresent()) {
			alterarP.setId(id);
			return produtoRepository.save(alterarP);
		}
		return null;
	}
	public boolean apagarProduto(Long Id) {
		Optional <Produto> existeProduto = produtoRepository.findById(Id);
		if (existeProduto.isPresent()) {
			produtoRepository.deleteById(Id);
			return true;
		}
		return false;
	}

}

