package gr.iti.mklab.simmo.associations;

import gr.iti.mklab.simmo.*;
import gr.iti.mklab.simmo.documents.Post;

import org.mongodb.morphia.annotations.*;

/**
 * The generation of media objects is modeled through a Creation association between Source and Object.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 21, 2014
 */
@Entity
public class Mention {

    @org.mongodb.morphia.annotations.Reference
    private Post mentions;

    @org.mongodb.morphia.annotations.Reference
    private UserAccount isMentioned;

    public Mention(){}

    public Mention (Post mentions, UserAccount isMentioned){
        this.isMentioned = isMentioned;
        this.mentions = mentions;
    }
    
    public Post getMentions(){
    	return mentions;
    }
    
    public UserAccount getIsMentioned(){
    	return isMentioned;
    }
    
}
