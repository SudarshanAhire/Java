import java.util.*;

// Write a function which takes age as a input and return the person was eligible to vote or not. A person has age > 18 is eligible to vote.

public class Exsersize15{

    public static void printVote(int age){
        if(age<18){
            System.out.print(" You are not eligible for vote ");
        }else{
            System.out.print(" You are eligible for vote ");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        printVote(age);
    }
}