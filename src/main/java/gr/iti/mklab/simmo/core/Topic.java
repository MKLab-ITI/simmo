package gr.iti.mklab.simmo.core;



/**
 * A topic is container associated with a Collection and specific {@link Annotation} objects
 *
 * @author kandreadou
 * @version 1.0.0
 * @since July 10, 2014
 */
public class Topic extends Annotatable implements Associated {
    /**
     * The topic unique id
     */
    protected String id;

    /** The topic featured title */
    protected String featuredTitle;
    
    
    
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


}
