package gr.iti.mklab.simmo.morphia;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import gr.iti.mklab.simmo.annotations.Original;
import gr.iti.mklab.simmo.associations.Annotation;
import gr.iti.mklab.simmo.associations.Creation;
import gr.iti.mklab.simmo.associations.Interaction;
import gr.iti.mklab.simmo.associations.Similarity;
import gr.iti.mklab.simmo.documents.Post;
import gr.iti.mklab.simmo.documents.Webpage;
import gr.iti.mklab.simmo.items.Image;
import gr.iti.mklab.simmo.util.Location;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author kandreadou
 * @version 1.0.0
 * @since September 12, 2014
 */
public class MorphiaManager {

    private static MongoClient mongoClient;
    private static Map<String, DB> dbases = new HashMap<String, DB>();
    private static final Morphia morphia = new Morphia();
    private static MorphiaManager instance;

    private MorphiaManager(String host) {
        try {
            if (mongoClient == null)
                mongoClient = new MongoClient(new MongoClientURI(host != null ? "mongodb://" + host + ":27017" : "mongodb://localhost:27017"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static void setup(String host) {
        if (instance == null)
            instance = new MorphiaManager(host);
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

    public static DB getDB(String dbName) {
        if (!dbases.containsKey(dbName)) {
            DB db = mongoClient.getDB(dbName);
            dbases.put(dbName, db);
            Datastore ds = morphia.createDatastore(mongoClient, db.getName());
            morphia.map(Image.class).
                    map(Location.class).
                    map(Similarity.class).
                    map(Post.class).
                    map(Webpage.class).
                    map(Creation.class).
                    map(Interaction.class);
            ds.ensureCaps();
            ds.ensureIndexes();
        }
        return dbases.get(dbName);
    }
}
