package gr.iti.mklab.simmo.impl.users;

import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelStatistics;

import gr.iti.mklab.simmo.core.UserAccount;
import gr.iti.mklab.simmo.impl.Sources;
import org.mongodb.morphia.annotations.Entity;

import java.util.Date;

/**
 * Class that holds the information of a youtube user
 * YouTube API v3
 *
 * @author kandreadou
 */
@Entity("UserAccount")
public class YoutubeChannel extends UserAccount {

    public YoutubeChannel(){}

    public YoutubeChannel(Channel c) {
        setId(Sources.YOUTUBE + '#' + c.getId());
        source = Sources.YOUTUBE;
        name = c.getSnippet().getTitle();
        description = c.getSnippet().getDescription();
        com.google.api.services.youtube.model.Thumbnail t = c.getSnippet().getThumbnails().getDefault();
        setAvatarBig(t.getUrl());
        ChannelStatistics s = c.getStatistics();
        if (s != null) {
            setNumFollowers(s.getSubscriberCount().intValue());
        }
        pageUrl = "https://www.youtube.com/channel/" + c.getId();
        numItems = s.getVideoCount().intValue();
        creationDate = new Date(c.getSnippet().getPublishedAt().getValue());
    }

}
