package lastindex;
class Outer{
    void outerMethod(){
        int x=98;
        class Inner{
            void innerMethod(){
                int x=100;
                System.out.println("X: "+ x);
            }
        }
        Inner in = new Inner();
        in.innerMethod();
    }
}
public class LastIndex {

    public static void main(String[] args) {
        Outer x = new Outer();
        x.outerMethod();
    }
    
}
