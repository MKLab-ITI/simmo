package gr.iti.mklab.simmo.core.annotations;

import gr.iti.mklab.simmo.core.Annotation;

public class DisturbingScore implements Annotation {
	
	private double score;
	
	private String annotationType = "DisturbingScore";
	
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

    public String getAnnotationType() {
		return annotationType;
	}

	public void setAnnotationType(String annotationType) {
		this.annotationType = annotationType;
	}
	
}
