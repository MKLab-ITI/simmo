package gr.iti.mklab.simmo;

import gr.iti.mklab.simmo.associations.Interaction;
import gr.iti.mklab.simmo.documents.Post;
import gr.iti.mklab.simmo.documents.Webpage;
import gr.iti.mklab.simmo.mocks.MockObjectFactory;
import gr.iti.mklab.simmo.morphia.DAOManager;

import org.junit.Test;


/**
 * Created by kandreadou on 11/26/14.
 */
public class DAOManagerTest extends DAOTest {

    @Test
    public void test() {
        testInteraction();
    }

    public void testInteraction() {
        Interaction i = MockObjectFactory.getInteraction();
        DAOManager.saveInteraction(MockObjectFactory.getInteraction());
    }

    public void testCreation() {
        DAOManager.saveCreation(MockObjectFactory.getCreation());
    }

    public void testPost() {
        DAOManager.savePost(MockObjectFactory.getPost("testid"));
        Post post = DAOManager.postDAO.findOne("numLikes", 4);
        int m = 5;
    }

    public void testWebpage() {
        DAOManager.saveWebpage(MockObjectFactory.getWebpage("http://www.wtf.eu"));
        Webpage page = DAOManager.pageDAO.findOne("url", "http://www.wtf.eu");
        int m = 5;
    }

}
