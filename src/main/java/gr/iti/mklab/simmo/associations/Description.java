package gr.iti.mklab.simmo.associations;

import gr.iti.mklab.simmo.*;
import org.mongodb.morphia.annotations.*;

/**
 * The generation of media objects is modeled through a Creation association between Source and Object.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 21, 2014
 */
@Entity
public class Description {

    private Annotation describes;
    private Annotatable isDescribed;


    public Description(){}

    public Description (Annotatable isDescribed, Annotation describes){
        this.isDescribed = isDescribed;
        this.describes = describes;
    }
    
    public Annotatable getIsDescribed(){
    	return isDescribed;
    }
    
    public Annotation getDescribes(){
    	return describes;
    }
    
}
