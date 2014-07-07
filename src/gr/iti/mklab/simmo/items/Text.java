package gr.iti.mklab.simmo.items;

import gr.iti.mklab.simmo.Item;

/**
 * A text item
 *
 * @see gr.iti.mklab.simmo.Item
 *
 * @version 1.0.0
 * @since July 7, 2014
 * @author amoumtzidou
 */
public class Text implements Item {
	
	/** Types of text */
    private enum TEXT_TYPE{ASR,OCR,TXT,HTML};

    
    /**
     * TODO: A path to the image thumbnail or a URL?
     */
    private TEXT_TYPE txtType;

    
    /** The content itself */
    private String content;

    
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TEXT_TYPE getTextType() {
        return txtType;
    }

    public void setTextType(TEXT_TYPE txtType) {
        this.txtType = txtType;
    }
    
    
}
