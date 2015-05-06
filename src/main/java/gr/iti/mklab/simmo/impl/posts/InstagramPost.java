package gr.iti.mklab.simmo.impl.posts;

import java.util.Date;
import java.net.MalformedURLException;
import java.net.URL;


import gr.iti.mklab.simmo.core.documents.Post;
import gr.iti.mklab.simmo.core.items.Image;
import gr.iti.mklab.simmo.core.util.Location;
import gr.iti.mklab.simmo.impl.Sources;
import gr.iti.mklab.simmo.impl.users.InstagramAccount;
import org.jinstagram.entity.common.Caption;
import org.jinstagram.entity.common.ImageData;
import org.jinstagram.entity.common.Images;
import org.jinstagram.entity.users.feed.MediaFeedData;
import org.mongodb.morphia.annotations.Entity;

/**
 * Class that holds the information of a instagram image
 *
 * @author ailiakop, kandreadou
 */
@Entity("Post")
public class InstagramPost extends Post {

    public InstagramPost(MediaFeedData image) throws MalformedURLException {

        if (image == null || image.getId() == null)
            return;

        //Crawl date
        Date now = new Date();
        setCrawlDate(now);
        //Id
        id = Sources.INSTAGRAM + "#" + image.getId();
        //SocialNetwork Name
        type = Sources.INSTAGRAM;
        //Timestamp of the creation of the photo
        int createdTime = Integer.parseInt(image.getCreatedTime());
        Date publicationDate = new Date((long) createdTime * 1000);
        creationDate = publicationDate;
        //Title of the photo
        Caption caption = image.getCaption();
        String captionText = null;
        if (caption != null) {
            captionText = caption.getText();
            title = captionText;
        }
        //Tags
        setTags(tags);

        url = image.getLink();

        //User that posted the photo
        if (image.getUser() != null) {
            setContributor(new InstagramAccount(image.getUser()));
        }
        //Location
        if (image.getLocation() != null) {
            double latitude = image.getLocation().getLatitude();
            double longitude = image.getLocation().getLongitude();

            location = new Location(latitude, longitude);
        }
        //Popularity
        numLikes = image.getLikes().getCount();
        numComments = image.getComments().getCount();

        //Getting the photo
        Images imageContent = image.getImages();
        ImageData thumb = imageContent.getThumbnail();
        String thumbnail = thumb.getImageUrl();

        ImageData standardUrl = imageContent.getStandardResolution();
        if (standardUrl != null) {
            Integer width = standardUrl.getImageWidth();
            Integer height = standardUrl.getImageHeight();

            String url = standardUrl.getImageUrl();

            if (url != null && (width > 150) && (height > 150)) {
                URL mediaUrl = null;
                try {
                    mediaUrl = new URL(url);
                } catch (MalformedURLException e) {

                    e.printStackTrace();
                }

                //url
                Image img = new Image();
                img.setUrl(mediaUrl.toString());

                String mediaId = Sources.INSTAGRAM + "#" + image.getId();

                //id
                img.setId(mediaId);
                //SocialNetwork Name
                img.setSource(Sources.INSTAGRAM);
                //Reference
                img.setSourceDocumentId(id);
                //Time of publication
                img.setCreationDate(creationDate);
                img.setContributor(getContributor());
                //PageUrl
                img.setWebPageUrl(image.getLink());
                //Thumbnail
                img.setThumbnail(thumbnail);
                //Title
                img.setTitle(title);
                //Description
                img.setDescription(description);
                //Tags
                img.setTags(tags);
                //Popularity
                img.setNumLikes(numLikes);
                img.setNumComments(numComments);
                //Location
                img.setLocation(location);
                img.setCrawlDate(now);
                addItem(img);
            }

        }

    }

    public InstagramPost(MediaFeedData image, InstagramAccount user) throws MalformedURLException {
        this(image);
        setContributor(user);
        getItems().stream().forEach(i -> i.setContributor(user));
    }

}
