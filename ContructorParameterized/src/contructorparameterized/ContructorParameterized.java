package contructorparameterized;
class Box{
    double width;
    double height;
    double depth;
    
    //This is the constructor for Box
    Box(double w, double h, double d){
        width = w;
        height = h;
        depth = d;
    }
    //compute and return volume
    double volume(){
        return width*height*depth;
    }
}
public class ContructorParameterized {
    public static void main(String[] args) {
        // TODO code application logic here
        Box mybox1 = new Box(10,20,15);
        Box mybox2 = new Box(3,6,9);
        double vol;
        
        //get volume of first box
        vol = mybox1.volume();
        System.out.println("Volume of first box is : "+vol);
        
        //get vol of second box
        vol = mybox2.volume();
        System.out.println("The volume of second box: "+vol);
    }
    
}
