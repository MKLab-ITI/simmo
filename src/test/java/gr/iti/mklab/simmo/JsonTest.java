package gr.iti.mklab.simmo;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.iti.mklab.simmo.documents.Post;
import gr.iti.mklab.simmo.items.Text;
import gr.iti.mklab.simmo.items.Video;
import gr.iti.mklab.simmo.associations.Reference;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by kandreadou on 7/21/14.
 */
public class JsonTest {

    public static void main(String[] args){
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setDateFormat(DateFormat.LONG)
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .setVersion(1.0)
                .create();

        Post post = new Post();
        post.setUrl("https://www.youtube.com/watch?v=wtt2aSV8wdw");
        post.setDescription("Internet Citizens: Defend Net Neutrality");
        post.setDescription("Tell the FCC to reclassify broadband internet as a title II common carrier telecommunications service: http://goo.gl/xHnB4n");
        post.setNumViews(919353);
        post.setPositiveVotes(42609);
        post.setNegativeVotes(394);
        post.setNumComments(4538);

        Calendar cal = Calendar.getInstance();
        cal.set(2014,6,21);
        post.setCrawlDate(cal.getTime());

        //The central video item
        Video video = new Video();
        video.setDuration(213);
        video.setTitle("Internet Citizens: Defend Net Neutrality");
        video.setCodec("application/x-shockwave-flash");
        video.setWidth(1280);
        video.setHeight(720);
        video.setDescription("Tell the FCC to reclassify broadband internet as a title II common carrier telecommunications service: http://goo.gl/xHnB4n");
        video.setThumbnail("https://i1.ytimg.com/vi/wtt2aSV8wdw/maxresdefault.jpg");
        cal = Calendar.getInstance();
        cal.set(2014, 4, 5);
        video.setCreationDate(cal.getTime());
        cal = Calendar.getInstance();
        cal.set(2014, 6, 21);
        video.setCrawlDate(cal.getTime());
        post.addItem(video);

        UserAccount account = new UserAccount();
        account.setName("CGP Grey");
        account.setNumFollowers(1361024);
        account.setAvatarSmall("https://yt3.ggpht.com/-hcwBgBwDiuk/AAAAAAAAAAI/AAAAAAAAAAA/eQENCQCzV4w/s100-c-k-no/photo.jpg");
                
        
        Post commentLink = new Post();
        commentLink.setNumLikes(739);
        commentLink.setNumComments(72);
        Text comment = new Text();
        comment.setContent("<div class=\"Ct\">Learn about this and pass it on! Remember SOPA and PIPA? This is BIGGER. Net neutrality is imperative for an open internet.<br><br><a rel=\"nofollow\" target=\"_blank\" href=\"https://www.youtube.com/watch?v=wtt2aSV8wdw\" class=\"ot-anchor aaTEdf\">Internet Citizens: Defend Net Neutrality</a>﻿</div>");
        comment.setTextType(Text.TEXT_TYPE.HTML);
        commentLink.addItem(comment);
        //Reference ref = new Reference("409sfh", Reference.ReferenceType.COMMENT);
        //post.addReferece(ref);

        Post comment2 = new Post();
        comment2.setNumLikes(63);
        comment2.setNumComments(5);
        comment = new Text();
        comment.setContent("Friggin' excellent video, man!  Net neutrality...  FOREVER");
        comment.setTextType(Text.TEXT_TYPE.HTML);
        //comment2.addItem(comment);
        //ref = new Reference("101reyk", Reference.ReferenceType.COMMENT);
        //post.addReferece(ref);

        System.out.println(gson.toJson(post));
        System.out.println(gson.toJson(commentLink));
    }
}
