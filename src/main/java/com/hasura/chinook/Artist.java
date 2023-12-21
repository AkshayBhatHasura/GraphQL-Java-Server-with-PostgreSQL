package com.hasura.chinook;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.sql.*; 
// import java.sql.Statement;
// import java.sql.Connection;

public class Artist {

    private int ArtistId;
    private String Name;
    private String Albums;

    public Artist(int ArtistId, String Name, String Albums) {
        this.ArtistId = ArtistId;
        this.Name = Name;
        this.Albums = Albums;
    }

    public Artist(int ArtistId, String Name) {
        this.ArtistId = ArtistId;
        this.Name = Name;
        this.Albums = null;
    }

    public int getArtistId() {
        return ArtistId;
    }

    public String getName() {
        return Name;
    }

    static String url = "jdbc:postgresql://localhost:5432/chinook";
	static String username = "postgres";
	static String password = "password";

	public static List<Artist> artists() {
	    String query = "SELECT * FROM Artist";
	    try (Connection connection = DriverManager.getConnection(url, username, password);
	         PreparedStatement statement = connection.prepareStatement(query);
	         ResultSet resultSet = statement.executeQuery()) {
	        List<Artist> artists = new ArrayList<>();
	        while (resultSet.next()) {
	            int id = resultSet.getInt("ArtistId");
	            String name = resultSet.getString("Name");
	            Artist artist = new Artist(id, name);
	            artists.add(artist);
	        }
	        return artists;
	    } catch (SQLException e) {
	        throw new RuntimeException("Error fetching artists", e);
	    }
	}
}