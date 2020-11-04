
package arraylistmonthly1;
import java.util.*;
public class ArrayListMonthly1 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        int n = sc.nextInt();
        while(n>0){
            list.add(sc.next());
            n--;
        }
        
        String hall = sc.next();
        if(list.contains(hall) == true)
         System.out.println(list.indexOf(hall));
        else
            System.out.println(hall + " hall is not found");
    }
    
}
