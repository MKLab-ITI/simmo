package gr.iti.mklab.simmo;

/**
 * An Annotation interface which can be instantiated in many different ways.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since July 3, 2014
 */
public interface Annotatable {
	
	
    /**
     * A list of annotatios 
     */
    protected List<Annotation> tags = new ArrayList<Annotation>();

}
