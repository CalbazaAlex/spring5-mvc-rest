package guru.springfamework.services;


import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    public static final Long ID = 2L;
    public static final String NAME = "Jimmy";
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);
    }

    @Test
    public void getAllCustomers() throws Exception {

        //given
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        //when
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        //then
        assertEquals(3, customerDTOS.size());

    }

    @Test
    public void getCustomerByFirstname() throws Exception {

        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstname(NAME);

        when(customerRepository.findByFirstname(anyString())).thenReturn(customer);

        //when
        CustomerDTO customerDTO = customerService.getCustomerByFirstname(NAME);

        //then
        assertEquals(ID, customerDTO.getId());
        assertEquals(NAME, customerDTO.getFirstname());

    }
}
