package gr.iti.mklab.simmo;

import java.util.ArrayList;
import java.util.List;

/**
 * An Annotation interface which can be instantiated in many different ways.
 *
 * @author amoumtzidou
 * @version 1.0.0
 * @since July 3, 2014
 */
public class Collection implements Annotatable {
	
	
    /**
     * The Collection unique id
     */
    protected String id;
	
	 /**
     * A list of documents that the Collection contains
     */
    protected List<Document> items = new ArrayList<Document>();
    
}