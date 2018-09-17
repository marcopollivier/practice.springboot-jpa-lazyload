package com.github.marcopollivier.avenuecode.productmanager.app.service;

import com.github.marcopollivier.avenuecode.productmanager.app.domain.model.Product;
import com.github.marcopollivier.avenuecode.productmanager.app.domain.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public Product saveOrUpdate(Product product) {
        LOGGER.info("Saving...");
        return productRepository.save(product);
    }

    public List<Product> retrieveProducts() {
        List<Product> allByParentProductIsNull = productRepository.findAllProducts();

        return allByParentProductIsNull;
    }

    public Product retrieveProduct(Long productId) {
        Optional<Product> findById = productRepository.findAllById(productId);

        if (!findById.isPresent()) {
            return null;
        }

        Product product = findById.get();

        return product;
    }


}
