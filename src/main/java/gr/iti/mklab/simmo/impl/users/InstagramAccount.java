package gr.iti.mklab.simmo.impl.users;

import gr.iti.mklab.simmo.core.UserAccount;
import gr.iti.mklab.simmo.impl.Sources;
import org.jinstagram.entity.common.User;
import org.jinstagram.entity.users.basicinfo.Counts;
import org.jinstagram.entity.users.basicinfo.UserInfoData;
import org.mongodb.morphia.annotations.Entity;

/**
 * Class that holds the information of an instagram user
 *
 * @author ailiakop, kandreadou
 */
@Entity("UserAccount")
public class InstagramAccount extends UserAccount {

    public InstagramAccount(){}

    public InstagramAccount(User user) {

        if (user == null) return;

        //Id
        setId(Sources.INSTAGRAM + "#" + user.getId());
        //The id of the user in the network
        username = user.getId();
        //The name of the user
        name = user.getFullName();
        //The username of the user
        username = user.getUserName();
        //streamId
        source = Sources.INSTAGRAM;
        //The description of the user
        description = user.getBio();
        //Profile picture of the user
        avatarBig = user.getProfilePictureUrl();
        //The link to the user's profile
        userUrl = user.getWebsiteUrl();
        //The link to the user's profile
        pageUrl = "http://instagram.com/" + username;
    }

    public InstagramAccount(UserInfoData user) {

        if (user == null) return;

        //Id
        setId(Sources.INSTAGRAM + "#" + user.getId());
        //The id of the user in the network
        username = user.getId();
        //The name of the user
        name = user.getFullName();
        //The username of the user
        username = user.getUsername();
        //streamId
        source = Sources.INSTAGRAM;
        //The description of the user
        description = user.getBio();
        //Profile picture of the user
        avatarBig = user.getProfile_picture();
        //The link to the user's profile
        pageUrl = "http://instagram.com/" + username;

        Counts counts = user.getCounts();
        if (counts != null) {
            numItems = counts.getMedia();
            numFriends = counts.getFollows();
            numFollowers = counts.getFollwed_by();
        }

    }
}
