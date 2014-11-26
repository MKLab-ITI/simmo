package gr.iti.mklab.simmo.documents;

import java.util.ArrayList;
import java.util.List;

import gr.iti.mklab.simmo.Document;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;


/**
 * A Webpage is a {@link gr.iti.mklab.simmo.Document}. It may contain other {@link gr.iti.mklab.simmo.Item} objects.
 * Webpages may contain Posts.
 *
 * @author amoumtzidou
 * @version 1.0.0
 * @see gr.iti.mklab.simmo.Document
 * @since July 7, 2014
 */
@Entity(noClassnameStored=true)
public class Webpage extends Document {

    /**
     * A list of posts that the Webpage contains
     */
    @Reference
    protected List<Post> posts = new ArrayList<Post>();

    public Webpage(){}
    
    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post){
    	posts.add(post);
    }

    public void removePost(Post post){
    	posts.remove(post);
    }

}
