package gr.iti.mklab.simmo.core.annotations;

import gr.iti.mklab.simmo.core.Annotation;

public class SummaryScore implements Annotation {

	 /** The prior of the item */
    private double popularityScore = 0;
    
	 /** The prior of the item */
    private double priorScore = 0;
    
	 /** The divRank score of the item */
    private double pageRankScore = 0;
    
	 /** The divRank score of the item */
    private double divRankScore = 0;

    public SummaryScore() {
    	
    }

    public SummaryScore(double popularityScore, double priorScore, double pageRankScore, double divRankScore) {
    	this.popularityScore = popularityScore;
    	this.priorScore = priorScore;
    	this.pageRankScore = pageRankScore;
    	this.divRankScore = divRankScore;
    }
    
	public double getPriorScore() {
		return priorScore;
	}

	public void setPriorScore(double priorScore) {
		this.priorScore = priorScore;
	}

	public double getPageRankScore() {
		return pageRankScore;
	}

	public void setPageRankScore(double pageRankScore) {
		this.pageRankScore = pageRankScore;
	}

	public double getDivRankScore() {
		return divRankScore;
	}

	public void setDivRankScore(double divRankScore) {
		this.divRankScore = divRankScore;
	}

	public double getPopularityScore() {
		return popularityScore;
	}

	public void setPopularityScore(double popularityScore) {
		this.popularityScore = popularityScore;
	}
    
    
}
