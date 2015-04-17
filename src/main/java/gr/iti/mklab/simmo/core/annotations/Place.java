package gr.iti.mklab.simmo.core.annotations;

import gr.iti.mklab.simmo.core.Annotation;
import gr.iti.mklab.simmo.core.util.Location;

/**
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 25, 2014
 */
public class Place extends Location implements Annotation {

    /** A confidence score indicating how confident the geolocation module is
     *  that this is the right and accurate Location */
    private float score;

    public Place(long longitude, long latitude, float score) {
        super(longitude, latitude);
        this.score = score;
    }
}
