package day10.readxmltoobject;

import org.json.simple.JSONObject;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;

public class JsonFileToXmlFileConverter {
    public static void main(String[] args) throws IOException, ParseException {
        try {
            // Read JSON file
            FileReader reader = new FileReader("day9.json");
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            // Convert to XML manually (basic version)
            StringBuilder xmlBuilder = new StringBuilder();
            xmlBuilder.append("<root>\n");
            for (Object key : jsonObject.keySet()) {
                Object value = jsonObject.get(key);
                xmlBuilder.append("  <").append(key).append(">")
                        .append(value)
                        .append("</").append(key).append(">\n");
            }
            xmlBuilder.append("</root>");

            // Write XML to file
            FileWriter writer = new FileWriter("output.xml");
            writer.write(xmlBuilder.toString());
            writer.close();

            System.out.println("XML output written to output.xml");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
