package net.katherine.graphqlmovieapp.dto;

import lombok.Data;

@Data
public class WatchListInput {

    private Integer customerId;
    private Integer movieId;

}
