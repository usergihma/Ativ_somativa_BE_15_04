package com.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.map.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
