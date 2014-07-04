package gr.iti.mklab.simmo.items;

import gr.iti.mklab.simmo.*;
import gr.iti.mklab.simmo.Object;
import gr.iti.mklab.simmo.util.Location;

/**
 * An abstract media item.
 * TODO: As Media id, shall we use the Object or the Item id?
 *
 * @see gr.iti.mklab.simmo.Item
 * @see gr.iti.mklab.simmo.Object
 *
 * @version 1.0.0
 * @since July 3, 2014
 * @author kandreadou
 */
public abstract class Media extends Object implements Item {

    protected Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
