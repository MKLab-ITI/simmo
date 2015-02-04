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
public class Aggregation {

    @org.mongodb.morphia.annotations.Reference
    private Topic aggregator;

    @org.mongodb.morphia.annotations.Reference
    private Collection aggregation;


    public Aggregation(){}

    public Aggregation (Topic aggregator, Collection aggregation){
        this.aggregator = aggregator;
        this.aggregation = aggregation;
    }
    
    public Topic getAggregator(){
    	return aggregator;
    }
    
    public Collection getAggregation(){
    	return aggregation;
    }
    
}
