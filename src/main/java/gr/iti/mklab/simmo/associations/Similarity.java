package gr.iti.mklab.simmo.associations;

import gr.iti.mklab.simmo.Association;
import gr.iti.mklab.simmo.Object;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
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
@Entity("Association")
public class Similarity extends Association {

    private double similarityScore;

    public Similarity() {
    }

    public Similarity(Object object, Object similar, double score) {
        super(object, similar);
        this.similarityScore = score;
    }

    public Object getFirstObject() {
        return (Object) one;
    }

    public Object getSecondObject() {
        return (Object) other;
    }

    public double getSimilarityScore() {
        return similarityScore;
    }


}
