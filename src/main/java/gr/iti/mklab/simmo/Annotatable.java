package gr.iti.mklab.simmo;

import gr.iti.mklab.simmo.associations.Annotation;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * An Annotation interface which can be instantiated in many different ways.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since July 3, 2014
 */
public abstract class Annotatable {

    @Embedded
    private List<Annotation> annotations = new ArrayList<Annotation>();

    public void addAnnotation(Annotation a){
        annotations.add(a);
    }

    public void removeAnnotation(Annotation a){
        annotations.remove(a);
    }

    public void setAnnotations(List<Annotation> annotations){
        this.annotations = annotations;
    }

    public Annotation getAnnotation(int position){
        return annotations.get(position);
    }

}
