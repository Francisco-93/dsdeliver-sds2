package com.devsuperior.dsdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsdeliver.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findAllByOrderByNameAsc();
	
	/*
	 * Atraves do nome do método, apenas, é possível fazer consultas personalizadas 
	 * no banco de dados, sem nem sequer implementar o método. Esse método é um 
	 * método abstrato da interface ProductRepository.
	 * 
	 * Os modelos e conceitos estão na documentação do spring.io jpa-query-methods!
	 */
}
