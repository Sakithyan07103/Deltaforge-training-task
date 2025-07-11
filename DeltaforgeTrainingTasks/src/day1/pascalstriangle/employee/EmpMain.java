package day1.pascalstriangle.employee;

import java.util.Scanner;

public class EmpMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee emp = new Employee();

        System.out.print("Enter Employee Id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee name: ");
        String name = sc.nextLine();
        System.out.print("Enter Employee Email: ");
        String mail = sc.nextLine();

        System.out.print("Enter Employee Desig: ");
        String desig = sc.nextLine();

        emp.setEmpId(id);
        emp.setEmpName(name);
        emp.setEmpEmail(mail);
        emp.setEmpDesig(desig);

        System.out.println(emp);

    }
}
