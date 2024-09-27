package com.example.demo.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CategoriaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "produtoCategoria")
    private List<Produto> produtos;

    public CategoriaProduto(Long id, String nome, List<Produto> produtos) {
        this.id = id;
        this.nome = nome;
        this.produtos = produtos;
    }
    public CategoriaProduto(String nome) {
        this.nome = nome;
    }
    public CategoriaProduto() {
    }
    public CategoriaProduto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    @Override
    public String toString() {
        return "CategoriaProduto [id=" + id + ", nome=" + nome + "]";
    }
}
