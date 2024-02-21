

import java.util.*;

public class User {
    private String username;
    public User(String username) { this.username = username; }

    HashMap<Movie, Integer> movieRatings = new HashMap<>();
    public boolean registerRate (Movie movie, Integer rate) {
        if (rate<1 || rate>10) { return false; }
        movieRatings.put(movie, rate);
        return true;
    }

    HashSet<Movie> searchHistory = new HashSet<>();

    @Override
    public String toString() {
        return username;
    }


}
