package cqueueusinglinkedlist;

import java.util.Scanner;

class Node{
    private int data;
    private Node next;
    Node(){
        data = 0;
        next = null;
    }
    Node(int d, Node n){
        data = d;
        next = n;
    }
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
class Cqueue{
    int size;
    Node front, rear;
    Cqueue(){
        size = 0;
        
        front = rear = null;
        
    }
    
    public void enqueue(int d){
        Node n = new Node();
        n.setData(d);
        if(front==null){
            front = n;
            size++;
        }
        else{
            rear.setNext(n);
            size++;
        }
            
            
        rear = n;
        rear.setNext(front);
        
    }
    public void dqueue(){
        if(front == null){
            System.out.println("Circular Queue is Empty.");
        }
        else if(front == rear){
            front = null;
            rear = null;
            size--;
        }
        else {
            front = front.getNext();
            rear.setNext(front);
            size--;
        }
    }
    public void display(){
        Node t;
        t = front;
        while(t.getNext() != front){
            System.out.print(t.getData() + " ");
            
            t=t.getNext();
        }
        System.out.println(t.getData());
    }
}
public class CqueueUsingLinkedList {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Cqueue cqueue = new Cqueue();
        Scanner sc = new Scanner(System.in);
        
        boolean flag = true;
        
        while(flag){
            System.out.println("Enter the choice: where\n1.Enueue \n2.Dequeue \n3.Display \n4.Exit");
            int choice = sc.nextInt();
            switch(choice){
            case 1:
                System.out.println("Enter the value: ");
                int m = sc.nextInt();
                cqueue.enqueue(m);
                break;
            case 2:
                cqueue.dqueue();
                System.out.println("");
                break;
            case 3:
                System.out.println("The Circular element are: ");
                cqueue.display();
                break;
            default:
                flag = false;
                
        }
        }
        
        System.out.println("The size of Circular queue is: "+ cqueue.size);
        
    }
    
}
