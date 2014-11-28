#simmo

Socially interconnected/interlinked and multimedia-enriched objects: A model for representing multimedia content in the context of the Web and Social Media. 

When using this framework, please quote the following paper:

>T. Tsikrika, K. Andreadou, A. Moumtzidou, E. Schinas, S. Papadopoulos, S. Vrochidis, Y. Kompatsiaris, "A Unified Model for Socially Interconnected Multimedia-Enriched Objects",  21st MultiMedia Modelling Conference (MMM2015), Sydney, Australia, 5-7 January, 2015 (accepted for publication)

#Morphia resources

 - [Morphia on github]
 - [Morphia wiki]

#How to use

The **MorphiaManager** is responisble for initializing all the Morphia related objects, as so
```
 mongoClient = new MongoClient(new MongoClientURI(System.getProperty("MONGO_URI", "mongodb://localhost:27017")));
db = mongoClient.getDB(dbName);
ds = morphia.createDatastore(mongoClient, db.getName());
morphia.map(Image.class).map(Location.class).map(Similarity.class).map(Post.class).map(Webpage.class);
ds.ensureCaps();
ds.ensureIndexes();
 ```
Make sure you call ```morphia.map()``` for all the classes mapped with the ```@Entity``` annotation. 

```ensureCaps()``` ensures capped collection from ```@Entity```

```ensureIndexes()``` creates indexes from ```@Index``` annotations in your entities

The **DAOManager** contains all necessary DAOs and helper methods for all CRUD operations. You should use the dedicated DAOManager methods for storing Items and Documents as these objects use the ```Reference``` annotation which requires for the referenced object to be already stored in the database before being referenced.

Some unit tests are already available in the test folder.

# Version
1.0.0

[Morphia on github]:https://github.com/mongodb/morphia
[Morphia wiki]:https://github.com/mongodb/morphia/wiki
