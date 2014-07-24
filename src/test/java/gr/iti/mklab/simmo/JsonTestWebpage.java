package gr.iti.mklab.simmo;

import com.google.gson.Gson;

import gr.iti.mklab.simmo.documents.Post;
import gr.iti.mklab.simmo.items.Image;
import gr.iti.mklab.simmo.items.Text;
import gr.iti.mklab.simmo.items.Video;
import gr.iti.mklab.simmo.documents.Webpage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * Created by amoumtzidou on 7/22/14.
 */
public class JsonTestWebpage {

	public static void main(String[] args){

		List<String> tags = new ArrayList<String>();
		tags.add("Twitter");
		tags.add("World Cup");
		tags.add("Social networking");
		tags.add("Social media");
		tags.add("Technology");
		tags.add("Media");
		tags.add("Football");
		tags.add("Sport");
		tags.add("World Cup 2014");
		tags.add("Digital media");
		tags.add("Internet");

		Calendar cal = Calendar.getInstance();
		
		Gson gson = new Gson();
		Webpage wp = new Webpage();
		wp.setId("180444840287");
		wp.setTitle("World Cup was biggest event yet for Twitter with 672m tweets | Technology | The Guardian");
		wp.setUrl("http://www.theguardian.com/technology/2014/jul/15/twitter-world-cup-tweets-germany-brazil");
		wp.setAuthor("Stuart Dredge");
		
		cal.set(2014, 7, 15, 11, 33, 51);
		wp.setLastModifiedDate(cal.getTime());
		
		cal.set(2014, 7, 15, 8, 1, 20);
		wp.setCreationDate(cal.getTime());
		wp.setDescription("Germany&#x27;s demolition of Brazil was biggest match on social network, but final victory saw peak tweets-per-minute. By Stuart Dredge");
		wp.setTags(tags);



		
        //The central video item
        Image img = new Image();
        img.setId("");
        img.setAlternateText("World Cup winner Germany was a big hit on Twitter during the tournament.");
        img.setSize((long)57.59);
        img.setWidth(620);
        img.setHeight(372);
        img.setUrl("http://i.guim.co.uk/w-620/h--/q-95/sys-images/Guardian/Pix/pictures/2014/7/15/1405409761872/c483154b-eb11-4ea5-a4bf-2a685c7f13ed-620x372.jpeg");
    
                
        wp.addItem(img);
                
       
        Text txt = new Text();
        txt.setId("");
        txt.setContent("Germany may have beaten Argentina to win the World Cup, but Twitter and Facebook have been engaged in their own battle for social supremacy during the football tournament. This particular competition is stretching beyond the final, as the two social networks continue to release stats on how popular the World Cup was among their users. Twitter's latest salvo focuses on the 672m related tweets sent during the competition. \"While this is the highest number we’ve announced related to an event, it’s hard to compare the 32-day, 64-match World Cup to, for example, the single-game Super Bowl, the one-night Oscars, or the 16-day Olympics,\" wrote data editor Simon Rogers in a blog post. Advertisement The most popular match on Twitter was Germany\'s 7-1 victory over Brazil in the semi-final, which sparked 35.6m tweets: more than the final's 32.1m. However, Germany's defeat of Argentina was the World Cup's biggest moment, generating more than 618,000 tweets per minute, ahead of the 580,000 tweets per minute sparked by the team's fifth goal against Brazil in the semi-final. The Brazilian star Neymar Jr was the most-mentioned player during the tournament, followed by Argentina's Lionel Messi and Urugay's Luis Suarez – the latter more due to his infamous biting episode in a group match against Italy, rather than his footballing skills. Facebook has already announced that 88m people generated more than 280m posts, comments and likes on its social network during the World Cup final, beating its previous record of 245m \"interactions\" set by the Super Bowl in 2013. The two companies have been keen to flag up the use of their apps by players during the competition, from Mario Götze on Instagram and Wayne Rooney apologising to England fans on Facebook, to Rihanna's new sideline as a Twitter pundit.");
        txt.setTextType(Text.TEXT_TYPE.HTML);
        
        
        Text comment = new Text();
         comment.setTextType(Text.TEXT_TYPE.TXT);
        comment.setId("409sfh");
        Reference ref = new Reference("409sfh", Reference.ReferenceType.COMMENT);
        wp.addReferece(ref);

        
        
        Post post1 = new Post();
        post1.setAuthor("outsiderwill");
        cal.set(2014,  7,  15,  9,  56);
        post1.setCreationDate(cal.getTime());
        post1.setDescription("Who gives a shit about Twitter");
        post1.setId("p1");
        
        Post post2 = new Post();
        post2.setAuthor("Dylan Alexander");
        post2.setDescription("Twitter is just about people posting inane comments. To consider I came across this article because of my twitter account would suggest it has some value.");
        post2.setId("p2");
        
//        wp.addItem(p1);
 //       Reference ref1 = new Reference("tr452", Reference.ReferenceType.COMMENT);
  //      post2.addReferece(p1);
        
    //    Annotation ann = 
        
        /*
        Reference ref2 = new Reference("tr452", Reference.ReferenceType.LINK);
        post.addReferece(ref2);
 */
        System.out.println(gson.toJson(wp));
        System.out.println(gson.toJson(comment));

		    }
}
