package gr.iti.mklab.simmo.associations;

import gr.iti.mklab.simmo.*;

/**
 * Affiliation models the implicit relation between two {@link gr.iti.mklab.simmo.UserAccount}
 * e.g. be friends with, follows
 *
 * @author kandreadou
 * @version 1.0.0
 * @since August 21, 2014
 */
public class Affiliation {

    protected UserAccount firstAccount;

    protected UserAccount secondAccount;

    private String id;

    public Affiliation (UserAccount account, UserAccount affiliated){
        this.firstAccount = account;
        this.secondAccount = affiliated;
    }
}
