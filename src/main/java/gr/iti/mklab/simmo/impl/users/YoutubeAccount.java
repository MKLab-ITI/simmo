package gr.iti.mklab.simmo.impl.users;

import gr.iti.mklab.simmo.core.UserAccount;
import gr.iti.mklab.simmo.impl.Sources;
import org.mongodb.morphia.annotations.Entity;

import com.google.gdata.data.Link;
import com.google.gdata.data.Person;
import com.google.gdata.data.media.mediarss.MediaThumbnail;
import com.google.gdata.data.youtube.UserProfileEntry;
import com.google.gdata.data.youtube.YtUserProfileStatistics;

/**
 * Class that holds the information of a youtube user
 * YouTube API v2
 *
 * @author kandreadou
 * @deprecated because Youtube API v2 is now obsolete
 * use {@link gr.iti.mklab.simmo.impl.users.YoutubeChannel} instead
 */
@Deprecated
@Entity("UserAccount")
public class YoutubeAccount extends UserAccount {

    public YoutubeAccount() {
    }

    public YoutubeAccount(String user) {

        if (user == null)
            return;

        //Id
        setId(Sources.YOUTUBE + "#" + user);
        //The name of the user
        username = user;
        source = Sources.YOUTUBE;
    }

    public YoutubeAccount(Person user) {

        if (user == null)
            return;

        //Id
        setId(Sources.YOUTUBE + "#" + user.getName());
        //The name of the user
        username = user.getName();
        source = Sources.YOUTUBE;
        //The link to the user's profile
        pageUrl = user.getUri();
    }

    public YoutubeAccount(UserProfileEntry user) {

        if (user == null)
            return;

        //Id
        setId(Sources.YOUTUBE + "#" + user.getUsername());
        //The username of the user
        username = user.getUsername();
        //The name of the user
        name = (user.getFirstName() == null ? "" : user.getFirstName() + " ") + (user.getLastName() == null ? "" : user.getLastName());
        source = Sources.YOUTUBE;

        MediaThumbnail thumnail = user.getThumbnail();
        avatarBig = thumnail.getUrl();

        Link link = user.getLink("alternate", "text/html");
        if (link != null) {
            pageUrl = link.getHref();
        }

        location = user.getLocation();

        description = user.getAboutMe();

        YtUserProfileStatistics statistics = user.getStatistics();
        if (statistics != null) {
            numFollowers = (int) statistics.getSubscriberCount();
        }
    }
}
