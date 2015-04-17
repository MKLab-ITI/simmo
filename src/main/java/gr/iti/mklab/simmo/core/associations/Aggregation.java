package gr.iti.mklab.simmo.core.associations;

import gr.iti.mklab.simmo.core.Association;
import gr.iti.mklab.simmo.core.Collection;
import gr.iti.mklab.simmo.core.Topic;
import org.mongodb.morphia.annotations.*;

/**
 * The generation of media objects is modeled through a Creation association between Source and Object.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 21, 2014
 */
@Entity("Association")
public class Aggregation extends Association {

    public Aggregation() {
    }

    public Aggregation(Topic aggregator, Collection aggregation) {
        super(aggregator, aggregation);
    }

    public Topic getAggregator() {
        return (Topic) one;
    }

    public Collection getAggregation() {
        return (Collection) other;
    }

}
