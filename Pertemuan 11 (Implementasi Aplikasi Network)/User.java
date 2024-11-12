import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<Post> posts;

    public User(String username) {
        this.username = username;
        this.posts = new ArrayList<>();
    }

    public String getUsername() {
        return this.username;
    }

    public void addPost(Post post) {
        posts.add(post);
        System.out.println(username + " posted: " + post.getContent());
    }

    public void likePost(Post post) {
        post.addLike(this);
    }

    public List<Post> getPosts() {
        return posts;
    }
}
