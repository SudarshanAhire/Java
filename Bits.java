import java.util.*;

public class Bits{
    public static void main(String args[]){
        int n = 5;
        int pos = 2;
        int BitMask = 1<<pos;
        int NotBitMask = ~(BitMask);

       // set bit operation
        if((BitMask & n) == 0){
            System.out.println("Bit was zero");
        }else{
            System.out.println("Bit was one");
        }
        
        // get bit operation
        int newNumber = BitMask | n;
        System.out.println(newNumber);
   
        int Number = NotBitMask & n;
        System.out.println(Number);

        

    }
}