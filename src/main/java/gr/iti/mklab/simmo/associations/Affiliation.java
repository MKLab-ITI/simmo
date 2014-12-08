package gr.iti.mklab.simmo.associations;

import gr.iti.mklab.simmo.*;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;

/**
 * Affiliation models the implicit relation between two {@link gr.iti.mklab.simmo.UserAccount}
 * e.g. be friends with, follows
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 21, 2014
 */
@Entity
public class Affiliation {

    public enum AFFILIATION_TYPE {
        FRIENDS_WITH, FOLLOWS, UNDEFINED
    }

    @Reference
    protected UserAccount firstAccount;

    @Reference
    protected UserAccount secondAccount;

    protected AFFILIATION_TYPE affiliationType;

    protected Date affiliationDate;

    @Id
    private ObjectId id;

    public Affiliation(){}

    public Affiliation (UserAccount account, UserAccount affiliated, AFFILIATION_TYPE type, Date date){
        this.firstAccount = account;
        this.secondAccount = affiliated;
        this.affiliationType = type;
        this.affiliationDate = date;
    }
    
    public ObjectId getId(){
    	return id;
    }

    public UserAccount getFirstAccount(){
        return firstAccount;
    }

    public UserAccount getSecondAccount(){
        return secondAccount;
    }
    
}
