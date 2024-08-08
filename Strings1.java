import java.util.*;

public class Strings1{
    public static void main(String args[]){
        StringBuilder sb = new StringBuilder("Tony");
        System.out.println(sb);

        // char at 0 index
        System.out.println(sb.charAt(0));

        //replace char at specific position
        sb.setCharAt(0, 'p');
        System.out.println(sb);

        //insert chat at any insex position
        sb.insert(2, 'n');
        System.out.println(sb);

        // delete char at any specific position
        sb.delete(2, 4);
        System.out.println(sb);
 
        //append char at any specific position
        sb.append("Hello");
        System.out.println(sb);

        //Revers string in java
        for(int i=0; i<sb.length()/2; i++){
            int front = i;
            int back = sb.length() - 1 - i;

            char frontChar = sb.charAt(front);
            char backChar = sb.charAt(back);

            sb.setCharAt(front, backChar);
            sb.setCharAt(back, frontChar);
        }
        System.out.println(sb);
    }
}