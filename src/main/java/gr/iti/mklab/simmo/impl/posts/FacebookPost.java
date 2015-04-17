package gr.iti.mklab.simmo.impl.posts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.restfb.types.*;
import com.restfb.types.Comment.Attachment;
import com.restfb.types.Comment.Media;


import gr.iti.mklab.simmo.core.annotations.Original;
import gr.iti.mklab.simmo.core.associations.Reference;
import gr.iti.mklab.simmo.core.documents.Webpage;
import gr.iti.mklab.simmo.core.items.Image;
import gr.iti.mklab.simmo.core.items.Text;
import gr.iti.mklab.simmo.impl.Sources;
import gr.iti.mklab.simmo.impl.users.FacebookAccount;
import org.mongodb.morphia.annotations.Entity;

/**
 * Class that holds the information of a facebook post
 *
 * @author ailiakop, kandreadou
 */
@Entity("Post")
public class FacebookPost extends gr.iti.mklab.simmo.core.documents.Post {


    public FacebookPost(Post post) {

        if (post == null || post.getId() == null) return;

        //Id
        setId(Sources.FACEBOOK + "#" + post.getId());
        //SocialNetwork Name
        type = Sources.FACEBOOK;
        //Timestamp of the creation of the post
        creationDate = post.getCreatedTime();
        //post's descritpion
        description = post.getDescription();
        //is this the original or a shared fb post
        Original original = new Original(true);
        addAnnotation(original);

        //Message that post contains
        String msg = post.getMessage();
        if (msg != null) {
            if (msg.length() > 100) {
                title = msg.subSequence(0, 100) + "...";
            } else {
                title = msg;
            }
        } else {
            if (post.getCaption() != null) {
                title = post.getCaption();
            } else if (post.getName() != null) {
                title = post.getName();
            } else if (description != null) {
                if (description.length() > 100)
                    title = description.subSequence(0, 100) + "...";
                else
                    title = description;
            } else {
                title = "";
            }
        }

        String text;
        if (msg != null)
            text = msg;
        else if (description != null)
            text = description;
        else
            text = title;
        Text textItem = new Text();
        textItem.setContent(text);
        textItem.setTitle(title);
        textItem.setCreationDate(post.getCreatedTime());
        textItem.setSourceDocumentId(id);
        addItem(textItem);

        //Location
        Place place = post.getPlace();
        if (place != null) {
            String placeName = place.getName();
            com.restfb.types.Location loc = place.getLocation();
            if (loc != null) {
                Double latitude = loc.getLatitude();
                Double longitude = loc.getLongitude();

                location = new gr.iti.mklab.simmo.core.util.Location(latitude, longitude);
                location.setCity(placeName);
            }
        }
        //Popularity of the post
        if (post.getLikesCount() != null)
            numLikes = post.getLikesCount().intValue();
        else {
            Post.Likes likesPosts = post.getLikes();
            if (likesPosts != null) {
                if (likesPosts.getTotalCount() == null) {
                    List<NamedFacebookType> likeData = likesPosts.getData();
                    if (likeData != null) {
                        numLikes = likeData.size();
                    }
                } else {
                    numLikes = likesPosts.getTotalCount().intValue();
                }
            }
        }

        if (post.getSharesCount() != null)
            numShares = post.getSharesCount().intValue();

        Post.Comments cmnts = post.getComments();
        if (cmnts != null) {
            Long n = cmnts.getTotalCount();
            if (n != null) {
                numComments = n.intValue();
            } else {
                List<Comment> data = cmnts.getData();
                if (data != null)
                    numComments = data.size();
            }
        }

        //Media Items - WebPages in a post
        String type = post.getType();

        if (type.equals("photo")) {

            url = post.getLink();
            String picture = post.getPicture();

            try {
                if (picture != null) {
                    URL p_url = null;
                    StringBuilder b = new StringBuilder(picture);
                    int index = picture.lastIndexOf("_s.");
                    if (index > 0) {
                        b.replace(index, index + 3, "_n.");
                        picture = picture.replaceAll("_s.", "_n.");
                        p_url = new URL(picture);

                        if (p_url != null) {

                            String mediaId = Sources.FACEBOOK + "#" + post.getId();
                            //url
                            Image img = new Image();
                            img.setUrl(p_url.toString());
                            img.setId(mediaId);
                            //SocialNetwork Name
                            img.setSource(Sources.FACEBOOK);
                            //Reference
                            img.setSourceDocumentId(id);
                            //Time of publication
                            img.setCreationDate(post.getCreatedTime());
                            img.setContributor(getContributor());

                            //PageUrl
                            String pageUrl = post.getLink();
                            img.setWebPageUrl(pageUrl);
                            //Thumbnail
                            String thumbnail = post.getPicture();
                            img.setThumbnail(thumbnail);
                            //Title
                            img.setTitle(title);
                            //Description
                            img.setDescription(description);
                            //Tags
                            img.setTags(tags);
                            //img.setTags(tags);
                            //Popularity
                            img.setNumLikes(numLikes);
                            img.setNumShares(numShares);
                            addItem(img);
                        }
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (type.equals("link")) {

            url = "https://www.facebook.com/" + post.getId();

            String picture = post.getPicture(); ///!!!!
            if (picture != null) {

                URL p_url = null;
                StringBuilder b = new StringBuilder(picture);
                int index = picture.lastIndexOf("_s.");
                if (index > 0) {
                    b.replace(index, index + 3, "_n.");
                    picture = picture.replaceAll("_s.", "_n.");
                    try {
                        p_url = new URL(picture);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                    if (p_url != null) {

                        String mediaId = Sources.FACEBOOK + "#" + post.getId();
                        //url
                        Image img = new Image();
                        img.setId(mediaId);
                        img.setUrl(p_url.toString());
                        //SocialNetwork Name
                        img.setSource(Sources.FACEBOOK);
                        //Reference
                        //mediaItem.setRef(id);
                        //Time of publication
                        img.setCreationDate(post.getCreatedTime());
                        img.setContributor(getContributor());

                        //PageUrl
                        String pageUrl = post.getLink();
                        img.setWebPageUrl(pageUrl);
                        //Thumbnail
                        String thumbnail = post.getPicture();
                        img.setThumbnail(thumbnail);
                        //Title
                        img.setTitle(title);
                        //Description
                        img.setDescription(description);
                        //Tags
                        img.setTags(tags);
                        img.setSourceDocumentId(id);
                        //Popularity
                        //mediaItem.setLikes(likes);
                        //mediaItem.setShares(shares);
                        //Store mediaItems and their ids
                        addItem(img);

                    }
                }
            }

            String link = post.getLink();
            if (link != null) {

                Webpage webPage = new Webpage();
                webPage.setId(id);
                webPage.setUrl(link);
                webPage.setSource(Sources.FACEBOOK);
                Reference ref = new Reference(webPage, this, Reference.ReferenceType.LINK);
                addAssociation(ref);
            }
        } else if (type.equals("video")) {

            url = "https://www.facebook.com/" + post.getId();

            String vUrl = post.getSource();
            String picture = post.getPicture();
            if (picture != null) {

                URL videoUrl = null;
                try {
                    videoUrl = new URL(vUrl);

                    String mediaId = Sources.FACEBOOK + "#" + post.getId();
                    //url
                    gr.iti.mklab.simmo.core.items.Video v = new gr.iti.mklab.simmo.core.items.Video();
                    v.setUrl(videoUrl.toString());
                    //id
                    v.setId(mediaId);
                    //SocialNetwork Name
                    v.setSource(Sources.FACEBOOK);
                    //Reference
                    //mediaItem.setRef(id);
                    //Time of publication
                    v.setCreationDate(post.getCreatedTime());
                    v.setContributor(getContributor());
                    v.setSourceDocumentId(id);
                    //PageUrl
                    String pageUrl = post.getLink();
                    v.setWebPageUrl(pageUrl);
                    //Thumbnail
                    String thumbnail = post.getPicture();
                    v.setThumbnail(thumbnail);
                    //Title
                    v.setTitle(title);
                    //Description
                    v.setDescription(description);
                    //Tags
                    v.setTags(tags);
                    //Popularity
                    //mediaItem.setLikes(likes);
                    //mediaItem.setShares(shares);

                    //Store mediaItems and their ids
                    addItem(v);

                } catch (MalformedURLException e) {

                }
            }

        } else {
            url = "https://www.facebook.com/" + post.getId();
        }

    }


    public FacebookPost(Post post, FacebookAccount user) {

        this(post);
        setContributor(user);
        getItems().stream().forEach(item ->
                        item.setContributor(user)
        );

    }

    public FacebookPost(Comment comment, Post post, User user) {

        if (comment == null) return;

        //Id
        id = Sources.FACEBOOK + "#" + comment.getId();
        //Reference to the original post
        String originalPostId = Sources.FACEBOOK + "#" + post.getId();
        gr.iti.mklab.simmo.core.documents.Post originalPost = new gr.iti.mklab.simmo.core.documents.Post();
        originalPost.setId(originalPostId);
        addAssociation(new Reference(originalPost, this, Reference.ReferenceType.COMMENT));
        //SocialNetwork Name
        setType(Sources.FACEBOOK);
        //Timestamp of the creation of the post
        setCreationDate(comment.getCreatedTime());
        //Message that post contains
        String msg = comment.getMessage();
        if (msg != null) {
            if (msg.length() > 100) {
                title = msg.subSequence(0, 100) + "...";
            } else {
                title = msg;
            }

            description = "Comment";
        }

        //All the text inside the comment
        Text textItem = new Text();
        textItem.setContent(msg);
        textItem.setTitle(title);
        textItem.setCreationDate(post.getCreatedTime());
        textItem.setSourceDocumentId(id);
        addItem(textItem);

        url = "https://www.facebook.com/" + post.getId();

        //User that posted the comment
        if (user != null) {
            setContributor(new FacebookAccount(user));
        } else {
            CategorizedFacebookType from = comment.getFrom();
            setContributor(new FacebookAccount(from));
        }

        addAnnotation(new Original(false));

        //Popularity of the post
        if (comment.getLikeCount() != null)
            numLikes = comment.getLikeCount().intValue();

        Attachment attachment = comment.getAttachment();
        if (attachment != null) {
            Media media = attachment.getMedia();

            String url = attachment.getUrl();
            try {
                URL mediaUrl = new URL(url);

                String mediaId = Sources.FACEBOOK + "#" + media.getId();

                Image img = new Image();
                img.setId(mediaId);
                img.setSourceDocumentId(id);
                img.setSource(Sources.FACEBOOK);
                img.setUrl(mediaUrl.toString());
                //Time of publication
                img.setCreationDate(comment.getCreatedTime());
                img.setContributor(getContributor());
                //PageUrl
                String pageUrl = post.getLink();
                img.setWebPageUrl(pageUrl);
                //Thumbnail
                String thumbnail = post.getPicture();
                img.setThumbnail(thumbnail);
                //Title
                img.setTitle(title);
                //Description
                img.setDescription(description);
                //Tags
                img.setTags(tags);
                //Popularity
                //mediaItem.setLikes(likes);
                //mediaItem.setShares(shares);
                addItem(img);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

    }
}
