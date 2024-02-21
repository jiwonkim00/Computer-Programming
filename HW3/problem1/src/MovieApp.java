
import java.util.*;

public class MovieApp {

    HashMap<String, Movie> movieCollection = new HashMap<>();
    HashMap<String, User> userCollection = new HashMap<>();


    public boolean addMovie(String title, String[] tags) {
        // TODO sub-problem 1
        if (! movieCollection.isEmpty()) {
            if (movieCollection.containsKey(title)){ return false; }
        }

        Movie movie = new Movie(title);
        movie.tagsList.addAll(Arrays.asList(tags));
        movieCollection.put(title, movie);
        return true;
    }

    public boolean addUser(String name) {
        // TODO sub-problem 1
        if (! userCollection.isEmpty()) {
            if (userCollection.containsKey(name)) { return false; }
        }

        User user = new User(name);
        userCollection.put(name, user);
        return true;
    }

    public Movie findMovie(String title) {
        // TODO sub-problem 1
        if (movieCollection==null || !movieCollection.containsKey(title)) { return null; }
        return movieCollection.get(title);
    }

    public User findUser(String username) {
        // TODO sub-problem 1
        if (userCollection==null || !userCollection.containsKey(username)) { return null; }
        return userCollection.get(username);
    }
//////////////////////////////////////////////////////////////////
    public List<Movie> findMoviesWithTags(String[] tags) {
        // TODO sub-problem 2
        List<Movie> movieWithTags = new ArrayList<>();
        if (tags.length==0) {return movieWithTags;}

        Iterator<String> ir = movieCollection.keySet().iterator();
        while (ir.hasNext()) {
            String key = ir.next();
            Movie movie = movieCollection.get(key);
            if (!movie.hasTags(tags)) { continue; }
            movieWithTags.add(movie);
        }
        Collections.sort(movieWithTags);
        return movieWithTags;
    }
/////////////////////////////////////////////////////////////////////
    public boolean rateMovie(User user, String title, int rating) {
        // TODO sub-problem 3
        Movie movie = movieCollection.get(title);
        if (user==null || !userCollection.containsValue(user)) { return false; }
        if (title==null || !movieCollection.containsKey(title)) { return false; }
        return user.registerRate(movie, rating);
    }

    public int getUserRating(User user, String title) {
        // TODO sub-problem 3
        Movie movie = movieCollection.get(title);
        if (user==null || !userCollection.containsValue(user)) { return -1; }
        if (title==null || !movieCollection.containsKey(title)) { return -1; }
        if (! user.movieRatings.containsKey(movie)) { return 0; }

        return user.movieRatings.get(movie);
    }
///////////////////////////////////////////////////////////////////////////


    public List<Movie> findUserMoviesWithTags(User user, String[] tags) {
        // TODO sub-problem 4
        if (user==null || !userCollection.containsValue(user)) { return new LinkedList<>(); }
        List<Movie> moviewithTags = findMoviesWithTags(tags);
        user.searchHistory.addAll(moviewithTags);

        return moviewithTags;
    }

    public List<Movie> recommend(User user) {
        // TODO sub-problem 4
        if (user==null || !userCollection.containsValue(user)) { return new LinkedList<>(); }
        Iterator<Movie> ir = user.searchHistory.iterator();
        List<Movie> finalList = new LinkedList<>();
        while (ir.hasNext()) {
            Movie movie = ir.next();
            movie.avgRating = getAverageRating(movie);
            finalList.add(movie);
        }
        MyComparator myComparator = new MyComparator();
        Collections.sort(finalList, myComparator);

        List<Movie> returnList = new LinkedList<>();

        for (int i=0; i<3; i++) {
            if (finalList.size() <= 3) {
                return finalList;
            }
            returnList.add(finalList.get(i));
        }

        return returnList;
    }

    public double getAverageRating(Movie movie) {
        Iterator<User> ir = userCollection.values().iterator();
        double sum = 0;
        double num = 0;
        while (ir.hasNext()) {
            User user = ir.next();
            int s = getUserRating(user, movie.toString());
            if (s==-1 || s==0) { continue; }
            sum += s;
            num++;
        }
        return sum/num;
    }
}

class MyComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        if (o1.avgRating < o2.avgRating) {
            return 1;
        }
        else if (o1.avgRating == o2.avgRating) {
            return o1.toString().compareTo(o2.toString());
        }
        return -1;
    }
}

