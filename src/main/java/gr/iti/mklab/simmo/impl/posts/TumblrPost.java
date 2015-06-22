package gr.iti.mklab.simmo.impl.posts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import gr.iti.mklab.simmo.core.associations.Reference;
import gr.iti.mklab.simmo.core.documents.Webpage;
import gr.iti.mklab.simmo.core.items.Image;
import gr.iti.mklab.simmo.impl.Sources;
import gr.iti.mklab.simmo.impl.users.TumblrAccount;
import org.apache.log4j.Logger;

import com.tumblr.jumblr.types.LinkPost;
import com.tumblr.jumblr.types.Photo;
import com.tumblr.jumblr.types.PhotoPost;
import com.tumblr.jumblr.types.PhotoSize;
import com.tumblr.jumblr.types.Post;
import com.tumblr.jumblr.types.Video;
import com.tumblr.jumblr.types.VideoPost;
import org.mongodb.morphia.annotations.Entity;


/**
 * Class that holds the information of a tumblr post
 *
 * @author ailiakop, kandreadou
 */
@Entity("Post")
public class TumblrPost extends gr.iti.mklab.simmo.core.documents.Post {

    public TumblrPost(Post post, TumblrAccount user) throws MalformedURLException {

        if (post == null || post.getId() == null) {
            return;
        }

        //Crawl date
        Date now = new Date();
        setCrawlDate(now);

        id = Sources.TUMBLR + "#" + post.getId();

        //SocialNetwork Name
        type = Sources.TUMBLR.toString();

        //Timestamp of the creation of the post
        creationDate = new Date(post.getTimestamp() * 1000);

        url = post.getPostUrl();

        title = post.getBlogName();

        contributor = user;

        //Tags
        post.getTags().stream().forEach(hashtag -> {
            tags.add(hashtag.toString());
        });

        //Items - WebPages in a post
        String pageURL = post.getPostUrl();

        int number = 0;
        if (post.getType().equals("photo")) {
            PhotoPost phPost;
            phPost = (PhotoPost) post;

            List<Photo> photos = phPost.getPhotos();
            if (photos == null)
                return;

            try {
                for (Photo photo : photos) {

                    String caption = photo.getCaption();
                    number++;

                    List<PhotoSize> allSizes = photo.getSizes();
                    String photoUrl = allSizes.get(0).getUrl();
                    String thumbnail = allSizes.get(allSizes.size() - 1).getUrl();

                    if (photoUrl != null) {

                        URL url = new URL(photoUrl);
                        //url
                        Image img = new Image();
                        img.setUrl(url.toString());
                        img.setId(Sources.TUMBLR + "#" + post.getId() + "_" + number);
                        img.setSource(Sources.TUMBLR);
                        img.setCreationDate(creationDate);
                        img.setWebPageUrl(pageURL);
                        img.setTitle(title);
                        img.setDescription(caption);
                        img.setThumbnail(thumbnail);
                        img.setTags(tags);
                        img.setContributor(user);
                        img.setSourceDocumentId(id);
                        img.setCrawlDate(now);
                        items.add(img);
                    }
                }
            } catch (MalformedURLException e1) {
                System.out.println("Photo URL is distorted: " + e1);
            } catch (Exception e2) {
                System.out.println("Exception: " + e2);
            }
        } else if (post.getType().equals("video")) {
            VideoPost vidPost = (VideoPost) post;
            List<Video> videos = vidPost.getVideos();

            String embedCode = videos.get(0).getEmbedCode();

            if (embedCode == null)
                return;

            String postfix = "";
            String prefix = "src=";
            //String compl = "";
            String prefix_id = "embed/";
            String postfix_id = "?";

            int index;
            int startIndex_id = embedCode.indexOf(prefix_id);

            String videoIdUrl;
            String videoThumbnail;
            String videoUrl = null;

            if (embedCode.contains("youtube")) {
                postfix = "frameborder";
                index = embedCode.lastIndexOf(prefix);
                videoIdUrl = embedCode.substring(startIndex_id + prefix_id.length(), embedCode.indexOf(postfix_id));
                videoUrl = embedCode.substring(index + prefix.length(), embedCode.indexOf(postfix));
                videoUrl = videoUrl.substring(1, videoUrl.length() - 1);


                videoThumbnail = "http://img.youtube.com/vi/" + videoIdUrl + "/0.jpg";

            } else if (embedCode.contains("dailymotion")) {
                postfix = "width";
                index = embedCode.lastIndexOf(prefix);
                videoUrl = embedCode.substring(index + prefix.length(), embedCode.indexOf(postfix));
                videoUrl = videoUrl.substring(1, videoUrl.length() - 1);

                StringBuffer str = new StringBuffer(videoUrl);
                String thumb = "thumbnail";

                str.insert(videoUrl.indexOf("/video/"), thumb);

                videoThumbnail = str.toString();

            } else {
                return;
            }

            if (videoUrl == null)
                return;

            URL url = null;
            try {
                url = new URL(videoUrl);
            } catch (MalformedURLException e1) {
                System.out.println("Video URL is distorted : " + e1);
            }
            number++;

            gr.iti.mklab.simmo.core.items.Video video = new gr.iti.mklab.simmo.core.items.Video();
            video.setUrl(url.toString());
            video.setId(Sources.TUMBLR + "#" + post.getId() + "_" + number);
            //SocialNetwork Name
            video.setSource(Sources.TUMBLR);
            //Time of publication
            video.setCreationDate(creationDate);
            //PageUrl
            video.setWebPageUrl(pageURL);
            //Thumbnail
            video.setThumbnail(videoThumbnail);
            //Title
            video.setTitle(title);
            video.setSourceDocumentId(id);
            video.setTags(tags);
            video.setContributor(user);
            video.setCrawlDate(now);
            items.add(video);

        } else if (post.getType().equals("link")) {

            LinkPost linkPost = (LinkPost) post;
            String link = linkPost.getLinkUrl();
            if (link != null) {
                Webpage p = new Webpage();
                p.setUrl(link);
                p.setId(id);
                p.setSource(Sources.TUMBLR);
                p.setCrawlDate(now);
                addAssociation(new Reference(this, p, Reference.ReferenceType.LINK));
            }
        }

    }
}
