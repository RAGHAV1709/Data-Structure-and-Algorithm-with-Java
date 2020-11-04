package mergesortusinglinkedlist;

import java.util.Scanner;

class LinkedListNode<T>{
    public T data;
    public LinkedListNode<T> next;
    
    public LinkedListNode(T data){
        this.data = data;
        this.next = null;
    }
}
public class MergeSortUsingLinkedList {
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
    public static void print(LinkedListNode<Integer> head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head ){
        if(head == null || head.next == null){
            return head;
        }
        LinkedListNode<Integer> mid = midPoint(head);
        LinkedListNode<Integer> head1 = head;
        LinkedListNode<Integer> head2 = mid.next;
        mid.next = null;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        LinkedListNode<Integer> answer = merge(head1, head2);
        return answer;
    }
    public static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2){
        LinkedListNode<Integer> resultHead = null;
        LinkedListNode<Integer> resultTail = null;
        if(head1.data < head2.data){
            resultHead = head1;
            resultTail = head1;
            head1 = head1.next;
        }
        else{
            resultHead = head2;
            resultTail = head2;
            head2 = head2.next;
        }
        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                resultTail.next = head1;
                head1 = head1.next;
                resultTail = resultTail.next;
            }
            else{
                resultTail.next = head2;
                head2 = head2.next;
                resultTail = resultTail.next;
            }
            
            
        }
        resultTail.next = head1 == null ? head2 : head1;
        return resultHead;
    }
    public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head){
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        print(mergeSort(input()));
        
    }
    
}
