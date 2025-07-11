package apprisal;

public class Manager extends Employees
{

    int hike;

    public Manager(int empId, String empName, String empDesignation, int empSalary , int empRating) {
        super(empId, empName, empDesignation, empSalary, empRating);
    }


    @Override
    public void getEmployeeApprisal(Employees emp){

        if (emp.getEmpRating() == 5) {
            hike = 20;
        } else if (emp.getEmpRating() > 2 && emp.getEmpRating() < 5) {
            hike = 25;
        } else if (emp.getEmpRating() > 0 && emp.getEmpRating() < 3) {
            hike = 30;
        }
        int apprisal = emp.getEmpSalary() + emp.getEmpSalary() * hike/100;

        System.out.println("Apprisal for Manager level employee is: " + emp.getEmpSalary()*(hike/100) + emp.getEmpSalary());
    }

}
