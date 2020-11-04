package anonymousinnerclass;
/*Anonymous inner classes are declared without any name at all. They
are created in two ways.
* As subclass of specified type
* As implementer of the specified interface

We are going to create two class Demo and Main. Here demo act as super class 
and anonymous class acts as a subclass, both classes have a method show(). 
In anonymous class show() method is overriden.
*/

class Demo{
    void show(){
        System.out.println("I am in show method of super class");
    }
}
public class AnonymousInnerClass {
    static Demo d = new Demo(){
            void show(){
                super.show();
                System.out.println("I am in Main classs.");
            }
        };
    public static void main(String[] args) {
        // TODO code application logic here
        d.show();
    }
    
}
