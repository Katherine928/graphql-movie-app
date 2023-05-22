package net.katherine.graphqlmovieapp.controller;


import net.katherine.graphqlmovieapp.client.CustomerClient;
import net.katherine.graphqlmovieapp.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Controller
public class CustomerController {

    @Autowired
    private CustomerClient client;

    @QueryMapping
    public Mono<Customer> userProfile(@Argument Integer id) {
        return client.getCustomer(id);
    }

    @MutationMapping
    private Mono<Customer> updateProfile(@Argument CustomerInput customerInput) {
        return client.updateCustomer(customerInput);
    }

    @MutationMapping
    public  Mono<WatchListResponse> addToWatchList(@Argument WatchListInput watchListInput) {
        return client.addToWatchList(watchListInput)
                .map(list -> WatchListResponse.create(Status.SUCCESS, list))
                .onErrorReturn(WatchListResponse.create(Status.FAILURE, Collections.emptyList()));
    }

}
