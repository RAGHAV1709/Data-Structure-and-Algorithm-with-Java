package extendthread;
//Create a second thread by extending the Thread
class NewThread extends Thread{
    NewThread(){
        //Create a new, second thread
        super("Demo Thread");
        System.out.println("Child thread: " + this);
        start();
    }
    //This is the entry point for the second thread.
    public void run(){
        try{
            for(int i = 5; i > 0; i--){
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            System.out.println("Child interrupted.");
        }
        System.out.println("Existing child thread.");
    }
}
public class ExtendThread {

    public static void main(String[] args) {
        // TODO code application logic here
        new NewThread(); //create a new thread
        try{
            for(int i = 5; i > 0; i--){
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println("Main thread interrupted.");
        }
        System.out.println("main thread existing");
        
    }
    
}
