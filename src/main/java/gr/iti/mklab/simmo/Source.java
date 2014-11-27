package gr.iti.mklab.simmo;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

/**
 * @author amoumtzidou
 * @version 1.0.0
 * @see gr.iti.mklab.simmo
 * @since July 10, 2014
 */
public abstract class Source extends Annotatable {

    /** The internal unique id for this source */
    @Id
    private ObjectId objectId;

    public ObjectId getObjectId(){
        return objectId;
    }

}
