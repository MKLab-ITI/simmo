package gr.iti.mklab.simmo.items;

/**
 * An image item
 *
 * @see gr.iti.mklab.simmo.Item
 * @see gr.iti.mklab.simmo.items.Media
 *
 * @version 1.0.0
 * @since July 7, 2014
 * @author amoumtzidou
 */
public class Image extends Media {

    /** The size of the image in bytes */
    private long size;

    
    /** The width of the video */
    private int width;
    
    /** The height of the video */
    private int height;
    
    
    /** A path (or URL) to the image thumbnail */
    private String thumbnail;


    /** The alternate text */
    private String alternateText;

    
    /** The EXIF data for jpg images */
    private String exif;
    
    
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
    
    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.widht = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    
    public String getExif() {
        return exif;
    }
    
    public void setExif(String exif) {
        this.exif = exif;
    }
    
}
