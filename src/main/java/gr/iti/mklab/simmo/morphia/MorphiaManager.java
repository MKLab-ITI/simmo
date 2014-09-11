package gr.iti.mklab.simmo.morphia;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import gr.iti.mklab.simmo.items.Image;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.dao.DAO;

/**
 * Created by kandreadou on 9/11/14.
 */
public class MorphiaManager {

    private MongoClient mongoClient;
    private DB db;
    private Datastore ds;
    private final Morphia morphia = new Morphia();
    private MorphiaManager instance;

    public MorphiaManager(String dbName){
        try {
            mongoClient = new MongoClient(new MongoClientURI(System.getProperty("MONGO_URI", "mongodb://localhost:27017")));
            db = mongoClient.getDB(dbName);
            ds =  morphia.createDatastore(mongoClient, db.getName());
            morphia.map(Image.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void tearDown() {
        mongoClient.close();
    }

    public DAO<Image, ObjectId> getImageDAO(){
        return new BasicDAO<Image, ObjectId>(Image.class, mongoClient, morphia, db.getName());
    }

    public void insertImage(){
        final DAO<Image, ObjectId> imageDAO = getImageDAO();
        Image img = new Image();
        img.setId("aasdfdf");
        img.setWidth(456);
        imageDAO.save(img);
    }

    public static void main(String[] args) throws Exception{
        MorphiaManager mngr = new MorphiaManager("morphia");
        mngr.insertImage();
        mngr.tearDown();
    }
}
