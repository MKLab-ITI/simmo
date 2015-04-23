package gr.iti.mklab.simmo.impl.posts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gr.iti.mklab.simmo.core.associations.Reference;
import gr.iti.mklab.simmo.core.documents.Post;
import gr.iti.mklab.simmo.core.documents.Webpage;
import gr.iti.mklab.simmo.core.items.Video;
import gr.iti.mklab.simmo.core.util.Location;
import gr.iti.mklab.simmo.impl.Sources;
import gr.iti.mklab.simmo.impl.users.GooglePlusAccount;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.api.services.plus.model.Activity;
import com.google.api.services.plus.model.Activity.Actor;
import com.google.api.services.plus.model.Activity.PlusObject;
import com.google.api.services.plus.model.Activity.PlusObject.Attachments;
import com.google.api.services.plus.model.Activity.PlusObject.Attachments.Embed;
import com.google.api.services.plus.model.Activity.PlusObject.Attachments.FullImage;
import com.google.api.services.plus.model.Activity.PlusObject.Attachments.Image;
import com.google.api.services.plus.model.Activity.PlusObject.Attachments.Thumbnails;
import com.google.api.services.plus.model.Comment;
import org.mongodb.morphia.annotations.Entity;

/**
 * Class that holds the information of a google plus activity
 *
 * @author ailiakop, kandreadou
 */
@Entity("Post")
public class GooglePlusPost extends Post {


