package gr.iti.mklab.simmo;

import gr.iti.mklab.simmo.associations.Interaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A generic super class which is instantiated as either {@link gr.iti.mklab.simmo.items.Media} or {@link gr.iti.mklab.simmo.Document}
 *
 * @author kandreadou
 * @version 1.0.0
 * @since July 3, 2014
 */
public abstract class Object implements Annotatable {

    /**
     * The object unique id
     */
    protected String id;

    protected String url;
    protected String title;
    protected String description;
    protected String author;

    /**
     * A list of tags in case of a social media item or a list of keywords
     * in case of an html based item
     */
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }

    public void addTag(String tag){
        tags.add(tag);
    }

    public void removeTag(String tag){
        tags.remove(tag);
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
