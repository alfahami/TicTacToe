package model;

import java.util.ArrayList;
import java.util.List;

public class MovieStore {
    private List<Movie> movies;

    public MovieStore() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        this.movies.add(new Movie(movie));
    }

    public List<Movie> filterByGenre(String genre) {
        return this.movies.stream().filter(movie -> movie.getGenre().equalsIgnoreCase(genre)).toList();
    }

    public List<Movie> sortByReleaseYear() {
        return this.movies.stream()
                .sorted((i, j) -> (Integer.compare(i.getReleaseYear(), j.getReleaseYear()))).toList();           
    }

    public List<Movie> getTopRatedMovies(int n) {
        return this.movies.stream().sorted((i, j) -> Double.compare(i.getRating(), j.getRating()))
                          .limit(n)
                          .toList();
    }

}