    public GooglePlusPost(Activity activity) {

        if (activity == null || activity.getId() == null) return;

        //Id
        id = Sources.GOOGLE_PLUS + "#" + activity.getId();
        //SocialNetwork Name
        type = Sources.GOOGLE_PLUS;
        //Timestamp of the creation of the post
        creationDate = new Date(activity.getPublished().getValue());
        //Title of the post
        title = activity.getTitle();
        //User that made the post
        Actor actor = activity.getActor();
        if (actor != null) {
            setContributor(new GooglePlusAccount(actor));
        }
        //Location
        if (activity.getGeocode() != null) {

            String locationInfo = activity.getGeocode();
            String[] parts = locationInfo.split(" ");
            double latitude = Double.parseDouble(parts[0]);
            double longitude = Double.parseDouble(parts[1]);

            location = new Location(latitude, longitude);
            location.setCity(activity.getPlaceName());
        }

        PlusObject object = activity.getObject();
        if (object == null)
            return;

        description = object.getContent();
        if (description != null) {
            try {
                Document doc = Jsoup.parse(description);
                Elements elements = doc.getElementsByClass("ot-hashtag");
                for (Element e : elements) {
                    String tag = e.text();
                    if (tag != null)
                        tags.add(tag.replaceAll("#", ""));
                }
            } catch (Exception e) {
            }
        }


        //Popularity
        if (object.getPlusoners() != null)
            numLikes = object.getPlusoners().getTotalItems().intValue();

        if (activity.getObject().getResharers() != null)
            numShares = object.getResharers().getTotalItems().intValue();

        if (activity.getObject().getReplies() != null)
            numComments = object.getReplies().getTotalItems().intValue();

        url = activity.getUrl();
        if (url == null) {
            url = object.getUrl();
        }

        //Media Items - WebPages in a post
        String pageURL = activity.getUrl();

        List<Attachments> attachmentsList = object.getAttachments();
        if (attachmentsList == null)
            attachmentsList = new ArrayList<Attachments>();

        for (Attachments attachment : attachmentsList) {

            if (attachment != null) {
                String type = attachment.getObjectType();

                if (type == null)
                    continue;

                if (type.equals("video")) {

                    if (attachment.getId() == null)
                        continue;

                    Image image = attachment.getImage();
                    Embed embed = attachment.getEmbed();

                    if (embed != null) {

                        String videoUrl = embed.getUrl();

                        URL mediaUrl = null;
                        try {
                            mediaUrl = new URL(videoUrl);
                        } catch (MalformedURLException e1) {
                            return;
                        }
                        //url
                        Video v = new Video();
                        v.setUrl(mediaUrl.toString());

                        String mediaId = Sources.GOOGLE_PLUS + "#" + attachment.getId();

                        //id
                        v.setId(mediaId);
                        //SocialNetwork Name
                        v.setSource(Sources.GOOGLE_PLUS);
                        //Reference
                        v.setSourceDocumentId(id);
                        //Time of publication
                        v.setCreationDate(creationDate);
                        v.setContributor(getContributor());
                        //PageUrl
                        v.setWebPageUrl(pageURL);
                        //Thumbnail
                        String thumbUrl = image.getUrl();
                        v.setThumbnail(thumbUrl);
                        //Title
                        v.setTitle(attachment.getDisplayName());
                        //Description
                        v.setDescription(attachment.getDisplayName());
                        //Tags
                        v.setTags(tags);
                        //Popularity
                        v.setNumLikes(numLikes);
                        v.setNumShares(numShares);
                        addItem(v);
                    }
                } else if (type.equals("photo")) {

                    if (attachment.getId() == null)
                        continue;

                    FullImage image = attachment.getFullImage();
                    String imageUrl = image.getUrl();
                    Image thumbnail = attachment.getImage();

                    Integer width = image.getWidth().intValue();
                    Integer height = image.getHeight().intValue();

                    if (thumbnail != null && (width > 250 && height > 250)) {
                        URL mediaUrl = null;
                        try {
                            mediaUrl = new URL(imageUrl);
                        } catch (MalformedURLException e2) {
                            return;
                        }

                        gr.iti.mklab.simmo.core.items.Image img = new gr.iti.mklab.simmo.core.items.Image();
                        img.setUrl(mediaUrl.toString());

                        String mediaId = Sources.GOOGLE_PLUS + "#" + attachment.getId();

                        //id
                        img.setId(mediaId);
                        //SocialNetwork Name
                        img.setSource(Sources.GOOGLE_PLUS);
                        //Reference
                        img.setSourceDocumentId(id);
                        //Time of publication
                        img.setCreationDate(creationDate);
                        img.setContributor(getContributor());
                        //PageUrl
                        img.setWebPageUrl(pageURL);
                        //Thumbnail
                        String thumnailUrl = thumbnail.getUrl();
                        img.setThumbnail(thumnailUrl);
                        //Title
                        img.setTitle(attachment.getDisplayName());
                        //Description
                        img.setDescription(attachment.getDisplayName());
                        //Tags
                        img.setTags(tags);
                        //Popularity
                        img.setNumLikes(numLikes);
                        img.setNumShares(numShares);
                        //Size
                        img.setWidth(width);
                        img.setHeight(height);
                        addItem(img);

                    }
                } else if (type.equals("album")) {

                    for (Thumbnails image : attachment.getThumbnails()) {

                        com.google.api.services.plus.model.Activity.PlusObject.Attachments.Thumbnails.Image thumbnail = image.getImage();

                        if (thumbnail != null && image.getImage().getWidth() > 250 && image.getImage().getHeight() > 250) {
                            URL mediaUrl = null;
                            try {
                                mediaUrl = new URL(image.getImage().getUrl());
                            } catch (MalformedURLException e3) {
                                return;
                            }


                            gr.iti.mklab.simmo.core.items.Image img = new gr.iti.mklab.simmo.core.items.Image();
                            img.setUrl(mediaUrl.toString());

                            String mediaId = Sources.GOOGLE_PLUS + "#" + attachment.getId();

                            //id
                            img.setId(mediaId);
                            //SocialNetwork Name
                            img.setSource(Sources.GOOGLE_PLUS);
                            //Reference
                            img.setSourceDocumentId(id);

                            //Time of publication
                            img.setCreationDate(creationDate);
                            img.setContributor(getContributor());
                            //PageUrl
                            img.setWebPageUrl(pageURL);
                            //Thumbnail
                            String thumbnailUrl = thumbnail.getUrl();
                            img.setThumbnail(thumbnailUrl);
                            //Title
                            img.setTitle(title);
                            //Description
                            img.setDescription(attachment.getDisplayName());
                            //Tags
                            img.setTags(tags);
                            //Popularity
                            img.setNumLikes(numLikes);
                            img.setNumShares(numShares);
                            //Size
                            Long width = image.getImage().getWidth();
                            Long height = image.getImage().getHeight();
                            if (width != null && height != null) {
                                img.setWidth(width.intValue());
                                img.setHeight(height.intValue());
                            }
                            addItem(img);
                        }

                    }
                } else if (type.equals("article")) {
                    String link = attachment.getUrl();
                    if (link != null) {
                        Webpage webpage = new Webpage();
                        webpage.setUrl(link);
                        webpage.setId(id);
                        webpage.setSource(Sources.GOOGLE_PLUS);
                        addAssociation(new Reference(webpage, this, Reference.ReferenceType.LINK));
                    }
                }
            }
        }
    }

    public GooglePlusPost(Activity activity, GooglePlusAccount user) {
        this(activity);
        setContributor(user);
    }

    public GooglePlusPost(Comment comment, Activity activity, GooglePlusAccount user) {

        if (comment == null) return;

        //Id
        id = Sources.GOOGLE_PLUS + "#" + comment.getId();

        //SocialNetwork Name
        type = Sources.GOOGLE_PLUS;
        //Timestamp of the creation of the post
        creationDate = new Date(comment.getPublished().getValue());
        description = "Comment";
        //User that posted the post
        setContributor(user);
        //Popularity of the post
        if (comment.getPlusoners() != null) {
            numLikes = comment.getPlusoners().size();
        }
        Post originalPost = new Post();
        originalPost.setId(Sources.GOOGLE_PLUS + "#" + activity.getId());
        addAssociation(new Reference(originalPost, this, Reference.ReferenceType.COMMENT));
    }

}
