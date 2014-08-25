package gr.iti.mklab.simmo.annotations;

import gr.iti.mklab.simmo.associations.Annotation;

import java.util.HashMap;

/**
 * A Map of concepts and confidence scores attributed to the object.
 * For instance, [{"Sky", 0.67}, {"Sport", 0.34}]
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 25, 2014
 */
public class Concepts extends HashMap<String, Float> implements Annotation {


}
