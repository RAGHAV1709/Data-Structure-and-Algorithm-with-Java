package methodlocalinnerclass2;
class Outer{
    void outerMethod(){
        int x=98;
        System.out.println("inside outerMethod");
        class Inner{
            int x=100;
            void innerMethod(){
                System.out.println("x= "+x);
            }
        }
        Inner y = new Inner();
        y.innerMethod();
    }
}
public class MethodLocalInnerClass2 {
    public static void main(String[] args) {
        // TODO code application logic here
        Outer x = new Outer();
        x.outerMethod();    }
    
}
