package gr.iti.mklab.simmo.core;

import org.mongodb.morphia.annotations.Entity;

/**
 * A User Account.
 *
 * @author kandreadou
 * @version 1.0.0
 * @see Document
 * @since July 3, 2014
 */
@Entity
public class UserAccount extends Source {

    /**
     * The source network where this UserAccount is originating, e.g. twitter, facebook etc
     */
    protected String source;

    /**
     * The user category
     */
    protected String category;

    /**
     * The author's full name
     */
    protected String name;

    protected String username;

    protected String userUrl;

    protected String userId;

    /**
     * The number of friends
     */
    protected int numFriends;

    /**
     * The number of followers
     */
    protected int numFollowers;

    protected int numListed;

    protected int numItems;

    protected int numFavourites;

    /**
     * Big avatar image path (or URL)
     */
    protected String avatarBig;

    /**
     * Small avatar image path (or URL)
     */
    protected String avatarSmall;

    protected boolean isVerified;

    public UserAccount() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumFriends() {
        return numFriends;
    }

    public void setNumFriends(int numFriends) {
        this.numFriends = numFriends;
    }

    public int getNumFollowers() {
        return numFollowers;
    }

    public void setNumFollowers(int numFollowers) {
        this.numFollowers = numFollowers;
    }

    public String getAvatarBig() {
        return avatarBig;
    }

    public void setAvatarBig(String avatarBig) {
        this.avatarBig = avatarBig;
    }

    public String getAvatarSmall() {
        return avatarSmall;
    }

    public void setAvatarSmall(String avatarSmall) {
        this.avatarSmall = avatarSmall;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getNumListed() {
        return numListed;
    }

    public void setNumListed(int numListed) {
        this.numListed = numListed;
    }

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    public int getNumFavourites() {
        return numFavourites;
    }

    public void setNumFavourites(int numFavourites) {
        this.numFavourites = numFavourites;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }
}
