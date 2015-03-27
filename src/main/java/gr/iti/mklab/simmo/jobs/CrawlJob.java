package gr.iti.mklab.simmo.jobs;

import org.mongodb.morphia.annotations.Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * A CrawlJob
 *
 * @author kandreadou
 * @version 1.0.0
 * @since March 26, 2015
 */
@Entity
public class CrawlJob extends Job {

    /**
     * The path to the crawl data directory (not the warc files rather than
     * the internal crawler files, sieve, frontier etc
     */
    protected String crawlDataPath;

    /**
     * The collection name, for naming the index and the mongo db table
     */
    protected String collection;

    /**
     * A list of keywords to focus the crawl on
     */
    protected Set<String> keywords = new HashSet<String>();

    /**
     * Will be this a new or an already existing crawl?
     * By default start a new crawl
     */
    protected boolean isNew = true;

    public CrawlJob() {
    }

    public CrawlJob(String path, String collection, Set<String> keywords, boolean isNew) {
        this.crawlDataPath = path;
        this.collection = collection;
        this.keywords = keywords;
        this.isNew = isNew;
        this.requestState = STATE.WAITING;
        this.lastStateChange = new Date();
        this.creationDate = new Date();
    }

    public void addKeyword(String keyword) {
        for (String s : keyword.split("\\s+"))
            keywords.add(s);
    }

    public void removeKeyword(String keyword) {
        keywords.remove(keyword);
    }

    public String getCrawlDataPath() {
        return crawlDataPath;
    }

    public void setCrawlDataPath(String crawlDataPath) {
        this.crawlDataPath = crawlDataPath;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }
}
