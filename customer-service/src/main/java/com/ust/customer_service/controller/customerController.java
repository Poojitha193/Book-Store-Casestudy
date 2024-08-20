package com.ust.customer_service.controller;

import com.ust.customer_service.dto.CustomerDto;
import com.ust.customer_service.model.Customer;
import com.ust.customer_service.service.CustomerServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class customerController {

    private final CustomerServiceImpl customerService;

    public customerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return ResponseEntity.created(null).body(customerService.createCustomer(customerDto));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody CustomerDto dto,@PathVariable long id){
        return ResponseEntity.accepted().body(customerService.updateCustomer(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable long id){
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }

}
