package com.virtual.thread.config;

import com.virtual.thread.entity.Customer;
import com.virtual.thread.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class DataLoader {

    private final String[] REGIONS = {"North America", "Europe", "Asia", "Australia"};
    private final String[] FIRST_NAMES = {"John", "Jane", "Michael", "Emily", "David", "Sarah", "James", "Emma", 
        "William", "Olivia", "Robert", "Sophia", "Joseph", "Isabella", "Thomas", "Mia", "Charles", "Charlotte"};
    private final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", 
        "Davis", "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas"};
    private final String[] GENDERS = {"Male", "Female"};

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository) {
        return args -> {
            // First, truncate existing records
            customerRepository.deleteAll();
            System.out.println("Existing records cleared.");

            List<Customer> customers = new ArrayList<>();
            Random random = new Random();
            long id = 1;

            // Generate 500 customers for each region
            for (String region : REGIONS) {
                for (int i = 0; i < 500; i++) {
                    String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
                    String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
                    String gender = GENDERS[random.nextInt(GENDERS.length)];
                    
                    Customer customer = Customer.builder()
                        .id(id++)
                        .name(firstName + " " + lastName)
                        .email(firstName.toLowerCase() + "." + lastName.toLowerCase() + "@example.com")
                        .gender(gender)
                        .region(region)
                        .build();
                    
                    customers.add(customer);
                }
            }

            // Save all customers in batch
            customerRepository.saveAll(customers);
            
            System.out.println("Sample data loaded successfully!");
            System.out.println("Total customers loaded: " + customerRepository.count());
            System.out.println("Records per region: 500");
            System.out.println("Total regions: " + REGIONS.length);
        };
    }
}
