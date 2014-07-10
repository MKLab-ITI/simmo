package gr.iti.mklab.simmo;

/**
 * 
 * @author amoumtzidou
 * @version 1.0.0
 * @see gr.iti.mklab.simmo.Document
 * @since July 10, 2014
 */
public class UserAccount {

    /** The internal unique id for this user account */
    protected String id;

    /** The user account id obtained from the source, i.e. facebook id, twitter id */
    protected String sourceId;

    /** The user category */
    protected String category;

    /** The stream id */
    protected String streamId;

    /** The author's full name */
    protected String name;

    /** The number of friends*/
    protected int numFriends;

    /** The number of followers */
    protected int numFollowers;

    /** Big avatar image path (or URL) */
    protected String avatarBig;

    /** Small avatar image path (or URL) */
    protected String avatarSmall;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
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
}
