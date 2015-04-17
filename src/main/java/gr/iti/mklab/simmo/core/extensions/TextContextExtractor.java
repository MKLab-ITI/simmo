package gr.iti.mklab.simmo.core.extensions;

import gr.iti.mklab.simmo.core.Document;
import gr.iti.mklab.simmo.core.annotations.NamedEntity;
import gr.iti.mklab.simmo.core.associations.TextualRelation;

/**
 * An interface to be implemented by text context extraction modules
 *
 * @author kandreadou
 * @version 1.0.0
 * @since November 5, 2014
 */
public interface TextContextExtractor {

    public Document analyze(String htmlStr);

    public String getCleanText(String htmlStr);

    public NamedEntity[] getNamedEntities(String htmlStr);

    public String[] getNamedEntitiesOfType(String htmlStr, String type);

    public TextualRelation[] getRelations(String htmlStr);

    public TextualRelation[] getRelationsOfType(String htmlStr, String type);

}
