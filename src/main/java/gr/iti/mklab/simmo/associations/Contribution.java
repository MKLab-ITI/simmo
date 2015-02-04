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
public class Contribution {

    @org.mongodb.morphia.annotations.Reference
    private Source contributor;

    @org.mongodb.morphia.annotations.Reference
    private Object contribution;

    @Id
    private ObjectId objectId;

    public Contribution(){}

    public Contribution (Source contributor, Object contribution){
        this.contribution = contribution;
        this.contributor = contributor;
    }
    
    public ObjectId getId(){
    	return objectId;
    }
    
    public Source getContributor(){
    	return contributor;
    }
    
    public Object getContribution(){
    	return contribution;
    }
    
}
