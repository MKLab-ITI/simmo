package gr.iti.mklab.simmo.core.associations;

import gr.iti.mklab.simmo.core.Association;
import gr.iti.mklab.simmo.core.annotations.NamedEntity;
import org.mongodb.morphia.annotations.Entity;

/**
 * TextualRelation models a textual relation between {@link gr.iti.mklab.simmo.core.annotations.NamedEntity} items
 * with attributes such as the type of the relation. This is relevant for text relation extraction modules.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since November 5, 2014
 */
@Entity("Association")
public class TextualRelation extends Association {

    /**
     * The frequency of appearance of the relation
     */
    private int count;

    private String relation;

    public TextualRelation() {
    }

    public TextualRelation(NamedEntity first, NamedEntity second, String relation) {
        super(first, second);
        this.relation = relation;
    }

    public TextualRelation(NamedEntity first, NamedEntity second, String relation, int count) {
        super(first, second);
        this.relation = relation;
        this.count = count;
    }

    public NamedEntity getFirstEntity() {
        return (NamedEntity) one;
    }

    public NamedEntity getSecondEntity() {
        return (NamedEntity) other;
    }

    public String getRelation() {
        return relation;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
