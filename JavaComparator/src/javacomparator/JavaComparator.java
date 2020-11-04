package javacomparator;
import java.lang.*;
import java.util.*;
import java.io.*;

import java.util.*;

// Write your Checker class here
class Checker implements Comparator<Player>{
    //Used for sorting in ascending order of roll name
    @Override
    public int compare(Player a, Player b){
    if(a.score<b.score)
        {
            return 1;
        }
    else if(a.score==b.score)
        {
        return a.name.compareTo(b.name);
        }
    else
        return -1;
    }
}
class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}
public class JavaComparator {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
     
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
    
}
