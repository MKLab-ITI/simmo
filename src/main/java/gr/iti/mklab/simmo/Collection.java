package gr.iti.mklab.simmo;

import java.util.ArrayList;


/**
 * A Collection models aggregates of Objects such as corpora of Web documents,
 * sets of tweets, and image collections. As it is already an ArrayList of Objects,
 * all utility methods are inherited from ArrayList, so they are not implemented
 * specifically for the Collection.
 *
 * @author kandreadou
 * @version 2.0.0
 * @since August 19, 2014
 */
public class Collection extends ArrayList<Object> implements Annotatable {
	
	
    /**
     * The Collection unique id
     */
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
