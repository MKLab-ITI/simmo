package gr.iti.mklab.simmo.morphia;

import gr.iti.mklab.simmo.items.Image;
import gr.iti.mklab.simmo.mocks.MockObjectFactory;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.BasicDAO;

/**
 * Image Data Access Object
 *
 * @author kandreadou
 * @version 1.0.0
 * @since September 12, 2014
 */
public class ImageDAO extends BasicDAO<Image, ObjectId> {

    public ImageDAO() {
        super(Image.class, MorphiaManager.getMongoClient(), MorphiaManager.getMorphia(), MorphiaManager.getDB().getName());
    }

    public static void main(String[] args) throws Exception {
        MorphiaManager.setup("morphia");
        ImageDAO dao = new ImageDAO();
        dao.save(MockObjectFactory.getImage("someid"));
        MorphiaManager.tearDown();
    }
}
