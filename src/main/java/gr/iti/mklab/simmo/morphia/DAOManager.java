package gr.iti.mklab.simmo.morphia;

import gr.iti.mklab.simmo.Document;
import gr.iti.mklab.simmo.Item;
import gr.iti.mklab.simmo.UserAccount;
import gr.iti.mklab.simmo.associations.Affiliation;
import gr.iti.mklab.simmo.associations.Creation;
import gr.iti.mklab.simmo.associations.Interaction;
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

    public final MediaDAO<Image> imageDAO;
    public final MediaDAO<Video> videoDAO;
    public final ObjectDAO<Text> textDAO;
    public final ObjectDAO<Post> postDAO;
    public final ObjectDAO<Webpage> pageDAO;
    public final DAO<UserAccount, ObjectId> userDAO;
    public final DAO<Creation, ObjectId> creationDAO;
    public final DAO<Interaction, ObjectId> interactionDAO;

    public DAOManager(String dbName) {
        imageDAO = new MediaDAO<Image>(Image.class, dbName);
        videoDAO = new MediaDAO<Video>(Video.class, dbName);
        textDAO = new ObjectDAO<Text>(Text.class, dbName);
        postDAO = new ObjectDAO<Post>(Post.class, dbName);
        pageDAO = new ObjectDAO<Webpage>(Webpage.class, dbName);
        userDAO = new BasicDAO<UserAccount, ObjectId>(UserAccount.class, MorphiaManager.getMongoClient(), MorphiaManager.getMorphia(), MorphiaManager.getDB(dbName).getName());
        creationDAO = new BasicDAO<Creation, ObjectId>(Creation.class, MorphiaManager.getMongoClient(), MorphiaManager.getMorphia(), MorphiaManager.getDB(dbName).getName());
        interactionDAO = new BasicDAO<Interaction, ObjectId>(Interaction.class, MorphiaManager.getMongoClient(), MorphiaManager.getMorphia(), MorphiaManager.getDB(dbName).getName());
    }

    public void saveInteraction(Interaction i) {
        Object o = i.getObject();
        if (o instanceof Post)
            savePost((Post) o);
        else if (o instanceof Webpage)
            saveWebpage((Webpage) o);
        else if (o instanceof Item)
            saveItem((Item) o);
        userDAO.save(i.getUser());
        interactionDAO.save(i);
    }

    public void saveCreation(Creation c) {
        Object o = c.getCreation();
        if (o instanceof Post)
            savePost((Post) o);
        else if (o instanceof Webpage)
            saveWebpage((Webpage) o);
        else if (o instanceof Item)
            saveItem((Item) o);
        userDAO.save((UserAccount) c.getCreator());
        creationDAO.save(c);
    }


    public void savePost(Post post) {
        saveDocument(post);

        //Then save the Post
        postDAO.save(post);
    }

    public void saveWebpage(Webpage page) {
        //First save the inner Posts because they are just references in the Webpage
        for (Post p : page.getPosts())
            savePost(p);

        //Then save the webpage child elements
        saveDocument(page);

        //Then save the Webpage
        pageDAO.save(page);

    }

    private void saveDocument(Document doc) {
        //First save the inner Items because they are just references in the Document
        for (Item i : doc.getItems())
            saveItem(i);

        //First save the inner References because they are just references in the Document
        for (Reference r : doc.getReferences()) {
            Document d = r.getDocument();
            if (d instanceof Post)
                savePost((Post) d);
            else if (d instanceof Webpage)
                saveWebpage((Webpage) d);
        }
    }

    private void saveItem(Item i) {
        if (i instanceof Image)
            imageDAO.save((Image) i);
        else if (i instanceof Video)
            videoDAO.save((Video) i);
        else if (i instanceof Text)
            textDAO.save((Text) i);
    }
}
