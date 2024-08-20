package com.ust.customer_service.service;

import com.ust.customer_service.Repository.CustomerRepo;
import com.ust.customer_service.dto.CustomerDto;
import com.ust.customer_service.exceptions.CustomerNotFoundException;
import com.ust.customer_service.exceptions.DuplicateCustomerException;
import com.ust.customer_service.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<Customer> getAllCustomers() throws CustomerNotFoundException{
        return customerRepo.findAll();
    }

    @Override
    public Customer getCustomerById(long id) throws CustomerNotFoundException{
        return customerRepo.findById(id).orElseThrow(()-> new RuntimeException("Book not Found"));
    }

    @Override
    public Customer createCustomer(CustomerDto customerdto) throws DuplicateCustomerException {
        Customer customer = new Customer();
        customer.setName(customerdto.name());
        customer.setEmail(customerdto.email());
        customer.setPhoneNumber(customerdto.phoneNumber());
        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomer(CustomerDto customerDto, long id)  throws CustomerNotFoundException{
        Customer customer = customerRepo.findById(id).orElseThrow(()-> new CustomerNotFoundException("The customer with id:"+id+" is not found"));
            customer.setName(customerDto.name());
            customer.setEmail(customerDto.email());
            customer.setPhoneNumber(customerDto.phoneNumber());
            return customerRepo.saveAndFlush(customer);
    }

    @Override
        public Customer deleteCustomer(long id) {
            Customer deletedCustomer = customerRepo.findById(id).orElseThrow(()-> new CustomerNotFoundException("Customer not Found"));
            customerRepo.delete(deletedCustomer);
            return deletedCustomer;
    }

}
