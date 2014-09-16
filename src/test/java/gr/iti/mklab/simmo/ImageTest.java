package gr.iti.mklab.simmo;

import gr.iti.mklab.simmo.items.Image;
import gr.iti.mklab.simmo.mocks.MockObjectFactory;
import gr.iti.mklab.simmo.morphia.ImageDAO;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by kandreadou on 9/16/14.
 */
public class ImageTest extends DAOTest {

    @Test
    public void test(){
        testCrawledAfter();
    }

    public void testCrawledAfter(){
        String imageId = "todayTuesday";
        ImageDAO dao = new ImageDAO();
        dao.save(MockObjectFactory.getImage(imageId));
        // Create a calendar object with today date. Calendar is in java.util pakage.
        Calendar calendar = Calendar.getInstance();
        // Move calendar to yesterday
        calendar.add(Calendar.DATE, -1);
        List<Image> images = dao.crawledAfter(calendar.getTime());
        assertNotNull(images);
        assertEquals(images.get(0).getId(), imageId);
    }
}
