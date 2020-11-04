package binarysearchtreeclass;

import java.util.Scanner;

class BinaryTreeNode<T> {
    public BinaryTreeNode(T data){
        this.data = data;
    }
    public T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    
}
class BinarySearchTree{
    private BinaryTreeNode<Integer> root;
    private BinaryTreeNode<Integer> insertData(int data, BinaryTreeNode<Integer> root){
        if(root == null){
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(data);
            return newNode;
        }
        if(root.data > data){
            root.left = insertData(data, root.left);
        }
        else{
            root.right = insertData(data, root.right);
        }
        return root;
    }
    public void insertData(int data){
        root = insertData(data, root);
    }
    public void deleteData(int data){
        root = deleteData(data, root);
    }
    private BinaryTreeNode<Integer> deleteData(int data, BinaryTreeNode<Integer> root){
        if(root == null){
            return null;
        }
        if(data < root.data){
            root.left = deleteData(data, root.left);
            return root;
        }
        else if(data > root.data){
            root.right = deleteData(data, root.right);
            return root;
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                BinaryTreeNode<Integer> minNode = root.right;
                while(minNode.left != null){
                    minNode = minNode.left;
                }
               root.data = minNode.data;
               root.right = deleteData(minNode.data, root.right);
               return root;
            }
        }
    }
    private void printTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        String toBePrinted = root.data + ":";
        if(root.left != null){
            toBePrinted += "L:" + root.left.data+",";
        }
        if(root.right != null){
            toBePrinted += "R:" + root.right.data;
        }
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }
    public void printTree(){
        printTree(root);
    }
    private boolean hasDataHelper(int data, BinaryTreeNode<Integer> root){
        if(root == null){
            return false;
        }
        if(root.data == data){
            return true;
        }
        else if(data > root.data){
            return hasDataHelper(data, root.right);
        }
        else{
            return hasDataHelper(data, root.left);
        }
        
    }
    public boolean hasData(int data){
        return hasDataHelper(data,root);
    }
}
public class BinarySearchTreeClass {
    public static BinaryTreeNode<Integer> lcaInBSTHelper(BinaryTreeNode<Integer> root, int a, int b){
        if(root == null){
            return null;
        }
        if(root.data == a || root.data == b){
            return root;
        }
        if(root.data < a && root.data < b){
            return lcaInBSTHelper(root.right, a, b);
        }
        else if(root.data > a && root.data > b){
            return lcaInBSTHelper(root.left, a, b);
        }
        else{
            BinaryTreeNode<Integer> left_lca = lcaInBSTHelper(root.left, a, b);
            BinaryTreeNode<Integer> right_lca = lcaInBSTHelper(root.right,a, b);
            if(left_lca != null && right_lca != null){
                return root;
            }
            else if(left_lca != null){
                return left_lca;
            }
            else{
                return right_lca;
            }
        }
        
    }
    public static int lcaInBST(BinaryTreeNode<Integer> root,int val1, int val2){
        BinaryTreeNode<Integer> node = lcaInBSTHelper(root, val1, val2);
        if(node != null){
            return node.data;
        }
        else{
            return -1;
        }
    }
    static Scanner s = new Scanner(System.in);
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        /*
        Path Sum Root to Leaf
        Send Feedback
        Given a binary tree and a number k, print out all root to leaf paths where the sum of all nodes value is same as the given number k.
        Input format :
        Line 1 : Elements in level order form (separated by space)
        (If any node does not have left or right child, take -1 in its place)
        Line 2 : k
        Output format : Print each path in new line, elements separated by space
        Sample Input 1 :
        5 6 7 2 3 -1 1 -1 -1 -1 9 -1 -1 -1 -1
        13
        Sample Output 1 :
        5 6 2
        5 7 1
       */
	// Write your code here
	 helper(root,k,"");
    }
    public static BinaryTreeNode<Integer> find(BinaryTreeNode<Integer> root, int f)
    {
        if(root==null)
            return null;
        if(root.data.equals(f))
        {
            return root;
        }
        
        BinaryTreeNode<Integer> l=find(root.left,f);
        if(l!=null)
            return l;
        BinaryTreeNode<Integer> r=find(root.right,f);
        if(r!=null)
            return r;
        return null;    
    }
    
    
    public static void nodesSumToS(BinaryTreeNode<Integer> croot,BinaryTreeNode<Integer> root, int sum) {
	    
	   if(croot==null)
	   {
	        return;
	   }
	   int s = sum-croot.data;
	 
	   BinaryTreeNode<Integer> f=null;
	   if(croot.data<s)
		   f=find(root,s);
	   if(f!=null)
	   {
	       System.out.println(croot.data+" "+f.data);
	   }
	  
	   nodesSumToS(croot.left,root,sum);
	   nodesSumToS(croot.right,root,sum);
	
	}
    

    public static void nodesSumToS(BinaryTreeNode<Integer> root, int sum) {
            /*
            Pair sum BInary Tree
            Send Feedback
            Given a binary tree and an integer S, print all the pair of nodes whose sum equals S.
            Assume binary tree contains all unique elements.
            Note : In a pair, print the smaller element first. Order of different pair doesn't matter.
            Input format :
            Line 1 : Elements in level order form (separated by space)
            (If any node does not have left or right child, take -1 in its place)
            Line 2 : Integer S
            Output Format :
            Each pair in different line (pair elements separated by space)
            Constraints :
            1 <= N <= 1000
            Sample Input 1:
            5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
            15
            Sample Output 1:
            5 10
            6 9
            */
            // Write your code here
            nodesSumToS(root,root,sum);

	}
    private static void helper(BinaryTreeNode<Integer> root,int k,String s){
        if(root==null)
            return;
        if(root.left==null && root.right==null && root.data==k)
        {
            System.out.println(s+root.data);
            return;
        }
        s=s+root.data+" ";
   
        helper(root.left,k-root.data,s);
        helper(root.right,k-root.data,s);
        
    }
    
    public static BinaryTreeNode<Integer> lcaBinaryTreeHelper(BinaryTreeNode<Integer> root, int a, int b)
    {
        if(root == null){
            return null;
        }
        if(root.data == a || root.data == b){
            return root;
        }
        BinaryTreeNode<Integer> left_lca = lcaBinaryTreeHelper(root.left, a, b);
        BinaryTreeNode<Integer> right_lca = lcaBinaryTreeHelper(root.right, a,b);
        if(left_lca != null && right_lca != null){
            return root;
        }
        if(left_lca != null){
            return left_lca;
        }
        return right_lca;
    }
    public static int lcaBinaryTree(BinaryTreeNode<Integer> root, int val1, int val2){
        BinaryTreeNode<Integer> node = lcaBinaryTreeHelper(root,val1,val2);
        if(node != null){
            return node.data;
        }
        else{
            return -1;
        }
    }
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(root.data);
        BinaryTreeNode<Integer> rootLeft = root.left;
        root.left = newNode;
        newNode.left = rootLeft;
        insertDuplicateNode(rootLeft);
        insertDuplicateNode(root.right);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        BinarySearchTree bst = new BinarySearchTree();
        int choice, input;
        while(true){
            choice = s.nextInt();
            switch(choice){
                case 1 :
                    input = s.nextInt();
                    bst.insertData(input);
                    break;
                case 2:
                    input = s.nextInt();
                    bst.deleteData(input);
                    break;
                case 3:
                    input = s.nextInt();
                    System.out.println(bst.hasData(input));
                    break;
                default:
                    bst.printTree();
                    return;
            }
        }
    }
    
}
