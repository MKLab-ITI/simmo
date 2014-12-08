package gr.iti.mklab.simmo.items;

import gr.iti.mklab.simmo.*;
import gr.iti.mklab.simmo.util.Location;
import org.mongodb.morphia.annotations.Embedded;

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
public abstract class Media extends Item {

    @Embedded
    protected Location location;

    protected String webPageUrl;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setWebPageUrl(String url){
        this.webPageUrl = url;
    }

    public String getWebPageUrl(){
        return this.webPageUrl;
    }

    @Override
    public ITEM_TYPE getType() {
        return type;
    }
}
