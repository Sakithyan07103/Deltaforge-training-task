package day7.mysqltomongodb;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.sql.*;

public class MigrateMySqlToMongoDb {
    private static final String mysqlUrl = "jdbc:mysql://localhost:3306/sample";
    private static final String mysqlUser = "root";
    private static final String mysqlPass = "1234";

    private static final String mongoUri = "mongodb://localhost:27017";
    private static final String mongoDbName = "School";
    private static final String mongoCollectionName = "students";

    public static void main(String[] args) throws SQLException {
        migrateStudents();
    }

    public static void migrateStudents() {
        try (
                Connection mysqlConn = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPass);
                MongoClient mongoClient = MongoClients.create(mongoUri)
        ) {
            String query = "select sid, sname, sroll from students";
            Statement stmt = mysqlConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            MongoDatabase mongoDatabase = mongoClient.getDatabase(mongoDbName);
            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(mongoCollectionName);

            int count = 0;
            while (rs.next()) {
                Document doc = new Document("sid", rs.getInt("sid"))
                        .append("sname", rs.getString("sname"))
                        .append("sroll", rs.getInt("sroll"));
                mongoCollection.insertOne(doc);
                count++;
            }

            System.out.println("Migration has been completed! " + count + " records have been migrated from MySQL to MongoDB.");

        } catch (SQLException e) {
            System.out.println(" ERROR_MYSQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" ERROR_MONGODB: " + e.getMessage());
        }
    }
}
