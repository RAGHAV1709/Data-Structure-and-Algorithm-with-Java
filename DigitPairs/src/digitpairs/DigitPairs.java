/*
Digit Pairs
Problem Description
Given N three-digit numbers, your task is to find bit score of all N numbers and then print the number of pairs possible based on these calculated bit score.

1. Rule for calculating bit score from three digit number:

From the 3-digit number,

· extract largest digit and multiply by 11 then

· extract smallest digit multiply by 7 then

· add both the result for getting bit pairs.

Note: - Bit score should be of 2-digits, if above results in a 3-digit bit score, simply ignore most significant digit.

Consider following examples:

Say, number is 286

Largest digit is 8 and smallest digit is 2

So, 8*11+2*7 =102 so ignore most significant bit , So bit score = 02.

Say, Number is 123

Largest digit is 3 and smallest digit is 1

So, 3*11+7*1=40, so bit score is 40.

2. Rules for making pairs from above calculated bit scores

Condition for making pairs are

· Both bit scores should be in either odd position or even position to be eligible to form a pair.

· Pairs can be only made if most significant digit are same and at most two pair can be made for a given significant digit.

Constraints
N<=500

Input Format
First line contains an integer N, denoting the count of numbers.

Second line contains N 3-digit integers delimited by space

Output
One integer value denoting the number of bit pairs.

Timeout
1

Explanation
Example 1

Input

8 234 567 321 345 123 110 767 111

Output

3

Explanation

After getting the most and least significant digits of the numbers and applying the formula given in Rule 1 we get the bit scores of the numbers as:

58 12 40 76 40 11 19 18

No. of pair possible are 3:

40 appears twice at odd-indices 3 and 5 respectively. Hence, this is one pair.

12, 11, 18 are at even-indices. Hence, two pairs are possible from these three-bit scores.

Hence total pairs possible is 3
*/
package digitpairs;
import java.util.*;
public class DigitPairs {
    public static int maxF(int temp){
        int max = Integer.MIN_VALUE;
        while(temp > 0){
            if((temp % 10) > max){
                max = temp % 10;
                
            }
            temp = temp / 10;
        }
        return max;
    }
    public static int minF(int temp){
        int min = Integer.MAX_VALUE;
        while(temp > 0){
            if((temp % 10) < min){
                min = temp % 10;
                
            }
            temp = temp / 10;
        }
        return min;
    }
    public static boolean checkVisited(int visited[],int m){
        for(int i = 0; i < visited.length; i++){
            if(m == visited[i]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = s.nextInt();
        }
        for(int i = 0; i < n; i++){
            int temp = a[i];
            int max = maxF(temp);
            int min = minF(temp);
            int k = (max * 11) + (min * 7);
            if(k > 99){
                k = k % 100;
            }
            a[i] = k;
        }
        int pairCount = 0;
//        for(int i = 0; i < n; i=i+2){
//            for(int j=i+2; j < n; j=j+2){
//                if((a[i] / 10) == (a[j] / 10)){
//                    pairCount++;
//                }
//            }
//
//        }
    int u =0;
        for(int i = 1; i < n; i=i+2){
            int m = a[i] / 10;
           int visited[] = new int[n];
           if(checkVisited(visited,m)){
               continue;
           }
           visited[u] = m;
           u++;
            
            for(int j=i+2; j < n; j=j+2){
                if((a[i] / 10) == (a[j] / 10)){
                    //System.out.println(a[i] + " "+a[j]);
                    pairCount++;
                }
            }
        }
        System.out.println(pairCount);
    }
    
}
