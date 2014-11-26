package gr.iti.mklab.simmo.annotations;

import gr.iti.mklab.simmo.associations.Annotation;
import org.mongodb.morphia.annotations.Entity;

/**
 * Original signifies if the {@link gr.iti.mklab.simmo.Object} is authentic or the product of processing or manipulation. This
 * can refer either to images / videos which have undergone some kind of processing
 * (malicious or not), or text (e.g. falsely attributed or claimed by an author
 * although it was created by another person). This annotation is expected to be used by
 * image manipulation detection or stylometry modules.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 22, 2014
 */
@Entity
public class Original implements Annotation {

    private boolean isOriginal = false;


    public Original(){}

    public Original(boolean isOriginal){
        this.isOriginal = isOriginal;
    }

    public boolean isOriginal() {
        return isOriginal;
    }

}
