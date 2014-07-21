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
    public enum SEGMENT_TYPE{SHOT, SCENE, UNDEFINED};

    
    /** The segment type */
    SEGMENT_TYPE segmentType = SEGMENT_TYPE.UNDEFINED;

    
    
    /** The first frame of the segment */
    public int firstFrame = 0;

    
    /** The last frame of the segment */
    public int lastFrame = 0;

    
    
}
