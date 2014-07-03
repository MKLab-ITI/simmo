package gr.iti.mklab.simmo;

import java.util.ArrayList;
import java.util.List;

/**
 * An Item interface
 *
 * @author kandreadou
 * @version 1.0.0
 * @since Jyly 3, 2014
 */
public interface Item {

    public List<Segment> segments = new ArrayList<Segment>();
    public String language = null;

}
