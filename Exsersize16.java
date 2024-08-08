import java.util.*;

//Write a infinite loop for using do while condition.

public class Exsersize16{

    public static void printLoop(int n){
        int i = 0;
        do{
            System.out.println(i);
            i++;
        }while(i<n);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printLoop(n);
    }
}