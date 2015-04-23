package gr.iti.mklab.simmo.impl.media;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import com.google.api.client.util.Key;

import gr.iti.mklab.simmo.core.items.Image;
import gr.iti.mklab.simmo.impl.Sources;
import gr.iti.mklab.simmo.impl.users.TwitPicAccount;
import org.mongodb.morphia.annotations.Entity;

/**
 * Class that holds the information regarding the twitpic media item
 *
 * @author manosetro, kandreadou
 */
@Entity("Image")
public class TwitPicImage extends Image {

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static String urlBase = "http://d3j5vwomefv46c.cloudfront.net/photos/large/";
    private static String thumbBase = "http://d3j5vwomefv46c.cloudfront.net/photos/thumb/";
    private static String pageBase = "http://twitpic.com/";

    public TwitPicImage(TwitPicImageItem image) throws Exception {
        url = urlBase + image.id + "." + image.type;

        //Id
        this.setId("Twitpic#" + image.id);
        //SocialNetwork Name
        this.setSource(Sources.TWITPIC);

        //Time of publication
        try {
            Date date = formatter.parse(image.timestamp);
            creationDate = date;
        } catch (Exception e) {

        }
        //PageUrl
        this.setWebPageUrl(pageBase + image.short_id);
        //Thumbnail
        this.setThumbnail(thumbBase + image.id + "." + image.type);
        //Title
        this.setTitle(image.message);
        //Tags
        if (image.tags != null) {
            this.setTags(new HashSet<>(Arrays.asList(image.tags.split(","))));
        }
        //Popularity
        numComments = image.number_of_comments;
        numViews = image.views;
        //Size
        setWidth(image.width);
        setHeight(image.height);
        setContributor(image.user);
    }


    /**
     * Class that holds the information regarding the twitpic image
     *
     * @author manosetro
     */
    public static class TwitPicImageItem {
        @Key
        public String id, message, tags, short_id, type;
        @Key
        public int views, number_of_comments, height, width;
        @Key
        public String timestamp;
        @Key
        public String user_id, location;
        @Key
        public TwitPicAccount user;
    }


}
