package gr.iti.mklab.simmo.core.documents;

import gr.iti.mklab.simmo.core.Document;
import gr.iti.mklab.simmo.core.UserAccount;
import gr.iti.mklab.simmo.core.util.Location;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 * A Post is a {@link gr.iti.mklab.simmo.core.Document} and it may also contain other {@link gr.iti.mklab.simmo.core.Item} objects.
 * Posts do not contain other Documents but simply link to them using a {@link gr.iti.mklab.simmo.core.associations.Reference}
 *
 * @author kandreadou
 * @version 1.0.0
 * @see gr.iti.mklab.simmo.core.Document
 * @since July 3, 2014
 */
@Entity
public class Post extends Document {

    /**
     * The number of likes
     */
    protected int numLikes;

    /**
     * The number of shares
     */
    protected int numShares;

    /**
     * The number of comments
     */
    protected int numComments;

    /**
     * The number of views
     */
    protected int numViews;

    /**
     * The number of ratings
     */
    protected int numRatings;

    /**
     * The number of positive votes
     */
    protected int positiveVotes;

    /**
     * The number of negative votes
     */
    protected int negativeVotes;

    /**
     * The number of subscriptions
     */
    protected int numSubscriptions;

    /**
     * The location for this post
     */
    @Embedded
    protected Location location;

    @Reference
    protected UserAccount replied;

    @Reference
    protected UserAccount shared;

    public Post() {
    }

    public Post(String postId) {
        this.id = postId;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public int getNumShares() {
        return numShares;
    }

    public void setNumShares(int numShares) {
        this.numShares = numShares;
    }

    public int getNumComments() {
        return numComments;
    }

    public void setNumComments(int numComments) {
        this.numComments = numComments;
    }

    public int getNumViews() {
        return numViews;
    }

    public void setNumViews(int numViews) {
        this.numViews = numViews;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }

    public int getPositiveVotes() {
        return positiveVotes;
    }

    public void setPositiveVotes(int positiveVotes) {
        this.positiveVotes = positiveVotes;
    }

    public int getNegativeVotes() {
        return negativeVotes;
    }

    public void setNegativeVotes(int negativeVotes) {
        this.negativeVotes = negativeVotes;
    }

    public int getNumSubscriptions() {
        return numSubscriptions;
    }

    public void setNumSubscriptions(int numSubscriptions) {
        this.numSubscriptions = numSubscriptions;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public UserAccount getReplied() {
        return replied;
    }

    public void setReplied(UserAccount replied) {
        this.replied = replied;
    }

    public UserAccount getShared() {
        return shared;
    }

    public void setShared(UserAccount shared) {
        this.shared = shared;
    }
}
