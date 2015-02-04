package gr.iti.mklab.simmo.items;

import org.mongodb.morphia.annotations.Entity;

/**
 * A video item
 *
 * @author kandreadou
 * @version 1.0.0
 * @see gr.iti.mklab.simmo.Item
 * @see gr.iti.mklab.simmo.items.Media
 * @since July 3, 2014
 */
@Entity
public class Video extends Media {

    /**
     * The size of the video in bytes
     */
    protected long size;

    /**
     * The width of the video
     */
    protected int width;

    /**
     * The height of the video
     */
    protected int height;

    /**
     * A path (or URL) to the image thumbnail
     */
    protected String thumbnail;

    /**
     * The number of frames in the video
     */
    protected int numFrames;

    /**
     * The video duration in seconds
     */
    protected long duration;

    /**
     * The video quality
     */
    protected String quality;

    /**
     * The video codec
     */
    protected String codec;

    /**
     * The number of likes
     */
    protected long numLikes;

    /**
     * The number of views
     */
    protected long numViews;

    /**
     * The rating
     */
    protected float rating;

    public Video() {
        this.type = ITEM_TYPE.VIDEO;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getNumFrames() {
        return numFrames;
    }

    public void setNumFrames(int numFrames) {
        this.numFrames = numFrames;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
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

}
