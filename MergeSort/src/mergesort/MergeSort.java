package mergesort;
public class MergeSort {
public static void mergeSort(int input[], int sI, int eI){
    if(sI >= eI){
        return;
    }
       int mid = (sI+eI)/2;
       mergeSort(input,sI,mid);
       mergeSort(input,mid+1,eI);
       merge(input,sI,eI);
    
}
public static void merge(int input[],int sI, int eI){
    int mid = (sI+eI)/2;
    int i = sI;
    int j = mid + 1;
    int k = 0;
    int[] ans = new int[eI-sI+1];
    while(i <= mid && j<=eI){
        if(input[i] < input[j]){
            ans[k] = input[i];
            k++; i++;
        }
        else{
            ans[k] = input[j];
            k++; j++;
        }
    }
    while(i <= mid){
        ans[k] = input[i];
        i++;
        k++;
    }
    while(j <= eI){
        ans[k] = input[j];
        k++;
        j++;
    }
    for(int index = 0; index < ans.length; index++){
        input[sI + index] = ans[index];
    }
}
public static void view(int a[],int ub){
    for(int i = 0; i<=ub;i++){
        System.out.print(a[i]+ " ");
    }
}
    public static void main(String[] args) {
        // TODO code application logic here
        int arr[] = { 12, 11, 13, 5, 6, 7 }; 
        mergeSort(arr, 0, arr.length - 1); 
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        
    }
    
}
