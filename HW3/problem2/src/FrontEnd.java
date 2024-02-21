import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.time.LocalDateTime;

public class FrontEnd {
    private UserInterface ui;
    private BackEnd backend;
    private User user;

    public FrontEnd(UserInterface ui, BackEnd backend) {
        this.ui = ui;
        this.backend = backend;
    }
    
    public boolean auth(String authInfo) {
        // TODO sub-problem 1
        String[] info = authInfo.split("\n");
        String id = info[0];
        String pw = info[1];
        try {
            if (backend.checkPW(id, pw)) {
                user = new User(id, pw);
                return true;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void post(Pair<String, String> titleContentPair) {
        // TODO sub-problem 2
        String title = titleContentPair.key;
        String content = titleContentPair.value;
        Post post = new Post(title, content);
        backend.storePost(user.id, post);
    }
    
    public void recommend(){
        // TODO sub-problem 3
        Post[] printPosts = backend.getRecentPosts(backend.getFriends(user.id));
        for (Post post : printPosts) {
            ui.println(post);
        }
    }

    public void search(String command) {
        // TODO sub-problem 4
        String[] keywords = command.split(" ");
        List<String> list = new ArrayList<>();
        list.add(keywords[1]);
        for (int i=2; i<keywords.length; i++) {
            if (list.contains(keywords[i])) { continue; }
            list.add(keywords[i]);
        }
        String[] keyFinal = new String[list.size()];
        for (int i=0; i<list.size(); i++) {
            keyFinal[i] = list.get(i);
        }

        ArrayList<Pair<Post, Integer>> allPosts = backend.postWithKeyword(keyFinal);
        if (allPosts.size()<=10) {
            for (int i=0; i< allPosts.size(); i++) {
                Post post = allPosts.get(i).key;
                ui.println(post.getSummary());
            }
        }
        else {
            for (int i=0; i<10; i++) {
                Post post = allPosts.get(i).key;
                ui.println(post.getSummary());
            }
        }


    }
    
    User getUser(){
        return user;
    }
}
