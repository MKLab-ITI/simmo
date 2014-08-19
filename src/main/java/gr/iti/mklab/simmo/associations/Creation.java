package gr.iti.mklab.simmo.associations;

import gr.iti.mklab.simmo.*;
import gr.iti.mklab.simmo.Object;

/**
 * The generation of media objects is modelled through a Creation association between Source and Object.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since July 3, 2014
 */
public class Creation {

    private Source creator;

    private Object creation;

    public Creation (Source creator, Object creation){
        this.creation = creation;
        this.creator = creator;
    }
}
