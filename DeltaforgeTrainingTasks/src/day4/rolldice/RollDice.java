package day4.rolldice;

import java.util.Scanner;

public class RollDice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String die;

        while(true){
            System.out.print("Enter start to roll a die: ");
            die = sc.nextLine();
            if(die.contains("start")){
                int random = (int)(Math.random() * 6) + 1;
                System.out.println(random);
            } else if(die.contains("exit")){
                System.out.println("no more rolling ");
                break;
            }
        }

    }
}
