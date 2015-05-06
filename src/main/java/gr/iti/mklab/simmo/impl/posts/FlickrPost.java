package gr.iti.mklab.simmo.impl.posts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.flickr4java.flickr.people.User;
import com.flickr4java.flickr.photos.GeoData;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.tags.Tag;


import gr.iti.mklab.simmo.core.documents.Post;
import gr.iti.mklab.simmo.core.items.Image;
import gr.iti.mklab.simmo.core.util.Location;
import gr.iti.mklab.simmo.impl.Sources;
import gr.iti.mklab.simmo.impl.users.FlickrAccount;
import org.mongodb.morphia.annotations.Entity;

/**
 * Class that holds the information of a flickr photo
 *
 * @author ailiakop, kandreadou
 */
@Entity("Post")
public class FlickrPost extends Post {

    @SuppressWarnings("deprecation")
    public FlickrPost(Photo photo) {

        if (photo == null || photo.getId() == null) return;

        //Crawl date
        Date now = new Date();
        setCrawlDate(now);
        //Id
        id = Sources.FLICKR + "#" + photo.getId();
        //SocialNetwork Name
        type = Sources.FLICKR.toString();
        //Timestamp of the creation of the photo
        creationDate = photo.getDatePosted();
        //Title of the photo
        if (photo.getTitle() != null) {
            title = photo.getTitle();
        }
        //Description of the photo
        description = photo.getDescription();
        //Tags of the photo
        Collection<Tag> photoTags = photo.getTags();
        if (photoTags != null) {
            for (Tag tag : photoTags) {
                String tagStr = tag.getValue();
                if (tagStr != null && !tagStr.contains(":"))
                    tags.add(tagStr);
            }
        }

        //User that posted the photo
        User user = photo.getOwner();
        if (user != null) {
            setContributor(new FlickrAccount(user));
        }

        //Location
        if (photo.hasGeoData()) {

            GeoData geo = photo.getGeoData();

            double latitude = (double) geo.getLatitude();
            double longitude = (double) geo.getLongitude();

            location = new Location(latitude, longitude);
        }else if(photo.getCountry()!=null){
            location = new Location();
            location.setCountry(photo.getCountry().getName());
        }

        url = photo.getUrl();

        //Popularity
        numComments = photo.getComments();
        if (photo.getStats() != null) {
            numViews = photo.getStats().getViews();
            numLikes = photo.getStats().getFavorites();
        }

        //Getting the photo
        try {
            String url = null;
            String thumbnail = photo.getMediumUrl();
            if (thumbnail == null) {
                thumbnail = photo.getThumbnailUrl();
            }
            URL mediaUrl = null;
            if ((url = photo.getLargeUrl()) != null) {
                mediaUrl = new URL(url);

            } else if ((url = photo.getMediumUrl()) != null) {
                mediaUrl = new URL(url);
            }

            if (mediaUrl != null) {
                Image img = new Image();
                img.setUrl(mediaUrl.toString());

                String mediaId = Sources.FLICKR + "#" + photo.getId();

                //id
                img.setId(mediaId);
                //SocialNetwork Name
                img.setSource(Sources.FLICKR);
                //Reference
                img.setSourceDocumentId(id);
                //Time of publication
                img.setCreationDate(creationDate);
                img.setContributor(getContributor());
                //PageUrl
                img.setWebPageUrl(photo.getUrl());
                //Thumbnail
                img.setThumbnail(thumbnail);
                //Title
                img.setTitle(title);
                //Description
                img.setDescription(description);
                //Tags
                img.setTags(tags);
                //Popularity
                img.setNumComments(numComments);
                img.setNumViews(numViews);
                img.setNumLikes(numLikes);
                //Location
                img.setLocation(location);
                //Size
                img.setWidth(photo.getOriginalWidth());
                img.setHeight(photo.getOriginalHeight());
                //Crawl date
                img.setCrawlDate(now);
                addItem(img);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public FlickrPost(Photo photo, FlickrAccount account) {
        this(photo);
        setContributor(account);

        getItems().stream().forEach(i -> i.setContributor(account));

    }

}
