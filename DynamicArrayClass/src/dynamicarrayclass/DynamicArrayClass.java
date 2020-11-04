package dynamicarrayclass;
class DynamicArray{
    private int data[];
    private int nextIndex;
    public DynamicArray(){
        data = new int[5];
        nextIndex = 0;
    }
    public int size(){
        return nextIndex;
    }
    public void add(int element){
        if(nextIndex == data.length){
            restructure();
        }
        else{
            data[nextIndex] = element;
            nextIndex++;
        }
    }
    public void set(int index, int element){
        if(index > nextIndex){
            return;
        }
        else if(index < nextIndex){
            data[index] = element;
        }
        else{
            add(element);
        }
    }
    public int get(int index){
        if(index >= nextIndex){
            return -1;
        }
        return data[index];
    }
    public boolean isEmpty() {
	if (size() == 0) {
		return true;
	} else {
		return false;
	}
    }
	
    public int removeLast() {
        if (size() == 0) {
	 // error out
	 return -1;
	}
	int value = data[nextIndex - 1];
	data[nextIndex - 1] = 0;
	nextIndex--;
	return value;
    }
    private void restructure(){
        int temp[] = data;
        data = new int[2*data.length];
        for(int i = 0; i < temp.length; i++){
            data[i] = temp[i];
        }
    }
        
    
}
public class DynamicArrayClass {

    public static void main(String[] args) {
        // TODO code application logic here
        DynamicArray d = new DynamicArray();
        d.add(0);
        d.add(1);
	d.add(2);
        d.add(3);
	for(int i = 0; i < d.size();i++){
            d.get(i);
        }	
//		for (int i = 0; i < 100; i++) {
//			d.add(i + 10);
//		}
//		
//		System.out.println(d.size());
//		
//		d.set(4, 10);
//		System.out.println(d.get(3));
//		System.out.println(d.get(4));
//		
//		while (!d.isEmpty()) {
//			System.out.println(d.removeLast());
//			System.out.println("size = " + d.size());
//		}
    }
    
}
