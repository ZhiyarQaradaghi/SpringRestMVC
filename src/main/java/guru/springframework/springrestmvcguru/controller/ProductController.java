package guru.springframework.springrestmvcguru.controller;

import guru.springframework.springrestmvcguru.model.Product;
import guru.springframework.springrestmvcguru.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    public static final String productEndPoint = "/products";

    private final ProductService productService;


    @PostMapping
    public ResponseEntity<Product> handlePost(@RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/product/" + savedProduct.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = {"{productId}"}, method = RequestMethod.GET)
    public Product listProductById(@PathVariable("productId") UUID productId) {
        return productService.listProductById(productId);
    }

    @GetMapping
    public List<Product> listALlProducts() {
        return productService.listProducts();
    }
}
