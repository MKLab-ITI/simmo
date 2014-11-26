package gr.iti.mklab.simmo;

import gr.iti.mklab.simmo.documents.Post;
import gr.iti.mklab.simmo.mocks.MockObjectFactory;
import gr.iti.mklab.simmo.morphia.DAOManager;

import org.junit.Test;


/**
 * Created by kandreadou on 11/26/14.
 */
public class PostTest extends DAOTest {

    @Test
    public void testPost(){
        DAOManager.savePost(MockObjectFactory.getPost("testid"));
        Post post = DAOManager.postDAO.findOne("numLikes",4);
        int m = 5;
    }
}
