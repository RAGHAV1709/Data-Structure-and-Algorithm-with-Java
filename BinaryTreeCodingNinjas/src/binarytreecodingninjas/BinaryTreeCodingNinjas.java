package binarytreecodingninjas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class BinaryTreeNode<T> {
    public BinaryTreeNode(T data){
        this.data = data;
    }
    public T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    
}
 class Node<T> {
    T data;
    Node<T> next;
    Node(T data){
	this.data = data;
    }
}
class Pair<T,V>{
    //Used for finding better diameter of binary tree
    T first;
    V second;
}
public class BinaryTreeCodingNinjas {
    public static BinaryTreeNode<Integer> takeInput(Scanner s){
        int rootData;
        System.out.println("Enter root data");
        rootData = s.nextInt();
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        root.left = takeInput(s);
        root.right = takeInput(s);
        return root;
    }
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
    public static void printTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        String toBePrinted = root.data + "";
        if(root.left != null){
            toBePrinted += "L:"+root.left.data+",";
            
        }
        if(root.right != null){
            toBePrinted += "R:"+root.right.data;
        }
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
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
    public static boolean isNodePresent1(BinaryTreeNode<Integer> root,int x){
        if(root == null){
            return false;
        }
        boolean found = root.data.equals(x);
        if(found){
            return found;
        }
        found = found || isNodePresent1(root.left, x);
        if(found){
            return found;
        }
        found = found || isNodePresent1(root.right, x);
        return found;
    }
    public static boolean isNodePresent2(BinaryTreeNode<Integer> root, int x){
        /*
        Find Node
        Send Feedback
        Given a binary tree and an integer x, check if node with data x is present in the input binary tree or not. Return true or false.
        Input format :
        Line 1 : Elements in level order form (separated by space)
        (If any node does not have left or right child, take -1 in its place)
        Line 2 : Integer x
        Output Format :
        true or false
        Sample Input :
        8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
        7
        Sample Output :
        true
        */
        if(root == null){
            return false;
        }
        boolean ans = false;
        if(root.data == x){
            return true;
        }
        ans = isNodePresent2(root.left, x);
        if(ans){
            return true;
        }
        ans = isNodePresent2(root.right, x);
       
        return ans;
    }
    public static int countHeight(BinaryTreeNode<Integer> root){
        /*
        Height Of Binary Tree
        Send Feedback
        Given a binary tree, find and return the height of given tree.
        Input format :
        Nodes in the level order form (separated by space). If any node does not have left or right child, take -1 in its place
        Output format :
        Height
        Constraints :
        1 <= N <= 10^5
        Sample Input :
        10
         9 
        4 
        -1 
        -1 
         5 
         8 
        -1 
        6 
        -1 
        -1 
        3 
        -1 
        -1
        -1
        Sample Output :
        5
        */
        if(root == null){
            return 0;
        }
        int left = countHeight(root.left), right = countHeight(root.right);
        if(left > right){
            return left+1;
        }
        else{
            return right+1;
        }
    }
    public static void mirror(BinaryTreeNode<Integer> root){
        /*
        Mirror a Binary Tree
        Send Feedback
        Mirror the given binary tree. That is, right child of every nodes should become left and left should become right.
        Alt text

        Note : You don't need to print or return the tree, just mirror it.
        Input format :

        Line 1 : Elements in level order form (separated by space)

        (If any node does not have left or right child, take -1 in its place)

        Output format : Elements in level order form (Every level in new line)

        Sample Input 1:
        1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
        Sample Output 1:
        1 
        3 2 
        7 6 5 4
        Sample Input 2:
        5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
        Sample Output 2:
        5 
        6 10 
        3 2 
        9
        */
        if(root == null){
            return;
        }
        BinaryTreeNode<Integer> temp = root.right;
        root.right = root.left;
        root.left = temp;
        mirror(root.left);
        mirror(root.right);
        
        //another way
        /*
        if(root == null){
            return;
        }
        mirror(root.left);
        mirror(root.right);
        BinaryTreeNode<Integer> templeft = root.left;
        root.left = root.right;
        root.right = temp;
        */
    }
    public static int diameter(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int option1 = height(root.left) + height(root.right);
        int option2 = diameter(root.left);
        int option3 = diameter(root.right);
        return Math.max(option1, Math.max(option2, option3));
    }
    public static int height(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return 1+Math.max(lh, rh);
    }
    public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root){
        if(root == null){
            Pair<Integer, Integer> output = new Pair<>();
            output.first = 0;
            output.second = 0;
            return output;
        }
        Pair<Integer, Integer> lo = heightDiameter(root.left);
        Pair<Integer, Integer> ro = heightDiameter(root.right);
        int height = 1 + Math.max(lo.first, ro.first);
        int option1 = lo.first + ro.first;
        int option2 = lo.second;
        int option3 = ro.second;
        int diameter = Math.max(option1, Math.max(option2,option3));
        Pair<Integer, Integer> output = new Pair<>();
        output.first = height;
        output.second = diameter;
        return output;
        
    }
    public static void inorder(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    public static BinaryTreeNode<Integer> getTreeFromPreoderAndInorder(int[] pre, int[] in){
        /*
        Code: Construct Tree from Preorder and Inorder
        Send Feedback
        Given Preorder and Inorder traversal of a binary tree, create the binary tree associated with the traversals.You just need to construct the tree and return the root.
        Note: Assume binary tree contains only unique elements.
        Input format :

        Line 1 : n (Total number of nodes in binary tree)

        Line 2 : Pre order traversal

        Line 3 : Inorder Traversal

        Output Format :

        Elements are printed level wise, each level in new line (separated by space).

        Sample Input :
        12
        1 2 3 4 15 5 6 7 8 10 9 12
        4 15 3 2 5 1 6 10 8 7 9 12
        Sample Output :
        1 
        2 6 
        3 5 7 
        4 8 9 
        15 10 12
        */
        return helper(0,0,in.length-1, pre, in);
    }
    private static BinaryTreeNode<Integer> helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preStart > preorder.length-1 || inStart > inEnd){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preorder[preStart]);
        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == root.data){
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
    public static ArrayList<Integer> getRootToNodePath(BinaryTreeNode<Integer> root, int data){
        if(root == null){
            return null;
        }
        if(root.data == data){
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }
        ArrayList<Integer> leftOutput = getRootToNodePath(root.left, data);
        if(leftOutput != null){
            leftOutput.add(root.data);
            return leftOutput;
        }
        ArrayList<Integer> rightOutput = getRootToNodePath(root.right, data);
        if(rightOutput != null){
            rightOutput.add(root.data);
            return rightOutput;
        }
        else{
            return null;
        }
    }
    
    public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post,int[] in){
        return getTreeFromPostAndIn(post, in, 0, post.length - 1,0,in.length - 1);
    }
    public static BinaryTreeNode<Integer> getTreeFromPostAndIn(int[] post, int[] in, int postS, int postE, int inS, int inE){
        /*
        Construct Tree from Postorder and Inorder
        Send Feedback
        Given Postorder and Inorder traversal of a binary tree, create the binary tree associated with the traversals.You just need to construct the tree and return the root.
        Note: Assume binary tree contains only unique elements.
        Input format :

        Line 1 : n (Total number of nodes in binary tree)

        Line 2 : Post order traversal

        Line 3 : Inorder Traversal

        Output Format :

        Elements are printed level wise, each level in new line (separated by space).

        Sample Input :
        8
        8 4 5 2 6 7 3 1
        4 8 2 5 1 6 3 7
        Sample Output :
        1 
        2 3 
        4 5 6 7 
        8
        */
        if(inS > inE){
            return null;
        }
        int rootData = post[postE];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        int i = inS;
        while(i <= inE){
            if(in[i] == rootData){
                break;
            }
            i++;
        }
        int leftInStart = inS;
        int leftInEnd = i - 1;
        int rightInStart = i + 1;
        int rightInEnd = inE;
        
        int leftPostStart = postS;
        int rightPostEnd = postE - 1;
        int leftLength = leftInEnd - leftInStart + 1;
        int leftPostEnd = leftPostStart + leftLength - 1;
        int rightPostStart = leftPostEnd + 1;
        
        root.left = getTreeFromPostAndIn(post, in, leftPostStart, leftPostEnd, leftInStart, leftInEnd);
        root.right = getTreeFromPostAndIn(post, in, rightPostStart, rightPostEnd, rightInStart, rightInEnd );
        return root;
    }
    public static int sum(BinaryTreeNode<Integer> root){
	//Sum of all nodes	
        if(root==null)
            return 0;
        
        int sum=0;
		sum+=root.data+sum(root.left)+sum(root.right);
        return sum;
	}
    public static class CheckBalancedReturnType{
        boolean isBalanced;
        int height;
    }
    public static boolean checkBalanced(BinaryTreeNode<Integer> root){
        if(root == null){
            return true;
        }
        return checkBalancedHelper(root).isBalanced;
    }
    public static CheckBalancedReturnType checkBalancedHelper(BinaryTreeNode<Integer> root){
        if(root == null){
            CheckBalancedReturnType ans = new CheckBalancedReturnType();
            ans.height = 0;
            ans.isBalanced = true;
            return ans;
        }
        CheckBalancedReturnType leftAns = checkBalancedHelper(root.left);
        CheckBalancedReturnType rightAns = checkBalancedHelper(root.right);
        
        int heightDiff = leftAns.height > rightAns.height ? (leftAns.height - rightAns.height) : (rightAns.height - leftAns.height);
        
        CheckBalancedReturnType ans;
        if(!leftAns.isBalanced || !rightAns.isBalanced || heightDiff > 1){
            ans = new CheckBalancedReturnType();
            ans.height = Math.max(leftAns.height, rightAns.height) + 1;
            ans.isBalanced = false;
        }
        else{
            ans = new CheckBalancedReturnType();
            ans.height = Math.max(leftAns.height, rightAns.height) + 1;
            ans.isBalanced = true;
        }
        return ans;
    }
    public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root){
        /*
        Remove Leaf nodes
        Send Feedback
        Remove all leaf nodes from a given Binary Tree. Leaf nodes are those nodes, which don't have any children.
        Note : Root will also be a leaf node if it doesn't have left and right child. You don't need to print the tree, just remove all leaf nodes and return the updated root.
        Input format :

        Elements in level order form (separated by space)

        (If any node does not have left or right child, take -1 in its place)

        Output Format :

        Elements are printed level wise, each level in new line (separated by space).

        Sample Input :
        8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
        Sample Output :
        8
        3 10
        6 14                    
        */
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return null;
        }
        root.left = removeAllLeaves(root.left);
        root.right = removeAllLeaves(root.right);
        return root;
    }
    public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) 
    {
	/*
        Level wise linkedlist
        Send Feedback
        Given a binary tree, write code to create a separate linked list for each level. You need to return the array which contains head of each level linked list.
        Input format :

        Elements in level order form (separated by space). If any node does not have left or right child, take -1 in its place.

        Output format : Each level linked list is printed in new line (elements separated by space).

        Sample Input :
        5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
        Sample Output :
        5 
        6 10 
        2 3 
        9
        */     
        
       ArrayList<Node<BinaryTreeNode<Integer>>> al = new ArrayList<Node<BinaryTreeNode<Integer>>>();
        Queue<BinaryTreeNode<Integer>> myQ = new LinkedList<BinaryTreeNode<Integer>>();
        myQ.add(root);
        myQ.add(null);
        try{ 
            Node<BinaryTreeNode<Integer>> head = null;
            Node<BinaryTreeNode<Integer>> tail = null;
            while(!myQ.isEmpty()){
                BinaryTreeNode<Integer> temp = myQ.remove();
                if(temp == null){
                //    System.out.println();
                    al.add(head);
                    head = null;
                    tail = null;
                    if(!myQ.isEmpty()){
                     myQ.add(null);   
                    }
                    continue;
                }
            //    System.out.print(temp.data+" ");
                Node<BinaryTreeNode<Integer>> var = new Node<BinaryTreeNode<Integer>>(temp);
                if(head == null){
                    head = var;
                    tail = var;
                }
                else{
                    tail.next = var;
                    tail = var;   
                }
                if(temp.left != null){
                    myQ.add(temp.left);
                }
                if(temp.right != null){
                    myQ.add(temp.right);
                }
                
            }
        }
            catch(Exception e){
                
            }
        return al;
	}
    
    public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel2(BinaryTreeNode<Integer> root){
        if(root == null){
            return null;
        }
        Queue<BinaryTreeNode<Integer>> primary = new LinkedList<>();
        Queue<BinaryTreeNode<Integer>> secondry = new LinkedList<>();
        primary.add(root);
        Node<BinaryTreeNode<Integer>> head = null, tail = null, newNode;
        ArrayList<Node<BinaryTreeNode<Integer>>> output = new ArrayList<>();
        while(!primary.isEmpty()){
            BinaryTreeNode<Integer> currentNode;
            currentNode = primary.remove();
            newNode = new Node<BinaryTreeNode<Integer>>(currentNode);
            if(head == null){
                head = newNode;
                tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }
            if(currentNode.left != null){
                secondry.add(currentNode.left);
            }
            if(currentNode.right != null){
                secondry.add(currentNode.right);
            }
            if(primary.isEmpty()){
                output.add(head);
                head = null;
                tail = null;
                Queue<BinaryTreeNode<Integer>> temp = primary;
                primary = secondry;
                secondry = temp;
            }
        }
        return output;
    }
    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
	/*
        Nodes without sibling
        Send Feedback
        Given a binary tree, print all nodes that don’t have a sibling.
        Edit : Print the elements in different lines. And order of elements doesn't matter.
        Input format :
        Elements in level order form (separated by space). If any node does not have left or right child, take -1 in its place.
        Output format :
        Print nodes separated by new line.
        Sample Input :
        5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
        Sample Output :
        9    
        */	
	// Write your code here
	if(root==null)
            return;
        
        if( root.left!=null &&  root.right==null )
            System.out.println(root.left.data);
        
        if( root.left==null &&  root.right!=null )
            System.out.println(root.right.data);
      
        
        printNodesWithoutSibling(root.left);
        
        printNodesWithoutSibling(root.right);
        
    }
    
    
    public static void printZigZag(BinaryTreeNode<Integer> root){
        /*
        ZigZag tree
        Send Feedback
        Given a binary tree, print the zig zag order i.e print level 1 from left to right, level 2 from right to left and so on. This means odd levels should get printed from left to right and even level right to left.
        Input format :

        Elements in level order form (separated by space)

        (If any node does not have left or right child, take -1 in its place)

        Output Format :

        Elements are printed level wise, each level in new line (separated by space).

        Sample Input :
        5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
        Sample Output :
        5
        10 6
        2 3
        9
        */
        if(root == null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        int level = 1;
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> currentNode = queue.remove();
            System.out.print(currentNode.data + " ");
            if(level % 2 == 0){
                if(currentNode.right != null){
                    stack.push(currentNode.right);
                }
                if(currentNode.left != null){
                    stack.push(currentNode.left);
                }
            }
            else{
                if(currentNode.left != null){
                    stack.push(currentNode.left);
                }
                if(currentNode.right != null){
                    stack.push(currentNode.right);
                }
            }
            if(queue.isEmpty()){
                while(!stack.isEmpty()){
                    queue.add(stack.pop());
                }
                System.out.println();
                level++;
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner s = new Scanner(System.in);
//        BinaryTreeNode<Integer> root = takeInput(s);
//        printTree(root);
//        s.close();
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
//        root.left = node1;
//        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(1);
//        root.left = node2;

        BinaryTreeNode<Integer> root = takeInputLevelWise();
        //printTree(root);
        //printLevelWise(root);
        //System.out.println(countHeight(root));
        //System.out.println("diameter: "+diameter(root));
        //Pair<Integer, Integer> pair = new Pair<>();
        //pair = heightDiameter(root);
        System.out.println("diameterBetter: " + heightDiameter(root).second);
        System.out.println("Height: "+heightDiameter(root).first);
        
        //For 
        int size = s.nextInt();
        int[] pre = new int[size];
        for(int i = 0; i < size; i++){
            pre[i] = s.nextInt();
        }
        int in[] = new int[size];
        for(int i = 0; i < size; i++){
            in[i] = s.nextInt();
        }
        BinaryTreeNode<Integer> tree = getTreeFromPreoderAndInorder(pre, in);
        printLevelWise(tree);
    }
    
}
