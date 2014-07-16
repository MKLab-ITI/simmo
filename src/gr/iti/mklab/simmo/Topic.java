package gr.iti.mklab.simmo;

import java.util.ArrayList;
import java.util.List;

/**
 * A topic is container associated with a Collection and specific {@link gr.iti.mklab.simmo.Annotation} objects
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
    protected List<Collection> associatedAnnotations = new ArrayList<Collection>();
    
    
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
     * @param annotation
     */
    public void associate(Annotation annotation){
        associatedAnnotations.add(annotation);
    }

    /**
     * Disassociates this topic from the specified annotation
     *
     * @param annotation
     */
    public void disassociate(Annotation annotation){
        associatedAnnotations.remove(annotation);
    }

    /**
     * @return the list of annotations
     */
    public List<Annotation> getAnnotations(){
        return associatedAnnotations;
    }
}
