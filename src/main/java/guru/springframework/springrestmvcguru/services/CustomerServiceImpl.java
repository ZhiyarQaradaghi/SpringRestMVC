package guru.springframework.springrestmvcguru.services;

import guru.springframework.springrestmvcguru.model.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private HashMap<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        customerMap = new HashMap<>();

        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("John Smith")
                .version("1")
                .createdDateTime(LocalDateTime.now())
                .lastModifiedDateTime(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Arthur Morgan")
                .version("1")
                .createdDateTime(LocalDateTime.now())
                .lastModifiedDateTime(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Dante Inferno")
                .version("1")
                .createdDateTime(LocalDateTime.now())
                .lastModifiedDateTime(LocalDateTime.now())
                .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }

    @Override
    public Customer findById(UUID id) {
        return customerMap.get(id);
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
        Customer savedCustomer = customer.builder()
                .id(UUID.randomUUID())
                .createdDateTime(LocalDateTime.now())
                .lastModifiedDateTime(LocalDateTime.now())
                .customerName(customer.getCustomerName())
                .version(customer.getVersion())
                .build();

        customerMap.put(savedCustomer.getId(), savedCustomer);

        return savedCustomer;
    }

    @Override
    public void updateCustomer(UUID customerId, Customer customer) {
        Customer existingCustomer = customerMap.get(customerId);

        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setVersion(customer.getVersion());
        existingCustomer.setLastModifiedDateTime(LocalDateTime.now());

        customerMap.put(existingCustomer.getId(), existingCustomer);
    }
}

