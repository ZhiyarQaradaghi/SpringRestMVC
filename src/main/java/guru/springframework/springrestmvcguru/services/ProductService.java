package guru.springframework.springrestmvcguru.services;

import guru.springframework.springrestmvcguru.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public List<Product> listProducts();
    public Product listProductById(UUID id);
    public void updateProduct(UUID id, Product product);
    public void deleteProduct(UUID id);
    public Product addProduct(Product product);
}
