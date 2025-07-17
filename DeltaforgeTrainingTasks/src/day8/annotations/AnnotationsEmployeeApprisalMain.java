package day8.annotations;

public class AnnotationsEmployeeApprisalMain {

    public static void main(String[] args) {
        AnnotationsEmployees saki = new AnnotationsStaff(1, "sakithyan", "junior", 10000, 2);
        AnnotationsEmployees rohini = new AnnotationsSenior(2, "Rohini", "senior", 30000,5);
        AnnotationsEmployees prasad = new AnnotationsManager(3, "Prasad", "Manager",100000, 3);

        saki.getEmployeeDetail(saki, "detailed");
        saki.getEmployeeApprisal(saki);
        System.out.println("\n");
        rohini.getEmployeeDetail(rohini);
        rohini.getEmployeeApprisal(rohini);

    }


}
