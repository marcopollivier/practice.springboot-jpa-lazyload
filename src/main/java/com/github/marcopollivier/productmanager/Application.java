package com.github.marcopollivier.productmanager;

import com.github.marcopollivier.productmanager.app.domain.model.Image;
import com.github.marcopollivier.productmanager.app.domain.model.Product;
import com.github.marcopollivier.productmanager.app.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EntityScan(basePackageClasses = {Application.class, Jsr310JpaConverters.class})
@ComponentScan(basePackages = {"com.github.marcopollivier.productmanager.app"})
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		Image img = new Image();
		img.setType("img.jpg");

		Set<Image> images = new HashSet<>();
		images.add(img);

		Product product = new Product();
		product.setName("Caderno");
		product.setDescription("Caderno pautado");
		product.addImage(img);


		context.getBean(ProductService.class).saveOrUpdate(product);
	}

}
