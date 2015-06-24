package gr.iti.mklab.simmo.impl.media;

import java.util.Date;

import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.VideoContentDetails;
import com.google.api.services.youtube.model.VideoStatistics;

import gr.iti.mklab.simmo.core.UserAccount;
import gr.iti.mklab.simmo.core.items.Video;
import gr.iti.mklab.simmo.impl.Sources;
import gr.iti.mklab.simmo.impl.users.YoutubeChannel;
import org.mongodb.morphia.annotations.Entity;


/**
 * Class that holds the information of a youtube video
 * YouTube API v3
 *
 * @author kandreadou
 */
@Entity("Video")
public class YoutubeVideo extends Video {
    
    public YoutubeVideo(){}

    public YoutubeVideo(com.google.api.services.youtube.model.Video v) {
        setId(Sources.YOUTUBE + '#' + v.getId());
        setSource(Sources.YOUTUBE);
        title = v.getSnippet().getTitle();
        description = v.getSnippet().getDescription();
        creationDate = new Date(v.getSnippet().getPublishedAt().getValue());
        crawlDate = new Date();
        VideoStatistics statistics = v.getStatistics();
        if (statistics != null) {
            numLikes = statistics.getFavoriteCount().intValue();
            numViews = statistics.getViewCount().intValue();
            numComments = statistics.getCommentCount().intValue();
        }
        VideoContentDetails details = v.getContentDetails();
        if (details != null) {
            quality = details.getDefinition();
        }
        com.google.api.services.youtube.model.Thumbnail t = v.getSnippet().getThumbnails().getHigh();
        setThumbnail(t.getUrl());
        setWidth(t.getWidth().intValue());
        setHeight(t.getHeight().intValue());
        url = "https://www.youtube.com/watch?v=" + v.getId();
        webPageUrl = url;
        UserAccount u = new UserAccount();
        u.setId(Sources.YOUTUBE + '#' + v.getSnippet().getChannelId());
        setContributor(u);
    }

    public YoutubeVideo(com.google.api.services.youtube.model.Video v, Channel c) {
        this(v);
        setContributor(new YoutubeChannel(c));
    }

}
