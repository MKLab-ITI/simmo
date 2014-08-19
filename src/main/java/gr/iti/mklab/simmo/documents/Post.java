package gr.iti.mklab.simmo.documents;

import gr.iti.mklab.simmo.Document;
import gr.iti.mklab.simmo.UserAccount;
import gr.iti.mklab.simmo.util.Location;



/**
 * A Post is a {@link gr.iti.mklab.simmo.Document} and it may also contain other {@link gr.iti.mklab.simmo.Item} objects.
 * Posts do not contain other Documents but simply link to them using a {@link gr.iti.mklab.simmo.Reference}
 *
 * @author kandreadou
 * @version 1.0.0
 * @see gr.iti.mklab.simmo.Document
 * @since July 3, 2014
 */
public class Post extends Document {

    /** The id of the Post in the original web page or social network where it was posted.
     *  Post also has a unique id inherited from its super class Object. */
    private String postId;

    /** The number of likes */
    private int numLikes;

    /** The number of shares */
    private int numShares;

    /** The number of comments */
    private int numComments;

    /** The number of views */
    private int numViews;

    /** The number of ratings */
    private int numRatings;

    /** The number of positive votes */
    private int positiveVotes;

    /** The number of negative votes */
    private int negativeVotes;

    /** The number of subscriptions */
    private int numSubscriptions;

    /** The location for this post */
    private Location location;

    /** The user who created this post */
    private UserAccount userAccount;
    
    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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
    
    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
