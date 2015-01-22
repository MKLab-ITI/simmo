package gr.iti.mklab.simmo;

import gr.iti.mklab.simmo.associations.Interaction;
import gr.iti.mklab.simmo.documents.Post;
import gr.iti.mklab.simmo.documents.Webpage;
import gr.iti.mklab.simmo.mocks.MockObjectFactory;
import gr.iti.mklab.simmo.morphia.DAOManager;

import org.junit.Before;
import org.junit.Test;


/**
 * Created by kandreadou on 11/26/14.
 */
public class DAOManagerTest extends DAOTest {

    private DAOManager mgr;
    private DAOManager mgr2;

    @Before
    public void setup(){
        mgr = new DAOManager("morphia");
        mgr2 = new DAOManager("morphia2");
    }

    @Test
    public void test() {
        testInteraction();
    }

    public void testInteraction() {
        Interaction i = MockObjectFactory.getInteraction();
        mgr.saveInteraction(MockObjectFactory.getInteraction());
        mgr2.saveInteraction(MockObjectFactory.getInteraction());
    }

    public void testCreation() {
        mgr.saveCreation(MockObjectFactory.getCreation());
    }

    public void testPost() {
        mgr.savePost(MockObjectFactory.getPost("testid"));
        Post post = mgr.postDAO.findOne("numLikes", 4);
        int m = 5;
    }

    public void testWebpage() {
        mgr.saveWebpage(MockObjectFactory.getWebpage("http://www.wtf.eu"));
        Webpage page = mgr.pageDAO.findOne("url", "http://www.wtf.eu");
        int m = 5;
    }

}
