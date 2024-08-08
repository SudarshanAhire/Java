import java.util.*;

// Write a program which takes radius as a input and returns the circumference of circle.

public class Exsersize14{

    public static void printCircumference(int n){
        double Circumference;
        Circumference = (2 * 3.14 * n);
        System.out.print(Circumference);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printCircumference(n);
    }

}