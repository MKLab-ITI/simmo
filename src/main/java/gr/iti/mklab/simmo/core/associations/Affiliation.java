package gr.iti.mklab.simmo.core.associations;

import gr.iti.mklab.simmo.core.Association;
import gr.iti.mklab.simmo.core.UserAccount;
import org.mongodb.morphia.annotations.*;

import java.util.Date;

/**
 * Affiliation models the implicit relation between two {@link gr.iti.mklab.simmo.core.UserAccount}
 * e.g. be friends with, follows
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 21, 2014
 */
@Entity("Association")
public class Affiliation extends Association {

    public enum AFFILIATION_TYPE {
        FRIENDS_WITH, FOLLOWS, UNDEFINED
    }

    private AFFILIATION_TYPE affiliationType;

    private Date affiliationDate;

    public Affiliation(){}

    public Affiliation(UserAccount account, UserAccount affiliated, AFFILIATION_TYPE type, Date date) {
        super(account, affiliated);
        this.affiliationType = type;
        this.affiliationDate = date;
    }

    public Affiliation(UserAccount account, UserAccount affiliated) {
        super(account, affiliated);
    }

    public UserAccount getFirstAccount() {
        return (UserAccount) one;
    }

    public UserAccount getSecondAccount() {
        return (UserAccount) other;
    }

}
