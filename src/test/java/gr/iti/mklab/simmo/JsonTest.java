package gr.iti.mklab.simmo;

import com.google.gson.Gson;
import gr.iti.mklab.simmo.documents.Post;
import gr.iti.mklab.simmo.items.Text;
import gr.iti.mklab.simmo.items.Video;
import gr.iti.mklab.simmo.documents.Webpage;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by kandreadou on 7/21/14.
 */
public class JsonTest {

    public static void main(String[] args){
        Gson gson = new Gson();
        Post post = new Post();
        post.setUrl("https://www.youtube.com/watch?v=wtt2aSV8wdw");
        post.setDescription("Internet Citizens: Defend Net Neutrality");
        post.setAuthor("CGP Grey");
        post.setDescription("Tell the FCC to reclassify broadband internet as a title II common carrier telecommunications service: http://goo.gl/xHnB4n");
        post.setNumViews(919353);
        post.setPositiveVotes(42609);
        post.setNegativeVotes(394);
        post.setNumComments(4538);
        post.setNumSubscriptions(1359322);

        Calendar cal = Calendar.getInstance();
        cal.set(2014,7,21);
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
        video.setAuthor("CGP Grey");
        cal = Calendar.getInstance();
        cal.set(2014, 5, 5);
        video.setCreationDate(cal.getTime());
        cal = Calendar.getInstance();
        cal.set(2014, 7, 21);
        video.setCrawlDate(cal.getTime());
        post.addItem(video);

        Text comment = new Text();
        comment.setContent("<div class=\"Ct\">Learn about this and pass it on! Remember SOPA and PIPA? This is BIGGER. Net neutrality is imperative for an open internet.<br><br><a rel=\"nofollow\" target=\"_blank\" href=\"https://www.youtube.com/watch?v=wtt2aSV8wdw\" class=\"ot-anchor aaTEdf\">Internet Citizens: Defend Net Neutrality</a>﻿</div>");
        comment.setTextType(Text.TEXT_TYPE.HTML);
        comment.setId("409sfh");
        Reference ref = new Reference("409sfh", Reference.ReferenceType.COMMENT);
        post.addReferece(ref);

        Post videoLink = new Post();
        videoLink.setUrl("https://www.youtube.com/watch?v=tk862BbjWx4");
        videoLink.setDescription("Copyright: Forever Less one Day");
        videoLink.setAuthor("CGP Grey");
        videoLink.setNumViews(2101670);
        videoLink.setId("tr452");

        Reference ref2 = new Reference("tr452", Reference.ReferenceType.LINK);
        post.addReferece(ref2);

        System.out.println(gson.toJson(post));
        System.out.println(gson.toJson(comment));
        System.out.println(gson.toJson(videoLink));
    }
}
