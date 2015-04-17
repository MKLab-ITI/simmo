package gr.iti.mklab.simmo.core.documents;

import java.util.ArrayList;
import java.util.List;

import gr.iti.mklab.simmo.core.Document;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;


/**
 * A Webpage is a {@link gr.iti.mklab.simmo.core.Document}. It may contain other {@link gr.iti.mklab.simmo.core.Item} objects.
 * Webpages may contain Posts.
 *
 * @author amoumtzidou
 * @version 1.0.0
 * @see gr.iti.mklab.simmo.core.Document
 * @since July 7, 2014
 */
@Entity
public class Webpage extends Document {

    /**
     * A list of posts that the Webpage contains
     */
    @Reference
    protected List<Post> posts = new ArrayList<Post>();

    /**
     * Where this webpage comes from, e.g. Twitter
     */
    protected String source;

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
