package net.katherine.graphqlmovieapp.controller;


import net.katherine.graphqlmovieapp.client.MovieClient;
import net.katherine.graphqlmovieapp.dto.Customer;
import net.katherine.graphqlmovieapp.dto.Genre;
import net.katherine.graphqlmovieapp.dto.Movie;
import net.katherine.graphqlmovieapp.dto.WatchListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

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

    @SchemaMapping(typeName = "watchListResponse")
    public Flux<Movie> watchList(WatchListResponse watchListResponse){
        return client.getMoviesByIds(watchListResponse.getWatchList());
    }

    @QueryMapping
    public Mono<Movie> movieDetails(@Argument Integer id) {
        return client.getMoviesByIds(List.of(id)).next();
    }

    @QueryMapping
    public Flux<Movie> moviesByGenre(@Argument Genre genre) {
        return client.moviesByGenre(genre);
    }
}
