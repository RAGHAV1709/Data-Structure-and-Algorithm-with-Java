package intelligentstring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IntelligentString {
    public static ArrayList<String> getSpecialSubstring(String s,int k, String charValue){
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> newList = new ArrayList<>();
        for(int i = 0; i < charValue.length(); i++){
            if(charValue.charAt(i) == '0'){
                char c = (char)(97+i);
                list2.add(String.valueOf(c));
            }
        }
        int size = s.length();
        for(int i = 0; i < size-1; i++){
            for(int j = i+1; j <=size;j++){
                list.add(s.substring(i,j));
                //[gir, ira, ra, affe, ffe, fe]
                System.out.println(s.substring(i,j));
            }
            Collections.sort(list);
            newList.add(longestSubstring(list,list2,k));
            list.removeAll(list);
        }
        return newList;
    }
    public static String longestSubstring(ArrayList<String> list, ArrayList<String> list2,int k){
        String longestString = "";
        
        for(int i = 0; i < list.size(); i++){
            int count = 0;
            count = numberNormalChar(list.get(i),list2);
            if(count <= k ){
                if(longestString.length() < (list.get(i).length())){
                    longestString = list.get(i);
                }
                
            }
            
        }
        return longestString;
    }
    public static int numberNormalChar(String s,ArrayList<String> list2){
        int count = 0;
        for(int i = 0; i < list2.size(); i++){
            
            if(s.contains(list2.get(i))){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String s = "giraffe";//sc.next();
        int k = 2;//sc.nextInt();
        String charValue = "01111001111111111011111111";//sc.next();
        
        getSpecialSubstring(s,k,charValue);
        
        
        //System.out.println(getSpecialSubstring(s,k,charValue));
    }
    
}
