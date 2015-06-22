package gr.iti.mklab.simmo.core;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Reference;

/**
 * The Association interface models the relations between the SIMMO elements
 *
 * @author kandreadou
 */
public abstract class Association {

    @Id
    private ObjectId id = new ObjectId();

    @Reference(ignoreMissing=true)
    @Indexed
    protected Associated one;

    @Reference(ignoreMissing=true)
    @Indexed
    protected Associated other;

    public Association() {
    }

    public Association(Associated one, Associated other) {
        this.one = one;
        this.other = other;
    }
}
