package day4.apprisal;

public class EmployeeApprisalMain {

    public static void main(String[] args) {
        Employees saki = new Staff(1, "sakithyan", "junior", 10000, 2);
        Employees rohini = new Senior(2, "Rohini", "senior", 30000,5);
        Employees prasad = new Manager(3, "Prasad", "Manager",100000, 3);

        saki.getEmployeeDetail(saki, "detailed");
        saki.getEmployeeApprisal(saki);
        System.out.println("\n");
        rohini.getEmployeeDetail(rohini);
        rohini.getEmployeeApprisal(rohini);

    }

    public static void getAllEmployeeDetail(){
        Employees saki = new Staff(1,"sakithyan","junior",10000,2);
        Employees rohini = new Senior(2,"Rohini" , "senior" , 30000,5);
        Employees prasad = new Manager(3, "Prasad", "Manager" , 100000, 3);
        Employees[] emp = {saki,rohini,prasad};

        getAllEmployeeDetail();

        for (Employees employees : emp) {
            System.out.println(employees.toString() + "\n");
        }
    }
}
