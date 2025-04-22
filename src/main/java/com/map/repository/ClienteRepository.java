package com.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.map.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
