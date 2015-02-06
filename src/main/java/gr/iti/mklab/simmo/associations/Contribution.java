package gr.iti.mklab.simmo.associations;

import gr.iti.mklab.simmo.*;
import gr.iti.mklab.simmo.Object;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

/**
 * The generation of media objects is modeled through a Contribution association between Source and Object.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 21, 2014
 */
@Entity("Association")
public class Contribution extends Association {

    public Contribution() {
    }

    public Contribution(Source contributor, Object contribution) {
        super(contributor, contribution);
    }

    public Source getContributor() {
        return (Source) one;
    }

    public Object getContribution() {
        return (Object) other;
    }

}
