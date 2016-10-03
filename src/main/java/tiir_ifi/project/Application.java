package tiir_ifi.project;

import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		try {
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			DB db = mongo.getDB("chatdb");
			DBCollection table = db.getCollection("log");
			BasicDBObject document = new BasicDBObject();
			document.put("pseudo","azuro");
			document.put("message", "salut");
			table.insert(document);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
