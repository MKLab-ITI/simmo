package gr.iti.mklab.simmo.impl.users;

import com.google.api.services.plus.model.Activity.Actor;
import com.google.api.services.plus.model.Person;

import gr.iti.mklab.simmo.core.UserAccount;
import gr.iti.mklab.simmo.impl.Sources;
import org.mongodb.morphia.annotations.Entity;

/**
 * Class that holds the information of a google plus user
 *
 * @author ailiakop, kandreadou
 */
@Entity("UserAccount")
public class GooglePlusAccount extends UserAccount {


    public GooglePlusAccount(Actor actor) {

        if (actor == null) return;

        //Id
        setId(Sources.GOOGLE_PLUS + "#" + actor.getId());

        //The id of the user in the network
        username = actor.getId();

        //The name of the user
        name = actor.getDisplayName();

        //The username of the user
        username = actor.getDisplayName();

        //streamId
        source = Sources.GOOGLE_PLUS;

        //Profile picture of the user
        avatarBig = actor.getImage().getUrl();

        //The link to the user's profile
        pageUrl = actor.getUrl();

        isVerified = false;

    }

    public GooglePlusAccount(Person person) {

        if (person == null)
            return;

        //Id
        setId(Sources.GOOGLE_PLUS + "#" + person.getId());

        //The id of the user in the network
        username = person.getId();

        //The name of the user
        name = person.getDisplayName();

        //The username of the user
        username = person.getDisplayName();

        //The brief description of this person.
        description = person.getTagline();

        //streamId
        source = Sources.GOOGLE_PLUS;

        //Profile picture of the user
        avatarBig = person.getImage().getUrl();

        //The link to the user's profile
        pageUrl = person.getUrl();

        isVerified = person.getVerified();

        if (person.getCircledByCount() != null)
            numFollowers = person.getCircledByCount();

        location = person.getCurrentLocation();

    }


}
