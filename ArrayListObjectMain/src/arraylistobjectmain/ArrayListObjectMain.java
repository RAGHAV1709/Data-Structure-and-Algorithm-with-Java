package arraylistobjectmain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class ItemType{
    private String name;
    private String dep,cpd;
    public void setname(String n){
        this.name=n;
    }
    public void setdep(String d){
        this.dep=d+".0";
    }
    public void setcpd(String d){
        this.cpd=d+".0";
    }
    public String getname(){
        return name;
    }
    public String getdep(){
        return dep;
    }
    public String getcpd(){
        return cpd;
    }
    public String toString(String name, String dep){
        return String.format(name + "%-20s%-20s%-20s"+dep+".0%-20s%-20s%-20s"+cpd+".0");
    }
    @Override 
    public String toString(){
        return String.format("%-20s%-20s%-20s",name,dep,cpd);
    }
}
public class ArrayListObjectMain {


    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<String> name = new ArrayList<String>();
        int t = sc.nextInt();
        sc.nextLine();
        System.out.printf("%-20s%-20s%-20s\n","Name","Deposit","Cost Per Day");
        for(int i=0; i<t; i++){
            ItemType st = new ItemType();
            st.setname(sc.nextLine());
            st.setdep(sc.nextLine());
            st.setcpd(sc.nextLine());
            System.out.println(st);
        }
    }
    
}
