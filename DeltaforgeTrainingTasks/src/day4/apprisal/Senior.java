package day4.apprisal;

public class Senior extends Employees{

    int hike;

    public Senior(int empId, String empName, String empDesignation, int empSalary, int empRating) {
        super(empId, empName, empDesignation, empSalary, empRating);
    }

    @Override
    public void getEmployeeApprisal(Employees emp){
        if (emp.getEmpRating() == 5) {
            hike = 15;
        } else if (emp.getEmpRating() > 2 && emp.getEmpRating() < 5) {
            hike = 20;
        } else if (emp.getEmpRating() > 0 && emp.getEmpRating() < 3) {
            hike = 25;
        }

        int apprisal = emp.getEmpSalary() + emp.getEmpSalary() * hike/100;

        System.out.println("Apprisal for senior employee is: " + emp.getEmpSalary()*(hike/100) + emp.getEmpSalary());
    }

}
