package com.desafiolike.demo.repository;

import com.desafiolike.demo.entity.ProdutoOrcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoOrcamentoRepository extends JpaRepository<ProdutoOrcamento, Integer> {
}
