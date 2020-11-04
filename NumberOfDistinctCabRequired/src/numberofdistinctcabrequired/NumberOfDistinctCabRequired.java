package numberofdistinctcabrequired;
import java.util.*;
public class NumberOfDistinctCabRequired {

    public static void main(String[] args) {
        // TODO code application logic here
        int[] a = new int[6];
        
        int count1 = 0;
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 6; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < 6; i++){
            int count = 1;
            for(int j = 0; j < 6; j++){
                if(a[i] == a[j]){
                    count++;
                }
            }
            if(count > 1){
                count1 += count;
            }
        }
        System.out.println(count1);
        
    }
    
}
