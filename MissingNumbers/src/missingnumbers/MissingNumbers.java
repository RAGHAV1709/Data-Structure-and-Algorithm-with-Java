/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missingnumbers;
import java.util.*;
/**
 *
 * @author ragha
 */
public class MissingNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        for(int i = 0; i < n; i++){
            if(a[i] != i+1){
                System.out.print((i+1)+" ");
            }
        }
    }
    
}
