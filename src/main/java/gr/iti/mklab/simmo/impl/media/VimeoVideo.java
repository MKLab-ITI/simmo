package gr.iti.mklab.simmo.impl.media;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import com.google.api.client.util.Key;

import gr.iti.mklab.simmo.core.UserAccount;
import gr.iti.mklab.simmo.core.items.Video;
import gr.iti.mklab.simmo.impl.Sources;
import org.mongodb.morphia.annotations.Entity;

/**
 * Class that holds the information regarding the vimeo media item
 * @author manosetro, kandreadou
 */
@Entity("Video")
public class VimeoVideo extends Video {
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public VimeoVideo(VimeoVideoItem video) throws Exception {
		//url
        url = "http://vimeo.com/moogaloop.swf?clip_id="+video.id;
		//Id
        id = "Vimeo#"+video.id;
        source = Sources.VIMEO;
		//Time of publication
		try {
			Date date = formatter.parse(video.upload_date);
			creationDate = date;
		}
		catch(Exception e) {}
		//PageUrl
		webPageUrl = video.url;
		//Thumbnail
		this.setThumbnail(video.thumbnail_large);
		//Title
		this.setTitle(video.title);
		//Description
		this.setDescription(video.description);
		//Tags
		String tags = video.tags;
		if(tags != null) {
			this.setTags(new HashSet<>(Arrays.asList(tags.split(","))));
		}
		//Description
		this.setDescription(video.description);
		//Popularity
		numLikes = video.stats_number_of_likes;
		numViews = video.stats_number_of_plays;
		numComments = video.stats_number_of_comments;
		//Size
        setWidth(video.width);
        setHeight(video.height);

        UserAccount u = new UserAccount();
        u.setId(String.valueOf(video.user_id));

		setContributor(u);
	}
	
	public static class VimeoVideoItem {
		@Key
		public int id;
		@Key
		public String title, url, thumbnail_large, description, tags;
		@Key
		public int stats_number_of_comments, stats_number_of_likes, stats_number_of_plays;
		@Key
		public String upload_date;
		@Key
		public int user_id;
		@Key
		public int height, width;
	}

}
