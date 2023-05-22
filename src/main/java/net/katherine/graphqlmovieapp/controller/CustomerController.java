package net.katherine.graphqlmovieapp.controller;


import net.katherine.graphqlmovieapp.client.CustomerClient;
import net.katherine.graphqlmovieapp.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class CustomerController {

    @Autowired
    private CustomerClient client;

    @QueryMapping
    public Mono<Customer> userProfile(@Argument Integer id) {
        return client.getCustomer(id);
    }

}
