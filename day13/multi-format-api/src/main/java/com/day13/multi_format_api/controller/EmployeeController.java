package com.day13.multi_format_api.controller;

import com.day13.multi_format_api.constants.Constants;
import com.day13.multi_format_api.dto.Employee;
import com.day13.multi_format_api.service.EmployeeService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping("")
    public  Employee readJson() throws IOException, ParseException {
        return service.readJson(Constants.empJsonFile);
    }

    @PostMapping("/{id}/{name}/{age}")
    public FileWriter createFile(@PathVariable int id, @PathVariable String name, @PathVariable int age)
            throws IOException {
        return service.createFile(Constants.txtFileName, id, name, age);
    }

    @PutMapping("/{id}/{name}/{age}")
    public String updateXml(@PathVariable int id,@PathVariable String name,@PathVariable int age)
            throws IOException {
        Employee emp = new Employee();
        emp.setEmpId(id);
        emp.setEmpName(name);
        emp.setEmpAge(age);
        return service.updateXml(Constants.empXmlFile,emp);
    }
}
