package gr.iti.mklab.simmo.core.annotations;

import gr.iti.mklab.simmo.core.Annotation;

/**
 * The cluster where this Annotatable belongs to
 *
 * @author kandreadou
 */
public class Clustered implements Annotation {

    /**
     * The id of the cluster where this item belongs to *
     */
    private String clusterId;

    public Clustered(){}

    public Clustered(String clusterId) {
        this.clusterId = clusterId;
    }

    public String getClusterId() {
        return clusterId;
    }
}
