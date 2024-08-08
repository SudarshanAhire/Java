import java.util.*;

public class array{
  public static void main(String args[]){

    // int[] marks = new int[3];
    // marks[0] = 97;
    // marks[1] = 98;
    // marks[2] = 78;
    // System.out.println(marks[0]);
    // System.out.println(marks[1]);
    // System.out.println(marks[2]);

    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int numbers[] = new int[size];

    //input
    for(int i=0; i<size; i++){
        numbers[i] = sc.nextInt();
    }
    
    //output
    for(int i=0; i<size; i++){
        System.out.println("the values are "+ numbers[i]);
    }
  }
}