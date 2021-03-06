package ru.anatomica.cookstarter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.anatomica.cookstarter.entities.Product;
import ru.anatomica.cookstarter.entities.dtos.ProductDto;
import ru.anatomica.cookstarter.repositories.ProductsRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAllProducts(Long id) {
        return productsRepository.findAll();
    }

    public Page<Product> findAll(Specification<Product> spec, Integer page) {
        if (page < 1L) {
            page = 1;
        }
        return productsRepository.findAll(spec, PageRequest.of(page - 1, 20));
    }

    public List<Product> findAllProductsByRestaurant(Long id) {
        return productsRepository.findAllByRestaurantId(id);
    }

    public Optional<Product> findById(Long id) {
        return productsRepository.findById(id);
    }

    public Product saveOrUpdate(Product product) {
        return productsRepository.save(product);
    }

    public void deleteById(Long id) {
        productsRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return productsRepository.existsById(id);
    }

    public List<ProductDto> getDtoData() {
        return productsRepository.findAllBy();
    }

}
