package gr.iti.mklab.simmo;

import java.util.ArrayList;
import java.util.List;

/**
 * An Item interface which is instantiated as either {@link gr.iti.mklab.simmo.items.Text} or {@link gr.iti.mklab.simmo.items.Media}.
 *
 * @author kandreadou
 * @version 1.0.0
 * @since July 3, 2014
 */
public interface Item extends Annotatable {

    /** A list of segments, representing the content of the Item at a finer level of granularity */
    public List<Segment> segments = new ArrayList<Segment>();

    public static enum ITEM_TYPE{
        TEXT, IMAGE, VIDEO, AUDIO, UNDEFINED;
    }

    /** The Item language */
    public String language = null;

    public ITEM_TYPE getType();

}
