package net.katherine.graphqlmovieapp.client;

import net.katherine.graphqlmovieapp.dto.Genre;
import net.katherine.graphqlmovieapp.dto.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class MovieClient {

    private final WebClient client;

    public MovieClient(@Value("${movie.service.url}") String baseUrl) {
        this.client = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public Flux<Movie> getMoviesByIds(List<Integer> ids) {

        return ids.isEmpty() ? Flux.empty() : moviesByIds(ids);

    }

    private Flux<Movie> moviesByIds(List<Integer> ids) {
        return client.get()
                .uri(uriBuilder ->
                        uriBuilder.queryParam("ids", ids).build())
                .retrieve()
                .bodyToFlux(Movie.class);
    }

    public Flux<Movie> moviesByGenre(Genre genre) {
        return client.get()
                .uri("{genre}/recommended", genre)
                .retrieve()
                .bodyToFlux(Movie.class);
    }

}
