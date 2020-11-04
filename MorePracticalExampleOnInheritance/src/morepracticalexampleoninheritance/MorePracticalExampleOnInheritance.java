package morepracticalexampleoninheritance;
class Box{
    double length;
    double width;
    double height;
    Box(double length, double width, double height){
        this.length=length;
        this.width=width;
        this.height=height;
    }
    Box(Box o){
        this.length=o.length;
        this.width=o.width;
        this.height=o.height;
        
    }
    Box(){
        length=-1;
        width=-1;
        height=-1;
    }
    Box(double len){
        length=width=height=len;
    }
    double volume(){
        return length*width*height;
    }
}
class BoxWeight extends Box{
    double weight;
    BoxWeight(double length, double width, double height,double weight){
        this.length=length;
        this.width=width;
        this.height=height;
        this.weight=weight;
    }
}
public class MorePracticalExampleOnInheritance {

    public static void main(String[] args) {
        // TODO code application logic here
        BoxWeight ob1 = new BoxWeight(12,13,34,35);
        BoxWeight ob2 = new BoxWeight(3,4,5,6);
        double vol;
        vol=ob1.volume();
        System.out.println("The volume of ob1: "+vol);
        System.out.println("weight of ob1: "+ob1.weight);
        System.out.println();
        
        vol=ob2.volume();
        System.out.println("The volume of ob2 : "+vol);
        System.out.println("Weight of ob2: "+ob2.weight);
        
        //A Superclass variable can reference a subclass object
        Box plainbox = new Box();
        
        //Assigning BoxWeight reference to Box reference
        plainbox=ob2;
        vol=plainbox.volume();
        System.out.println("After Assigning reference of BoxWeight reference to Plainbox, vol: "+vol);
        System.out.println("weight of plainbox: "+ plainbox.weight);
        
        
    }
    
}
