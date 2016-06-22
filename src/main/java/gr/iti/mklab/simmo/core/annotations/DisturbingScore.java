package gr.iti.mklab.simmo.core.annotations;

import gr.iti.mklab.simmo.core.Annotation;

public class DisturbingScore implements Annotation {
	
	private double score;

	public DisturbingScore() {
		
	}
	
	public DisturbingScore(double score) {
		this.score = score;
	}
	
	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

}
