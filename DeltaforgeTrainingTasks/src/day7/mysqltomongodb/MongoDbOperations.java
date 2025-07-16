package day7.mysqltomongodb;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoDbOperations {
   private static final String mongoUri = "mongodb://localhost:27017";
   private static final String mongoDbName = "School";
   private static final String mongoCollectionName = "students";
   static  MongoClient mongoClient;

    public void mongoDbReadAll() {
         mongoClient = MongoClients.create(mongoUri);
         MongoDatabase database = mongoClient.getDatabase(mongoDbName);
         MongoCollection<Document> collection = database.getCollection(mongoCollectionName);
         FindIterable<Document> docs = collection.find();

         for (Document doc : docs) {
            System.out.println(doc.toJson());
         }
    }

    public void mongoDbCreate(int id, String name, String dept, double salary) {
        mongoClient = MongoClients.create(mongoUri);
        MongoDatabase database = mongoClient.getDatabase(mongoDbName);
        MongoCollection<Document> collection = database.getCollection(mongoCollectionName);
        Document doc = new Document("sid", id)
                .append("sname", name)
                .append("sroll", dept);
        collection.insertOne(doc);
        System.out.println("Inserted employee");
    }

    public void mongoDbUpdate(int id, String name) {
        mongoClient = MongoClients.create(mongoUri);
        MongoDatabase database = mongoClient.getDatabase(mongoDbName);
        MongoCollection<Document> collection = database.getCollection(mongoCollectionName);
        Bson filter = Filters.eq("sid", id);
        Bson updates = Updates.combine(
                Updates.set("sname", name)
        );
        collection.updateOne(filter, updates);
        System.out.println("Updated employee");
    }

    public void mongoDbDelete(int id) {
        mongoClient = MongoClients.create(mongoUri);
        MongoDatabase database = mongoClient.getDatabase(mongoDbName);
        MongoCollection<Document> collection = database.getCollection(mongoCollectionName);
        Bson filter = Filters.eq("sid", id);
        collection.deleteOne(filter);
        System.out.println("Deleted employee");
    }


}
