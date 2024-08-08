import java.util.*;

// Problem 1
// Enter the 3 numbers from user and print the avarage using functions 

public class Exsersize1{

    public static void printAvarage(int a, int b, int c){
        int Avarage ;
        Avarage = (a+b+c)/3;

        System.out.print("The avarage is "+Avarage);
        return;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        printAvarage(a,b,c);
    }
}