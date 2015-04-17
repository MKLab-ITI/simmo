package gr.iti.mklab.simmo.core.associations;

import gr.iti.mklab.simmo.core.Association;
import gr.iti.mklab.simmo.core.Object;
import org.mongodb.morphia.annotations.Entity;

/**
 * Similarity models an implicit relation between {@link gr.iti.mklab.simmo.core.Object} items
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
