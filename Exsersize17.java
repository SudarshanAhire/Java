import java.util.*;

public class Exsersize17{

    public static void printCount(int n){
        int count = 0;
        if(n<0){
            count = count + 1;
            System.out.print(count);
        }else if(n>0){
            count = count + 1;
             System.out.print(count);
        }else{
            count = count + 1;
             System.out.print(count);
        }
        
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        for(int i=0; i<=100; i++){
             n = sc.nextInt();
             System.out.println("Number addded in "+n);
        }

        
        printCount(n);
    }
}

