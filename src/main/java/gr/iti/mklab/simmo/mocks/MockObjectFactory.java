package gr.iti.mklab.simmo.mocks;

import gr.iti.mklab.simmo.UserAccount;
import gr.iti.mklab.simmo.associations.Affiliation;
import gr.iti.mklab.simmo.items.Image;
import gr.iti.mklab.simmo.util.Location;

import java.util.Date;

/**
 * Created by kandreadou on 9/12/14.
 */
public class MockObjectFactory {

    public static Image getImage(String id) {
        Image img = new Image();
        img.setWidth(800);
        img.setHeight(500);
        img.setId(id);
        img.setThumbnail("/home/fake/path");
        img.setDescription("this is not an image");
        img.setAuthor("me");
        img.setAlternateText("wtf?!");
        img.setExifMetadataField("codec", "jpeg");
        img.setCrawlDate(new Date(System.currentTimeMillis()));
        img.setLastModifiedDate(new Date(System.currentTimeMillis()));
        img.setTitle("OMG");
        img.setUrl("http://fake.url");
        img.setLocation(new Location(45.67, 36.78));
        return img;
    }

    public static UserAccount getUserAccount(String id, String name) {
        UserAccount ua = new UserAccount();
        ua.setId(id);
        ua.setName(name);
        ua.setNumFollowers(56000);
        ua.setAvatarSmall("/fake/path/to/a/avatar");
        return ua;
    }

    public static Affiliation getAffiliation() {
        Affiliation affiliation = new Affiliation(getUserAccount("test145", "Joe"), getUserAccount("test2", "Jane"), Affiliation.AFFILIATION_TYPE.FOLLOWS, new Date(System.currentTimeMillis()));
        return affiliation;
    }


}
