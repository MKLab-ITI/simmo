package gr.iti.mklab.simmo;

/**
 * An Annotation interface which can be instantiated in many different ways.
 *
 * @author amoumtzidou
 * @version 1.0.0
 * @since July 3, 2014
 */
public class Collection {
	
	
    /**
     * The Collection unique id
     */
    protected String id;
	
	 /**
     * A list of documents that the Collection contains
     */
    protected List<Document> items = new ArrayList<Document>();
    
}
