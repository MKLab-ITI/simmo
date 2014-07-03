package gr.iti.mklab.simmo;

/**
 *
 * @author kandreadou
 * @version 1.0.0
 * @since Jyly 3, 2014
 */
public class Reference {

    public enum ReferenceType {
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
