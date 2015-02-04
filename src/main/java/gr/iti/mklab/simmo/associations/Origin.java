package gr.iti.mklab.simmo.associations;

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
@Entity
public class Origin {

    @Reference
    protected Annotation firstAnnotation;

    @Reference
    protected Annotation secondAnnotation;

    public Origin(){}

    public Origin (Annotation annotation, Annotation originated){
        this.firstAnnotation = annotation;
        this.secondAnnotation = originated;
    }


    public Annotation getFirstAnnotation(){
        return firstAnnotation;
    }

    public Annotation getSecondAnnotation(){
        return secondAnnotation;
    }
    
}
