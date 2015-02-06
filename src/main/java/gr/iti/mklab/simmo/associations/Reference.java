package gr.iti.mklab.simmo.associations;

import gr.iti.mklab.simmo.Association;
import gr.iti.mklab.simmo.Document;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

/**
 * The Reference describes the relationship between {@link gr.iti.mklab.simmo.Document} objects using the
 * ReferenceType enumeration. Each Document contains a list of References to other Documents. Since a Reference
 * always belongs to a Document, it only needs to hold information concerning the type of relation and
 * the referenced Document.
 *
 * @author kandreadou
 * @version 1.0.0
 * @see gr.iti.mklab.simmo.Document
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
