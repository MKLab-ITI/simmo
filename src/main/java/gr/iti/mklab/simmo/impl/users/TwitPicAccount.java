package gr.iti.mklab.simmo.impl.users;

import com.google.api.client.util.Key;
import gr.iti.mklab.simmo.core.UserAccount;
import org.mongodb.morphia.annotations.Entity;

import java.util.Date;

/**
 * Class that holds the information of a twitpic user
 *
 * @author manosetro, kandreadou
 */
@Entity("UserAccount")
public class TwitPicAccount extends UserAccount {

    public TwitPicAccount(TwitPicUser user) {
        setId("Twitpic#" + user.id);
        description = user.bio;
        username = user.username;
        name = user.name;
        numItems = user.photo_count;
        location = user.location;
        creationDate = new Date(Long.valueOf(user.timestamp));
        avatarBig = user.avatar_url;
    }

    /**
     * Class that holds the information regarding the twitpic image
     *
     * @author manosetro
     */
    public static class TwitPicUser {
        @Key
        public String id, username, name, bio, avatar_url, timestamp, location;
        @Key
        public int photo_count;
    }
}
