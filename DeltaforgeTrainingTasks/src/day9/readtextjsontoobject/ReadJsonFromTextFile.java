package day9.readtextjsontoobject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ReadJsonFromTextFile {
    public static void main(String[] args) {
        try {
            File file = new File("student.txt"); // Ensure this file exists and contains valid JSON

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(file);

            System.out.println("JSON Content:");
            System.out.println(root.toPrettyString());

            Student student = mapper.treeToValue(root, Student.class);

            System.out.println("\nParsed from file:");
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Detail1: " + student.getDetail().getDetail1());
            System.out.println("ID: " + student.getDetail().getId());

        } catch (Exception e) {
            System.out.println("Error reading or parsing file: " + e.getMessage());
        }
    }

    public static void sample(){

    }
}
