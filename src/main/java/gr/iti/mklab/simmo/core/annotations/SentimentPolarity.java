package gr.iti.mklab.simmo.core.annotations;

import gr.iti.mklab.simmo.core.Annotation;

public class SentimentPolarity implements Annotation {
	
		
	
    private double positive;
	private double negative;

	private double sentiment;
	private double polarity;

	public SentimentPolarity(){ }
	
    public SentimentPolarity(double positive, double negative){
        this.positive = positive;
        this.negative = negative;
        this.sentiment = Math.abs(positive) + Math.abs(negative);
        this.polarity = positive + negative;
    }
	
    public SentimentPolarity(double positive, double negative, double sentiment, double polarity){
        this.positive = positive;
        this.negative = negative;
        this.sentiment = sentiment;
        this.polarity = polarity;
    }
	
    
    public void setPositive(double positive) {
        this.positive = positive;
    }

    public double getPositive() {
        return positive;
    }
    
    
    public void setNegative(double negative) {
        this.negative = negative;
    }

    public double getNegative() {
        return negative;
    }
    
    
    public void setPolarity(double polarity) {
        this.polarity = polarity;
    }

    
    public double getPolarity() {
        return polarity;
    }
    
   
    public void setSentiment(double sentiment) {
        this.sentiment = sentiment;
    }

   
    public double getSentiment() {
        return sentiment;
    }


}