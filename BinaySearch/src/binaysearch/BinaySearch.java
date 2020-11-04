package binaysearch;
public class BinaySearch {
    public static int binarySearch(int input[], int element){
        return binarySearch(input,0,input.length,element);
    }
    public static int binarySearch(int input[],int start,int end, int element){
        int mid = (start+end)/2;
        if(start > end){
            return -1;
        }
        if(input[mid] == element){
            return mid;
        }
        else if(element < input[mid]){
            return binarySearch(input,start,mid-1,element);
        }
        else{
            return binarySearch(input,mid+1,end,element);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int input[] = {1,3,4,5,6,7,8,9};
        System.out.println(binarySearch(input,5));
    }
    
}
