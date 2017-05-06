package model;

public class Post {
    private String title;
    private String content;
    private String userName;
    private String location = "";
    private int id;

    public Post(String title, String content, String username, String location, int id) {
        this.title = title;
        this.content = content;
        this.userName = username;
        this.location = location;
        this.id = id;
    }


}
