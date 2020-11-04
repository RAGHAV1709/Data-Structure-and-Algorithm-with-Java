package countnumberofdigitrecursion;

public class CountNumberOfDigitRecursion {
	public static int count(int n){
		if(n == 0){
			return 0;
		}
		int smallAns = count(n / 10);
                System.out.println(smallAns);
		return smallAns;
                
	}
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 15;
        //count(n);
        int k = count(n);
        System.out.println(k);
    }
    
}
