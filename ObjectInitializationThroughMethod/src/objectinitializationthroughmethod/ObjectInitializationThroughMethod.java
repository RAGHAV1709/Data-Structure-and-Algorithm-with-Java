package objectinitializationthroughmethod;
class Student{
    int rollno;
    String name;
    void insertRecord(int r, String n){
        rollno = r;
        name = n;
    }
    void displayInformation(){
        System.out.println(rollno+" "+name);
    }
    
}
public class ObjectInitializationThroughMethod {

    public static void main(String[] args) {
        // TODO code application logic here
        Student s1 = new Student();
        Student s2 = new Student();
        s1.insertRecord(100, "Mukund");
        s2.insertRecord(101, "Badri");
        s1.displayInformation();
        s2.displayInformation();
    }
    
}
