package inheritancemorepracticalexample;
//This program uses inheritance to extend Box
class Box{
    double width;
    double heigth;
    double depth;
    
    //construct clone of an object
    Box(Box ob){//pass object to constructor
        width = ob.width;
        heigth = ob.heigth;
        depth = ob.depth;
    }
    //contructor used when all dimensions specified
    Box(double w, double h, double d){
        width = w;
        heigth = h;
        depth = d;
        
    }
    
    //contructor used when no dimension specified
    Box(){
        // use -1 to indicate an uninitialized box
        width = -1;
        heigth = -1;
        depth = -1;
        
    }
    //constructor used when cube is created
    Box(double len){
        width = heigth=depth=len;
    }
    //compute and return volume
    double volume(){
        return width*heigth*depth;
    }
}
//Here, Box is extended to include weight.
class BoxWeight extends Box{
    double weight; //weight of box
    BoxWeight(double w, double h, double d, double m){
        width = w;
        heigth = h;
        depth = d;
        weight = m;
    }
}
public class InheritanceMorePracticalExample {
    public static void main(String[] args) {
        // TODO code application logic here
        BoxWeight mybox1 = new BoxWeight(10, 20, 15, 34.3);
        BoxWeight mybox2 = new BoxWeight(2,3,4,0.076);
        double vol;
        
        vol = mybox1.volume();
        System.out.println("Volume of mybox1 is  "+ vol);
        System.out.println("Weigth of mybox1 is "+mybox1.weight);
        System.out.println();
        
        vol = mybox2.volume();
        System.out.println("Volume of mybox2 is " + vol);
        System.out.println("Weight of mybox2 is "+ mybox2.weight);
    }
    
    //Constructor for BoxWeigth
    
    
}
