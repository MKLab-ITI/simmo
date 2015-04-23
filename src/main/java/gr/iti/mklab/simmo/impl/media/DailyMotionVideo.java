package gr.iti.mklab.simmo.impl.media;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import com.google.api.client.util.Key;

import gr.iti.mklab.simmo.core.items.Video;
import gr.iti.mklab.simmo.core.util.Location;
import gr.iti.mklab.simmo.impl.Sources;
import org.mongodb.morphia.annotations.Entity;

/**
 * Class that holds the information regarding the dailymotion video
 *
 * @author manosetro, kandreadou
 */
@Entity("Video")
public class DailyMotionVideo extends Video {

    public DailyMotionVideo(DailyMotionVideoItem video) throws Exception {
        url = video.embed_url;
        //id
        this.setId(Sources.DAILYMOTION + '#' + video.id);
        //SocialNetwork Name
        this.setSource(Sources.DAILYMOTION);
        //Time of publication
        creationDate = new Date(1000 * video.created_time);
        //PageUrl
        this.setWebPageUrl(video.url);
        //Thumbnail
        this.setThumbnail(video.thumbnail_url);
        //Title
        this.setTitle(video.title);
        //Tags
        this.setTags(new HashSet<>(Arrays.asList(video.tags)));
        //Popularity
        //comments = new Long(video.comments_total);
        numViews = video.views_total;
        numRatings = video.ratings_total;
        //Location
        double[] geoloc = video.geoloc;
        if (geoloc != null && geoloc.length > 0) {
            setLocation(new Location(geoloc[0], geoloc[1]));
        }

    }

    /**
     * Represents a daily motion video.
     */
    public static class DailyMotionVideoItem {
        @Key
        public String id, title, url, embed_url, thumbnail_url;
        @Key
        public String[] tags;
        @Key
        public int rating, ratings_total, views_total, comments_total;
        @Key
        public long created_time;
        @Key
        public double[] geoloc;
    }

}
