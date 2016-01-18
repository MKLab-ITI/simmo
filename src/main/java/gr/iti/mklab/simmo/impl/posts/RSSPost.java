package gr.iti.mklab.simmo.impl.posts;

import gr.iti.mklab.simmo.core.documents.Post;
import org.jsoup.Jsoup;

import com.sun.syndication.feed.synd.SyndEntry;
import org.mongodb.morphia.annotations.Entity;

/**
 * Class that holds the information of an RSS feed
 * @author manosetro, kandreadou
 */
@Entity("Post")
public class RSSPost extends Post {

	public RSSPost() {
		
	}
	
	public RSSPost(SyndEntry rssEntry) {
		
		if(rssEntry == null || rssEntry.getLink() == null)
			return;
		//Id
		id = rssEntry.getLink();
		//Document's title
		title = rssEntry.getTitle();
		//Document's content - Extract text content from html structure
		if(rssEntry.getDescription()!=null)
			description = extractDocumentContent(rssEntry.getDescription().getValue());
		//Document's time of publication
		
		creationDate = rssEntry.getPublishedDate();
		//The url where the document can be found
		url = rssEntry.getLink();
	}
	
	private String extractDocumentContent(String htmlContent){
		org.jsoup.nodes.Document doc = Jsoup.parse(htmlContent);
		
		String content = doc.body().text();
		
		return content;
	}
}
