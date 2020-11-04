package complexnum;
import java.util.*;
class ComplexNumbers {
	// Complete this class
    private int real;
    private int imaginary;
    int rr;
    int ri;
    ComplexNumbers(int real, int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    public void plus(ComplexNumbers c){
        rr = this.real + c.real;
        ri = this.imaginary +c.imaginary;
    }
    public void multiply(ComplexNumbers c){
        
        rr = (this.real * c.real) - (this.imaginary*c.imaginary);
        ri = ((this.real * c.imaginary + this.imaginary * c.real)); 
        
    }
    public void print(){
        if(ri > 0){
            System.out.println(rr + " + " + "i"+ri);
        }
        else if(this.imaginary == 0){
            System.out.println(rr);
        }
        else if(ri<0){
            int k = ri *(-1);
            System.out.println(rr + "-"+ "i"+k);
        }
            
    }
}
public class ComplexNum {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);

		int real1 = s.nextInt();
		int imaginary1 = s.nextInt();

		int real2 = s.nextInt();
		int imaginary2 = s.nextInt();

		ComplexNumbers c1 = new ComplexNumbers(real1, imaginary1);
		ComplexNumbers c2 = new ComplexNumbers(real2, imaginary2);
                boolean flag = true;
                while(flag){
                    int choice = s.nextInt();
		 
                    if(choice == 1) {
			// Add
			c1.plus(c2);
			c1.print();
                    }
                    else if(choice == 2) {
			// Multiply
			c1.multiply(c2);
			c1.print();
                    }
                    else if(choice == 3){
                        flag = false;
                    }
                    
                }
		
    }
    
}
