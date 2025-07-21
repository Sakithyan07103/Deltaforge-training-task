package day8.annotations;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnnotationsSenior extends AnnotationsEmployees {
    int hike;

    public AnnotationsSenior(int empId, String empName, String empDesignation, int empSalary, int empRating) {
        super(empId, empName, empDesignation, empSalary, empRating);
    }

    @Override
    public void getEmployeeApprisal( AnnotationsEmployees emp){
        if (emp.getEmpRating() == 5) {
            hike = 15;
        } else if (emp.getEmpRating() > 2 && emp.getEmpRating() < 5) {
            hike = 20;
        } else if (emp.getEmpRating() > 0 && emp.getEmpRating() < 3) {
            hike = 25;
        }

        int apprisal = emp.getEmpSalary() * hike/100 + emp.getEmpSalary();
        System.out.println("Apprisal for senior employee is: " + apprisal);
    }
}
