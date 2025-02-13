package guru.springframework.springrestmvcguru.services;

import guru.springframework.springrestmvcguru.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    private HashMap<UUID, Product> productMap;

    public ProductServiceImpl() {
        productMap = new HashMap<>();

        Product product1 = Product.builder()
                .id(UUID.randomUUID())
                .name("Cake")
                .description("First cake")
                .build();

        Product product2 = Product.builder()
                .id(UUID.randomUUID())
                .name("Bread")
                .description("Fresh bread")
                .build();

        productMap.put(product1.getId(), product1);
        productMap.put(product2.getId(), product2);
    }

    @Override
    public List<Product> listProducts() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product listProductById(UUID id) {
        return productMap.get(id);
    }

    @Override
    public void updateProduct(UUID id, Product product) {

    }

    @Override
    public void deleteProduct(UUID id) {

    }

    @Override
    public Product addProduct(Product product) {
        Product savedProduct = product.builder()
                .id(UUID.randomUUID())
                .name(product.getName())
                .description(product.getDescription())
                .build();

        productMap.put(product.getId(), savedProduct);

        return savedProduct;

    }
}
