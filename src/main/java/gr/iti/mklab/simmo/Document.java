package gr.iti.mklab.simmo;

import gr.iti.mklab.simmo.associations.Contribution;
import org.mongodb.morphia.annotations.Reference;
import org.mongodb.morphia.annotations.Transient;

import java.util.ArrayList;
import java.util.List;

/**
 * A Document consists of {@link gr.iti.mklab.simmo.Item} objects, i.e., {@link gr.iti.mklab.simmo.items.Text},
 * {@link gr.iti.mklab.simmo.items.Video} and is instantiated as Webpage or Post.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since July 3, 2014
 */
public abstract class Document extends Object {

    /**
     * A list of items that the Documents contains
     */
    @org.mongodb.morphia.annotations.Reference
    protected List<Item> items = new ArrayList<Item>();

    /**
     * The document language
     */
    protected String language;

    /**
     * The document type
     */
    protected String type;


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void addAssociation(Association a){
        associations.add(a);
    }

    public void removeAssociation(Association a){
        associations.remove(a);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
