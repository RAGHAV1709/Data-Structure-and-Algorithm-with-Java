package nodehavingsumofchildrenandnodeismax;
import java.util.*;
class TreeNode<T>{
    T data;
    ArrayList<TreeNode<T>> children;
    public TreeNode(T d){
        this.data = d;
        children = new ArrayList<>();
    }
}
public class NodeHavingSumOfChildrenAndNodeIsMax {
    public static TreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root data");
        int rootData = s.nextInt();
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()){
            
                TreeNode<Integer> frontNode = pendingNodes.remove();
                System.out.println("Enter num of children of "+frontNode.data);
                int numChildren = s.nextInt();
                for(int i = 0; i < numChildren; i++){
                    System.out.println("Enter "+(i+1)+"th child of "+frontNode.data);
                    int child = s.nextInt();
                    TreeNode<Integer> childNode = new TreeNode<Integer>(child);
                    frontNode.children.add(childNode);
                    pendingNodes.add(childNode);
                }
             
        }
        return root;
    }
    public static void print(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode<Integer> frontNode = queue.remove();
            if(frontNode == null){
                if(queue.isEmpty()){
                    break;
                }
                System.out.println();
                queue.add(null);
            }
            else{
                System.out.print(frontNode.data+" ");
                for(int i = 0; i < frontNode.children.size(); i++){
                    queue.add(frontNode.children.get(i));
                }
            }
        }
    }
    static class MaxNodePair<T>{
        TreeNode<T> node;
        int sum;
    }
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        return maxSumNodeHelper(root).node;
    }
    public static MaxNodePair<Integer> maxSumNodeHelper(TreeNode<Integer> root){
        if(root == null){
            MaxNodePair<Integer> pair = new MaxNodePair<>();
            pair.node = null;
            pair.sum = Integer.MIN_VALUE;
            return pair;
        }
        int sum = root.data;
        for(TreeNode<Integer> child : root.children){
            sum += child.data;
        }
        MaxNodePair<Integer> ans = new MaxNodePair<>();
        ans.node = root;
        ans.sum = sum;
        for(TreeNode<Integer> child : root.children){
            MaxNodePair<Integer> childAns = maxSumNodeHelper(child);
            if(childAns.sum > ans.sum){
                ans = childAns;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        TreeNode<Integer> root = takeInputLevelWise();
        TreeNode<Integer> ans = maxSumNode(root);
        if(ans == null){
            System.out.println(Integer.MIN_VALUE);
        }
        else{
            System.out.println(ans.data);
        }
    }
    
}
