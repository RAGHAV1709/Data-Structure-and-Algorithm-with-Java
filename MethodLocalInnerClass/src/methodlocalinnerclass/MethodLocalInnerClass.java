package methodlocalinnerclass;
class Outer{
    void outerMethod(){
        System.out.println("Inside outerMethod.");
        class Inner{
            void innerMethod(){
                System.out.println("inside innerMethod.");
            }
        }
        Inner y = new Inner();
        y.innerMethod();
    }
}
public class MethodLocalInnerClass {

    public static void main(String[] args) {
        // TODO code application logic here
        Outer x = new Outer();
       
        x.outerMethod();
        
    }
    
}
