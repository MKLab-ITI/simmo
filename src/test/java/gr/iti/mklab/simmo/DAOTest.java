package gr.iti.mklab.simmo;

import gr.iti.mklab.simmo.morphia.MorphiaManager;
import org.junit.After;
import org.junit.Before;
import org.mongodb.morphia.mapping.MappedClass;

/**
 * Created by kandreadou on 9/12/14.
 */
public class DAOTest {

    @Before
    public void setUp() {
        MorphiaManager.setup("morphia");
    }

    @After
    public void tearDown() {
        /*for (final MappedClass mc : MorphiaManager.getMorphia().getMapper().getMappedClasses()) {
            MorphiaManager.getDB().getCollection(mc.getCollectionName()).drop();
        }*/
        MorphiaManager.tearDown();
    }
}
