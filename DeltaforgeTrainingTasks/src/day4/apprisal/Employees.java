package day4.apprisal;

public class Employees {

    private int empId;
    private String empName;
    private String empDesignation;
    private int empSalary;
    private int empRating;

    public Employees(int empId, String empName, String empDesignation, int empSalary, int empRating) {
        this.empId = empId;
        this.empName = empName;
        this.empDesignation = empDesignation;
        this.empSalary = empSalary;
        this.empRating = empRating;
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

    public int getEmpRating() {
        return empRating;
    }

    public void setEmpRating(int empRating) {
        this.empRating = empRating;
    }

    public  void getEmployeeDetail(Employees emp) {
        System.out.println("Employee Id: " + emp.getEmpId());
        System.out.println("Employee Name: " + emp.getEmpName());
        System.out.println("Employee Designation: " + emp.getEmpDesignation());
    }

    public  void getEmployeeDetail(Employees emp, String detailed) {
        if (detailed.contains("detailed")) {
            System.out.println("Employee Id: " + emp.getEmpId());
            System.out.println("Employee Name: " + emp.getEmpName());
            System.out.println("Employee Designation: " + emp.getEmpDesignation());
            System.out.println("Employee Salary: " + emp.getEmpSalary());
            System.out.println("Employee Rating: " + emp.getEmpRating());
        }
    }

    public void getEmployeeApprisal(Employees emp) {
        System.out.println("The apprisal for the employee is: " + emp.getEmpSalary() + " + hike");
    }
}
