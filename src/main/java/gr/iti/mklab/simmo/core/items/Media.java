package gr.iti.mklab.simmo.core.items;

import gr.iti.mklab.simmo.core.Item;
import gr.iti.mklab.simmo.core.cluster.Clusterable;
import gr.iti.mklab.simmo.core.util.Location;
import org.mongodb.morphia.annotations.Embedded;

/**
 * An abstract media item.
 *
 * @see gr.iti.mklab.simmo.core.Item
 * @see gr.iti.mklab.simmo.core.Object
 *
 * @version 1.0.0
 * @since July 3, 2014
 * @author kandreadou
 */
public abstract class Media extends Item implements Clusterable {

    @Embedded
    protected Location location;

    protected String webPageUrl;

    /** The social network source id */
    protected String source;

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


    public String getSource() {
        return source;
    }

    public void setSource(String sourceId) {
        this.source = sourceId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setWebPageUrl(String url){
        this.webPageUrl = url;
    }

    public String getWebPageUrl(){
        return this.webPageUrl;
    }

    @Override
    public ITEM_TYPE getType() {
        return type;
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
}
