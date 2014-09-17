package gr.iti.mklab.simmo.morphia;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import gr.iti.mklab.simmo.associations.Similarity;
import gr.iti.mklab.simmo.items.Image;
import gr.iti.mklab.simmo.items.Media;
import gr.iti.mklab.simmo.util.Location;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author kandreadou
 * @version 1.0.0
 * @since September 12, 2014
 */
public class MorphiaManager {

    private static MongoClient mongoClient;
    private static DB db;
    private static Datastore ds;
    private static final Morphia morphia = new Morphia();

    private MorphiaManager(String dbName) {
        try {
            mongoClient = new MongoClient(new MongoClientURI(System.getProperty("MONGO_URI", "mongodb://localhost:27017")));
            db = mongoClient.getDB(dbName);
            ds = morphia.createDatastore(mongoClient, db.getName());
            morphia.map(Image.class).map(Location.class).map(Similarity.class);
            ds.ensureCaps();
            ds.ensureIndexes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void setup(String dbName) {
        new MorphiaManager(dbName);
    }

    public static void tearDown() {
        mongoClient.close();
    }

    public static MongoClient getMongoClient() {
        if (mongoClient == null)
            throw new RuntimeException("MorphiaManager has not been properly initialized. Call setup");
        return mongoClient;
    }

    public static Morphia getMorphia() {
        if (morphia == null)
            throw new RuntimeException("MorphiaManager has not been properly initialized. Call setup");
        return morphia;
    }

    public static DB getDB() {
        if (db == null)
            throw new RuntimeException("MorphiaManager has not been properly initialized. Call setup");
        return db;
    }
}
