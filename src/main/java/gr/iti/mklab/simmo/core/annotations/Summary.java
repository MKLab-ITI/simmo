package gr.iti.mklab.simmo.core.annotations;

import gr.iti.mklab.simmo.core.Annotation;


public class Summary implements Annotation {
	
	
	/** Types of feature encodings */
	public enum SUMMARY_METHOD{Abstractive, Extractive, Manual, Unknown};
	
	
	/** The type of descriptor */
	private SUMMARY_METHOD summaryMethod;
	
	
	
    /** The summary itself */
    private String content;
	
	
    
	public SUMMARY_METHOD getSummaryMethod() {
		return summaryMethod;
	}

	
	public void setSummaryMethod(SUMMARY_METHOD summaryMethod) {
		this.summaryMethod = summaryMethod;
	}

	
	
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
	

}
