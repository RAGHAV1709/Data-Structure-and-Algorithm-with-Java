package binarytree;
import java.util.Scanner;

public class BinaryTree {
    Node root;
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public Node insertLevelOrder(int[] arr, Node root, int i){
        if(i < arr.length){
            Node temp = new Node(arr[i]);
            root = temp;
            root.left = insertLevelOrder(arr, root.left, 2*i+1);
            root.right = insertLevelOrder(arr, root.right, 2*i+2);
        }
        return root;
    }
    public void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        BinaryTree t2 = new BinaryTree();
        int num = s.nextInt();
        int arr[] = new int[num];
        for(int i=0; i<num; i++){
            arr[i] = s.nextInt();
        }
        t2.root = t2.insertLevelOrder(arr, t2.root,0);
        t2.inOrder(t2.root);
    }
    
}
