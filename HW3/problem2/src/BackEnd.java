import java.awt.List;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.DoubleToIntFunction;

public class BackEnd extends ServerResourceAccessible {
    // Use getServerStorageDir() as a default directory
    // TODO sub-program 1 ~ 4 :

    final String DATA_DIR = getServerStorageDir();
    private Post MyComparator;

    public boolean checkPW(String id, String password) {
        File file = new File(DATA_DIR + id + "/password.txt");
        String filePW = "";
        try {
            Scanner input = new Scanner(file);
            if(input.hasNext()) {
                filePW = input.nextLine();
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return password.equals(filePW);
    }

    public int getPostID(String userID) {
        File directoryPath = new File(DATA_DIR + userID + "/post");
        if (!directoryPath.isDirectory()) { return -1; }

        File[] filesList = directoryPath.listFiles();
        assert filesList != null;
        int[] fileNames = new int[filesList.length];
        int i=0;
        for (File file : filesList) {
            String temp = file.getName();
            int index = temp.lastIndexOf(".");
            fileNames[i] = (Integer.parseInt(temp.substring(0, index)));
            i++;
        }
        Arrays.sort(fileNames);
        return fileNames[fileNames.length-1];
    }

    public void storePost(String userID, Post post) {
        int postID = getPostID(userID) + 1;
        post.setId(postID);
        File file = new File(DATA_DIR + userID + "/post/" + post.getId() + ".txt");
        String date = post.getDate();
        String title = post.getTitle();
        String[] content = post.getContent().split("\\n");

        try {
            FileWriter fw = new FileWriter(file);
            fw.write(date + "\n");
            fw.write(title + "\n");
            fw.write("\n");
            for (int i=0; i<content.length-1; i++) {
                fw.write(content[i] + "\n");
            }
            fw.write(content[content.length-1]);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/////////////////////////////////////////////////////////////////////////////////

    public String[] getFriends(String userID) {
        File file = new File(DATA_DIR + userID + "/friend.txt");
        StringBuilder line = new StringBuilder();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(DATA_DIR + userID + "/friend.txt"));
            String l;
            while ((l= bf.readLine()) != null) {
                line.append(l).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line.toString().split("\n");
    }

    public Post txtToPost(File file) {
        try {
            String filePath = file.getPath();
            File newFile = new File(filePath);
            if (!newFile.isFile()) { return null; }
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            StringBuilder textContent = new StringBuilder();
            while ((line = br.readLine()) != null) {
                textContent.append(line).append("\r\n");
            }
            String[] data = textContent.toString().split("\n");

            String tempdate = data[0];
            String date = data[0].substring(0, tempdate.length()-1);
            String title = data[1];
            StringBuilder content = new StringBuilder(data[3]);
            for (int j=4; j<data.length; j++) {
                content.append("\n").append(data[j]);
            }
            String temp = file.getName();
            int index = temp.lastIndexOf(".");
            int postID = (Integer.parseInt(temp.substring(0, index)));
            return new Post(postID, getDateTime(date), title, content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LocalDateTime getDateTime (String dateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return LocalDateTime.parse(dateTime, dateFormatter);
    }

    public Post[] getRecentPosts(String[] friends) {
        int i=0;
        for (String friend : friends) {
            if (getPostNumber(friend) == -1) { continue; }
            i += getPostNumber(friend);
        }
        Post[] allPosts = new Post[i];
        int k = 0;
        for (String friend : friends) {
            File directoryPath = new File(DATA_DIR + friend + "/post");
            if (!directoryPath.isDirectory()) { break; }
            File[] filesList = directoryPath.listFiles();
            assert filesList != null;
            for (File file : filesList) {
                allPosts[k] = txtToPost(file);
                k++;
            }
        }                    //get ALL posts

        Arrays.sort(allPosts, new MyComparator());
        Post[] top10 = new Post[10];
        for (int j=0; j<10; j++) {
            top10[j] = allPosts[j];
        }
        return top10;
    }

    public int getPostNumber(String userID) {
        File directoryPath = new File(DATA_DIR + userID + "/post");
        if (!directoryPath.isDirectory()) { return -1; }
        File[] filesList = directoryPath.listFiles();
        assert filesList != null;
        return filesList.length;
    }
    ///////////////////////////////////////////////////////////////////////////

    public ArrayList<Pair<Post, Integer>> postWithKeyword(String[] keyword) {
        ArrayList<Pair<Post, Integer>> hasKeyword = new ArrayList<>();

        File directoryPath = new File(DATA_DIR.substring(0, DATA_DIR.length()-1));
        if(!directoryPath.isDirectory()) {
            System.out.println("Is not a directory!!!");
            return null;
        }

        File[] userList = directoryPath.listFiles();
        assert userList != null;
        for (File user : userList) {
            String username = user.getName();
            String filePath = DATA_DIR + username + "/post";

            File userDir = new File(filePath);
            if(!userDir.isDirectory()) {break;}
            File[] userPosts = userDir.listFiles();
            assert userPosts != null;
            for (File post : userPosts) {
                String giveDataPath = filePath + "/" + post.getName();
                if (numberOfKeyword(keyword, giveDataPath) > 0) {
                    Post add = txtToPost(post);
                    Pair<Post, Integer> pair = new Pair<>(add, numberOfKeyword(keyword, giveDataPath));
                    hasKeyword.add(pair);
                }
            }
        }

        Collections.sort(hasKeyword, new PairComparator());
        return hasKeyword;
    }

    public int numberOfKeyword(String[] keywordSet, String dataPath) {
        File file = new File(dataPath);
        if (!file.isFile()) {
            System.out.println("not a file!!");
            return -1;
        }
        int num = 0;
        for (String word : keywordSet) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line=br.readLine()) != null) {
                    if (line.contains(word)) {
                        String[] sts = line.split(" ");
                        for (String st : sts) {
                            if (st.equals(word)) {
                                num++;
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return num;
    }





}

class MyComparator implements Comparator<Post> {
    @Override
    public int compare(Post o1, Post o2) {
        LocalDateTime date1 = Post.parseDateTimeString(o1.getDate(),DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss") );
        LocalDateTime date2 = Post.parseDateTimeString(o2.getDate(),DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss") );

        if(date2.isAfter(date1)) { return 1; }
        else if(date2.isEqual(date1)) { return 0; }
        return -1;
    }
}

class PairComparator implements Comparator<Pair<Post, Integer>> {

    @Override
    public int compare(Pair<Post, Integer> o1, Pair<Post, Integer> o2) {
        if (o1.value < o2.value) {
            return 1;
        }
        else if (o1.value == o2.value) {
            Post p1 = o1.key;
            Post p2 = o2.key;
            LocalDateTime date1 = Post.parseDateTimeString(p1.getDate(),DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss") );
            LocalDateTime date2 = Post.parseDateTimeString(p2.getDate(),DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss") );

            if(date2.isAfter(date1)) { return 1; }
            else if(date2.isEqual(date1)) { return 0; }
            return -1;
        }
        return -1;
    }
}
