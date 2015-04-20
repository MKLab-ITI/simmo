package gr.iti.mklab.simmo.impl.users;

import gr.iti.mklab.simmo.core.UserAccount;
import gr.iti.mklab.simmo.impl.Sources;
import org.mongodb.morphia.annotations.Entity;
import twitter4j.User;

/**
 * Class that holds the information of a twitter user
 *
 * @author manosetro, kandreadou
 */
@Entity("UserAccount")
public class TwitterAccount extends UserAccount {

    public TwitterAccount(){
    }

    public TwitterAccount(User user) {

        if (user == null)
            return;
        //Id
        setId(Sources.TWITTER + "#" + user.getId());
        //The name of the user
        name = user.getName();
        //The username of the user
        username = user.getScreenName();
        //streamId
        source = Sources.TWITTER;
        //The description of the user
        description = user.getDescription();
        //Profile picture of the user
        avatarBig = user.getProfileImageURL();
        //Page URL of the user
        pageUrl = "https://twitter.com/" + user.getScreenName();
        userUrl = user.getURL();

        isVerified = user.isVerified();
        numListed =  user.getListedCount();

        //Statuses of the user
        numItems = user.getStatusesCount();
        //Creation date of user's profile
        creationDate = user.getCreatedAt();
        //Location
        location = user.getLocation();
        //Followers of the user
        numFollowers = user.getFollowersCount();
        //Friends of the user
        numFriends = user.getFriendsCount();

        numFavourites = user.getFavouritesCount();

        location = user.getTimeZone();
    }

}
