import java.util.*;

public class Functions1{
    
    // public static void printMyName(String name){
    //     System.out.print(name);
    //     return;
    // }
    
    public static void factorial(int n){
        int factorial = 1;

        for(int i=n; i>=1; i--){
            factorial = factorial * i;
        }

        System.out.print(factorial);
        return;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // String name = sc.next();
        int n = sc.nextInt();

        // printMyName(name);
        factorial(n);
    }
}