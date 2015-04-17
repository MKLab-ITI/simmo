package gr.iti.mklab.simmo.core.associations;

import gr.iti.mklab.simmo.core.Association;
import gr.iti.mklab.simmo.core.UserAccount;
import gr.iti.mklab.simmo.core.documents.Post;

import org.mongodb.morphia.annotations.*;

/**
 * The generation of media objects is modeled through a Creation association between Source and Object.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 21, 2014
 */
@Entity("Association")
public class Mention extends Association {

    public Mention() {
    }

    public Mention(Post mentions, UserAccount isMentioned) {
        super(mentions, isMentioned);
    }

    public Post getMentions() {
        return (Post) one;
    }

    public UserAccount getIsMentioned() {
        return (UserAccount) other;
    }

}
