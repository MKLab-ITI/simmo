package gr.iti.mklab.simmo.items;

/**
 * A video item
 *
 * @see gr.iti.mklab.simmo.Item
 * @see gr.iti.mklab.simmo.items.Media
 *
 * @version 1.0.0
 * @since July 3, 2014
 * @author amoumtzidou
 */
public class Image extends Media {

    /** The size of the image in bytes */
    private long size;

    /**
     * TODO: A path to the image thumbnail or a URL?
     */
    private String thumbnail;


    /** The alternate text */
    private String alternateText;

    
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
    
    public String getAlternateText(){
    	return alternateText;
    }
    
    public void setAlternateText(String alternateText){
    	this.alternateText = alternateText;
    }
    
}
