package aircraftmain;
class Aircraft{
    String aircraftName;
    String source;
    String destination;
    //Aircraft ob1 = new Aircraft(String aircraftName,String source,String destination);
    void displayDetails(){
        System.out.println("Aircraft Name: "+aircraftName);
        System.out.println("Source: "+ source);
        System.out.println("Destination: ");
    }
}
class PublicAircraft extends Aircraft{
    int noOfKgsallowed;
    float additionalFeeperkgs;
    //PublicAircraft ob1 = new Aircraft(String aircraftName,String source,String destination,int noOfKgsallowed,float additionalFeeperkgs);
    void displayDetails(){
        System.out.println("noOfKgsallowed: "+noOfKgsallowed);
        System.out.println("additionalFeeperkgs: "+ additionalFeeperkgs);
    }
}
class PrivateAircraft extends Aircraft{
    
}
public class AircraftMain {

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
