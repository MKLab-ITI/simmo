package gr.iti.mklab.simmo.jobs;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

/**
 * A Job abstract class to represent long running tasks, e.g. crawling, clustering
 *
 * @author kandreadou
 * @version 1.0.0
 * @since March 26, 2015
 */
public abstract class Job {

    public enum STATE {
        WAITING, STOPPING, PAUSED, RUNNING, FINISHED, DELETING, STARTING
    }

    @Id
    protected String id = new ObjectId().toString();
    /**
     * The current state of this job
     */
    protected STATE requestState;

    /**
     * The job creation date
     */
    protected Date creationDate;

    /**
     * The date of the latest change of the request state
     * Useful for finding out how long a job has been waiting or running for instance
     */
    protected Date lastStateChange;
}
