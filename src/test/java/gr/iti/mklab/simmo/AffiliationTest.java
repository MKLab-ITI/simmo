package gr.iti.mklab.simmo;

import gr.iti.mklab.simmo.associations.Affiliation;
import gr.iti.mklab.simmo.mocks.MockObjectFactory;
import gr.iti.mklab.simmo.morphia.MorphiaManager;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.dao.DAO;

/**
 * Created by kandreadou on 9/16/14.
 */
public class AffiliationTest extends DAOTest {

    @Test
    public void testAffiliation(){
        DAO<Affiliation, ObjectId> afDAO = new BasicDAO<Affiliation, ObjectId>(Affiliation.class, MorphiaManager.getMongoClient(), MorphiaManager.getMorphia(), MorphiaManager.getDB().getName());
        afDAO.save(MockObjectFactory.getAffiliation());
    }
}
