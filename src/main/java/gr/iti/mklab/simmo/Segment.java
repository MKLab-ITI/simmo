package gr.iti.mklab.simmo;

/**
 *
 * @author amoumtzidou
 * @version 1.0.0
 * @since July 8, 2014
 */
public abstract class Segment extends Annotatable {
	
	
    /** The unique internal Item id */
    public String id = null;

    
	/** Types of frame blocks */
    public enum FRAMES_BLOCK_TYPE{SHOT, SCENE, UNDEFINED};

    
    /** The frame block type */
    FRAMES_BLOCK_TYPE framesBlockType = FRAMES_BLOCK_TYPE.UNDEFINED;

	
    /** Types of frame blocks */
    public enum SEGMENT_TYPE{LINEAR, SPATIAL, TEMPORAL, SPATIOTEMPORAL};

    
    
    /** The first frame of the segment */
    public int firstFrame = 0;

    
    /** The last frame of the segment */
    public int lastFrame = 0;

    
    
}
