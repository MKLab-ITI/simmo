package gr.iti.mklab.simmo;


import java.util.ArrayList;
import java.util.List;


public class SegmentGroup implements Segment {

	
    /**
     * A list of Segments that the SegmentGroup contains
     */
    protected List<Segment> segments = new ArrayList<Segment>();

    
    public List<Segment> getSegments() {
        return segments;
    }

    public void addSegment(Segment segment){
    	segments.add(segment);
    }

    public void removeSegment(Segment segment){
    	segments.remove(segment);
    }
    
}
