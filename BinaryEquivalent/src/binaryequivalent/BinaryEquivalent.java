package binaryequivalent;

import static java.lang.Integer.toBinaryString;
import java.util.Arrays;
import java.util.Scanner;

public class BinaryEquivalent {
    public static int[][] subsets(int input[]) {
		// Write your code here
		return subsetsHelper(input,0);
	}
    public static int[][] subsetsHelper(int[] input,int startIndex){
        if(startIndex == input.length){
            int[][] output = new int[1][0];
            return output;
        }
        int[][] smallerOutput = subsetsHelper(input,startIndex+1);
        int[][] output = new int[2*smallerOutput.length][];
        int k = 0;
        for(int i = 0; i < smallerOutput.length; i++){
            output[k] = new int[smallerOutput[i].length];
            
            for(int j = 0; j < smallerOutput[i].length; j++){
                output[k][j] = smallerOutput[i][j];
                
            }
            k++;
        }
        for(int i = 0; i < smallerOutput.length; i++){
            output[k] = new int[smallerOutput[i].length+1];
            output[k][0] = input[startIndex];
            
            for(int j = 1; j <= smallerOutput[i].length; j++){
            	output[k][j] = smallerOutput[i][j-1];
                
            }
            k++;
    	}
       return output;
    }
    public static int[] takeInput(){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int arr[] = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = s.nextInt();
        }
        return arr;
    }
    public static boolean checkBinaryEquivalent(int a[], int maxBit){
        if(a.length == 1){
            
        }
        else{
            
        }
        return true;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[] input = takeInput();
        int max = Arrays.stream(input).max().getAsInt();
        
        String maxBinary = toBinaryString(max);
        
        int maxBit = maxBinary.length();
        
        int count = 0;
        System.out.println(maxBit);
        int[][] a = subsets(input);
        for(int i = 1; i < a.length; i++){
            int temp[] = new int[a[i].length];
            for(int j = 0; j < a[i].length; j++){
                temp[j] = a[i][j];
            }
            if(checkBinaryEquivalent(temp,maxBit)){
                count++;
            }
            System.out.println();
        }
    }
    
}
/*
10
7
710
2
210
27
2710
*/