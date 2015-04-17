package gr.iti.mklab.simmo.core.segments;

import gr.iti.mklab.simmo.core.Segment;
import gr.iti.mklab.simmo.core.Segment.SEGMENT_TYPE;

public class SegmentFactory {


	//use getShape method to get object of type shape 
	public Segment getSegment(SEGMENT_TYPE segmentType){

		if(segmentType == null){
			return null;
		}		

		if(segmentType == SEGMENT_TYPE.LINEAR){
			return new LinearSegment();
		} 
		else if(segmentType == SEGMENT_TYPE.SPATIAL){
			return new SpatialSegment();
		} 
		else if(segmentType == SEGMENT_TYPE.TEMPORAL){
			return new TemporalSegment();
		}
		else if(segmentType == SEGMENT_TYPE.SPATIOTEMPORAL){
			return new SpatioTemporalSegment();
		}
		
		return null;
	}
}
