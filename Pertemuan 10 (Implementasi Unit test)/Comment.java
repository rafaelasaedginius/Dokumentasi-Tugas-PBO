public class Comment {
    private String author;
    private String text;
    private int rating;
    private int vote;

    public Comment(String author, String text, int rating) {
        this.author = author;
        this.text = text;
        this.rating = rating;
        this.vote = 0;
    }

    public String getAuthor() { return author; }
    public String getText() { return text; }
    public int getRating() { return rating; }
    public int getVoteCount() { return vote; }

    public void upvote() { vote++; }
    public void downvote() { vote--; }

    public String getFullDetails() {
        return author + " (" + rating + "): " + text + " | Votes: " + vote;
    }
}