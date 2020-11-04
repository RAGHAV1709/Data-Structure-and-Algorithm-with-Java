package linkedlistself;

import java.util.Scanner;

class Node{
    private int data;
    private Node next;
    public Node(){
        data = 0;
        next = null;
    }
    Node(int d, Node n){
        data = d;
        next = n;
        
    }

//    Node() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public void setData(int d){
        data = d;
    }
    public void setNext(Node n){
        next = n;
    }
    public int getData(){
        return data;
    }
    public Node getNext(){
        return next;
    }
    
}
class LinkedList{
        private Node start;
        private int size;
        public LinkedList(){
            size = 0;
            start = null;
        }
        public boolean isEmpty(){
            if(size == 0)
                return true;
            else
                return false;
        }
        public void viewList(){
            Node t;
            t = start;
            if(isEmpty()){
                System.out.println("List is Empty.");
            }
            else{
                while(t.getNext() != null){
                    t = t.getNext();
                    System.out.println(t.getData()+ " ");
                }
            }
        }
        public void insertAtFirst(int val){
            Node n;
            n = new Node();
            n.setData(val);
            n.setNext(start);
            start = n; 
            size++;
        }
        public void insertAtEnd(int val){
            Node n,t;
            n = new Node();
            n.setData(val);
            t = start;
            if(start == null){
                start=n;
                size++;
            }
            else{
                
                while(t.getNext() != null){
                    t = t.getNext();
                }
                t.setNext(n);
                size++;
            }
            
        }
        public void insertAtPos(int val, int pos){
                Node n,t;
                n = new Node();
                
                t = start;
                if(pos == 1)
                    insertAtFirst(val);
                else if(pos == size + 1)
                    insertAtEnd(val);
                else if(pos > 1 && pos <=size){
                    n.setData(val);
                    for(int i=0; i<pos -1; pos++){
                        t = t.getNext();
                    }
                    n.setNext(t);
                    t.setNext(n);
                    size++;
                }
               else
                    System.out.println("Insertion not possible at position" + pos);
            }
        public void deleteAtFirst(){
            if(start == null)
                System.out.println("List is already empty.");
            else{
                start = start.getNext();
                size--;
            }
        }
        public void deleteAtLast(){
            if(start == null)
                System.out.println("List is already Empty.");
            else if(size == 1){
                start = null;
            }
            else{
                Node t;
                t = start;
                for(int i = 0; i<size-1; i++){
                    t = t.getNext();
                }
                t.setNext(null);
                size--;
            }    
            
        }
        public void deleteAtPos(int pos){
            if(start == null){
                System.out.println("List is Already Empty.");
            }
            else if(pos == 1)
                deleteAtFirst();
            else if(pos == size)
                deleteAtLast();
            else if(pos < 1 || pos > size)
                System.out.println("Invalid Position.");
            else{
                Node t, t1;
                t = start;
                for(int i = 1; i<pos-1; pos++){
                    t=t.getNext();  
                }
                t1 = t.getNext();
                t.setNext(t1.getNext());
                size--;
            }
        }
    }
public class LinkedListSelf {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        LinkedList list = new LinkedList();
        while(flag){
            System.out.println(" ");
            System.out.println("1. Add at Start.");
            System.out.println("2. Insert at Last.");
            System.out.println("3.Insert at Pos.");
            System.out.println("4.Delete at first.");
            System.out.println("5.Delete Last Item from the list.");
            System.out.println("6.Delete from the list with given position.");
            System.out.println("7.View List.");
            System.out.println("8. Exit.");
            System.out.println("Enter the Choice.");
            int choice = sc.nextInt();
            int position,  val;
            switch(choice){
                case 1: 
                    System.out.println("Enter the value of lidt item");
                    val = sc.nextInt();
                    list.insertAtFirst(val);
                    break;
                case 2:
                    System.out.println("Enter value of last item");
                    val = sc.nextInt();
                    list.insertAtEnd(val);
                    break;
                case 3:
                    System.out.println("Enter the position.");
                    position = sc.nextInt();
                    System.out.println("Enter the List item.");
                    val = sc.nextInt();
                    list.insertAtPos(val, position);
                    break;
                case 4:
                    list.deleteAtFirst();
                    break;
                case 5:
                    list.deleteAtLast();
                    break;
                case 6:
                    System.out.println("Enter the position.");
                    position = sc.nextInt();
                    list.deleteAtPos(position);
                    break;
                case 7:
                    list.viewList();
                default:
                    flag = false;
            }
            
        }
        
    }
    
}
