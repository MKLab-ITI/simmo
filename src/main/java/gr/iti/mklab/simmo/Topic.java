package gr.iti.mklab.simmo;

import java.util.ArrayList;
import java.util.List;

/**
 * A topic is container associated with a Collection and specific {@link gr.iti.mklab.simmo.associations.Annotation} objects
 *
 * @author kandreadou
 * @version 1.0.0
 * @since July 10, 2014
 */
public class Topic  implements Annotatable {
    /**
     * The topic unique id
     */
    protected String id;

    /** The topic featured title */
    protected String featuredTitle;
    
    /** The topic's associated collections */
    protected List<Collection> associatedCollections = new ArrayList<Collection>();
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeaturedTitle() {
        return featuredTitle;
    }

    public void setFeaturedTitle(String featuredTitle) {
        this.featuredTitle = featuredTitle;
    }

    /**
     * Associates this topic to the specified annotation
     *
     * @param collection
     */
    public void associate(Collection collection){
        associatedCollections.add(collection);
    }

    /**
     * Disassociates this topic from the specified annotation
     *
     * @param collection
     */
    public void disassociate(Collection collection){
        associatedCollections.remove(collection);
    }

    /**
     * @return the list of collections
     */
    public List<Collection> getCollections(){
        return associatedCollections;
    }
}
