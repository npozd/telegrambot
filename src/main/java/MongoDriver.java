import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.mongodb.client.model.Filters.regex;

public class MongoDriver {

    public static String findMatchesInDb(String message) {

        MongoClientURI clientURI = new MongoClientURI("mongodb+srv://npozd:mongoQwerty123@cluster0-mul8q.mongodb.net/test?retryWrites=true");
        MongoClient mongoClient = new MongoClient(clientURI);
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("exnesscars");

        String regex = "[0-9]{3}";
        String matchedMessage = null;
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(message);
        Boolean findResult = matcher.find();

        if (findResult) {
            matchedMessage = matcher.group();
        }
        else matchedMessage = message;

        try {
            Document myDoc = collection.find(regex("car_number", "[a-zA-Z]{3}" + matchedMessage)).first();
            mongoClient.close();
            return myDoc.get("name").toString() + " " + myDoc.get("car_number").toString();
        } catch (NullPointerException e) {
            System.err.println("Caught NullPointerException(Message " + message + ")");
            mongoClient.close();
            return "Нет такого номера";
        }
    }
}
