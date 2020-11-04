package binarytree2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class BinaryTreeNode<T>{
    public T data;
    public BinaryTreeNode(T data){
        this.data = data;
    }
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
}
public class BinaryTree2 {
    public static BinaryTreeNode<Integer> takeInput(Scanner s){
        System.out.println("Enter the root data: ");
        int rootData = s.nextInt();
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        root.left = takeInput(s);
        root.right = takeInput(s);
        return root;
    }
    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the root data: ");
        int rootData = s.nextInt();
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> frontRoot = queue.remove();
            System.out.println("Enter the left child of: "+frontRoot.data);
            int leftchild = s.nextInt();
            if(leftchild != -1){
                BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftchild);
                queue.add(child);
                frontRoot.left = child;  
            }
            System.out.println("Enter the right child of: "+frontRoot.data);
            int rightchild = s.nextInt();
            if(rightchild != -1){
                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(rightchild);
                queue.add(child);
                frontRoot.right = child;
            }
             
        }
        return root;
    }
    public static void print(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        String toBePrinted = root.data+"";
        if(root.left != null){
            toBePrinted += "L:"+root.left.data+",";
        }
        if(root.right != null){
            toBePrinted += "R:"+root.right.data+",";
        }
        System.out.println(toBePrinted);
        print(root.left);
        print(root.right);
    }
    public static void printLevelWise(BinaryTreeNode<Integer> root){
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryTreeNode<Integer> current = null;
            current = q.remove();
            String toBePrinted = current.data + ":";
            if(current.left != null){
                toBePrinted += "L:" + current.left.data + ",";
                q.add(current.left);
            }
            else{
                toBePrinted += "L:-1,";
            }
            if(current.right != null){
                toBePrinted += "R:"+current.right.data;
                q.add(current.right);
            }
            else{
                toBePrinted += "R:-1";
            }
            System.out.println(toBePrinted);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        //Scanner s = new Scanner(System.in);
        //BinaryTreeNode<Integer> root = takeInput(s);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        //print(root);
        printLevelWise(root);
        
    }
    
}
