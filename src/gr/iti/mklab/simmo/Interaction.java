package gr.iti.mklab.simmo;

import java.util.Date;

/**
 * The Interaction describes the relationship between a {@link gr.iti.mklab.simmo.UserAccount} and
 * an {@link gr.iti.mklab.simmo.Object} through specific attributes, for instance the type of
 * relationship, the date etc
 *
 * @author kandreadou
 * @version 1.0.0
 * @since July 10, 2014
 */
public class Interaction {

    /**
     * The ways in which a UserAccount interacts with a content Object
     */
    public static enum InteractionType{
        MENTIONS, COMMENTS, LIKES, DISLIKES, FAVORITES, UPVOTES, DOWNVOTES, UNDEFINED
    }

    private Object objectOfInteraction;

    private UserAccount interactingUser;

    private Date interactionDate;

    private InteractionType interactionType;

    public Interaction(Object objectOfInteraction, UserAccount interactingUser, Date interactionDate, InteractionType interactionType){
        this.objectOfInteraction = objectOfInteraction;
        this.interactingUser = interactingUser;
        this.interactionDate = interactionDate;
        this.interactionType = interactionType;
    }

    public Object getObject() {
        return objectOfInteraction;
    }

    public void setObject(Object objectOfInteraction) {
        this.objectOfInteraction = objectOfInteraction;
    }

    public UserAccount getUser() {
        return interactingUser;
    }

    public void setUser(UserAccount interactingUser) {
        this.interactingUser = interactingUser;
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