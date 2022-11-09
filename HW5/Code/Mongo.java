import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.*;
import java.sql.*;
import java.util.Iterator;
import org.bson.Document;

public class Mongo {

  public static void main(String[] args) throws Exception {
    MongoClient mongoClient = new MongoClient();
    MongoDatabase dbObj = mongoClient.getDatabase("test");
    for (String name : dbObj.listCollectionNames()) {
      System.out.println("Collections inside this db:" + name);
    }
    MongoCollection<Document> col = dbObj.getCollection("inventory");
    Iterator<Document> it = col.find().iterator();
    while (it.hasNext()) {
      System.out.println("docs inside the col:" + it.next());
    }

    dbObj.createCollection("newcolzero");
    // MongoCollection<Document> col = dbObj.getCollection("newcolzero");
    Document mydoc = new Document();
    mydoc.put("name", "johnzzzz");
    mydoc.put("role", "studentzzz");
    col.insertOne(mydoc);
    MongoCollection<Document> collection = dbObj.getCollection("newcolzero");
    collection.drop();
    BasicDBObject doc2remove = new BasicDBObject();
    doc2remove.put("name", "john");
    col.deleteMany(doc2remove);
  }
}
