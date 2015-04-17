package gr.iti.mklab.simmo.core.items;

import org.mongodb.morphia.annotations.Entity;

import java.util.HashMap;
import java.util.Map;

/**
 * An image item
 *
 * @see gr.iti.mklab.simmo.core.Item
 * @see gr.iti.mklab.simmo.core.items.Media
 *
 * @version 1.0.0
 * @since July 7, 2014
 * @author amoumtzidou
 */
/*@Indexes({
        @Index("id"),
        @Index("location.coordinates")
})*/
@Entity
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

    
    /** The EXIF metadata for JPEG images */
    private Map<String, String> exif = new HashMap<String, String>();

    public Image(){
        this.type = ITEM_TYPE.IMAGE;
    }
    
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
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    
    public String getExifMetadataField(String exifField) {
        return exif.get(exifField);
    }
    
    public void setExifMetadataField(String exifField, String valueforField) {
        exif.put(exifField, valueforField);
    }

    public Map<String, String> getExifMetadata(){
        return exif;
    }
    
}
