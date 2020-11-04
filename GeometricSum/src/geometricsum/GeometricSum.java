package geometricsum;

public class GeometricSum {

	public static double findGeometricSum(int k){
		// Write your code here
        //double sum = 0.0;
//	for(int i = 0; i <= k; i++){
//            sum += 1.00 /(Math.pow(2, i)); 
//            //System.out.println(sum);
//        }
        if(k == 0){
             return 1;
        }
        double sum = 1.00 /(Math.pow(2, k));
        sum += findGeometricSum(k-1);
        return sum;
	}
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println(findGeometricSum(4));
    }
    
}
