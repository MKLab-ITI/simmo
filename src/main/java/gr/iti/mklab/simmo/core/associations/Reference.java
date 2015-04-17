package gr.iti.mklab.simmo.core.associations;

import gr.iti.mklab.simmo.core.Association;
import gr.iti.mklab.simmo.core.Document;
import org.mongodb.morphia.annotations.Entity;

/**
 * The Reference describes the relationship between {@link gr.iti.mklab.simmo.core.Document} objects using the
 * ReferenceType enumeration. Each Document contains a list of References to other Documents. Since a Reference
 * always belongs to a Document, it only needs to hold information concerning the type of relation and
 * the referenced Document.
 *
 * @author kandreadou
 * @version 1.0.0
 * @see gr.iti.mklab.simmo.core.Document
 * @since July 3, 2014
 */
@Entity("Association")
public class Reference extends Association  {

    public static enum ReferenceType {
        LINK, REPLY, COMMENT, UNDEFINED
    }

    private ReferenceType type;

    public Reference() {
    }

    public Reference(Document origDoc, Document refDoc, ReferenceType type) {
        super(origDoc, refDoc);
        this.type = type;
    }

    public ReferenceType getType() {
        return type;
    }

    public void setType(ReferenceType type) {
        this.type = type;
    }

    public Document getRefDocument() {
        return (Document) other;
    }

    public void setRefDocument(Document doc) {
        this.other = doc;
    }

    public Document getOriginalDocument() {
        return (Document) one;
    }

    public void setOriginalDocument(Document doc) {
        this.one = doc;
    }

}
