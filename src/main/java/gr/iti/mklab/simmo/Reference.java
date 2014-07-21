package gr.iti.mklab.simmo;

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
public class Reference {

    public static enum ReferenceType {
        LINK, REPLY, COMMENT, UNDEFINED
    }

    private ReferenceType type;
    private String referencedDocumentId;

    public Reference(String id, ReferenceType type){
        this.referencedDocumentId = id;
        this.type = type;
    }

    public ReferenceType getType() {
        return type;
    }

    public void setType(ReferenceType type) {
        this.type = type;
    }

    public String getReferencedDocumentId() {
        return referencedDocumentId;
    }

    public void setReferencedDocumentId(String referencedDocumentId) {
        this.referencedDocumentId = referencedDocumentId;
    }
}
