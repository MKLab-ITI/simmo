package gr.iti.mklab.simmo.impl.media;

import com.google.api.client.util.Key;
import gr.iti.mklab.simmo.core.items.Image;
import gr.iti.mklab.simmo.core.util.Location;
import gr.iti.mklab.simmo.impl.Sources;
import gr.iti.mklab.simmo.impl.users.PanoramioAccount;
import org.mongodb.morphia.annotations.Entity;

/**
 * Class that holds the information regarding the panoramio media item
 *
 * @author kandreadou
 */
@Entity("Image")
public class PanoramioImage extends Image {

    public PanoramioImage() {
    }

    public PanoramioImage(PanoramioItem item) {
        url = item.photo_file_url;
        webPageUrl = item.photo_url;
        title = item.photo_title;
        id = Sources.PANORAMIO + '#' + item.photo_id;
        source = Sources.PANORAMIO;
        setWidth(item.width);
        setHeight(item.height);
        setLocation(new Location(item.latitude, item.longitude));
        //setContributor(new PanoramioAccount(String.valueOf(item.owner_id), item.owner_url, item.owner_name));
    }

    /*
        From http://www.panoramio.com/api/data/api.html
        Wrapper class for deserialization

        "photo_id": 532693,
          "photo_title": "Wheatfield in afternoon light",
          "photo_url": "http://www.panoramio.com/photo/532693",
          "photo_file_url": "http://static2.bareka.com/photos/medium/532693.jpg",
          "longitude": 11.280727,
          "latitude": 59.643198,
          "width": 500,
          "height": 333,
          "upload_date": "22 January 2007",
          "owner_id": 39160,
          "owner_name": "Snemann",
          "owner_url": "http://www.panoramio.com/user/39160",

     */
    public static class PanoramioItem {
        @Key
        public long photo_id, owner_id;
        @Key
        public String photo_title, photo_url, photo_file_url, owner_name, owner_url, upload_date;
        @Key
        public double longitude, latitude;
        @Key
        public int width, height;
    }
}
