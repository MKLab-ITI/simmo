package gr.iti.mklab.simmo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kandreadou on 7/3/14.
 */
public class Document extends Object {

    /**
     * A list of items that the Documents contains
     */
    protected List<Item> items = new ArrayList<Item>();

    /**
     * A list of references to other Documents
     */
    protected List<Reference> references = new ArrayList<Reference>();

    protected String language;
    protected String type;

}
