package gr.iti.mklab.simmo;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A generic super class which is instantiated as either {@link gr.iti.mklab.simmo.items.Media} or {@link gr.iti.mklab.simmo.Document}
 *
 * @author kandreadou
 * @version 1.0.0
 * @since Jyly 3, 2014
 */
public abstract class Object {

    /**
     * The object unique id
     */
    protected String id;
    protected URL url;
    protected String title;
    protected String description;
    protected List<String> tags = new ArrayList<String>();
    protected Date creationDate;
    protected Date lastModifiedDate;
    protected Date crawlDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getCrawlDate() {
        return crawlDate;
    }

    public void setCrawlDate(Date crawlDate) {
        this.crawlDate = crawlDate;
    }
}
