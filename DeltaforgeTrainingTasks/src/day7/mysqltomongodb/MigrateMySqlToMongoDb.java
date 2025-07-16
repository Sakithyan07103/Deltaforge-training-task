package day7.mysqltomongodb;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.sql.*;
import java.util.Scanner;

public class MigrateMySqlToMongoDb {
    static Scanner sc = new Scanner(System.in);
    private static final String mysqlUrl = "jdbc:mysql://localhost:3306/sample";
    private static final String mysqlUser = "root";
    private static final String mysqlPass = "1234";

    private static final String mongoUri = "mongodb://localhost:27017";
    private static final String mongoDbName = "School";
    private static final String mongoCollectionName = "students";

    public static void main(String[] args) throws SQLException {
        System.out.println("Where do you want to perform operations?");
        System.out.println("1. MySQL");
        System.out.println("2. MongoDB");
        System.out.print("Press any number: ");
        int num = sc.nextInt();

        if (num == 1) {
            mySqlOperations();
        } else if (num == 2) {
            mongoDbOperations();
        }

        migrateStudents();
    }

    public static void mySqlOperations() throws SQLException {
        MySqlOperations mysql = new MySqlOperations();

        while (true) {
            System.out.println("==== List of operation you can do to the table ====");
            System.out.println(" 1. view all Students");
            System.out.println(" 2. View Student based on id ");
            System.out.println(" 3. Insert a student detail");
            System.out.println(" 4. update a student detail");
            System.out.println(" 5. delete a student detail");
            System.out.println(" 6. Exit");

            System.out.print("Press any number: ");
            int num = sc.nextInt();
            System.out.println();
            if (num == 1) {
                System.out.println("The list of employees are as follows:");
                mysql.mySqlReadAll();
            } else if (num == 2) {
                System.out.print("Enter the ID: ");
                int id = sc.nextInt();
                mysql.mySqlRead(id);
            } else if (num == 3) {
                System.out.print("Enter the ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter a name: ");
                String name = sc.nextLine();
                System.out.print("Enter a roll number: ");
                int roll = sc.nextInt();
                mysql.mySqlCreate(id, name, roll);
            } else if (num == 4) {
                System.out.print("Enter the ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter a name: ");
                String name = sc.nextLine();
                mysql.mySqlUpdate(name, id);
            } else if (num == 5) {
                System.out.print("Enter the ID: ");
                int id = sc.nextInt();
                mysql.mySqlDelete(id);
                break;
            } else if (num == 6) {
                System.out.println("Exiting. Thank you for using this application!");
                break;
            }

            System.out.println();
        }
    }

    public static void mongoDbOperations() {
        MongoDbOperations mongodb = new MongoDbOperations();

        while (true) {
            System.out.println("==== List of operation you can do to the file ====");
            System.out.println(" 1. view all Students");
            System.out.println(" 2. View Student based on id ");
            System.out.println(" 3. Insert a student detail");
            System.out.println(" 4. update a student detail");
            System.out.println(" 5. delete a student detail");
            System.out.println(" 6. Exit");

            System.out.print("Press any number: ");
            int num = sc.nextInt();

            if (num == 1) {
                System.out.println("The list of employees are as follows:");
                mongodb.mongoDbReadAll();
            } else if (num == 2) {
                System.out.print("Enter the ID: ");
                int id = sc.nextInt();
                mongodb.mongoDbRead(id);
            } else if (num == 3) {
                System.out.print("Enter the Id: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter a name: ");
                String name = sc.nextLine();
                System.out.print("Enter a roll number: ");
                int roll = sc.nextInt();
                mongodb.mongoDbCreate(id,name,roll);
            } else if (num == 4) {
                System.out.print("Enter the ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter a name: ");
                String name = sc.nextLine();
                mongodb.mongoDbUpdate(id,name);
            } else if (num == 5) {
                System.out.print("Enter the ID: ");
                int id = sc.nextInt();
                mongodb.mongoDbDelete(id);
            } else if (num == 6) {
                System.out.println("Exiting. Thank you for using this application!");
                break;
            }
            
            System.out.println();
        }
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
