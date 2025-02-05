package guru.springframework.springrestmvcguru.controller;

import guru.springframework.springrestmvcguru.model.Customer;
import guru.springframework.springrestmvcguru.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers() {
        return customerService.findAll();
    }

    @RequestMapping(value = {"{customerId}"}, method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("customerId") UUID customerId) {
        return customerService.findById(customerId);
    }
}
