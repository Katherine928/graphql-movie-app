package net.katherine.graphqlmovieapp.controller;


import net.katherine.graphqlmovieapp.client.MovieClient;
import net.katherine.graphqlmovieapp.dto.Customer;
import net.katherine.graphqlmovieapp.dto.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class MovieController {

    @Autowired
    private MovieClient client;

    @SchemaMapping(typeName = "UserProfile")
    public Flux<Movie> watchList(Customer customer){
        return client.getMoviesByIds(customer.getWatchList());
    }

    @SchemaMapping(typeName = "UserProfile")
    public Flux<Movie> recommended(Customer customer){
        return client.moviesByGenre(customer.getFavoriteGenre());
    }
}
