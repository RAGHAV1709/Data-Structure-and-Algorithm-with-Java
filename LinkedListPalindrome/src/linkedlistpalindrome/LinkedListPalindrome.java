package linkedlistpalindrome;
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
public class LinkedListPalindrome {
    private static Scanner s = new Scanner(System.in);
    
    public static LinkedListNode<Integer> input(){
        int data = s.nextInt();
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;
        while(data != -1){
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
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
        //data = s.nextInt();
        return head;
    }
    static LinkedListNode<Integer> left = null;
    public static boolean isPalindrome_2(LinkedListNode<Integer> head){
        left = head;
        
        return find(head);
    }
    // Find size of linkedlist
    public static void size(LinkedListNode<Integer> head){
        int count = 0;
        LinkedListNode temp = null;
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        System.out.println(count);
    }
    
    //Checking palindrome using recursion method 
    public static boolean find(LinkedListNode<Integer> right){
   	 if(right==null){
        return true;
      }
      boolean val=find(right.next);
      if(val==true){
        if(left.data==right.data){
          left=left.next;
          return true;
        }
      }
    return false;
    }
    
    // Checking palindrome by creating new Inversed LinkedList of current LinkedList
    private static LinkedListNode<Integer> reverse_I(LinkedListNode<Integer> head){
        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> fwd = null;
        
        while(curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
    
    public static boolean isPalindrome_1(LinkedListNode<Integer> head){
        if(head == null || head.next == null){
            return true;
        }
        //find the list centre
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        LinkedListNode<Integer> secondHead = slow.next;
        slow.next = null;
        secondHead = reverse_I(secondHead);
        
        
        //compare two sublists now
        LinkedListNode<Integer> p = secondHead;
        LinkedListNode<Integer> q = head;
        
        while(p != null){
            if(p.data != q.data){
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
     }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(isPalindrome_1(input()));
        //size(input());
    }
    
}
