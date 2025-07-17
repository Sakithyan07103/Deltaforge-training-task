package day8.annotations;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnnotationsStaff extends AnnotationsEmployees {

    int hike;

    public AnnotationsStaff(int empId, String empName, String empDesignation, int empSalary, int empRating) {
        super(empId, empName, empDesignation, empSalary, empRating);
    }

    @Override
    public void getEmployeeApprisal( AnnotationsEmployees emp) {
        if (emp.getEmpRating() == 5) {
            hike = 10;
        } else if (emp.getEmpRating() > 2 && emp.getEmpRating() < 5) {
            hike = 15;
        } else if (emp.getEmpRating() > 0 && emp.getEmpRating() < 3) {
            hike = 20;
        }

        int apprisal = emp.getEmpSalary() * hike/100 + emp.getEmpSalary();
        System.out.println("Apprisal for staff employee is: " + apprisal);
    }
}
