package com.ust.customer_service.service;

import com.ust.customer_service.dto.CustomerDto;
import com.ust.customer_service.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomers();
    public Customer getCustomerById(long id);
    public Customer createCustomer(CustomerDto customerdto);
    public Customer updateCustomer(CustomerDto customerdto, long id);
    public Customer deleteCustomer(long id);
}
