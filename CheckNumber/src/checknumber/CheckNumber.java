package checknumber;

public class CheckNumber {
	public static boolean checkNumber(int input[], int x) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
		return checkNumber(input,x,0);
	}
    public static boolean checkNumber(int input[],int x,int startIndex){
        if(input[startIndex] == x){
            return true;
        }
        if(startIndex >= input.length-1){
        
            return false;
        }
        return checkNumber(input,x,startIndex+1);
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[] input = new int[]{1,5,7,9};
        System.out.println(input.length);
        System.out.println(checkNumber(input,8));
    }
    
}
