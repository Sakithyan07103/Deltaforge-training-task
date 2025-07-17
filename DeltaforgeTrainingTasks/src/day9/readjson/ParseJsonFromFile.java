package day9.readjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;

public class ParseJsonFromFile {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = ParseJsonFromFile.class.getClassLoader().getResourceAsStream("day9.json");
            if (is == null) {
                throw new RuntimeException("day9 json file not exist");
            }
            Student student = mapper.readValue(is, Student.class);

            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Detail1: " + student.getDetail().getDetail1());
            System.out.println("ID: " + student.getDetail().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
