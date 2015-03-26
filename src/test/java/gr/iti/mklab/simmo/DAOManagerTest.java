package gr.iti.mklab.simmo;

import gr.iti.mklab.simmo.cluster.Cluster;
import gr.iti.mklab.simmo.documents.Post;
import gr.iti.mklab.simmo.documents.Webpage;
import gr.iti.mklab.simmo.items.Image;
import gr.iti.mklab.simmo.jobs.CrawlJob;
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
    public void setup() {
        mgr = new DAOManager("morphia");
        //mgr2 = new DAOManager("morphia2");
    }

    @Test
    public void test() {
        testCrawl();
    }

    public void testCrawl(){
        mgr.crawlsDAO.save(new CrawlJob("daf","sdf", null, true));
    }

    public void testCluster(){
        Image im = MockObjectFactory.getImage("blabla");
        mgr.imageDAO.save(im);
        Cluster c = new Cluster();
        c.addMember(im);
        mgr.clusterDAO.save(c);
        Image im1 = (Image) mgr.clusterDAO.get("5514268300b04db3ca890382").members.get(0);
        int m = 5;
    }

    public void testPost() {
        mgr.savePost(MockObjectFactory.getPost("testid"));
        //Post post = mgr.postDAO.get("testid");
        //post.associations = mgr.associationDAO.findAssociationsForObject(post);
    }

    public void testWebpage() {
        mgr.saveWebpage(MockObjectFactory.getWebpage("http://www.wtf.eu"));
        Webpage page = mgr.pageDAO.findOne("url", "http://www.wtf.eu");
        int m = 5;
    }

}
