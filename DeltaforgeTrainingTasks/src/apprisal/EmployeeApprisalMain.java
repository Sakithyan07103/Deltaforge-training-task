package apprisal;

public class EmployeeApprisalMain {
    public static void main(String[] args) {


        Employees saki = new Staff(1,"sakithyan","junior",10000);
        Employees rohini = new Senior(2,"Rohini" , "senior" , 30000);



        saki.getEmployeeDetail(saki);
        saki.getEmployeeApprisal(saki);
        rohini.getEmployeeDetail(rohini);
        rohini.getEmployeeApprisal(rohini);






    }
}
