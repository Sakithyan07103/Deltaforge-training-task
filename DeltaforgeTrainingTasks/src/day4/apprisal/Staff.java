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
public class Staff extends Employees{

    int hike;

    public Staff(int empId, @NotNull String empName, @NotNull String empDesignation, int empSalary, int empRating) {
        super(empId, empName, empDesignation, empSalary, empRating);
    }


    @Override
    public void getEmployeeApprisal(@NotNull Employees emp) {
        if (emp.getEmpRating() == 5) {
            hike = 10;
        } else if (emp.getEmpRating() > 2 && emp.getEmpRating() < 5) {
            hike = 15;
        } else if (emp.getEmpRating() > 0 && emp.getEmpRating() < 3) {
            hike = 20;
        }

        int apprisal = emp.getEmpSalary() + emp.getEmpSalary() * hike/100;
        System.out.println("Apprisal for staff employee is: " + apprisal);
    }

}
