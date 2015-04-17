package gr.iti.mklab.simmo.core.morphia;

import gr.iti.mklab.simmo.core.*;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

import java.util.List;

/**
 * Created by kandreadou on 2/6/15.
 */
public class AssociationDAO extends BasicDAO<Association, String> {

    public AssociationDAO(String dbName) {
        super(Association.class, MorphiaManager.getMongoClient(), MorphiaManager.getMorphia(), MorphiaManager.getDB(dbName).getName());
    }

    public List<Association> findAssociationsForObject(gr.iti.mklab.simmo.core.Object object) {
        Query<Association> q = getDatastore().createQuery(Association.class);
        q.or(
                q.criteria("one").equal(object),
                q.criteria("other").equal(object)
        );
        return q.asList();
    }

    public List<Association> findAssociationsForUserAccount(UserAccount u) {
        Query<Association> q = getDatastore().createQuery(Association.class);
        q.or(
                q.criteria("one").equal(u),
                q.criteria("other").equal(u)
        );
        return q.asList();
    }
}
