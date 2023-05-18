package net.katherine.graphqlmovieapp.dto;

import lombok.Data;

@Data
public class Review {
    private Integer id;
    private String username;
    private Integer rating;
    private String comment;
}
