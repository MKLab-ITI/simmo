package gr.iti.mklab.simmo.core.associations;

import gr.iti.mklab.simmo.core.Annotatable;
import gr.iti.mklab.simmo.core.Annotation;
import gr.iti.mklab.simmo.core.Association;
import org.mongodb.morphia.annotations.*;

/**
 * The generation of media objects is modeled through a Creation association between Source and Object.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 21, 2014
 */
@Entity("Association")
public class Description extends Association {

    public Description() {
    }

    public Description(Annotatable isDescribed, Annotation describes) {
        super(isDescribed, describes);
    }

    public Annotatable getIsDescribed() {
        return (Annotatable) one;
    }

    public Annotation getDescribes() {
        return (Annotation) other;
    }

}
