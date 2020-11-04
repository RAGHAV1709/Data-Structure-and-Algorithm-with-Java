package anagramdifferentapproach;

import java.util.Scanner;

public class AnagramDifferentApproach {
    static boolean isAnagram(String a, String b) {
        // Complete the function
        String c=a.toLowerCase();
        String d=b.toLowerCase();
        
    // To store the xor value  
    int value = 0;  
  
    for (int i = 0; i < c.length(); i++)  
    {  
        value = value ^ (int) c.charAt(i); 
        System.out.println("Value1:"+value);
        value = value ^ (int) d.charAt(i); 
        System.out.println("Value2: "+ value);
    }  
  
    return value == 0;
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        
        //String b = scan.next();
        //scan.close();
        //boolean ret = isAnagram(a, b);
        //System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
        
    }
    
}
