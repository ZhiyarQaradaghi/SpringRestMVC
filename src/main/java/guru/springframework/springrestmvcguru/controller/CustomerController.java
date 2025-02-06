package guru.springframework.springrestmvcguru.controller;

import guru.springframework.springrestmvcguru.model.Customer;
import guru.springframework.springrestmvcguru.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PutMapping("{customerId}")
    public ResponseEntity updateByCustomerId(@PathVariable("customerId") UUID customerId , @RequestBody Customer customer) {
        customerService.updateCustomer(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "api/v1/customer/"+ savedCustomer.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers() {
        return customerService.findAll();
    }

    @RequestMapping(value = {"{customerId}"}, method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("customerId") UUID customerId) {
        return customerService.findById(customerId);
    }
}
