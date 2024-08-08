import java.util.*;

public class BitUpdate{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int oper = sc.nextInt();
        int n = 5;
        int pos = 1;

        int bitMask = 1<<pos;
        if(oper == 1){
            int NewNumber = bitMask | n;
            System.out.println(NewNumber);
        }else{
            int NewBitMask = ~(bitMask);
            int NewNumber = NewBitMask & n;
            System.out.println(NewNumber);
        }
    }
}