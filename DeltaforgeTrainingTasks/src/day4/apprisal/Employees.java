package day4.apprisal;


import com.mongodb.lang.Nullable;
import lombok.*;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"WeakerAcess","unused"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employees {

    private int empId;
    @NotNull
    private String empName;
    @NotNull
    private String empDesignation;
    private int empSalary;
    private int empRating;



    public  void getEmployeeDetail(@NotNull Employees emp) {
        System.out.println("Employee Id: " + emp.getEmpId());
        System.out.println("Employee Name: " + emp.getEmpName());
        System.out.println("Employee Designation: " + emp.getEmpDesignation());
    }

    public  void getEmployeeDetail(@NotNull Employees emp, @Nullable String detailed) {
        if (detailed != null && detailed.contains("detailed")) {
            System.out.println("Employee Id: " + emp.getEmpId());
            System.out.println("Employee Name: " + emp.getEmpName());
            System.out.println("Employee Designation: " + emp.getEmpDesignation());
            System.out.println("Employee Salary: " + emp.getEmpSalary());
            System.out.println("Employee Rating: " + emp.getEmpRating());
        }
    }

    public void getEmployeeApprisal(@NotNull Employees emp) {
        System.out.println("The apprisal for the employee is: " + emp.getEmpSalary() + " + hike");
    }
}