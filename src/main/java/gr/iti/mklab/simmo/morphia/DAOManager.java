package gr.iti.mklab.simmo.morphia;

import gr.iti.mklab.simmo.Item;
import gr.iti.mklab.simmo.documents.Post;
import gr.iti.mklab.simmo.items.Image;

/**
 * Static class with helper methods.
 * Eventually it could be the point of access to all the necessary DAOs.
 *
 * @author kandreadou
 */
public class DAOManager {

    public final static MediaDAO<Image> imageDAO = new MediaDAO<Image>(Image.class);
    public final static ObjectDAO<Post> postDAO = new ObjectDAO<Post>(Post.class);

    public static void savePost(Post post){
        //First save the inner Items because they are just references in the Post
        for(Item i:post.getItems()){
            imageDAO.save((Image)i);
        }
        //Then save the Post
        postDAO.save(post);
    }
}
