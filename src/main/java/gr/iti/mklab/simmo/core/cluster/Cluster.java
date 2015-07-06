package gr.iti.mklab.simmo.core.cluster;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

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
    protected List<Clusterable> members = new ArrayList<>();

    protected int size;

    public Cluster() {
    }

    public void addMember(Clusterable c) {
        members.add(c);
    }

    public void removeMember(Clusterable c) {
        members.remove(c);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Clusterable> getMembers() {
        return members;
    }

    public void setMembers(List<Clusterable> members){
        this.members = members;
    }

    public String getId() {
        return id;
    }
}
