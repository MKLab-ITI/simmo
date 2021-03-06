package gr.iti.mklab.simmo.impl.media;

import java.util.Date;

import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.Thumbnail;
import com.google.api.services.youtube.model.VideoContentDetails;
import com.google.api.services.youtube.model.VideoSnippet;
import com.google.api.services.youtube.model.VideoStatistics;

import gr.iti.mklab.simmo.core.UserAccount;
import gr.iti.mklab.simmo.core.items.Video;
import gr.iti.mklab.simmo.impl.Sources;
import gr.iti.mklab.simmo.impl.users.YoutubeChannel;

import org.mongodb.morphia.annotations.Entity;


/**
 * Class that holds the information of a youtube video YouTube API v3
 *
 * @author kandreadou
 */
@Entity("Video")
public class YoutubeVideo extends Video {
    
    public YoutubeVideo(){
    	
    }

    public YoutubeVideo(com.google.api.services.youtube.model.Video v) {
        
    	setId(Sources.YOUTUBE + '#' + v.getId());
        
        setSource(Sources.YOUTUBE);
        
        title = v.getSnippet().getTitle();
        
        description = v.getSnippet().getDescription();
        
        creationDate = new Date(v.getSnippet().getPublishedAt().getValue());
        
        crawlDate = new Date();
        
        VideoStatistics statistics = v.getStatistics();
        if (statistics != null) {
        	if(statistics.getFavoriteCount() != null) {
        		numLikes = statistics.getFavoriteCount().intValue();
        	}
            if(statistics.getViewCount() != null) {
            	numViews = statistics.getViewCount().intValue();
            }
            if(statistics.getCommentCount() != null) {
            	numComments = statistics.getCommentCount().intValue();
            }
        }
        
        VideoContentDetails details = v.getContentDetails();
        if (details != null) {
            quality = details.getDefinition();
        }
        
        VideoSnippet snippet = v.getSnippet();
        Thumbnail t = snippet.getThumbnails().getHigh();
        
        setThumbnail(t.getUrl());
        
        setWidth(t.getWidth().intValue());
        
        setHeight(t.getHeight().intValue());
        
        url = "https://www.youtube.com/watch?v=" + v.getId();
        
        webPageUrl = url;
        
        UserAccount channel = new YoutubeChannel();
        
        channel.setId(Sources.YOUTUBE + '#' + snippet.getChannelId());
        channel.setSource(Sources.YOUTUBE);
        channel.setUserId(snippet.getChannelId());
        channel.setName(snippet.getChannelTitle());
        channel.setPageUrl("https://www.youtube.com/channel/" + snippet.getChannelId());
        channel.setDescription(snippet.getDescription());
        setContributor(channel);
    }

    public YoutubeVideo(com.google.api.services.youtube.model.Video v, Channel c) {
        this(v);
        setContributor(new YoutubeChannel(c));
    }

}
