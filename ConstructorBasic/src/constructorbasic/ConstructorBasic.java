package constructorbasic;
class Box{
    double width;
    double height;
    double depth;
    
    //This is the constructor for Box.
    Box(){
        System.out.println("Constructing Box");
        width = 10;
        height = 10;
        depth = 10;
    }
    // compute and return the value
    double volume(){
        return width*height*depth;
    }
}
public class ConstructorBasic {

    public static void main(String[] args) {
        // TODO code application logic here
        //declare, allocate, and initialize box objects
        Box mybox1 = new Box();
        Box mybox2 = new Box();
        
        double vol = mybox1.volume();
        System.out.println("Volume is "+vol);
        
        //get volume of second box
        vol = mybox2.volume();
        System.out.println("Volume is "+vol);
        
    }
    
}
