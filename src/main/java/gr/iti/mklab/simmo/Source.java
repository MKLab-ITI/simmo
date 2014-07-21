package gr.iti.mklab.simmo;

import java.util.ArrayList;
import java.util.List;

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
    List<Object> items = new ArrayList<Object>();
    
}
