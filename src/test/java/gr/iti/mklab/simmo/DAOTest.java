package gr.iti.mklab.simmo;

import gr.iti.mklab.simmo.core.morphia.MorphiaManager;
import org.junit.After;
import org.junit.Before;

/**
 * Created by kandreadou on 9/12/14.
 */
public class DAOTest {

    @Before
    public void setUp() {
        MorphiaManager.setup("127.0.0.1");
    }

    @After
    public void tearDown() {
        /*for (final MappedClass mc : MorphiaManager.getMorphia().getMapper().getMappedClasses()) {
            MorphiaManager.getDB().getCollection(mc.getCollectionName()).drop();
        }*/
        MorphiaManager.tearDown();
    }
}
