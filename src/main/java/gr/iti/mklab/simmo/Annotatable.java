package gr.iti.mklab.simmo;

import gr.iti.mklab.simmo.associations.Annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * An Annotation interface which can be instantiated in many different ways.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since July 3, 2014
 */
public interface Annotatable {

    public List<Annotation> annotations = new ArrayList<Annotation>();

}
