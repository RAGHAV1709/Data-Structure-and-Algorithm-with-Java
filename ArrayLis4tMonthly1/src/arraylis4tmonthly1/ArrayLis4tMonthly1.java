package arraylis4tmonthly1;

import java.util.*;

public class ArrayLis4tMonthly1 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> checker = new ArrayList<String>();
        int n = sc.nextInt();
        int a = n;
        while(n>0){
            names.add(sc.next());
            n--;
        }
        while(a>0){
            checker.add(sc.next());
            a--;
        }
        if(names.equals(checker))
            System.out.println("Both lists are same");
        else
            System.out.println("Both lists are different");
        
        
    }
    
}
