public class spiral{
     public static  void gufu(int arr[][]){

    int startrow=0;
    int endrow=arr.length-1;
    int startcol=0;
    int endcol=arr.length-1;

    while(startrow<endrow && startcol<endcol){


        for(int i=startcol ; i<=endcol ; i++ ){
            System.out.print(arr[startrow][i]+ " ");
        }

        for(int j=startrow+1 ; j<=endrow ; j++){
            System.out.print(arr[j][endcol] + " ");
        }

        for(int i=endcol-1 ; i>=startcol ; i--){
            System.out.print(arr[endrow][i]+ " ");
        }

        for(int j=endrow-1 ; j>=startrow+1 ; j--){
            System.out.print(arr[j][startcol]+ " ");
        }

       // System.out.println();
       

        startcol++;
        startrow++;
        endcol--;
        endrow--;
    } 



     }
     public static void main(String[] args){

        int arr[][]={{ 1 , 2 , 3 ,4 },
                     { 5 ,6 , 7 ,8  },
                      {9 , 10 , 11 ,12},
                      {13 , 14 ,14 ,15}};
                    gufu(arr);
     }
}