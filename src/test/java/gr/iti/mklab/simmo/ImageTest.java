package gr.iti.mklab.simmo;

import gr.iti.mklab.simmo.items.Image;
import gr.iti.mklab.simmo.mocks.MockObjectFactory;
import gr.iti.mklab.simmo.morphia.MediaDAO;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Test for ImageDao methods
 *
 * @author kandreadou
 * @version 1.0.0
 * @since September 17, 2014
 */
public class ImageTest extends DAOTest {

    @Test
    public void test() {
        testNear();
    }

    public void testCrawledAfter() {
        String imageId = "todayTuesday";
        MediaDAO<Image> dao = new MediaDAO<Image>(Image.class);
        dao.save(MockObjectFactory.getImage(imageId));
        // Create a calendar object with today date. Calendar is in java.util pakage.
        Calendar calendar = Calendar.getInstance();
        // Move calendar to yesterday
        calendar.add(Calendar.DATE, -1);
        List<Image> images = dao.crawledAfter(calendar.getTime());
        assertNotNull(images);
        assertEquals(images.get(0).getId(), imageId);
    }

    public void testNear() {
        MediaDAO<Image> dao = new MediaDAO<Image>(Image.class);
        dao.save(MockObjectFactory.getImage("paris", 48.8567, 2.3508));
        dao.save(MockObjectFactory.getImage("london", 51.5072, 0.1275));
        dao.save(MockObjectFactory.getImage("barcelona", 41.3833, 2.1833));
        dao.save(MockObjectFactory.getImage("milan", 45.4667, 9.1833));

        List<Image> images = dao.findNear(50.8500, 4.3500, 4);  //bruxelles
        for (Image i : images) {
            System.out.println(i.getId() + " " + i.getCrawlDate());
        }
    }
}
