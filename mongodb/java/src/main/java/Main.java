import java.sql.Timestamp;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class Main {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// init
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("argus");

		// Count
		DBCollection dbcollection = db.getCollection("notification.email");
		System.out.println(dbcollection.getCount());

		// Iterator
		DBCursor all = dbcollection.find();
		try {
			while (all.hasNext()) {
				System.out.println(all.next());
			}
		} finally {
			all.close();
		}

		DBObject filter = new BasicDBObject("_id", new ObjectId(
				"51467751d51adb62e990ed00"));
		DBObject update = new BasicDBObject("$set", new BasicDBObject().append(
				"sendTs", new Timestamp(System.currentTimeMillis())));

		DBCursor cursor = dbcollection.find(filter);
		while (cursor.hasNext()) {
			System.out.print(cursor.next());
		}
		WriteResult result = dbcollection.update(filter, update);
		System.out.println();
	}

}
