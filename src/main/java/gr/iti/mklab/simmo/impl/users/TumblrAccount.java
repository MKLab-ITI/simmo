package gr.iti.mklab.simmo.impl.users;

import com.tumblr.jumblr.types.Blog;
import com.tumblr.jumblr.types.User;


import gr.iti.mklab.simmo.core.UserAccount;
import gr.iti.mklab.simmo.impl.Sources;
import org.mongodb.morphia.annotations.Entity;

/**
 * Class that holds the information of a tumblr user
 *
 * @author ailiakop, kandreadou
 */
@Entity("UserAccount")
public class TumblrAccount extends UserAccount {

    public TumblrAccount(){}

    public TumblrAccount(Blog blog) {

        //Id
        setId(Sources.TUMBLR + "#" + blog.getName());
        //The id of the user in the network
        username = blog.getName();
        //The name of the blog
        name = blog.getName();
        //streamId
        source = Sources.TUMBLR;
        //The description of the blog
        blog.getDescription();
        //Profile picture of the blog
        avatarBig = blog.avatar();
        //Likes of the blog
        numListed = blog.getLikeCount();
        //Posts of the blog
        numItems = blog.getPostCount();

    }

    public TumblrAccount(User user) {

        //Id
        setId(Sources.TUMBLR + "#" + user.getName());

        //The id of the user in the network
        username = user.getName();

        //The name of the blog
        name = user.getName();

        //streamId
        source = Sources.TUMBLR;
        //Profile picture of the blog
        numItems = user.getBlogs().size();

    }
}
