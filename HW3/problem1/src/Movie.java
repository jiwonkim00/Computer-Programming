
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Movie implements Comparable<Movie> {
    private String title;
    public Movie(String title) { this.title = title;}
    public ArrayList<String> tagsList = new ArrayList<>();
    double avgRating;

    public boolean hasTags (String[] tags) {
        ArrayList<String> checkList = new ArrayList<>();
        for (String tag : tags) {
            checkList.add(tag);
        }
        if (tagsList.containsAll(checkList)) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return title;
    }

    @Override
    public int compareTo(Movie movie) {
        return this.title.compareTo(movie.title);
    }
}
