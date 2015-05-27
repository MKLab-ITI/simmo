package gr.iti.mklab.simmo.impl.users;

import gr.iti.mklab.simmo.core.UserAccount;
import gr.iti.mklab.simmo.impl.Sources;
import org.mongodb.morphia.annotations.Entity;

/**
 * Class that holds the information of a panoramio user
 *
 * @author kandreadou
 */
@Entity("UserAccount")
public class PanoramioAccount extends UserAccount {

    public PanoramioAccount() {
    }

    public PanoramioAccount(String owner_id, String url, String name) {
        setId(Sources.PANORAMIO + '#' + owner_id);
        setUserUrl(url);
        setName(name);
    }
}
