package day10.readxmltoobject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.util.Scanner;

public class ReadObjDisplayXml {
    public static void main(String[] args) throws JsonProcessingException {
        Scanner sc = new Scanner(System.in);
        Detail detail = new Detail();
        Student student = new Student();
        System.out.print("Enter your Name: ");
        String name = sc.nextLine();
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        System.out.print("Enter you Details: ");
        String details = sc.nextLine();
        sc.next();
        System.out.print("Enter your id: ");
        int id = sc.nextInt();
        sc.nextLine();

        detail.setDetails(details);
        detail.setId(id);

        student.setName(name);
        student.setAge(age);
        student.setDetail(detail);

       try {
           XmlMapper mapper = new XmlMapper();
           mapper.setDefaultUseWrapper(false);
           String xml = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
           System.out.println(xml);
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
