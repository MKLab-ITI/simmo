package gr.iti.mklab.simmo.associations;

import gr.iti.mklab.simmo.annotations.NamedEntity;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 * TextualRelation models a textual relation between {@link gr.iti.mklab.simmo.annotations.NamedEntity} items
 * with attributes such as the type of the relation. This is relevant for text relation extraction modules.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since November 5, 2014
 */
@Entity
public class TextualRelation {

    @Reference
    private NamedEntity first;

    @Reference
    private NamedEntity second;

    private String relation;

    @Id
    private String id;

    public TextualRelation(){}

    public TextualRelation(NamedEntity first, NamedEntity second, String relation){
        this.first = first;
        this.second = second;
        this.relation = relation;
    }

    public NamedEntity getFirstEntity(){
        return first;
    }

    public NamedEntity getSecondEntity(){
        return second;
    }

    public String getRelation(){
        return relation;
    }
}
