package methodoverridingusingruntimepolymorphism;
//Using runtime polymorphism
class Figure{
    double dim1;
    double dim2;
    
    Figure(double a, double b){
        dim1=a;
        dim2=b;
        
    }
    double area(){
        System.out.println("Area for figure is undefined.");
        return 0;
    }
}
class Rectangle extends Figure{
    Rectangle(double a, double b){
        super(a, b);
    }
    //Override area for rectangle
    double area(){
        System.out.println("Inside Area for Rectangle.");
        return dim1*dim2;
    }
}
class Triangle extends Figure{
    Triangle(double a, double b){
        super(a,b);
    }
    //override area for right triangle
    double area(){
        System.out.println("Inside Area for Triangle.");
        return dim1*dim2 / 2;
    }
}
public class MethodOverridingUsingRuntimePolymorphism {
    public static void main(String[] args) {
        // TODO code application logic here
        Figure f = new Figure(10,10);
        Rectangle r = new Rectangle(9,5);
        Triangle t = new Triangle(10,8);
        Figure figuref;
        figuref=r;
        
        System.out.println("Area is "+figuref.area());
        
        figuref=t;
        System.out.println("Area is "+figuref.area());
        
        figuref=f;
        System.out.println("Area is "+figuref.area());
    }
    
}
