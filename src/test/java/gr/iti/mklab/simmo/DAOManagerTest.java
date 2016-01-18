package gr.iti.mklab.simmo;

import gr.iti.mklab.simmo.core.cluster.Cluster;
import gr.iti.mklab.simmo.core.documents.Post;
import gr.iti.mklab.simmo.core.documents.Webpage;
import gr.iti.mklab.simmo.core.items.Image;
import gr.iti.mklab.simmo.core.jobs.CrawlJob;
import gr.iti.mklab.simmo.core.mocks.MockObjectFactory;
import gr.iti.mklab.simmo.core.morphia.DAOManager;

import org.junit.Before;
import org.junit.Test;


/**
 * Created by kandreadou on 11/26/14.
 */
public class DAOManagerTest extends DAOTest {

    private DAOManager mgr;
    private DAOManager mgr2;

    @Before
    public void setup() {
        mgr = new DAOManager("morphia4");
        //mgr2 = new DAOManager("morphia2");
    }

    @Test
    public void test() {
        testPost();
    }

    public void testCrawl() {
        mgr.crawlsDAO.save(new CrawlJob("daf", "sdf", null, true));
    }

    public void testCluster() {
        Image im = MockObjectFactory.getImage("blabla");
        mgr.imageDAO.save(im);
        Cluster c = new Cluster();
        c.addMember(im);
        mgr.clusterDAO.save(c);
    }

    public void testPost() {
        //mgr.savePost(MockObjectFactory.getPost("testid"));
        //List<Image> im = mgr.imageDAO.getNotVIndexed(5);
       //Post post = mgr.postDAO.get("testid");
        //post.associations = mgr.associationDAO.findAssociationsForObject(post);
    }

    public void testWebpage() {
        mgr.saveWebpage(MockObjectFactory.getWebpage("http://www.wtf.eu"));
        Webpage page = mgr.pageDAO.findOne("url", "http://www.wtf.eu");
        int m = 5;
    }

}
