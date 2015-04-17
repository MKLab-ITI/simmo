package gr.iti.mklab.simmo.core.associations;

import gr.iti.mklab.simmo.core.Association;
import gr.iti.mklab.simmo.core.Object;
import gr.iti.mklab.simmo.core.UserAccount;
import org.mongodb.morphia.annotations.Entity;

import java.util.Date;

/**
 * The Interaction describes the relationship between a {@link gr.iti.mklab.simmo.core.UserAccount} and
 * an {@link gr.iti.mklab.simmo.core.Object} through specific attributes, for instance the type of
 * relationship, the date etc
 *
 * @author kandreadou
 * @version 1.0.0
 * @since July 10, 2014
 */
@Entity("Association")
public class Interaction extends Association {

    /**
     * The ways in which a UserAccount interacts with a content Object
     */
    public static enum InteractionType {
        MENTION, COMMENT, LIKE, DISLIKE, FAVORITE, UPVOTE, DOWNVOTE, REPLY, RETWEET, UNDEFINED
    }

    private Date interactionDate;

    private InteractionType interactionType;

    public Interaction() {
    }

    public Interaction(Object objectOfInteraction, UserAccount interactingUser, InteractionType interactionType) {
        super(objectOfInteraction, interactingUser);
        this.interactionType = interactionType;
    }

    public Object getObject() {
        return (Object) one;
    }

    public void setObject(Object objectOfInteraction) {
        this.one = objectOfInteraction;
    }

    public UserAccount getUser() {
        return (UserAccount) other;
    }

    public void setUser(UserAccount interactingUser) {
        this.other = interactingUser;
    }

    public Date getDate() {
        return interactionDate;
    }

    public void setDate(Date interactionDate) {
        this.interactionDate = interactionDate;
    }

    public InteractionType getType() {
        return interactionType;
    }

    public void setType(InteractionType interactionType) {
        this.interactionType = interactionType;
    }
}
