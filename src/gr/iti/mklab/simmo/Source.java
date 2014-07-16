package gr.iti.mklab.simmo;

/**
 * 
 * @author amoumtzidou
 * @version 1.0.0
 * @see gr.iti.mklab.simmo
 * @since July 10, 2014
 */
public interface Source extends Annotatable {

	 /**
     * A list of Objects that the Source contains
     */
    protected List<Object> items = new ArrayList<Object>();
    
}
