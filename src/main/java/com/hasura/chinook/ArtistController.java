package com.hasura.chinook;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class ArtistController {
    @QueryMapping
    public List<Artist> Artist() {
        return Artist.artists();
    }

    @SchemaMapping
    public Integer Artist(Artist artist) {
        return artist.getArtistId();
    }
}