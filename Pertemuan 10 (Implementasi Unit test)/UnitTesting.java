import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SalesItemTest {
    private SalesItem item;

    @BeforeEach
    void setUp() {
        item = new SalesItem("Laptop", 120000);
    }

    @Test
    void testGetName() {
        assertEquals("Laptop", item.getName());
    }

    @Test
    void testGetPrice() {
        assertEquals(120000, item.getPrice());
    }

    @Test
    void testAddValidComment() {
        assertTrue(item.addComment("Adi", "Bagus sekali", 5));
        assertEquals(1, item.getNumberOfComments());
    }

    @Test
    void testAddCommentWithInvalidRating() {
        assertFalse(item.addComment("Budi", "Sangat bagus", 6));
        assertFalse(item.addComment("Cici", "Kurang bagus", 0));
        assertEquals(0, item.getNumberOfComments());
    }

    @Test
    void testAddCommentWithExistingAuthor() {
        item.addComment("Adi", "Bagus sekali", 5);
        assertFalse(item.addComment("Adi", "Produk mantap", 4));
        assertEquals(1, item.getNumberOfComments());
    }

    @Test
    void testRemoveComment() {
        item.addComment("Adi", "Bagus sekali", 5);
        item.addComment("Budi", "Sangat bagus", 4);
        item.removeComment(0);
        assertEquals(1, item.getNumberOfComments());
    }

    @Test
    void testUpvoteComment() {
        item.addComment("Adi", "Bagus sekali", 5);
        item.voteComment(0, true);
        item.voteComment(0, true);
        assertEquals(2, item.getCommentVotes(0));
    }

    @Test
    void testDownvoteComment() {
        item.addComment("Adi", "Bagus sekali", 5);
        item.voteComment(0, false);
        item.voteComment(0, false);
        assertEquals(-2, item.getCommentVotes(0));
    }

    @Test
    void testFindMostHelpfulComment() {
        item.addComment("Adi", "Bagus sekali", 5);
        item.addComment("Budi", "Sangat puas", 4);
        item.voteComment(0, true);
        item.voteComment(0, true);
        item.voteComment(1, true);
        assertEquals("Adi (5): Bagus sekali | Votes: 2", item.findMostHelpfulComment().getFullDetails());
    }
}

class CommentTest {
    private Comment comment;

    @BeforeEach
    void setUp() {
        comment = new Comment("Adi", "Produk bagus", 4);
    }

    @Test
    void testGetAuthor() {
        assertEquals("Adi", comment.getAuthor());
    }

    @Test
    void testGetText() {
        assertEquals("Produk bagus", comment.getText());
    }

    @Test
    void testGetRating() {
        assertEquals(4, comment.getRating());
    }

    @Test
    void testUpvote() {
        comment.upvote();
        comment.upvote();
        assertEquals(2, comment.getVoteCount());
    }

    @Test
    void testDownvote() {
        comment.downvote();
        assertEquals(-1, comment.getVoteCount());
    }

    @Test
    void testGetFullDetails() {
        assertEquals("Adi (4): Produk bagus | Votes: 0", comment.getFullDetails());
        comment.upvote();
        assertEquals("Adi (4): Produk bagus | Votes: 1", comment.getFullDetails());
    }
}

