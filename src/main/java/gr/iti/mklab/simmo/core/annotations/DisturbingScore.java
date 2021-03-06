package gr.iti.mklab.simmo.core.annotations;

import gr.iti.mklab.simmo.core.Annotation;

public class DisturbingScore implements Annotation {
	
	private double confidenceScore;
	
	private String annotationType = "DisturbingScore";
	
	public DisturbingScore() {
		
	}
	
	public DisturbingScore(double score) {
		this.confidenceScore = score;
	}
	
	public double getConfidenceScore() {
		return confidenceScore;
	}

	public void setConfidenceScore(double score) {
		this.confidenceScore = score;
	}

    public String getAnnotationType() {
		return annotationType;
	}

	public void setAnnotationType(String annotationType) {
		this.annotationType = annotationType;
	}
	
}
