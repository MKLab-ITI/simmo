package gr.iti.mklab.simmo.core.morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import gr.iti.mklab.simmo.core.jobs.CrawlJob;
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
    private static Map<String, MongoDatabase> dbases = new HashMap<String, MongoDatabase>();
    private static final Morphia morphia = new Morphia();
    private static MorphiaManager instance;

    private MorphiaManager(String host, int port) {
        try {
            if (mongoClient == null) {
            	Builder optionsBuilder = new MongoClientOptions.Builder().socketKeepAlive(true);
                mongoClient = new MongoClient(new MongoClientURI(
                		host != null ? "mongodb://" + host + ':' + port : "mongodb://localhost:27017",
                				optionsBuilder));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static void setup(String host) {
        setup(host, 27017);
    }

    public synchronized static void setup(String host, int port) {
        if (instance == null) {
            instance = new MorphiaManager(host, port);
        }
    }


    public static void tearDown() {
        mongoClient.close();
    }

    public static MongoClient getMongoClient() {
        if (mongoClient == null) {
            throw new RuntimeException("MorphiaManager has not been properly initialized. Call setup");
        }
        return mongoClient;
    }

    public static Morphia getMorphia() {
        if (morphia == null) {
            throw new RuntimeException("MorphiaManager has not been properly initialized. Call setup");
        }
        return morphia;
    }

    public static MongoDatabase getDB(String dbName) {
        if (!dbases.containsKey(dbName)) {
            MongoDatabase db = mongoClient.getDatabase(dbName);
            dbases.put(dbName, db);
            Datastore ds = morphia.createDatastore(mongoClient, db.getName());
            morphia.mapPackage("gr.iti.mklab.simmo.core");
            ds.ensureCaps();
            ds.ensureIndexes();
        }
        return dbases.get(dbName);
    }

    public static MongoDatabase getCrawlsDB(){
        if (!dbases.containsKey(CRAWLS_DB_NAME)) {
            MongoDatabase db = mongoClient.getDatabase(CRAWLS_DB_NAME);
            dbases.put(CRAWLS_DB_NAME, db);
            Morphia crawlsMoprhia = new Morphia();
            Datastore ds = crawlsMoprhia.createDatastore(mongoClient, db.getName());
            crawlsMoprhia.map(CrawlJob.class);
            ds.ensureCaps();
            ds.ensureIndexes();
        }
        return dbases.get(CRAWLS_DB_NAME);
    }
}
