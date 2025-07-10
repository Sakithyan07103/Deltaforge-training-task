package apprisal;

public class Employees {

    private int empId;
    private String empName;
    private String empDesignation;
    private int empSalary;

    public Employees(int empId, String empName, String empDesignation, int empSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empDesignation = empDesignation;
        this.empSalary = empSalary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }

    public  void getEmployeeDetail(Employees emp){
        System.out.println("Employee Id: " + emp.getEmpId());
        System.out.println("Employee Name: " + emp.getEmpName());
        System.out.println("Employee Designation: " + emp.getEmpDesignation());
        System.out.println("Employee Salary: " + emp.getEmpSalary());
    }

    public void getEmployeeApprisal(Employees emp){


        System.out.println("The apprisal for the employee is: " + emp.getEmpSalary() + " + hike");
    }






}
