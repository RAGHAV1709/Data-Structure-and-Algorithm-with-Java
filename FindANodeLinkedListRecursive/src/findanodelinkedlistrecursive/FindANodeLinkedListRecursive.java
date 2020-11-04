package findanodelinkedlistrecursive;
import java.util.Scanner;

class LinkedListNode<T>{
    public T data;
    public LinkedListNode<T> next;
    public LinkedListNode(T data){
        this.setData(data);
        this.next = null;
    }
    public T getData(){
        return data;
    }
    public void setData(T data){
        this.data = data;
    }
}
public class FindANodeLinkedListRecursive {
    private static Scanner s = new Scanner(System.in);
    public static LinkedListNode<Integer> input(){
        int data = s.nextInt();
        
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;
        
        while(data != -1){
            LinkedListNode<Integer>  newNode = new LinkedListNode<Integer>(data);
            if(head == null){
                head = newNode;
                tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }
            data = s.nextInt();
        }
        return head;
    }
    public static int index = 0;
    public static int indexOfNRec(LinkedListNode<Integer> head, int n){
        LinkedListNode<Integer> temp  = head;
        if(head == null){
            return -1;
        }
        if(temp.data != n){
            index++;
            head = head.next;
            return indexOfNRec(head,n);
        }
        return index;
    }
    
    public static int indexOfNRec2(LinkedListNode<Integer> head, int n){
        if(head == null){
            return -1;
        }
        if(head.data.equals(n)){
            return 0;
        }
        int i = indexOfNRec(head.next, n);
        if(i != -1){
            return i+1;
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedListNode<Integer> head = input();
        int n = s.nextInt();
        //System.out.println("Under First Function: "+indexOfNRec(head,n));
        System.out.println("Under Second function: "+indexOfNRec2(head,n));
    }
    
}
