package gr.iti.mklab.simmo.annotations;

import gr.iti.mklab.simmo.associations.Annotation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author kandreadou
 * @version 1.0.1
 * @since November 5, 2014
 */
public class NamedEntity implements Annotation {

    /**
     * The named entity token, for instance "Yesterday"
     */
    private String token;

    /**
     * The named entity type, for instance "date"
     */
    private String type;

    public NamedEntity(String token, String type){
        this.token = token;
        this.type = type;
    }

    public String getToken(){
        return token;
    }

    public String getType(){
        return type;
    }
}
