package day10.readxmltoobject;

import org.json.simple.JSONObject;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import day10.readxmltoobject.constants.Constants;
import java.io.FileReader;
import java.io.FileWriter;

public class JsonFileToXmlFileConverter {
    public static void main(String[] args) throws IOException, ParseException {
        try {
            FileReader reader = new FileReader(Constants.day9JsonFile);
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            StringBuilder xmlBuilder = new StringBuilder();
            xmlBuilder.append("<root>\n");

            for (Object key : jsonObject.keySet()) {
                Object value = jsonObject.get(key);
                xmlBuilder.append("  <").append(key).append(">")
                        .append(value)
                        .append("</").append(key).append(">\n");
            }

            xmlBuilder.append("</root>\n");

            FileWriter writer = new FileWriter(Constants.outPutXmlFile);
            writer.write(xmlBuilder.toString());
            writer.close();

            System.out.println("XML output written to output.xml");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
