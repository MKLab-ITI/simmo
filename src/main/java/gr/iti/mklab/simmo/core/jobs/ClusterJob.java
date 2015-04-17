package gr.iti.mklab.simmo.core.jobs;

import org.mongodb.morphia.annotations.Entity;

import java.util.HashMap;
import java.util.Map;

/**
 * A ClusterJob
 *
 * @author kandreadou
 * @version 1.0.0
 * @since March 26, 2015
 */
@Entity
public class ClusterJob extends Job {

    public enum CLUSTERING_ALGORITHM{
        DBSCAN, KMEANS
    }

    protected CLUSTERING_ALGORITHM algorithm;

    protected Map<String, String> parameters = new HashMap<>();

    public ClusterJob(){}

    public ClusterJob(CLUSTERING_ALGORITHM algorithm){
        this.algorithm = algorithm;
    }

    public void addParameter(String key, String value){
        parameters.put(key, value);
    }

    public void removeParameter(String key){
        parameters.remove(key);
    }
}
