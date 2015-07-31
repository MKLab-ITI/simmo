package gr.iti.mklab.simmo.core.annotations;

import gr.iti.mklab.simmo.core.Annotation;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;


/**
 * @author kandreadou
 * @version 1.0.1
 * @since November 5, 2014
 */
@Entity
public class NamedEntity implements Annotation {

    @Id
    public String id = new ObjectId().toString();

    public enum NAMED_ENTITY_TYPE {PERSON, LOCATION, ORGANISATION, BRAND, TIME, AMOUNT, COMMUNICATION, NAME}

    ;


    /**
     * The modality  of descriptor
     */
    private NAMED_ENTITY_TYPE namedEntityType;

    /**
     * The named entity token, for instance "Yesterday"
     */
    private String token;

    /**
     * The named entity type, for instance "date"
     */
    private String type;


    /**
     * The named entity attribute, for instance "year"
     */
    private String attribute;

    /**
     * The number of occurences of this NamedEntity
     */
    private int count;

    public NamedEntity() {
    }

    public NamedEntity(String token, String type) {
        this.token = token;
        this.type = type;
    }

    public NamedEntity(String token, String type, int count) {
        this.token = token;
        this.type = type;
        this.count = count;
    }

    public NamedEntity(String token, NAMED_ENTITY_TYPE namedEntityType, String attribute) {
        this.token = token;
        this.namedEntityType = namedEntityType;
        this.attribute = attribute;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }


    public NAMED_ENTITY_TYPE getNamedEntityType() {
        return namedEntityType;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNamedEntityType(NAMED_ENTITY_TYPE namedEntityType) {
        this.namedEntityType = namedEntityType;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
