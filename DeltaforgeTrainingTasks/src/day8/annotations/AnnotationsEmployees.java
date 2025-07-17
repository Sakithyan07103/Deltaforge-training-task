package day8.annotations;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnotationsEmployees {

    private int empId;
    @NotNull
    private String empName;
    @NotNull
    private String empDesignation;
    private int empSalary;
    private int empRating;

    public  void getEmployeeDetail(@NotNull AnnotationsEmployees emp) {
        System.out.println();
        System.out.println("Details of the Employee " + emp.empName + ":");
        System.out.println("Employee Id: " + emp.getEmpId());
        System.out.println("Employee Name: " + emp.getEmpName());
        System.out.println("Employee Designation: " + emp.getEmpDesignation());
    }

    public  void getEmployeeDetail(@NotNull AnnotationsEmployees emp, @Nullable String detailed) {
        if (detailed != null && detailed.contains("detailed")) {
            System.out.println();
            System.out.println("Details of the Employee " + emp.empName + ":");
            System.out.println("Employee Id: " + emp.getEmpId());
            System.out.println("Employee Name: " + emp.getEmpName());
            System.out.println("Employee Designation: " + emp.getEmpDesignation());
            System.out.println("Employee Salary: " + emp.getEmpSalary());
            System.out.println("Employee Rating: " + emp.getEmpRating());
        }
    }

    public void getEmployeeApprisal(@NotNull AnnotationsEmployees emp) {
        System.out.println("The apprisal for the employee is: " + emp.getEmpSalary() + " + hike");
    }
}