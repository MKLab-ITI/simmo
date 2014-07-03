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

    public String id = null;
    public List<Segment> segments = new ArrayList<Segment>();
    public String language = null;

}
