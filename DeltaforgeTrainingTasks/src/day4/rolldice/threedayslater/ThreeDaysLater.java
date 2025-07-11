package day4.rolldice.threedayslater;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class ThreeDaysLater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a day: ");
        int day = sc.nextInt();
        System.out.print("Enter a month: ");
        int month = sc.nextInt();
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        DateFormat formate = new SimpleDateFormat("dd MM yyyy");
        LocalDate date = LocalDate.of(year, month, day);
        LocalDate newDate = date.plusDays(3);

        System.out.println("After 3 days the date will be: " + newDate);
    }
}
