package day4.apprisal;

import lombok.*;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("Unused")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class Senior extends Employees{

    int hike;

    public Senior(int empId, @NotNull String empName, @NotNull String empDesignation, int empSalary, int empRating) {
        super(empId, empName, empDesignation, empSalary, empRating);
    }

    @Override
    public void getEmployeeApprisal(@NotNull Employees emp){
        if (emp.getEmpRating() == 5) {
            hike = 15;
        } else if (emp.getEmpRating() > 2 && emp.getEmpRating() < 5) {
            hike = 20;
        } else if (emp.getEmpRating() > 0 && emp.getEmpRating() < 3) {
            hike = 25;
        }

        int apprisal = emp.getEmpSalary() + emp.getEmpSalary() * hike/100;
        System.out.println("Apprisal for senior employee is: " + apprisal);
    }

}
