package gr.iti.mklab.simmo.associations;

import gr.iti.mklab.simmo.*;
import gr.iti.mklab.simmo.Object;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

/**
 * The generation of media objects is modeled through a Creation association between Source and Object.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 21, 2014
 */
@Entity
public class Creation {

    @org.mongodb.morphia.annotations.Reference
    private Source creator;

    @org.mongodb.morphia.annotations.Reference
    private Object creation;

    @Id
    private ObjectId objectId;

    public Creation(){}

    public Creation (Source creator, Object creation){
        this.creation = creation;
        this.creator = creator;
    }
    
    public ObjectId getId(){
    	return objectId;
    }
    
    public Source getCreator(){
    	return creator;
    }
    
    public Object getCreation(){
    	return creation;
    }
    
}
