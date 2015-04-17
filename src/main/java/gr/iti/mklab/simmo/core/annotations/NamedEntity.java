package gr.iti.mklab.simmo.core.annotations;

import gr.iti.mklab.simmo.core.Annotation;


/**
 * @author kandreadou
 * @version 1.0.1
 * @since November 5, 2014
 */
public class NamedEntity implements Annotation {

	
    public enum NAMED_ENTITY_TYPE{PERSON, LOCATION, ORGANISATION, BRAND, TIME, AMOUNT, COMMUNICATION, NAME};
    
    
	/** The modality  of descriptor */
	private NAMED_ENTITY_TYPE namedEntityType;
	
    /**
     * The named entity token, for instance "Yesterday"
     */
    private String token;

    /**
     * The named entity type, for instance "date"
     */
    private String type;

    
    /**
     * The named entity attribute, for instance "year"
     */
    private String attribute;

    
    
    public NamedEntity(String token, String type){
        this.token = token;
        this.type = type;
    }

    
    public NamedEntity(String token, NAMED_ENTITY_TYPE namedEntityType, String attribute){
        this.token = token;
        this.namedEntityType = namedEntityType;
        this.attribute = attribute;
    }

    public String getToken(){
        return token;
    }

    public String getType(){
        return type;
    }
    
    
    public NAMED_ENTITY_TYPE getNamedEntityType(){
        return namedEntityType;
    }
    
    public String getAttribute(){
        return attribute;
    }
}
