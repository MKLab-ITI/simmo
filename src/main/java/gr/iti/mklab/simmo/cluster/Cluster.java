package gr.iti.mklab.simmo.cluster;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A Cluster class
 *
 * @author kandreadou
 * @version 1.0.0
 * @since March 26, 2015
 */
@Entity
public class Cluster {

    @Id
    protected String id = new ObjectId().toString();

    @Reference
    public List<Clusterable> members = new ArrayList<>();

    public Cluster(){}

    public void addMember(Clusterable c){
        members.add(c);
    }

    public void removeMember(Clusterable c){
        members.remove(c);
    }

}