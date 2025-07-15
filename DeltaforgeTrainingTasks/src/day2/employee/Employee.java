package day2.employee;

public class Employee {
    private int empId;
    private String empName;
    private String empEmail;
    private String empDesignation;

    public void setEmpId(int empId) {
       if (empId > 0 && empId < 10000){
           this.empId = empId;
       } else {
           throw new RuntimeException("Employee id should be more than 1 and less than 100000");
       }
    }
    public int getEmpId() {
        return empId;
    }

    public void setEmpName(String empName) {
        if (!empName.isEmpty()) {
            this.empName = empName;
        }
    }
    public String getEmpName() {
        return empName;
    }

    public void setEmpEmail(String empEmail) {
        if (empEmail.contains("@")){
            this.empEmail = empEmail;
        }else {
            throw new RuntimeException("mail id can't be written without @");
        }

    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpDesig(String empDesig) {
        this.empDesignation = empDesig;
    }

    public String getEmpDesig() {
        return empDesignation;
    }

    public String toString() {

        return  "ID: " + getEmpId() +
                " \nNAME: " + getEmpName() +
                " \nEMAIL: " + getEmpEmail() +
                " \nDEPT: " + getEmpDesig();
    }

}
