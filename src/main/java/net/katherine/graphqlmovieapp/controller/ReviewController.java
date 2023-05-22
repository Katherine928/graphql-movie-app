package net.katherine.graphqlmovieapp.controller;


import net.katherine.graphqlmovieapp.client.ReviewClient;
import net.katherine.graphqlmovieapp.dto.Movie;
import net.katherine.graphqlmovieapp.dto.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class ReviewController {

    @Autowired
    private ReviewClient client;


    @SchemaMapping(typeName = "MovieDetails")
    public Flux<Review> reviews(Movie movie) {
        return client.reviews(movie.getId());
    }
}
