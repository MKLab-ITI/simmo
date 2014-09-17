package gr.iti.mklab.simmo.associations;

import gr.iti.mklab.simmo.Object;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 * Similarity models an implicit relation between {@link gr.iti.mklab.simmo.Object} items
 * with attributes such as the type of the relation and the similarity score. This is useful
 * in several tasks, such as clustering and verification of content provenance.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 21, 2014
 */
@Entity
public class Similarity {

    @Reference
    private Object firstObject;

    @Reference
    private Object secondObject;

    private double similarityScore;

    @Id
    private String id = "test";

    public Similarity(){}


    public Similarity(Object object, Object similar, double score) {
        this.firstObject = object;
        this.secondObject = similar;
        this.similarityScore = score;
    }

    public Object getFirstObject() {
        return firstObject;
    }

    public Object getSecondObject() {
        return secondObject;
    }

    public double getSimilarityScore() {
        return similarityScore;
    }
    
    public String getId(){
    	return id;
    }

}
