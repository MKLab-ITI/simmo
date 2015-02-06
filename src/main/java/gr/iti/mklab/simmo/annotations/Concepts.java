package gr.iti.mklab.simmo.annotations;

import gr.iti.mklab.simmo.Annotation;

import java.util.HashMap;

/**
 * A Map of concepts and confidence scores attributed to the object.
 * For instance, [{"Sky", 0.67}, {"Sport", 0.34}]
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 25, 2014
 */
public class Concepts extends HashMap<String, Float> implements Annotation {

    public enum CONCEPT_MODALITY{TEXTUAL, VISUAL, HYBRID};
    
    
	/** The modality  of descriptor */
	private CONCEPT_MODALITY conceptModality;
	
	
    /** The name of the concept (URI or String) */
    private String concept;
	
    
    /** The score of the concept */
    private double score;

	
    public Concepts(String concept, double score, CONCEPT_MODALITY conceptModality){
        this.concept = concept;
        this.score = score;
        this.conceptModality = conceptModality;
    }
	
    


    public void setScore(double score) {
        this.score = score;
    }
    
    public double getScore() {
        return score;
    }  
    
    
    
    public void setConcept(String concept) {
        this.concept = concept;
    }
    
    public String getConcept() {
        return concept;
    }

    

	public void setConceptModality(CONCEPT_MODALITY conceptModality) {
		this.conceptModality = conceptModality;
	}
	
	public CONCEPT_MODALITY getConceptModality() {
		return conceptModality;
	}
	

}
