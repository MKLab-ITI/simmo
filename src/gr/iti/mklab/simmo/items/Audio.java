package gr.iti.mklab.simmo.items;

/**
 * A video item
 *
 * @see gr.iti.mklab.simmo.Item
 * @see gr.iti.mklab.simmo.items.Media
 *
 * @version 1.0.0
 * @since July 7, 2014
 * @author amoumtzidou
 */
public class Audio extends Media {

    /** The audio duration in seconds */
    private long duration;


    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    
}