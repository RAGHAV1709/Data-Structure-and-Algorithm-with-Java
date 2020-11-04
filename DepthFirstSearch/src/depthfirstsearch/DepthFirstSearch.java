package depthfirstsearch;

import java.util.Scanner;
class Stack{
    int size,top;
    int[] a = new int[size];
    Stack(){
        size = 15;
        top = -1;
    }
    public void push(int n)
    {
        if(top == size){
            System.out.println("Stack is full.");
            return;
        }
        else{
            top++;
            a[top] = n;
        }
    }
    public void pop(){
        if(top < 0){
            System.out.println("Stack is empty.");
            return;
        }
        else{
            a[top] = 0;
            top--;
        }
    }
}
public class DepthFirstSearch {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        //int n = sc.nextInt();
        //int m = sc.nextInt();
        int[][] a = {{0,1,0,1,0,0,0},{1,0,1,1,0,1,1},{0,1,0,1,1,1,1},{1,1,1,0,1,0,0},{0,0,1,1,0,0,1},{0,1,1,0,0,0,0},{0,1,0,0,1,0,0}};
        
        System.out.println("The required tree are: ");
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
            System.out.print(a[i][j]+" ");
        }
            System.out.println();
        }
        
        for(int i = 0; i < 7; i++){
            for(int j = 0; j<7;j++){
                if(a[i][j] == 1){
                    stack.push(a[i][j]);
                }
                
            }
        }
    }
    
}
