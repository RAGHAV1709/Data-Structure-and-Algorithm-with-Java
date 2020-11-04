package args1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Main implements Comparable<Main> {
    public int compareTo(Main m){
        if(avg==m.getAvg()){
            return 0;
        }
        else if(avg>m.getAvg()){
            return 1;
        }
        return -1;
    }
    private int rrno;
    private  int mark1;
    private int mark2;
    private int mark3;
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private double avg;
    public int getRrno() {
        return rrno;
    }
    public void setRrno(int rrno) {
        this.rrno = rrno;
    }
    public int getMark1() {
        return mark1;
    }
    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }
    public int getMark2() {
        return mark2;
    }
    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }
    public int getMark3() {
        return mark3;
    }
    public void setMark3(int mark3) {
        this.mark3 = mark3;
    }
    public double getAvg() {
        return avg;
    }
    public void setAvg(double avg) {
        this.avg = avg;
    }
    public Main(int rrno, int mark1, int mark2, int mark3, String name) {
        this.rrno = rrno;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.name = name;
    }
    @Override
    public String toString() {
        return String.format(("%-20s%-20s%-20s"),rrno,name,avg);
    }
    public void avergae(){
        int m=(mark1+mark2+mark3)/ 3;
        avg=m;
    }
}
public class Args1 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        ArrayList<Main> aa=new ArrayList<>();
        while (a>0){
            int b=sc.nextInt();
            sc.nextLine();
            String k=sc.nextLine();
            int m1=sc.nextInt();
            int m2=sc.nextInt();
            int m3=sc.nextInt();
            aa.add(new Main(b,m1,m2,m3,k));
            a--;
        }
        for(Main e:aa){
            e.avergae();
        }
        Collections.sort(aa);
        System.out.printf("%-20s%-20s%-20s","Roll No","Name","Average");
        System.out.println();
        for(Main e:aa){
            System.out.println(e.toString());
        }
        
    }
    
}

 