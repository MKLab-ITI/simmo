package gr.iti.mklab.simmo.core;

import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;
import org.mongodb.morphia.annotations.Transient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A generic super class which is instantiated as either {@link gr.iti.mklab.simmo.core.items.Media} or {@link Document}
 * This class is not abstract any more because morphia has problems with abstract classes.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since July 3, 2014
 */
public abstract class Object extends Annotatable {

    /**
     * The object unique id
     */
    @Id
    protected String id;

    protected String url;
    protected String title;
    protected String description;

    /**
     * A list of tags in case of a social media item or a list of keywords
     * in case of an html based item
     */
    protected List<String> tags = new ArrayList<String>();
    protected Date creationDate;
    protected Date lastModifiedDate;
    protected Date crawlDate;

    @Reference
    protected UserAccount contributor;

    /**
     * This is a transient field, not stored in the respective collection.
     * Its only use is for helping data parsing and storing.
     */
    @Transient
    protected List<Association> associations = new ArrayList<Association>();

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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags){this.tags = tags;}

    public void addTag(String tag) {
        tags.add(tag);
    }

    public void removeTag(String tag) {
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

    public void addAssociation(Association a) {
        associations.add(a);
    }

    public void removeAssociation(Association a) {
        associations.remove(a);
    }

    public List<Association> getAssociations() {
        return associations;
    }

    public UserAccount getContributor() {
        return contributor;
    }

    public void setContributor(UserAccount contributor) {
        this.contributor = contributor;
    }

    public <T extends Association> List<T> getAssociationsOfType(Class<T> type) {
        return (List<T>) associations.stream()
                .filter(t -> t.getClass() == type).collect(Collectors.toList());
    }

    public List<gr.iti.mklab.simmo.core.associations.Reference> getLinks() {
        return getReferenceOfType(gr.iti.mklab.simmo.core.associations.Reference.ReferenceType.LINK);
    }

    public List<gr.iti.mklab.simmo.core.associations.Reference> getReplies() {
        return getReferenceOfType(gr.iti.mklab.simmo.core.associations.Reference.ReferenceType.REPLY);
    }

    private List<gr.iti.mklab.simmo.core.associations.Reference> getReferenceOfType(gr.iti.mklab.simmo.core.associations.Reference.ReferenceType type) {
        List<gr.iti.mklab.simmo.core.associations.Reference> refs = getAssociationsOfType(gr.iti.mklab.simmo.core.associations.Reference.class);
        return refs.stream()
                .filter(t -> t.getType() == type)
                .collect(Collectors.toList());
    }
}
