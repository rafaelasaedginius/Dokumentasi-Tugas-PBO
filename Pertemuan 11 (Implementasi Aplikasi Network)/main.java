public class main {
    public static void main(String[] args) {
        Network network = new Network();

        User alice = network.addUser("Alice");
        User bob = network.addUser("Bob");

        MessagePost alicePost = new MessagePost(alice, "Hello ini post pertama Alice!");
        MessagePost bobPost = new MessagePost(bob, "Hai, Bob disini");

        alice.addPost(alicePost);
        bob.addPost(bobPost);

        network.addPost(alicePost);
        network.addPost(bobPost);

        bob.likePost(alicePost);
        alice.likePost(bobPost);

        network.showAllPosts();
    }
}