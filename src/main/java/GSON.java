import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GSON {

    public static void main(String[] args) throws FileNotFoundException {
        matchDataFile("NAK773");

    }


    public static String matchDataFile (String message) throws FileNotFoundException{
//        String path = "/Users/npozd/IdeaProjects/telegrambots/src/main/resources/cars.json";
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
//
//        Gson gson = new Gson();
//        List<JsonStructure.Person> json = (List<JsonStructure.Person>) gson.fromJson(bufferedReader, JsonStructure.class);
////##########
//        String regex = "[0-9]{3}";
//        String matchedMessage = null;
//        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
//        Matcher matcher = pattern.matcher(message);
//        Boolean findResult = matcher.find();
//
//        if (findResult) {
//            matchedMessage = matcher.group();
//        }
//        else matchedMessage = message;
//##########

        return null;
    }
}