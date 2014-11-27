package gr.iti.mklab.simmo.morphia;

import gr.iti.mklab.simmo.Document;
import gr.iti.mklab.simmo.Item;
import gr.iti.mklab.simmo.associations.Reference;
import gr.iti.mklab.simmo.documents.Post;
import gr.iti.mklab.simmo.documents.Webpage;
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
    public final static ObjectDAO<Webpage> pageDAO = new ObjectDAO<Webpage>(Webpage.class);

    public static void saveDocument(Document doc) {
        //First save the inner Items because they are just references in the Document
        for (Item i : doc.getItems())
            imageDAO.save((Image) i);

        //First save the inner References because they are just references in the Document
        for (Reference r : doc.getReferences())
            savePost((Post) r.getDocument());

    }

    public static void savePost(Post post){
        saveDocument(post);

        //Then save the Post
        postDAO.save(post);
    }

    public static void saveWebpage(Webpage page) {
        //First save the inner Posts because they are just references in the Webpage
        for (Post p : page.getPosts())
            savePost(p);

        //Then save the webpage child elements
        saveDocument(page);

        //Then save the Webpage
        pageDAO.save(page);

    }
}
