package gr.iti.mklab.simmo.associations;

import gr.iti.mklab.simmo.Object;

/**
 * Similarity models an implicit relation between {@link gr.iti.mklab.simmo.Object} items
 * with attributes such as the type of the relation and the similarity score. This is useful
 * in several tasks, such as clustering and verification of content provenance.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 21, 2014
 */
public class Similarity {


    private Object firstObject;

    private Object secondObject;

    private float similarityScore;

    private String id;

    public Similarity(Object object, Object similar, float score) {
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

    public float getSimilarityScore() {
        return similarityScore;
    }
    
    public String getId(){
    	return id;
    }

}
