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

    /** * The item unique id */
    protected String id;
	
	
	/** Types of text */
    public enum TEXT_TYPE{ASR,OCR,TXT,HTML};

    /** The text type */
    private TEXT_TYPE txtType;
    
    /** The content itself */
    private String content;

    private ITEM_TYPE type = ITEM_TYPE.TEXT;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public ITEM_TYPE getType() {
        return type;
    }
    
}
