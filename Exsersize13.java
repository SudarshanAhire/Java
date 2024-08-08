import java.util.*;

// Write a function which takes two numbers and returns the greater of those two.


public class Exsersize13{

    public static void printGreater(int a, int b){
    if(a>b){
        System.out.print(a);
    }else{
        System.out.print(b);
    }
}

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        printGreater(a, b);

    }
}