package pascalstriangle;

import java.util.Scanner;

public class PascalsTriangle {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

//        System.out.println(factorial(4));
//        System.out.println(pascalsCombination(4,3));

        pascalsTriangle();
        reversePascalsTraingle();
        //findElement(8,5);

    }
    public static int factorial(int n){
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int pascalsCombination(int n , int r){
        return factorial(n) / (factorial(r) * factorial(n-r));
    }

    public static void pascalsTriangle() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = sc.nextInt();
        System.out.print("Pascal's triangle:- ");
        System.out.println();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(" " + pascalsCombination(i, k));
            }
            System.out.println();
        }
    }

    public static void findElement(int row, int column){


        int numerator = factorial(row - 1);
        int denominator = factorial(column - 1) * factorial(row - column);
        int element = numerator/denominator;

        System.out.println("The element at row " + row +" and column " + column +" is: " +element + " ");

    }

    public static void reversePascalsTraingle() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = sc.nextInt();
        System.out.print("Reverse pascals's traingle:- ");
        System.out.println();

        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < row - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(" " + pascalsCombination(i, k) );
            }
            System.out.println();
        }
    }
}
