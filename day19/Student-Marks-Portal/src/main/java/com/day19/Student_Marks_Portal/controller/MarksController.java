package com.day19.Student_Marks_Portal.controller;

import com.day19.Student_Marks_Portal.dto.MarksDTO;
import com.day19.Student_Marks_Portal.model.Marks;
import com.day19.Student_Marks_Portal.service.impls.MarkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark")
public class MarksController {
    @Autowired
    MarkServiceImpl markService;

    @PostMapping("")
    public Marks createMarks(@RequestBody MarksDTO marksDTO) {
        return markService.createMarks(marksDTO);
    }
    
    @GetMapping("")
    public List<Marks> getAllMarks() {
        return markService.getAllMarks();
    }

    @GetMapping("/{id}")
    public Marks getMarksById(@PathVariable int id) {
        return markService.getMarksById(id);
    }

    @PutMapping("")
    public Marks updateMarks(@RequestBody MarksDTO marksDTO) {
        return markService.updateMarks(marksDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable int id) {
        return markService.deleteMarks(id);
    }
}
