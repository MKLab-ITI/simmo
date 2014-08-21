package gr.iti.mklab.simmo.associations;

import gr.iti.mklab.simmo.*;

import java.util.Date;

/**
 * Affiliation models the implicit relation between two {@link gr.iti.mklab.simmo.UserAccount}
 * e.g. be friends with, follows
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 21, 2014
 */
public class Affiliation {

    public enum AFFILIATION_TYPE {
        FRIENDS_WITH, FOLLOWS, UNDEFINED
    }

    protected UserAccount firstAccount;

    protected UserAccount secondAccount;

    protected AFFILIATION_TYPE affiliationType;

    protected Date affiliationDate;

    private String id;

    public Affiliation (UserAccount account, UserAccount affiliated, AFFILIATION_TYPE type, Date date){
        this.firstAccount = account;
        this.secondAccount = affiliated;
        this.affiliationType = type;
        this.affiliationDate = date;
    }
    
    public String getId(){
    	return id;
    }
    
}
