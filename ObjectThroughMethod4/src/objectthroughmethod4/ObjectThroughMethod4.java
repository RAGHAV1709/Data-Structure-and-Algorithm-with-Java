package objectthroughmethod4;
class Company{
    String name;
    void changeRef(Company that, Company someCompany){
        someCompany = that;
        someCompany.name = this.name;
        that = someCompany;
    }

}
public class ObjectThroughMethod4 {

    public static void main(String[] args) {
        // TODO code application logic here
        Company c1 = new Company();
        c1.name = "Ethinus";
        Company c2 = new Company();
        c2.name="Aptimithra";
        c1.changeRef(c2, c1);
        System.out.println(c1.name);
        System.out.println(c2.name);
    }
    
    
}
