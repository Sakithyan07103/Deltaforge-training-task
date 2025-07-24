package com.day13.multi_format_api.service;

import com.day13.multi_format_api.dto.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class EmployeeService {

    Employee emp;

    public Employee readJson(String filename) throws IOException, ParseException {
        FileReader reader =new FileReader(filename);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        int empId = ((Long)jsonObject.get("empId")).intValue();
        String empName = jsonObject.get("empName").toString();
        int empAge = ((Long) jsonObject.get("empAge")).intValue();

        emp = new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        emp.setEmpAge(empAge);

        System.out.println("Details of Employee is: ");
        System.out.println("Id of the employee is: " + emp.getEmpId());
        System.out.println("Name of the employee is: " + emp.getEmpName());
        System.out.println("Age of the employee is: " + emp.getEmpAge());
        return emp;
    }

    public FileWriter createFile(String fileName, int id, String name, int age) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write("Id of the employe is: "+ id);
        writer.append("\nName of the Employee is: ").append(name);
        writer.append("\nAge of the Employee is: ").append(String.valueOf(age));
        writer.close();
        return writer;
    }

    public String updateXml(String filename, Employee emp) throws IOException {
        XmlMapper mapper = new XmlMapper();
        String xmlContent = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp));
        Files.write(Paths.get(filename), xmlContent.getBytes(StandardCharsets.UTF_8));
        return xmlContent;
    }

}
