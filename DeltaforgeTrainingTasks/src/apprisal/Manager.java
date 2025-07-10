package apprisal;

public class Manager extends Employees
{

    int hike  = 20;

    public Manager(int empId, String empName, String empDesignation, int empSalary) {
        super(empId, empName, empDesignation, empSalary);
    }

    @Override
    public void getEmployeeDetail(Employees emp){
        System.out.println("Employee Id: " + emp.getEmpId());
        System.out.println("Employee Name: " + emp.getEmpName());
        System.out.println("Employee Designation: " + emp.getEmpDesignation());
        System.out.println("Employee Salary: " + emp.getEmpSalary());
    }

    @Override
    public void getEmployeeApprisal(Employees emp){
        int apprisal = emp.getEmpSalary() + emp.getEmpSalary() * hike/100;

        System.out.println("Apprisal for Manager level employee is: " + emp.getEmpSalary()*(hike/100) + emp.getEmpSalary());
    }

}
