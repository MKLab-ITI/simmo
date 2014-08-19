package gr.iti.mklab.simmo;

import gr.iti.mklab.simmo.associations.Reference;

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
    protected List<Item> items = new ArrayList<Item>();

    /**
     * A list of references to other Documents
     */
    protected List<Reference> references = new ArrayList<Reference>();

    /**
     * The document language
     * TODO: Should this be an enum?
     */
    protected String language;

    /**
     * The document type
     * TODO: If this refers to Webpage or Post, it should be removed as it is covered by inheritance
     */
    protected String type;

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public List<Reference> getReferences() {
        return references;
    }

    public void addReferece(Reference reference){
        references.add(reference);
    }

    public void removeReference(Reference reference){
        references.remove(reference);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
