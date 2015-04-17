package gr.iti.mklab.simmo.core;

import java.util.ArrayList;
import java.util.List;


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
public class Collection extends Annotatable implements Associated {
	
	
    /**
     * The Collection unique id
     */
    protected String id;

    protected List<Object> objects = new ArrayList<Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public List<Object> getObjects() {
        return objects;
    }

    
    public void addObject(Object object){
    	objects.add(object);
    }

    
    public void removeObject(Object object){
    	objects.remove(object);
    }
    
    
}
