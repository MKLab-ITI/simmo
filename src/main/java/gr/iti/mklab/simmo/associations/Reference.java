package gr.iti.mklab.simmo.associations;

import gr.iti.mklab.simmo.Document;
import org.mongodb.morphia.annotations.Embedded;

/**
 * The Reference describes the relationship between {@link gr.iti.mklab.simmo.Document} objects using the
 * ReferenceType enumeration. Each Document contains a list of References to other Documents. Since a Reference
 * always belongs to a Document, it only needs to hold information concerning the type of relation and
 * the referenced Document.
 *
 * @see gr.iti.mklab.simmo.Document
 * @author kandreadou
 * @version 1.0.0
 * @since July 3, 2014
 */
public class Reference  {

    public static enum ReferenceType {
        LINK, REPLY, COMMENT, UNDEFINED
    }

    private ReferenceType type;

    @org.mongodb.morphia.annotations.Reference
    private Document refDocument;

    public Reference(){}

    public Reference(Document doc, ReferenceType type){
        this.refDocument = doc;
        this.type = type;
    }

    public ReferenceType getType() {
        return type;
    }

    public void setType(ReferenceType type) {
        this.type = type;
    }

    public Document getDocument() {
        return refDocument;
    }

    public void setDocument(Document doc) {
        this.refDocument = doc;
    }
}
