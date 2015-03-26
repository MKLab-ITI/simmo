package gr.iti.mklab.simmo.morphia;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import gr.iti.mklab.simmo.jobs.CrawlJob;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kandreadou
 * @version 1.0.0
 * @since September 12, 2014
 */
public class MorphiaManager {

    private final static String CRAWLS_DB_NAME = "simmo_crawls";
    private static MongoClient mongoClient;
    private static Map<String, DB> dbases = new HashMap<String, DB>();
    private static final Morphia morphia = new Morphia();
    private static MorphiaManager instance;

    private MorphiaManager(String host, int port) {
        try {
            if (mongoClient == null)
                mongoClient = new MongoClient(new MongoClientURI(host != null ? "mongodb://" + host + ':' + port : "mongodb://localhost:27017"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static void setup(String host) {
        setup(host, 27017);
    }

    public synchronized static void setup(String host, int port) {
        if (instance == null)
            instance = new MorphiaManager(host, port);
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
            morphia.mapPackage("gr.iti.mklab.simmo");
            ds.ensureCaps();
            ds.ensureIndexes();
        }
        return dbases.get(dbName);
    }

    public static DB getCrawlsDB(){
       return getDB(CRAWLS_DB_NAME);
    }
}
