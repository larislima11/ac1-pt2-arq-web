package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
    List<Produto> findByPrecoGreaterThan(Integer preco);

    List<Produto> findByPrecoLessThanEqual(Integer preco);

    List<Produto> findByNomeStartingWith(String prefixo);
    
}
