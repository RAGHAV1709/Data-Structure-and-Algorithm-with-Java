/*
Code: Min Steps to One
Send Feedback
Given a positive integer n, find the minimum number of steps s, that takes n to 1. You can perform any one of the following 3 steps.
1.) Subtract 1 from it. (n= n - ­1) ,
2.) If its divisible by 2, divide by 2.( if n%2==0, then n= n/2 ) ,
3.) If its divisible by 3, divide by 3. (if n%3 == 0, then n = n / 3 ).  
Just write brute-force recursive solution for this.
Input format :
Line 1 : A single integer i.e. n
Output format :
Line 1 : Single integer i.e number of steps
Constraints :
1 <= n <= 500
Sample Input 1 :
4
Sample Output 1 :
2 
Sample Output 1 Explanation :
For n = 4
Step 1 : n = 4/2 = 2
Step 2 : n = 2/2 = 1
Sample Input 2 :
7
Sample Output 2 :
3
Sample Output 2 Explanation :
For n = 7
Step 1 : n = 7 ­ - 1 = 6
Step 2 : n = 6 / 3 = 2
Step 3 : n = 2 / 2 = 1
*/
package minto1;

import java.util.Scanner;

public class MinTo1 {
    public static int countStepsTo1(int n){
        if(n == 1){
            return 0;
        }
        int count1, count2 = Integer.MAX_VALUE, count3 = Integer.MAX_VALUE;
        count1 = countStepsTo1(n - 1);
        if(n % 2 == 0){
            count2 = countStepsTo1(n / 2);
        }
        if(n % 3 == 0){
            count3 = countStepsTo1(n / 3);
        }
        return 1 + Math.min(count1, Math.min(count2, count3));
    }
    
    public static int countStepsTo1DP(int n){
        int steps[] = new int[n+1];
        for(int i = 2; i <= n; i++){
            int count1, count2 = Integer.MAX_VALUE, count3 = Integer.MAX_VALUE;
            count1 = steps[i - 1];
            if(i % 2 == 0){
                count2 = steps[i / 2];
            }
            if(i % 3 == 0){
                count3 = steps[i / 3];
            }
            steps[i] = 1 + Math.min(count1, Math.min(count2, count3));
        }
        return steps[n];
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(countStepsTo1(n));
        System.out.println(countStepsTo1DP(n));
    }
    
}
