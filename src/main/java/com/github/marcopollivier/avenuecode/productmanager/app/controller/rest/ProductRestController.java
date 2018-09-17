package com.github.marcopollivier.avenuecode.productmanager.app.controller.rest;

import com.github.marcopollivier.avenuecode.productmanager.app.controller.adapter.ProductAdapter;
import com.github.marcopollivier.avenuecode.productmanager.app.controller.dto.ProductDTO;
import com.github.marcopollivier.avenuecode.productmanager.app.domain.model.Product;
import com.github.marcopollivier.avenuecode.productmanager.app.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/product")
@Api(tags = "Product Manager API - Product", description = "Product operations.")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Retrieve a specific Single Products", notes = "Get a specific product excluding relationships ")
    @RequestMapping(method = RequestMethod.GET, value = "{productId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> requestSpecificSingleProduct(@PathVariable("productId") long productId) {

        Product product = productService.retrieveProduct(productId);

        ProductAdapter adapter = new ProductAdapter(product);
        ProductDTO productDTO = adapter.convertToDTO();

        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieve All Complete Products", notes = "Get all products including all relationships.")
    @RequestMapping(method = RequestMethod.GET, value = "/complete", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDTO>> requestAllCompleteProduct() {

        List<Product> products = productService.retrieveProducts();

        ProductAdapter adapter = new ProductAdapter(products);
        List<ProductDTO> productDTOS = adapter.fromEntityList();

        return new ResponseEntity<>(productDTOS, HttpStatus.OK);
    }

}