package innerclass3;
class Demo{
    void show(){
        System.out.println("I am in show method of super class");
    }
}
public class InnerClass3 {
    static Demo d = new Demo(){
            void show(){
                super.show();
                System.out.println("I am in Main class");
            }
        };
    public static void main(String[] args) {
        // TODO code application logic here
        d.show();
    }
    
}
