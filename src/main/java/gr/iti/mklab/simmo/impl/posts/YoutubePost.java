package gr.iti.mklab.simmo.impl.posts;


import com.google.gdata.data.Person;
import com.google.gdata.data.extensions.Rating;
import com.google.gdata.data.media.mediarss.MediaDescription;
import com.google.gdata.data.media.mediarss.MediaPlayer;
import com.google.gdata.data.media.mediarss.MediaThumbnail;
import com.google.gdata.data.youtube.VideoEntry;
import com.google.gdata.data.youtube.YouTubeMediaContent;
import com.google.gdata.data.youtube.YouTubeMediaGroup;
import com.google.gdata.data.youtube.YtStatistics;
import gr.iti.mklab.simmo.core.Item;
import gr.iti.mklab.simmo.core.documents.Post;
import gr.iti.mklab.simmo.core.items.Video;
import gr.iti.mklab.simmo.impl.Sources;
import gr.iti.mklab.simmo.impl.users.YoutubeAccount;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.mongodb.morphia.annotations.Entity;

/**
 * Class that holds the information of a youtube video
 * YouTube API v2
 *
 * @author kandreadou
 * @deprecated because Youtube API v2 is now obsolete
 * use {@link gr.iti.mklab.simmo.impl.media.YoutubeVideo} instead
 */
@Deprecated
@Entity("Post")
public class YoutubePost extends Post {

    public YoutubePost() {
    }

    public YoutubePost(VideoEntry videoEntry) {

        if (videoEntry == null || videoEntry.getId() == null)
            return;

        //Crawl date
        Date now = new Date();
        setCrawlDate(now);
        YouTubeMediaGroup mediaGroup = videoEntry.getMediaGroup();
        //Id
        id = Sources.YOUTUBE + "#" + mediaGroup.getVideoId();
        //Timestamp of the creation of the video
        creationDate = new Date(mediaGroup.getUploaded().getValue());
        //Title of the video
        title = mediaGroup.getTitle().getPlainTextContent();
        //Description of the video
        MediaDescription desc = mediaGroup.getDescription();
        description = desc == null ? "" : desc.getPlainTextContent();
        //User that uploaded the video
        List<Person> authors = videoEntry.getAuthors();
        if (authors.size() > 0) {
            contributor = new YoutubeAccount(authors.get(0));
        } else {
            if (mediaGroup.getUploader() != null) {
                contributor = new YoutubeAccount(mediaGroup.getUploader());
            }
        }
        //Popularity
        YtStatistics statistics = videoEntry.getStatistics();
        if (statistics != null) {
            numLikes = (int) statistics.getFavoriteCount();
            numViews = (int) statistics.getViewCount();
        }

        //Getting the video
        List<MediaThumbnail> thumbnails = mediaGroup.getThumbnails();
        MediaPlayer mediaPlayer = mediaGroup.getPlayer();

        // Page Url of this Item
        url = mediaPlayer.getUrl();

        String videoID = videoEntry.getId().substring(videoEntry.getId().indexOf("video:") + ("video:").length());
        List<YouTubeMediaContent> mediaContent = mediaGroup.getYouTubeContents();

        String videoURL = null;
        for (YouTubeMediaContent content : mediaContent) {
            if (content.getType().equals("application/x-shockwave-flash")) {
                videoURL = content.getUrl();
                break;
            }
        }
        if (videoURL == null)
            videoURL = mediaPlayer.getUrl();

        URL url = null;
        try {
            url = new URL(videoURL);
        } catch (MalformedURLException e1) {
            return;
        }

        int size = 0;
        MediaThumbnail thumbnail = null;
        for (MediaThumbnail thumb : thumbnails) {
            int t_size = thumb.getWidth() * thumb.getHeight();
            if (size < t_size) {
                size = t_size;
                thumbnail = thumb;
            }
        }

        if (thumbnail != null) {
            //url
            Video mediaItem = new Video();
            mediaItem.setUrl(url.toString());
            String mediaId = Sources.YOUTUBE + "#" + videoID;

            //id
            mediaItem.setId(mediaId);
            //SocialNetwork Name
            mediaItem.setSource(Sources.YOUTUBE);
            //Time of publication
            mediaItem.setCreationDate(creationDate);
            //Author
            if (contributor != null) {
                mediaItem.setContributor(contributor);
            }
            //Thumbnail
            String thumbUrl = thumbnail.getUrl();
            mediaItem.setThumbnail(thumbUrl);
            //Title
            mediaItem.setTitle(title);
            //Description
            mediaItem.setDescription(description);
            //Tags
            mediaItem.setTags(tags);
            //Popularity
            if (statistics != null) {
                mediaItem.setNumLikes(numLikes);
                mediaItem.setNumViews(numViews);
            }
            Rating rating = videoEntry.getRating();
            if (rating != null) {
                mediaItem.setNumRatings(rating.getNumRaters());
            }
            //Size
            mediaItem.setWidth(thumbnail.getWidth());
            mediaItem.setHeight(thumbnail.getHeight());
            //Crawl date
            mediaItem.setCrawlDate(now);
            items.add(mediaItem);
        }

    }

    public YoutubePost(VideoEntry videoEntry, YoutubeAccount user) {

        this(videoEntry);

        //User that posted the post
        contributor = user;

        for (Item mItem : this.items) {
            mItem.setContributor(contributor);
        }

    }
}
