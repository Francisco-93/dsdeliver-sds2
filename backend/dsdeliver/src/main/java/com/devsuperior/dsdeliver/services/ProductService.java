package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	@Transactional(readOnly = true) //Para garantir fechamento de conexão com o banco e readOnly é para evitar loking de escrita no banco
	public List<ProductDTO> findAll(){
		List<Product> list = repository.findAllByOrderByNameAsc();
		/*List<ProductDTO> productsDTO = new ArrayList<>();
		for (Product p : list) {
			ProductDTO dto = new ProductDTO(p);
			productsDTO.add(dto);
		}*/
		return list.stream().map((x)-> new ProductDTO(x)).collect(Collectors.toList());
	}
	
}
