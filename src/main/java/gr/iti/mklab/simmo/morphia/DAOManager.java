package gr.iti.mklab.simmo.morphia;

import gr.iti.mklab.simmo.*;
import gr.iti.mklab.simmo.Object;
import gr.iti.mklab.simmo.associations.Contribution;
import gr.iti.mklab.simmo.associations.Interaction;
import gr.iti.mklab.simmo.documents.Post;
import gr.iti.mklab.simmo.documents.Webpage;
import gr.iti.mklab.simmo.items.Image;
import gr.iti.mklab.simmo.items.Text;
import gr.iti.mklab.simmo.items.Video;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.dao.DAO;
import org.mongodb.morphia.mapping.MappingException;

import java.util.List;
import java.util.UUID;

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
    public final DAO<UserAccount, String> userDAO;
    public final DAO<WebDomain, String> domainDAO;
    //public final DAO<Association, ObjectId> associationDAO;
    public final AssociationDAO associationDAO;

    public DAOManager(String dbName) {
        imageDAO = new MediaDAO<Image>(Image.class, dbName);
        videoDAO = new MediaDAO<Video>(Video.class, dbName);
        textDAO = new ObjectDAO<Text>(Text.class, dbName);
        postDAO = new ObjectDAO<Post>(Post.class, dbName);
        pageDAO = new ObjectDAO<Webpage>(Webpage.class, dbName);
        userDAO = new BasicDAO<UserAccount, String>(UserAccount.class, MorphiaManager.getMongoClient(), MorphiaManager.getMorphia(), MorphiaManager.getDB(dbName).getName());
        domainDAO = new BasicDAO<WebDomain, String>(WebDomain.class, MorphiaManager.getMongoClient(), MorphiaManager.getMorphia(), MorphiaManager.getDB(dbName).getName());
        associationDAO = new AssociationDAO(dbName);
        //associationDAO = new BasicDAO<Association, ObjectId>(Association.class, MorphiaManager.getMongoClient(), MorphiaManager.getMorphia(), MorphiaManager.getDB(dbName).getName());
    }

    public void savePost(Post post) {
        validate(post);

        saveDocument(post);

        //Then save the Post
        postDAO.save(post);

        UserAccount replied = post.getReplied();
        if (replied != null) {
            saveSource(replied);
            associationDAO.save(new Interaction(post, replied, Interaction.InteractionType.REPLY));
        }
        UserAccount shared = post.getShared();
        if (shared != null) {
            saveSource(shared);
            associationDAO.save(new Interaction(post, shared, Interaction.InteractionType.RETWEET));
        }
        saveAssociations(post.getAssociations());
    }

    public void saveWebpage(Webpage page) {
        validate(page);

        //First save the inner Posts because they are just references in the Webpage
        for (Post p : page.getPosts())
            savePost(p);

        //Then save the webpage child elements
        saveDocument(page);

        //Then save the Webpage
        pageDAO.save(page);

        saveAssociations(page.getAssociations());

    }

    private void saveDocument(Document doc) {
        validate(doc);

        UserAccount c = doc.getContributor();
        if (c != null) {
            saveSource(c);
            associationDAO.save(new Contribution(c, doc));
        }

        //First save the inner Items because they are just references in the Document
        for (Item i : doc.getItems())
            saveItem(i);

        saveAssociations(doc.getAssociations());
    }

    private void saveItem(Item i) {
        validate(i);

        if (i instanceof Image)
            imageDAO.save((Image) i);
        else if (i instanceof Video)
            videoDAO.save((Video) i);
        else if (i instanceof Text)
            textDAO.save((Text) i);
        saveAssociations(i.getAssociations());
    }

    private void saveSource(Source s) {
        validate(s);

        if (s instanceof UserAccount)
            userDAO.save((UserAccount) s);
        else if (s instanceof WebDomain)
            domainDAO.save((WebDomain) s);
    }

    private void saveAssociations(List<? extends Association> associations) {
        for (Association a : associations) {
            associationDAO.save(a);
        }
    }

    private void validate(gr.iti.mklab.simmo.Object o) {
        if (o.getId() == null) {
            o.setId(UUID.randomUUID().toString());
        }
    }

    private void validate(Source s) {
        if (s.getId() == null) {
            s.setId(UUID.randomUUID().toString());
        }
    }
}
