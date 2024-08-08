import java.util.*;

// Print the sum of all the odd numbers from 1 to n 

public class Exsersize12{

    public static void printSum(int n){
        int sum = 0;
        for(int i=1; i<=n; i++){
            if(i%2!=0){
                System.out.println(i);
                sum = sum + i;
            }
        }
        System.out.print(sum);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printSum(n);
    }
}