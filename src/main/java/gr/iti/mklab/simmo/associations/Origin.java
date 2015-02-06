package gr.iti.mklab.simmo.associations;

import gr.iti.mklab.simmo.Annotation;
import gr.iti.mklab.simmo.Association;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;
import org.mongodb.morphia.annotations.Reference;


/**
 * Affiliation models the implicit relation between two {@link gr.iti.mklab.simmo.UserAccount}
 * e.g. be friends with, follows
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 21, 2014
 */
@Entity("Association")
public class Origin extends Association {

    public Origin() {
    }

    public Origin(Annotation annotation, Annotation originated) {
        super(annotation, originated);
    }

    public Annotation getFirstAnnotation() {
        return (Annotation) one;
    }

    public Annotation getSecondAnnotation() {
        return (Annotation) other;
    }

}
