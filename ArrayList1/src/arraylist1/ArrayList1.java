package arraylist1;

import java.util.*;

public class ArrayList1 {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        //int n = sc.nextInt();
        list.add(1, 3);
//        for(int i=0;i<=n;i++){
//            if(i % 2 ==0)
//                list.add(i,5);
//        }
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }        
               
//        System.out.println(list.size());
//        int k = 0;
//        for(int i = 0; i < n; i++){
//            k += list.get(i);
//        }
//        System.out.println(k);
        //2Iterator iterator = list.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

    }
    
}
