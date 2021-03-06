package gr.iti.mklab.simmo.core.cluster;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    protected Date startDate;
    
    protected Date endDate;
    
	protected Clusterable centroid;
	
	protected Map<String, Double> avgDistances;
	
    public Map<String, Double> getAvgDistance() {
		return avgDistances;
	}

	public void setAvgDistances(Map<String, Double> avgDistances) {
		this.avgDistances = avgDistances;
	}

	protected List<Map<String, String>> centroids = new ArrayList<Map<String, String>>();
    
    public List<Map<String, String>> getCentroids() {
		return centroids;
	}

	public void setCentroids(List<Map<String, String>> centroids) {
		this.centroids = centroids;
	}

	public void addCentroid(Map<String, String> centroid) {
		this.centroids.add(centroid);
	}
	
	public Clusterable getCentroid() {
		return centroid;
	}
    
	public void setCentroid(Clusterable centroid) {
		this.centroid = centroid;
	}
    
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

    public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
    
    public void setId(String id) {
        this.id = id;
    }
}
