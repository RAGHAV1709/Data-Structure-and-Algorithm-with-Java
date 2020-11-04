package insertionsort;

public class InsertionSort {

    public static void main(String[] args) {
        // TODO code application logic here
        int[] a = new int[]{6,1,2,8,5,3,4,10,9,7};
        for(int i = 1; i<a.length; i++){
            
                int temp = a[i];
                int j = i-1;
                while(j>=0 && temp<a[j]){// Checkout why temp<a[j] && j>=0 gives array out of bound exception
                    a[j+1] = a[j];
                    j--;
                }
                a[j+1] = temp;
            
            
        }
        for(int i = 0; i<a.length; i++){
            System.out.print(a[i] + " ");
        }
        
    }
    
}
