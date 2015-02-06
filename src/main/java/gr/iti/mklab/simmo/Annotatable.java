package gr.iti.mklab.simmo;

import org.mongodb.morphia.annotations.Embedded;

import java.util.ArrayList;
import java.util.List;

/**
 * An Annotatable abstract class implemented by objects that can be annotated
 *
 * @author kandreadou
 * @version 1.0.0
 * @since July 3, 2014
 */
public abstract class Annotatable implements Associated {

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
