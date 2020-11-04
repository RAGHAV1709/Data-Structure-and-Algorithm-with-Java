package minimumwatertoberemoved;

import java.util.Scanner;

public class MinimumWaterToBeRemoved {
    public static int waterToRemoved(int a[],int n){
        int prev = 0;
        int removed = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            int temp1 = 0, temp2 = 0;
            prev += a[i];
            for(int j = i+1; j < n; j++){
                temp1 += (a[j] - a[i]);
            }
            for(int j = i + 1; j < n; j++){
                temp2 += (a[j] - a[i]) + a[i];
            }
            if(temp1 < removed || temp2 < removed){
                System.out.println("temp1: "+ temp1);
                System.out.println("temp2: "+ temp2);
                if(temp1 < temp2){
                    removed = temp1;
                }
                else{
                    removed = temp2;
                }
            }
        }
        return removed;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = s.nextInt();
        }
        System.out.println(waterToRemoved(a, a.length));
    }
    
}
