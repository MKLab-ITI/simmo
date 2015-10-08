package gr.iti.mklab.simmo.core.annotations;

import gr.iti.mklab.simmo.core.Annotation;

public class Category implements Annotation {
	
	private String category;

	public Category(){ }
		
    
    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
       
    
}