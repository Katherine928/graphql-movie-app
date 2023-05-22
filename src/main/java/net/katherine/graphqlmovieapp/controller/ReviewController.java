package net.katherine.graphqlmovieapp.controller;


import net.katherine.graphqlmovieapp.client.ReviewClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewController {

    @Autowired
    private ReviewClient client;
}
