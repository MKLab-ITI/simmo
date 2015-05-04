package gr.iti.mklab.simmo.core.mocks;

import gr.iti.mklab.simmo.core.UserAccount;
import gr.iti.mklab.simmo.core.annotations.Original;
import gr.iti.mklab.simmo.core.associations.Affiliation;
import gr.iti.mklab.simmo.core.associations.Contribution;
import gr.iti.mklab.simmo.core.associations.Interaction;
import gr.iti.mklab.simmo.core.associations.Reference;
import gr.iti.mklab.simmo.core.documents.Post;
import gr.iti.mklab.simmo.core.documents.Webpage;
import gr.iti.mklab.simmo.core.items.Image;
import gr.iti.mklab.simmo.core.util.Location;

import java.util.Date;
import java.util.UUID;

/**
 * Created by kandreadou on 9/12/14.
 */
public class MockObjectFactory {

    public static Image getImage(String id) {
        return getImage(id, 0, 0);
    }

    public static Interaction getInteraction() {
        return new Interaction(getPost("somewhereonepost"), getUserAccount("John Doe"), Interaction.InteractionType.COMMENT);
    }

    public static Contribution getCreation() {
        return new Contribution(getUserAccount("John Doe"), getPost("somewhereonepost"));
    }

    public static Webpage getWebpage(String url) {
        Webpage p = new Webpage();
        p.setUrl(url);
        //p.setAuthor("me");
        p.setDescription("oh how boring");
        p.addPost(getPost("twitterpost456"));
        //p.addReferece(new Reference(getPost("instagram789"), Reference.ReferenceType.REPLY));
        p.addAnnotation(new Original(false));
        return p;
    }

    public static Post getPost(String postId) {
        Post p = new Post(postId);
        p.setNumViews(56);
        p.setNumComments(78);
        p.setNumLikes(4);
        p.setUrl("http://www.great.com");
        p.setTitle("this is a title");
        p.setLastModifiedDate(new Date(System.currentTimeMillis()));
        p.setNegativeVotes(7);
        p.setNumSubscriptions(90);
        //p.setAuthor("Some author");
        p.setLanguage("EN-en");
        p.setLocation(new Location(48.8577, 2.4567));
        p.addItem(getImage("image09990"));
        p.addTag("a tag");
        p.addLabel("twitter");
        p.addAnnotation(new Original(false));
        p.setContributor(getUserAccount("John Doe"));
        p.setReplied(getUserAccount("Some person"));
        p.addAssociation(new Interaction(p, getUserAccount("Some other person"), Interaction.InteractionType.DISLIKE));
        Webpage page = new Webpage();
        page.setId("Web#"+56);
        page.setUrl("www.google.com");
        page.setDescription("oh how boring");
        p.addAnnotation(new Original(false));
        p.addAssociation(new Reference(p, page, Reference.ReferenceType.LINK));
        return p;
    }

    public static Image getImage(String id, double longitude, double latitude) {
        Image img = new Image();
        img.setWidth(800);
        img.setHeight(500);
        img.setId(id);
        img.setThumbnail("/home/fake/path");
        img.setDescription("this is not an image");
        //img.setAuthor("me");
        img.setAlternateText("wtf?!");
        img.setExifMetadataField("codec", "jpeg");
        img.setCrawlDate(new Date(System.currentTimeMillis()));
        img.setLastModifiedDate(new Date(System.currentTimeMillis()));
        img.setTitle("OMG");
        img.setUrl("http://fake.url");
        img.setLocation(new Location(longitude, latitude));
        Original or = new Original(true);
        img.addAnnotation(or);
        return img;
    }

    public static UserAccount getUserAccount(String name) {
        UserAccount ua = new UserAccount();
        ua.setId(UUID.randomUUID().toString());
        ua.setName(name);
        ua.setNumFollowers(56000);
        ua.setAvatarSmall("/fake/path/to/a/avatar");
        return ua;
    }

    public static Affiliation getAffiliation() {
        Affiliation affiliation = new Affiliation(getUserAccount("Joe"), getUserAccount("Jane"), Affiliation.AFFILIATION_TYPE.FOLLOWS, new Date(System.currentTimeMillis()));
        return affiliation;
    }

}
