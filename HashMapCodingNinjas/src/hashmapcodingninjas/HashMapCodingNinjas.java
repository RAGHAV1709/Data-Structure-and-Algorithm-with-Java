package hashmapcodingninjas;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
public class HashMapCodingNinjas {
    public static ArrayList<Integer> removeDuplicates(int a[]){
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Boolean> seen = new HashMap<>();
        for(int i = 0; i < a.length; i++){
            if(seen.containsKey(a[i])){
                continue;
            }
            output.add(a[i]);
            seen.put(a[i], true);
        }
        return output;
    }
    public static int maxFrequencyNumber(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i : arr){
            if(hm.containsKey(i)){
                hm.put(i, hm.get(i)+1);
            }
            else{
                hm.put(i, 1);
            }
        }
        int max = 0, ans = Integer.MIN_VALUE;
        for(int i : arr){
            if(hm.get(i) > max){
                max = hm.get(i);
                ans = i;
            }
        }
        return ans;
    }
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		//Your Code goes here
        HashMap<Integer, Boolean> map = new LinkedHashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int v : arr) {
            map.put(v, false);
        }
        for (int e : map.keySet()) {
            if (!map.get(e)) {
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(e);
                map.put(e, true);
                for (int i = 1; map.containsKey(e + i); i++) {
                    tempList.add(e + i);
                    map.put(e + i, true);
                }
                if (result.size() < tempList.size()) {
                    result = tempList;
                }
            }
        }
		return result;
	}
    
    public static int maxFrequencyNumber1(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i : arr){
            if(hm.containsKey(i)){
                hm.put(i, hm.get(i)+1);
            }
            else{
                hm.put(i, 1);
            }
        }
        int max = 0, ans = Integer.MIN_VALUE;
        for(int i : arr){
            if(hm.get(i) > max){
                max = hm.get(i);
                ans = i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        HashMap<String, Integer> map = new HashMap<>();
        //insert
        map.put("abc", 1);
        map.put("def", 2);
        map.put("def1", 2);
        map.put("abc1", 1);
        
        System.out.println("Size: "+ map.size());
        if(map.containsKey("abc")){
            System.out.println("Has abc");
        }
        if(map.containsKey("abc1")){
            System.out.println("has abc1");
        }
        
        if(map.containsValue(2)){
            //Operation on value are expensive
            //it's time complexity is O(n)
            System.out.println("has 2 as value");
        }
        //get value
        int v = 0;
        if(map.containsKey("abc1")){
            v = map.get("abc1");
        }
        System.out.println(v);
        
        //remove
        int s = map.remove("abc");
        System.out.println(s);
        
        //iterate
//        Set<String> keys = map.keySet();
//        for(String str : keys ){
//            System.out.println(str);
//        }
        
        
//        int a[] = {1,3,2,4,1,2,2,2,1000,3,2};
//        ArrayList<Integer> output = removeDuplicates(a);
//        for(int i = 0; i < output.size(); i++){
//            System.out.println(output.get(i));
//        }
    }
    
}
