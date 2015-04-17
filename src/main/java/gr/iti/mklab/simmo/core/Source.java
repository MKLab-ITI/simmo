package gr.iti.mklab.simmo.core;


import org.mongodb.morphia.annotations.Id;

import java.util.Date;

/**
 * @author amoumtzidou
 * @version 1.0.0
 * @see gr.iti.mklab.simmo
 * @since July 10, 2014
 */
public abstract class Source extends Annotatable {

    /**
     * The internal unique id for this source
     */
    @Id
    private String id;

    protected String pageUrl;

    protected String location;

    protected String description;

    protected Date creationDate;

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
