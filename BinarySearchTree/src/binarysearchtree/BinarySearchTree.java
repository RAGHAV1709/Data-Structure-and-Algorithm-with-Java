package binarysearchtree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BinaryTreeNode<T> {
    public BinaryTreeNode(T data){
        this.data = data;
    }
    public T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    
}
class Pair<T,V>{
    
    T first;
    V second;
}
class LinkedListNode<T>{
    T data;
    LinkedListNode<T> next;
    
    public LinkedListNode(T data){
        this.data = data;
    }
}
class PairOfNodeElem{
    LinkedListNode<Integer> head;
    LinkedListNode<Integer> tail;
    
}
public class BinarySearchTree {
    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        int rootData = s.nextInt();
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front = pendingNodes.remove();
            System.out.println("Enter left child of "+front.data);
            int leftChild = s.nextInt();
            if(leftChild != -1){
                BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
                pendingNodes.add(child);
                front.left = child;
            }
            System.out.println("Enter right child of "+front.data);
            int rightChild = s.nextInt();
            if(rightChild != -1){
                BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
                pendingNodes.add(child);
                front.right = child;
            }
        }
        return root;
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
    public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root , int k){
        BinaryTreeNode<Integer> temp=null;
        if(root==null)
            return null;
        if(root.data==k)
            return root;
        if(root.data>k)
            temp=searchInBST(root.left,k);
        else if(root.data<k)
            temp=searchInBST(root.right,k);
        return temp;
    }
    public static void printNodeFromK1ToK2(BinaryTreeNode<Integer> root, int k1, int k2){
        if(root == null){
            return;
        }
        if((int)root.data >= k1){
            printNodeFromK1ToK2(root.left,k1,k2);
        }
        if((int)root.data >= k1 && (int)root.data <= k2){
            System.out.println(root.data + " ");
        }
        if((int)root.data <= k2){
            printNodeFromK1ToK2(root.right,k1,k2);
        }
    }
    
    public static boolean isBST(BinaryTreeNode<Integer> root, int min, int max){
        //Time complexity is o(n)....
        if(root == null){
            return true;
        }
        if(root.data > min && root.data <= max){
            boolean ans1 = isBST(root.left,min,root.data - 1);
            boolean ans2 = isBST(root.right, root.data, max);
            return ans1 && ans2;
        }
        else{
            return false;
        }
    }
    public static boolean isBST(BinaryTreeNode<Integer> root){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static boolean isBST1(BinaryTreeNode<Integer> root){
        // Time complexity is o(nlogn)
        if(root == null){
            return true;
        }
        int leftMax = maximum(root.left);
        int rightMin = minimum(root.right);
        if(root.data <= leftMax){
            return false;
        }
        if(root.data > rightMin){
            return false;
        }
        boolean isLeftBST = isBST(root.left);
        boolean isRightBST = isBST(root.right);
        if(isLeftBST && isRightBST){
            return true;
        }
        else{
            return false;
        }
    }
    public static int minimum(BinaryTreeNode<Integer> root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data, Math.min(minimum(root.left),minimum(root.right)));
        
    }
    public static int maximum(BinaryTreeNode<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
        
    }
    public static Pair<Boolean, Pair<Integer, Integer>> isBST2(BinaryTreeNode<Integer> root){
        //Time complexity O(n)
        if(root == null){
            Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
            output.first = true;
            output.second = new Pair<Integer, Integer>();
            output.second.first = Integer.MAX_VALUE;
            output.second.second = Integer.MIN_VALUE;
            return output;
        }
        Pair<Boolean, Pair<Integer, Integer>> leftOutput = isBST2(root.left);
        Pair<Boolean, Pair<Integer, Integer>> rightOutput = isBST2(root.right);
        int min = Math.min(root.data, Math.min(leftOutput.second.first, rightOutput.second.first));
        int max = Math.max(root.data, Math.max(leftOutput.second.second, rightOutput.second.second));
        boolean isBST = (root.data > leftOutput.second.second) && (root.data <= rightOutput.second.first) && leftOutput.first && rightOutput.first;
        Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
        output.first = isBST;
        output.second = new Pair<Integer, Integer>();
        output.second.first = min;
        output.second.second = max;
        return output;        
    }
    
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr){
        return SortedArrayToBST(arr,0,arr.length-1);
    }
    private static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr,int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start)/2;
        BinaryTreeNode<Integer> temp = new BinaryTreeNode<Integer>(arr[mid]);
        temp.left = SortedArrayToBST(arr,start,mid-1);
        temp.right = SortedArrayToBST(arr, mid+1, end);
        return temp;
    }
    public static LinkedListNode<Integer> BSTToSortedLL(BinaryTreeNode<Integer> root){
        return helper(root).head;
    }
    private static PairOfNodeElem helper(BinaryTreeNode<Integer> root){
        if(root == null){
            PairOfNodeElem pair = new PairOfNodeElem();
            pair.head = null;
            pair.tail = null;
            return pair;
        }
        LinkedListNode<Integer> nn = new LinkedListNode<Integer>(root.data);
        PairOfNodeElem leftTree = helper(root.left);
        PairOfNodeElem rightTree = helper(root.right);
        PairOfNodeElem pair = new PairOfNodeElem();
        if(leftTree.head != null){
            pair.head = leftTree.head;
            pair.tail = leftTree.tail;
            pair.tail.next = nn;
            pair.tail = nn;
            if(rightTree.head == null){
                return pair;
            }
        }
        if(rightTree.head != null && leftTree.head != null){
            pair.tail.next = rightTree.head;
            pair.tail = rightTree.tail;
            return pair;
        }
        if(rightTree.head != null && leftTree.head == null){
            pair.head = nn;
            nn.next = rightTree.head;
            pair.tail = rightTree.tail;
            return pair;
        }
        else{
            pair.head = nn;
            pair.tail = nn;
        }
        return pair;
    }
    public static ArrayList<Integer> findPath(BinaryTreeNode<Integer> root, int data){
        /*
        Sample Input :
        8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
        2
        Sample Output :
        2
        5
        8
        */
        if(root==null)
        {// {ArrayList<Integer> arr=new ArrayList<Integer>(1);
        // arr.add(data);
            return null;
        }

        if(root.data==data)
        {
            ArrayList<Integer> arr=new ArrayList<Integer>();
            arr.add(root.data);
            return arr;
        }
        
        ArrayList<Integer> leftOutput=findPath(root.left,data);   
                    
        if(leftOutput!=null){
            leftOutput.add(root.data);
            return leftOutput;
        }
        
        ArrayList<Integer> rightOutput=findPath(root.right,data);   
                    
        if(rightOutput!=null){
            rightOutput.add(root.data);
            return rightOutput;
        }
        
        else{
            return null;
        }
    }
    
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if(root==null)
            return;
        BinaryTreeNode<Integer> temp=root;
        temp.left=root.left;
        temp.right=root.right;
        root.left=temp;
        
	
        insertDuplicateNode(temp.left);
        insertDuplicateNode(temp.right);
    
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        int k = s.nextInt();
        BinaryTreeNode<Integer> ans = searchInBST(root,k);
        if(ans != null){
            System.out.println(ans.data);
        }
        System.out.println(isBST2(root).first);
        
        LinkedListNode<Integer> ans1 = BSTToSortedLL(root);
        while(ans != null){
            System.out.println(ans1.data + " ");
            ans1 = ans1.next;
        }
    }
    
}
