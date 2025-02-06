package guru.springframework.springrestmvcguru.services;

import guru.springframework.springrestmvcguru.model.Customer;

import java.util.*;

public interface CustomerService {
    public Customer findById(UUID id);
    public List<Customer> findAll();
    public Customer saveNewCustomer(Customer customer);
}
