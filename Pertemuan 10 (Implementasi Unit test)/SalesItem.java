import java.util.ArrayList;

public class SalesItem {
    private String name;
    private int price;
    private ArrayList<Comment> comments;

    public SalesItem(String name, int price) {
        this.name = name;
        this.price = price;
        this.comments = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getNumberOfComments() { return comments.size(); }

    public boolean addComment(String author, String text, int rating) {
        if (rating < 1 || rating > 5 || findCommentByAuthor(author) != null) return false;
        comments.add(new Comment(author, text, rating));
        return true;
    }

    public void removeComment(int index) {
        if (index >= 0 && index < comments.size()) comments.remove(index);
    }

    public void voteComment(int index, boolean upvote) {
        if (index >= 0 && index < comments.size()) {
            if (upvote) comments.get(index).upvote();
            else comments.get(index).downvote();
        }
    }

    public int getCommentVotes(int index) {
        return (index >= 0 && index < comments.size()) ? comments.get(index).getVoteCount() : 0;
    }

    public void showInfo() {
        System.out.println("*** " + name + " ***");
        System.out.println("Price: " + formatPrice(price));
        System.out.println("Customer comments:");
        comments.forEach(c -> System.out.println("-----------------------------------\n" + c.getFullDetails()));
        System.out.println("=====================================");
    }

    public Comment findMostHelpfulComment() {
        return comments.stream().max((c1, c2) -> Integer.compare(c1.getVoteCount(), c2.getVoteCount())).orElse(null);
    }

    private Comment findCommentByAuthor(String author) {
        return comments.stream().filter(c -> c.getAuthor().equals(author)).findFirst().orElse(null);
    }

    private String formatPrice(int price) {
        int dollars = price / 100;
        int cents = price % 100;
        return String.format("$%d.%02d", dollars, cents);
    }
}

