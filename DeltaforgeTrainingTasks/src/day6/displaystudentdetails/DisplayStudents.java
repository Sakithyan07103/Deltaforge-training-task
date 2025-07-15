package day6.displaystudentdetails;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DisplayStudents {
    static Student sakithyan = new Student(101, "Sakithyan", 30);
    static Student shwetha = new Student(202, "Shwetha", 85);
    static Student snegha = new Student(303, "Snegha", 83);
    static Student rohini = new Student(404, "Rohini", 25);
    static Student sanjay = new Student(505, "Sanjay", 42);

    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println();

        displaySortedByNames();
        dispayPaasedStudents();
        displahyHighestLowestMarks();
        displayPassOrFail();
    }

    public static void displaySortedByNames() {
        students.add(snegha);
        students.add(shwetha);
        students.add(sakithyan);
        students.add(rohini);
        students.add(sanjay);

        students.sort(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getStudentName().compareTo(s2.getStudentName());
            }
        });

        for (Student stds : students) {
            System.out.println(stds + " ");
        }
        System.out.println();
    }

    public static void dispayPaasedStudents() {
        List<Student> passedStudents = students.stream().filter(n -> n.getStudentMarks() >= 40).toList();

        for (Student stds : passedStudents) {
            System.out.println(stds.getStudentName() + " passed with " + stds.getStudentMarks());
        }
        System.out.println();
    }

    public static void displahyHighestLowestMarks() {
        List<Student> sortedByMarks = new ArrayList<>(students);
        sortedByMarks.sort(Comparator.comparingInt(Student::getStudentMarks));

        System.out.println("Lowest scorer: " + sortedByMarks.getFirst());
        System.out.println("Highest Scorer: " + sortedByMarks.getLast());
        System.out.println();
    }

    public static void displayPassOrFail() {
        Map<Integer, String> passFailMap = students.stream()
                .collect(Collectors.toMap(
                        Student::getStudentId,
                        s -> s.getStudentMarks() >= 40 ? "Pass" : "Fail"
                ));

        System.out.println("Student marks Pass/Fail:");
        passFailMap.forEach((id, result) -> System.out.println("Student ID " + id + ": " + result));
        System.out.println();
    }

}
