package com.folksdev.account.service;

import com.folksdev.account.dto.CustomerDto;
import com.folksdev.account.dto.CustomerDtoConverter;
import com.folksdev.account.exception.CustomerNotFoundExcepiton;
import com.folksdev.account.model.Customer;
import com.folksdev.account.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    private CustomerService service;
    private CustomerRepository customerRepository;
    private CustomerDtoConverter converter;

    @BeforeEach
    public  void setUp(){
        customerRepository = Mockito.mock(CustomerRepository.class);
        converter=Mockito.mock(CustomerDtoConverter.class);
        service= new CustomerService(customerRepository,converter);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdExists_shouldReturnCustomer(){
        Customer customer= new Customer("id","name","surname", Set.of());
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));
        Customer result=service.findCustomerById("id");
        assertEquals(result,customer);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdDoesNotExist_shouldThrowCustomerNotFoundException(){

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());
        assertThrows(CustomerNotFoundExcepiton.class,()->service.findCustomerById("id"));

    }

    @Test
    public void testGetCustomerId_whenCustomerIdDoesNotExist_shouldReturnCustomer(){
        Customer customer= new Customer("id","name","surname", Set.of());
        CustomerDto customerDto=new CustomerDto("id","name","surname",Set.of());
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));
        Mockito.when(converter.convertToCustomerDto(customer)).thenReturn(customerDto);
        CustomerDto result=service.getCustomerId("id");
        assertEquals(result,customerDto);

    }

    @Test
    public void testGetCustomerById_whenCustomerIdDoesNotExist_shouldThrowCustomerNotFoundException(){
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());
       assertThrows(CustomerNotFoundExcepiton.class,()->service.getCustomerId("id"));
        Mockito.verifyNoInteractions(converter);
    }

}