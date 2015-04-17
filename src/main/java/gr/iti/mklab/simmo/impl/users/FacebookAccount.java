package gr.iti.mklab.simmo.impl.users;

import com.restfb.types.CategorizedFacebookType;
import com.restfb.types.Location;
import com.restfb.types.Page;
import com.restfb.types.User;

import gr.iti.mklab.simmo.core.UserAccount;
import gr.iti.mklab.simmo.impl.Sources;
import org.mongodb.morphia.annotations.Entity;

/**
 * Class that holds the information of a facebook user or a facebook page
 *
 * @author ailiakop, kandreadou
 */
@Entity("UserAccount")
public class FacebookAccount extends UserAccount {
    /**
     * Maps the information of a facebook user
     *
     * @param user - Facebook's user
     */
    public FacebookAccount(User user) {

        if (user == null) return;

        //Id
        setId(Sources.FACEBOOK + "#" + user.getId());

        //The id of the user in the network
        //username = user.getId();

        //The name of the user
        if (user.getFirstName() == null && user.getLastName() == null)
            name = user.getName();
        else if (user.getMiddleName() != null)
            name = user.getFirstName() + " " + user.getMiddleName() + " " + user.getLastName();
        else
            name = user.getFirstName() + " " + user.getLastName();

        //The username of the user
        username = user.getUsername();

        //streamId
        source = Sources.FACEBOOK;

        //The description of the user
        description = user.getAbout();

        //The link to the user's profile
        pageUrl = user.getLink();
        if (pageUrl == null) {
            pageUrl = username == null ? ("https://www.facebook.com/profile.php?id=" + user.getId()) : ("http://www.facebook.com/" + username);
        }

        avatarBig = "https://graph.facebook.com/" + user.getId() + "/picture";

        //Last time user's profile was updated
        //if (user.getUpdatedTime() != null)
        //= user.getUpdatedTime().getTime();

        //Location
        if (user.getLocation() != null)
            location = user.getLocation().getName();

        //Is the user a verified user
        if (user.getVerified() != null)
            isVerified = user.getVerified();


    }

    /**
     * Maps the information of a facebook page
     *
     * @param page - Facebook's page
     */
    public FacebookAccount(Page page) {
        if (page == null) return;

        //Id
        setId(Sources.FACEBOOK + "#" + page.getId());

        //The id of the page in the network
        //userid = page.getId();

        //The name of the page
        name = page.getName();

        //The username of the page
        username = page.getUsername();

        //The name of the Social Network
        source = Sources.FACEBOOK;

        //The description of the page
        description = page.getAbout();

        pageUrl = page.getLink();
        if (pageUrl == null) {
            pageUrl = username == null ? ("https://www.facebook.com/profile.php?id=" + page.getId()) : ("http://www.facebook.com/" + username);
        }

        //Avatar of the page
        avatarBig = page.getPicture();
        if (avatarBig == null) {
            avatarBig = "https://graph.facebook.com/" + page.getId() + "/picture";
        }

        //Number of people talking about the page
        numFollowers = page.getTalkingAboutCount().intValue();

        //Location
        Location loc = page.getLocation();
        if (loc != null) {
            location = loc.getCity();
        }

    }

    public FacebookAccount(CategorizedFacebookType user) {

        if (user == null) return;

        //Id
        setId(Sources.FACEBOOK + "#" + user.getId());
        //The id of the page in the network
        //userid = user.getId();
        //The name of the page
        name = user.getName();
        //Link to the page
        pageUrl = "https://www.facebook.com/profile.php?id=" + user.getId();
        //Avatar of the page
        avatarBig = "https://graph.facebook.com/" + user.getId() + "/picture";

    }

}
