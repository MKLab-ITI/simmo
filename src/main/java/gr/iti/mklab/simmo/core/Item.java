package gr.iti.mklab.simmo.core;

import java.util.ArrayList;
import java.util.List;

/**
 * An Item interface which is instantiated as either {@link gr.iti.mklab.simmo.core.items.Text} or {@link gr.iti.mklab.simmo.core.items.Media}.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since July 3, 2014
 */
public abstract class Item extends Object {

    public ITEM_TYPE type;

    /**
     * A list of segments, representing the content of the Item at a finer level of granularity
     */
    public List<Segment> segments = new ArrayList<Segment>();

    /**
     * The id of the document where this item is originating from *
     */
    protected String sourceDocumentId;

    public static enum ITEM_TYPE {
        TEXT, IMAGE, VIDEO, AUDIO, UNDEFINED;
    }

    /**
     * The Item language
     */
    public String language = null;

    public ITEM_TYPE getType() {
        return type;
    }

    public String getSourceDocumentId() {
        return sourceDocumentId;
    }

    public void setSourceDocumentId(String sourceDocumentId) {
        this.sourceDocumentId = sourceDocumentId;
    }

}
