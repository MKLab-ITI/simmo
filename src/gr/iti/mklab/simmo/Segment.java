package gr.iti.mklab.simmo;

/**
 *
 * @author amoumtzidou
 * @version 1.0.0
 * @since July 8, 2014
 */
public interface Segment extends Annotatable {
	
	
    /** The unique internal Item id */
    public String id = null;

    
	/** Types of segments */
    public enum SEGMENT_TYPE{SHOT, SCENE};

    
    /** The segment type */
    private SEGMENT_TYPE segmentType;

    
    
    /** The first frame of the segment */
    public int firstFrame = null;

    
    /** The last frame of the segment */
    public int lastFrame = null;

    
    
}
