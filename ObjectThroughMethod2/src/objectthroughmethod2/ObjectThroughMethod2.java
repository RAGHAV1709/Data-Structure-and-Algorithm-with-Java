package objectthroughmethod2;
class Company {
    String name;
    void changeRef(Company that){
        that.name = this.name;
        //that = null;
    }
}
public class ObjectThroughMethod2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Company c1 = new Company();
        c1.name = "Ethinus";
        Company c2 = new Company();
        c2.name = "Aptimithra";
        c1.changeRef(c2);
        System.out.println(c1.name);
        System.out.println(c2.name);
    }
    
}
