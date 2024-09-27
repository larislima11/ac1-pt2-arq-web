package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.repositories.CategoriaProdutoRepository;
import com.example.demo.repositories.ProdutoRepository;
import com.example.demo.models.CategoriaProduto;
import com.example.demo.models.Produto;
@SpringBootApplication
public class DemoApplication {

	@SuppressWarnings("unused")
	@Bean
	public CommandLineRunner init(
		@Autowired
		ProdutoRepository produtoRepository,
		@Autowired
		CategoriaProdutoRepository categoriaProdutoRepository) {
			return args -> {

				CategoriaProduto c1 = categoriaProdutoRepository.save(new CategoriaProduto("GAME"));
				CategoriaProduto c2 = categoriaProdutoRepository.save(new CategoriaProduto("MOVEIS"));
				CategoriaProduto c3 = categoriaProdutoRepository.save(new CategoriaProduto("ELETRONICOS"));
				CategoriaProduto c4 = categoriaProdutoRepository.save(new CategoriaProduto("COZINHA"));

				Produto p1 = produtoRepository.save(new Produto("produto1",279.00,c1));
				Produto p2 = produtoRepository.save(new Produto("mouse logitech",399.00,c1));
				Produto p3 = produtoRepository.save(new Produto("cadeira gamer",99.00,c1));
				Produto p4 = produtoRepository.save(new Produto("produto4",39.00,c4));

				List<CategoriaProduto> categorias = categoriaProdutoRepository.findAll();
				System.out.println("Categoria <> ");
				for(CategoriaProduto c : categorias){
					System.out.println(c.getNome());
				}

				List<Produto> produtos = produtoRepository.findAll();
				System.out.println("Produtos <> ");
				for(Produto p : produtos){
					System.out.println("produto - " + p.getNome() +" Categoria -  " +  p.getProdutoCategoria().getNome());
				}

				/////////////////////
				System.out.println("Produtos com valor Maior que 50 -> " + produtoRepository.findByPrecoGreaterThan(50));
				System.out.println("Produto com valor menor igual a 99.0" + produtoRepository.findByPrecoLessThanEqual(99));
				System.out.println("Produtos que começam com 'Cor' > " + produtoRepository.findByNomeStartingWith("Cor"));

				
				System.out.println("Categorias que começam com 'cate'" + categoriaProdutoRepository.findByNomeStartingWith("cate"));
				System.out.println("Todos os produtos da categoria id 1" + categoriaProdutoRepository.findProdutosByCategoriaId(Long.valueOf(1)));
			};

		}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);



	}

}