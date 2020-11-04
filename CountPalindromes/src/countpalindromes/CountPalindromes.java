package countpalindromes;

import java.util.ArrayList;
import java.util.Scanner;

public class CountPalindromes {
    public static boolean checkPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        return s.equals(sb);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int count = 0;
        ArrayList<String> list = new ArrayList<>();
        String time = "";
        String sec[] = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
        String min[] = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
        String hr[] = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
        for(int d=n1; d<=n2; d++){
            for(int i=0; i < hr.length; i++){
                for(int j = 0; j < min.length; j++){
                    for(int k = 0; k < sec.length; k++){
                        time += (d+hr[i]+min[j]+sec[k]);
                        if(checkPalindrome(time)){
                            count++;
                            list.add(time);
                        }
                    }
                }
            }
        }
        
        
    }
    
}
