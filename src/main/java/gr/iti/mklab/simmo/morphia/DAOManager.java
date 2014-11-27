package gr.iti.mklab.simmo.morphia;

import gr.iti.mklab.simmo.Document;
import gr.iti.mklab.simmo.Item;
import gr.iti.mklab.simmo.UserAccount;
import gr.iti.mklab.simmo.associations.Affiliation;
import gr.iti.mklab.simmo.associations.Creation;
import gr.iti.mklab.simmo.associations.Reference;
import gr.iti.mklab.simmo.documents.Post;
import gr.iti.mklab.simmo.documents.Webpage;
import gr.iti.mklab.simmo.items.Image;
import gr.iti.mklab.simmo.items.Text;
import gr.iti.mklab.simmo.items.Video;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.dao.DAO;

/**
 * Static class with helper methods.
 * Eventually it could be the point of access to all the necessary DAOs.
 *
 * @author kandreadou
 */
public class DAOManager {

    public final static MediaDAO<Image> imageDAO = new MediaDAO<Image>(Image.class);
    public final static MediaDAO<Video> videoDAO = new MediaDAO<Video>(Video.class);
    public final static ObjectDAO<Text> textDAO = new ObjectDAO<Text>(Text.class);
    public final static ObjectDAO<Post> postDAO = new ObjectDAO<Post>(Post.class);
    public final static ObjectDAO<Webpage> pageDAO = new ObjectDAO<Webpage>(Webpage.class);
    public final static DAO<UserAccount, ObjectId> userDAO = new BasicDAO<UserAccount, ObjectId>(UserAccount.class, MorphiaManager.getMongoClient(), MorphiaManager.getMorphia(), MorphiaManager.getDB().getName());
    public final static DAO<Creation, ObjectId> creationDAO = new BasicDAO<Creation, ObjectId>(Creation.class, MorphiaManager.getMongoClient(), MorphiaManager.getMorphia(), MorphiaManager.getDB().getName());

    public static void saveCreation(Creation c){
        Object o = c.getCreation();
        if(o instanceof Post)
            savePost((Post)o);
        else if (o instanceof Webpage)
            saveWebpage((Webpage)o);
        else if (o instanceof Item)
            saveItem((Item)o);
        userDAO.save((UserAccount)c.getCreator());
        creationDAO.save(c);
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

    private static void saveDocument(Document doc) {
        //First save the inner Items because they are just references in the Document
        for (Item i : doc.getItems())
            saveItem(i);

        //First save the inner References because they are just references in the Document
        for (Reference r : doc.getReferences()){
            Document d = r.getDocument();
            if(d instanceof Post)
                savePost((Post)d);
            else if(d instanceof Webpage)
                saveWebpage((Webpage)d);
        }
    }

    private static void saveItem(Item i){
        if(i instanceof Image)
            imageDAO.save((Image)i);
        else if (i instanceof Video)
            videoDAO.save((Video)i);
        else if(i instanceof Text)
            textDAO.save((Text)i);
    }
}
