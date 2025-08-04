package com.day19.Student_Marks_Portal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stdId;

    @Column(name = "student_name")
    private String stdName;

    @Column(name = "student_roll_number")
    private int stdRoll;
}
