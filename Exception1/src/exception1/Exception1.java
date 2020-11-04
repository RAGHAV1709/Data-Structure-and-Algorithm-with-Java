package exception1;
//Handle an exception and move on.
import java.util.Random;
public class Exception1 {
    public static void main(String[] args) {
        // TODO code application logic here
        int a=0, b = 0, c = 0,count=0,acount=0;
        Random r = new Random();
        for(int i = 0; i<32000; i++){
            try{
                b = r.nextInt();
                c = r.nextInt();
                a = 12345 / (b/c);
                count++;
            }catch(ArithmeticException e){
                System.out.println("Division by Zero.");
                a = 0; //set a to zero and continue
                acount++;
            }
            System.out.println("a: " + a);
        }
        System.out.println(count + " " + acount);
        
    }
    
}
