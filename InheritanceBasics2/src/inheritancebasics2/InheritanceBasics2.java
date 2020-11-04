package inheritancebasics2;
class A{
    int i;
    //private int j; private will lead to compilation error
    int j;
    void setij(int x, int y){
        i=x;
        j=y;
    }
    
}
class B extends A{
    int total;
    void sum(){
        total = i+j;
    }
}
public class InheritanceBasics2 {
    public static void main(String[] args) {
        // TODO code application logic here
        B subob =new B();
        subob.setij(10,12);
        subob.sum();
        System.out.println("Total is: " + subob.total);
    }
    
}
