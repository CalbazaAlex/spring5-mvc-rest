package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 9/24/17.
 */
@Component
public class Bootstrap implements CommandLineRunner{

    private final CategoryRepository categoryRespository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRespository, CustomerRepository customerRepository) {
        this.categoryRespository = categoryRespository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRespository.save(fruits);
        categoryRespository.save(dried);
        categoryRespository.save(fresh);
        categoryRespository.save(exotic);
        categoryRespository.save(nuts);


        System.out.println("Data Category Loaded = " + categoryRespository.count() );

        Customer customer1 = new Customer();
        customer1.setFirstname("Alex");
        customer1.setLastname("Alex1");

        Customer customer2 = new Customer();
        customer2.setFirstname("Alexut");
        customer2.setLastname("Alex2");

        Customer customer3 = new Customer();
        customer3.setFirstname("Margareta");
        customer3.setLastname("Alex3");

        Customer customer4 = new Customer();
        customer4.setFirstname("Almost");
        customer4.setLastname("Alex4");

        Customer customer5 = new Customer();
        customer5.setFirstname("Alexa");
        customer5.setLastname("Xela");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);


        System.out.println("Data Customer Loaded = " + customerRepository.count() );

    }
}
