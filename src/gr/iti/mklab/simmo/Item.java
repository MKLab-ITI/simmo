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
public interface Item {

    /** The unique Item id */
    public String id = null;

    /** A list of segments, representing the content of the Item at a finer level of granularity */
    public List<Segment> segments = new ArrayList<Segment>();

    /** The Item language */
    public String language = null;

}
