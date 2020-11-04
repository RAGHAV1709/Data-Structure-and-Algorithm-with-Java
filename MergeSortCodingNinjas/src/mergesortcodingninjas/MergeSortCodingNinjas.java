package mergesortcodingninjas;

public class MergeSortCodingNinjas {
    public static void mergeSort(int a[]){
        if(a.length <= 1){
            return;
        }
        int mid = a.length / 2;
        int part1[] = new int[mid];
        int part2[] = new int[a.length - mid];
        int k = 0;
        for(int i = 0; i < mid; i++){
            part1[i] = a[i];
        }
        for(int i = mid; i < a.length; i++){
            part2[k] = a[i];
            k++;
        }
        mergeSort(part1);
        mergeSort(part2);
        merge(part1,part2,a);
        
       
    }
    public static void merge(int part1[], int part2[],int output[]){
        int i = 0,j = 0, k = 0;
        while(i < part1.length && j < part2.length){
            if(part1[i] < part2[j]){
                output[k] = part1[i];
                i++;
                k++;
            }
            else{
                output[k] = part2[j];
                k++;
                j++;
            }
        }
        while(i < part1.length){
            output[k] = part1[i];
            i++;
            k++;
        }
        while(j < part2.length){
            output[k] = part2[j];
            k++;
            j++;
        }
        
    }
    public static void main(String[] args) {
       // TODO code application logic here
        int a[] = new int[]{15,5,24,8,1,3,16,10,20};
        mergeSort(a);
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]+ " ");
        }
        System.out.println();
    }
    
}
