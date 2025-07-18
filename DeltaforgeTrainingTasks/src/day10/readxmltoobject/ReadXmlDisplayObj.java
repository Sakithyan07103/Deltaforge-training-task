package day10.readxmltoobject;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ReadXmlDisplayObj {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        File file = new File("Students.xml");

        XmlMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Student std = mapper.readValue(file, Student.class);
        System.out.println("\nParsed from file:");
        System.out.println("Name: " + std.getName());
        System.out.println("Age: " + std.getAge());
        System.out.println("Details: " + std.getDetail().getDetails());
        System.out.println("ID: " + std.getDetail().getId());



    }
}
